package com.san.mxchengxin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.log.CmLog;
import com.san.mxchengxin.model.log.CmLogDAO;
import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;
import com.san.mxchengxin.objects.CountryMapObj;
import com.san.mxchengxin.objects.StatisticsChengxinObj;
import com.san.mxchengxin.utils.ComparatorCmLevel;
import com.san.mxchengxin.utils.ComparatorTownChengxinObj;
import com.san.share.pmi.dto.LoginUserInfo; 
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class ChengxinBaseAction extends Action {
	
	protected String cn ;
	protected String ouId ;
	protected String ouName ;
	protected String sn ;
	
	public CmLogDAO cmLogDAO = null; 
	public CmPartDAO cmPartDAO = null;
	
	private String[] specifyPartmentList = {
	"系统管理部",
	"崇明县"	
	};
	
	
	public CmLogDAO getCmLogDAO() {
		return cmLogDAO;
	}

	public void setCmLogDAO(CmLogDAO cmLogDAO) {
		this.cmLogDAO = cmLogDAO;
	}


	public CmPartDAO getCmPartDAO() {
		return cmPartDAO;
	}

	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
	}

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		//Object o = getBean("com.san.mxchengxin.action.LogAction");
		
				pickOutUserInfo( request);
				
				return null;
	
				
	}
	
	public boolean pickOutUserInfo( HttpServletRequest request )
	{
		boolean ret = true;
		LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
		cn = userInfo.getCn();//获得用户登录名
		ouId = userInfo.getOuid();//获得用户所属部门ID
		ouName = userInfo.getOuname();//获得用户所属部门名称
		
		if( ouName == "" ) 
		{
			System.out.println("找不到用户所属部门 ouName = " + ouName );
		}
			
		sn = userInfo.getSn();//获得用户姓名

		return ret ;
	}
	
	public boolean isAllVisiable()
	{
		for( int i = 0 ; i < specifyPartmentList.length ; i++ )
		{
			if( specifyPartmentList[i].equals( ouName ) )
			{
				return true;
			}
		}
		
		return false;
	}
	public List<CmCountry> getVisiableCountry( CmCountryDAO cmCountryDAO )
	{
		if( ouName == null || ouName.isEmpty() )
		{
			return null;
		}
		List<CmCountry> countryList = null;
		
		if( isAllVisiable() )
		{
			countryList = cmCountryDAO.findAll();
		}
		else
		{
			List<CmCountry> cmCountry = cmCountryDAO.findByName( ouName );
			
			if( cmCountry.size() < 1 )
			{
				System.out.println("在 CmCountry表中找不到" + ouName );
				
				if( cmPartDAO.findByPartName( ouName ).size() > 0 )
				{	//是个部门所有的村镇都可见，间接可以看到所有村镇下的人
					countryList = cmCountryDAO.findAll();
				}
				else
				{
					//没有找到对应的部门，用unknow产生一个临时的country，以便用于过滤people和record
					countryList = new ArrayList<CmCountry>();
					countryList.add( new CmCountry( "unknow" , "" , (long) 0 ) );
				}
			}
			else
			{
				DetachedCriteria searDc =	DetachedCriteria.forClass( CmCountry.class);
		
				searDc.add(Restrictions.or( Restrictions.eq("id", cmCountry.get(0).getId() )  , Restrictions.eq("parentid", cmCountry.get(0).getId() )));
						
				countryList = cmCountryDAO.getHibernateTemplate ().findByCriteria( searDc );
			}
			
		}
		return countryList;
	}
	
	// out: String[] names = {"ID1","ID2","ID3"};
	public String[] getVisiableCountryForString( CmCountryDAO cmCountryDAO )
	{
		
		List<CmCountry> countryList = getVisiableCountry(cmCountryDAO);
		
		if( countryList == null ) 
		{
			return null;
		}
		String[] names = new String[countryList.size()];
		
		for( int i = 0 ; i < countryList.size() ; i++ )
		{
			names[i] = countryList.get(i).getId().toString();
		}
		
		return names;
	}
	
	public Integer[] getVisiableCountryForInteger( CmCountryDAO cmCountryDAO )
	{
		
		List<CmCountry> countryList = getVisiableCountry(cmCountryDAO);
		if( countryList == null ) 
		{
			return null;
		}
		Integer[] names = new Integer[countryList.size()];
		
		for( int i = 0 ; i < countryList.size() ; i++ )
		{
			names[i] = new Integer((countryList.get(i).getId()));
		}
		
		return names;
	}
	
	public Short[] getVisiableCountryForShort( CmCountryDAO cmCountryDAO )
	{
		
		List<CmCountry> countryList = getVisiableCountry(cmCountryDAO);
		if( countryList == null ) 
		{
			return null;
		}
		Short[] names = new Short[countryList.size()];
		
		for( int i = 0 ; i < countryList.size() ; i++ )
		{
			names[i] = new Short((countryList.get(i).getId()));
		}
		
		return names;
	}
	
	public Short[] getVisiableCountryForShortAsCountryId( CmCountryDAO cmCountryDAO , Short id )
	{
		Short[] names = null;
		
		Map<Short, CountryMapObj > countryMap = cmCountryDAO.packCountryMapAsLevel(  cmCountryDAO.findAll() );
		
		if( countryMap.get( id ) == null )
		{
			names = new Short[1];
			names[0] = id;
		}
		else
		{
			names = new Short[countryMap.get( id ).sonList.size() + 1 ];
			
			names[0] = id;
			int count = 1;
			
			 for (Short key : countryMap.get( id ).sonList.keySet() ) {
				 names[count++] = key;
			  }
		}
		
		return names;
	}
	
	public void saveMessageToLog( String message ,HttpServletRequest request )
	{
		CmLog cl = new CmLog();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		System.out.println(df.format(now));// new Date()为获取当前系统时间
		
		cl.setInfo( message );
		cl.setPubdate( now.getTime()/1000 );
		cl.setIp( request.getRemoteAddr() );
		cl.setAuthor( cn );
		
		cmLogDAO.save( cl );
		
	}
	
	// return CmPart ID accord to ouName
	public short getPartId( CmPartDAO cmPartDAO , CmCountryDAO	cmCountryDAO )
	{
		short ret = -1;
		
		List<CmPart> cpList = cmPartDAO.findByPartName( ouName );
		
		if( cpList.size() > 0 )
		{
			ret = cpList.get(0).getId();
		}
		else
		{
			List<CmCountry> cclist  = cmCountryDAO.findByName( ouName );
			
			if( cclist.size() > 0 )
			{
				if( cclist.get(0).getParentid() == 0 )
				{ // 无父节点，镇
					List<CmPart> pList = cmPartDAO.findByPartName( "乡镇" );
					if( pList.size() > 0 )
					{
						ret = pList.get(0).getId();
					}
				}
				else
				{ // 村以及以下
					List<CmPart> pList = cmPartDAO.findByPartName( "村" );
					if( pList.size() > 0 )
					{
						ret = pList.get(0).getId();
					}
				}
			}
			
		}
		return ret;
	}
	
	public List<CmTarget> getVisiableTargetList( CmTargetDAO cmTargetDAO , CmPartDAO cmPartDAO , CmCountryDAO	cmCountryDAO)
	{
		List<CmTarget> ctList = null;
		
		if( isAllVisiable() )
		{
			ctList = cmTargetDAO.findAll( );
		}
		else
		{
			short partId = getPartId( cmPartDAO , cmCountryDAO );
			
			ctList = cmTargetDAO.findByPartId( partId );
		}
		
		return ctList;
	}
	
	
	public Integer[] getVisiableTargetIdList( CmTargetDAO cmTargetDAO , CmPartDAO cmPartDAO , CmCountryDAO	cmCountryDAO)
	{
		Integer ret[] = null;
		List<CmTarget> ctList = null;
		
		ctList = getVisiableTargetList( cmTargetDAO , cmPartDAO ,cmCountryDAO );
		
		
		if( ctList!= null )
		{
			ret = new Integer[ctList.size() ];
			
			for( int i = 0 ; i < ctList.size() ;i++ )
			{
				ret[i] = (int)(ctList.get(i).getId());
			}
		}
		
		
		return ret;
	}
	
	public void ajaxResponse( HttpServletResponse response , Object jasonOut )
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.setHeader("Cache-Control", "no-cache"); 
		PrintWriter out;
		if( jasonOut != null )
		{
			JSONArray jsonObject = JSONArray.fromObject( jasonOut );//装换json
			
			try {
				out = response.getWriter();
		
				out.write(jsonObject.toString()); 
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

    /**
     * 获得当前分页开始的记录数
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 当前分页开始记录数
     */
    private int getFirstSize(int pageNo,int pageSize){
        int firstSize = 0;
        firstSize = (pageNo -1) * pageSize;
        return firstSize;
    }
    
    
	/**
     * 通过传入标准sql语句获取记录集,并支持分页
     * @param sqlStr SQL语句
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsBySql(String sqlStr) throws Exception {
        Session session = null;
        try
        {
            session = cmLogDAO.getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
            return sqlQuery.list();
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
        }
        finally
        {
        	session.close();
        }
    }
    
    /**
     * 通过传入标准sql语句获取记录集,并支持分页
     * @param sqlStr SQL语句
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsBySqlForPage(String sqlStr, int pageNo, int pageSize) throws Exception {
        Session session = null;
        try
        {
            session = cmLogDAO.getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
            sqlQuery.setFirstResult(getFirstSize(pageNo,pageSize));
            sqlQuery.setMaxResults(pageSize);
            return sqlQuery.list();
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
        }
        finally
        {
        	session.close();
        }
    }
    
    public List<StatisticsChengxinObj> sqlResultToStatisticsChengxinObjList( List sqlResult )
    {
    	List<StatisticsChengxinObj> ret = new ArrayList<StatisticsChengxinObj>();
    	
    	for( int i = 0 ; i < sqlResult.size() ; i++ )
    	{
    		Object[] subject = (Object[]) sqlResult.get(i);
    		
    		String name = (String)subject[0];

    		
    		long numberOfAllPerson = ((BigDecimal )subject[1]).longValue();
    		
    		long numberOfLessZeroPerson = 0;
    		if( subject[2] != null )
    		{
    			numberOfLessZeroPerson = ((BigDecimal )subject[2]).longValue();
    		}
    		
    		long sumAddScore = 0;
    		if( subject[3] != null )
    		{
    			sumAddScore = ((BigDecimal )subject[3]).longValue();
    		}
    		
    		long sumSubScore = 0;
    		if( subject[4] != null )
    		{
    			sumSubScore = ((BigDecimal )subject[4]).longValue();
    		}
    		
    		long subScore = sumSubScore  /numberOfAllPerson;
    		long addScore = sumAddScore  /numberOfAllPerson;
    		long baseScore = 1099 - ( numberOfLessZeroPerson * 99 ) / numberOfAllPerson;
    		long totalScore = baseScore + addScore + subScore;
    		String levelSql = "select LEVEL_NAME from CM_LEVEL where  LEVEL_SCORE <= "+totalScore+"   ORDER BY LEVEL_SCORE DESC  " ;
    		List levelList = null;
			try {
				levelList = getRsBySql( levelSql );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		String rankName =""  ;
    		
    		if( levelList.size() > 0 )
    		{
    			rankName = (String)levelList.get(0);
    		
    		}
    		ret.add( new StatisticsChengxinObj( name ,
    											subScore,
    											addScore,
    											baseScore,
    											totalScore,
    											rankName
    											) );
    	}
    	
    	// 调用排序方法，参数二为自定义的排序工具类
		Collections.sort(ret, new ComparatorTownChengxinObj(false));
		// des order
    			
    	return ret;
    }
    // 所有城镇都可见
    public List<StatisticsChengxinObj> getTownChengxinObjList( int recordsPerPage )
    {

    	String joinRecord_Person_CountryStr = "( CM_RECORD JOIN CM_PERSON  on CM_RECORD.PERSON_ID = CM_PERSON.ID) JOIN CM_COUNTRY on CM_PERSON.country_id = CM_COUNTRY.id ";
		String townGroupSql = " CASE CM_COUNTRY.PARENTID	 WHEN 0     THEN CM_COUNTRY.id	 ELSE CM_COUNTRY.PARENTID  END";
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		System.out.println(df.format(now));// new Date()为获取当前系统时间
		long nowTime = now.getTime()/1000;
	
		Calendar   yearBegin=Calendar.getInstance();
		yearBegin.set(Calendar.DAY_OF_YEAR, 1);
		yearBegin.set(Calendar.HOUR_OF_DAY , 0 );
		yearBegin.set(Calendar.MINUTE , 0 );

		
		
		// 在有效期内的记录列表
		String validDateSql = " CM_RECORD .DATELINE > " +  Long.toString(nowTime);
				
		//记录中共有多少人
		String Sql1 = "select COUNT(DISTINCT CM_RECORD.PERSON_ID) as numberOfAllPerson, " + townGroupSql + " GROUP_ID  from  " + joinRecord_Person_CountryStr + " where " + validDateSql  +" GROUP BY  " + townGroupSql;
		
		//从本年度1月1日开始小于0的人的个数
		String Sql2 = "SELECT COUNT(DISTINCT CM_RECORD.PERSON_ID) as numberOfLessZeroPerson, " + townGroupSql + " GROUP_ID   FROM  " + joinRecord_Person_CountryStr + " where CM_RECORD.PUBDATE > " + yearBegin.getTime().getTime() /1000+" AND CM_RECORD.SCORE < 0 AND " +  validDateSql +" GROUP BY " + townGroupSql;
		
		// 加分
		String Sql3 = "SELECT sum( cm_record.score) as sumAddScore," + townGroupSql + " GROUP_ID  FROM " + joinRecord_Person_CountryStr + " where cm_record.SCORE > 0 AND " + validDateSql + " GROUP BY  " + townGroupSql ;
		//String Sql3 = "SELECT sum( cm_record.score) as sumAddScore," + townGroupSql + " GROUP_ID   ,  CASE WHEN cm_record.SCORE < 0 THEN 'sub' WHEN cm_record.SCORE > 0 THEN 'add' ELSE NULL END SCORE_T   FROM " + joinRecord_Person_CountryStr + " GROUP BY  " + townGroupSql + ", CASE WHEN cm_record.SCORE < 0 THEN 'sub' WHEN  cm_record.SCORE > 0 THEN 'add' ELSE NULL END";
		 
		// 减分
		String Sql4 = "SELECT sum( cm_record.score) as sumSubScore," + townGroupSql + " GROUP_ID  FROM " + joinRecord_Person_CountryStr + " where cm_record.SCORE < 0  AND " + validDateSql + " GROUP BY  "  + townGroupSql ;
					
		 // SUM(CM_RECORD.SCORE)   GROUP_ID               SCORE_T 
		 //---------------------- ---------------------- ------- 
		//		 -400                   10                     减分    
		//		 -10352                 13                     减分    
		//		 150                    10                     加分   
		
		 //String totalSql = "select CM_COUNTRY.Name as name , s1.numberOfLessZeroPerson as numberOfLessZeroPerson, s2.numberOfAllPerson as numberOfAllPerson, s3.sumAddScore as sumAddScore ,s4.sumSubScore as sumSubScore from (" + Sql1 + ")s1,(" + Sql2 + ")s2,( "+ Sql3 + ")s3,( "+ Sql4 + ")s4 , cm_country where s1.GROUP_ID = cm_country.id AND s1.GROUP_ID = s2.GROUP_ID AND s1.GROUP_ID = s3.GROUP_ID AND s1.GROUP_ID = s4.GROUP_ID";
		String totalSql = "select CM_COUNTRY.Name as name , s1.numberOfAllPerson as numberOfAllPerson, s2.numberOfLessZeroPerson as numberOfLessZeroPerson, s3.sumAddScore as sumAddScore ,s4.sumSubScore as sumSubScore from (((((" + Sql1 + ")s1 LEFT JOIN (" + Sql2 + ")s2 on s1.GROUP_ID = s2.GROUP_ID )  LEFT JOIN ( "+ Sql3 + ")s3 on s1.GROUP_ID = s3.GROUP_ID )  LEFT JOIN ( "+ Sql4 + ")s4 on s1.GROUP_ID = s4.GROUP_ID ) LEFT JOIN  cm_country on  s1.GROUP_ID = cm_country.id  )";
		 
		List result = null;
		try {
			result = getRsBySql( totalSql );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<StatisticsChengxinObj> chengxinObjList = sqlResultToStatisticsChengxinObjList( result);
		
		
		return chengxinObjList;
	 	
    }
    
    //取得所有村的诚信列表 ,town 在cmCountry里面的ID ， 如果是县级管理员进入则 townId = -1
    public List<StatisticsChengxinObj> getCountryChengxinObjList( CmCountryDAO cmCountryDAO , int page , int recordsPerPage )
    {
    	Short[] visiableCountryList = getVisiableCountryForShort(cmCountryDAO);
    		
    	String joinRecord_Person_CountryStr = "( CM_RECORD JOIN CM_PERSON  on CM_RECORD.PERSON_ID = CM_PERSON.ID) JOIN CM_COUNTRY on CM_PERSON.country_id = CM_COUNTRY.id ";
		
    	//限制需要的村列表SQL 语句
    	String limitCountryListSql = " cm_country.ID IN ( ";
		for( int i = 0 ; i < visiableCountryList.length ; i++ )
		{
			limitCountryListSql = limitCountryListSql + visiableCountryList[i];
			
			if( i < visiableCountryList.length - 1 )
			{
				limitCountryListSql = limitCountryListSql + ',' ;
			}
		}
		
		limitCountryListSql = limitCountryListSql + ") ";
		
    	String townGroupSql = " cm_country.id ";
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		System.out.println(df.format(now));// new Date()为获取当前系统时间
		long nowTime = now.getTime()/1000;
	
		Calendar   yearBegin=Calendar.getInstance();
		yearBegin.set(Calendar.DAY_OF_YEAR, 1);
		yearBegin.set(Calendar.HOUR_OF_DAY , 0 );
		yearBegin.set(Calendar.MINUTE , 0 );

		
		
		// 在有效期内的记录列表
		String validDateSql = " CM_RECORD .DATELINE > " +  Long.toString(nowTime);
				
		//记录中共有多少人
		String Sql1 = "select COUNT(DISTINCT CM_RECORD.PERSON_ID) as numberOfAllPerson, " + townGroupSql + "as GROUP_ID  from  " + joinRecord_Person_CountryStr + " where " + validDateSql  + "  AND " + limitCountryListSql + " GROUP BY  " + townGroupSql;
		
		//从本年度1月1日开始小于0的人的个数
		String Sql2 = "SELECT COUNT(DISTINCT CM_RECORD.PERSON_ID) as numberOfLessZeroPerson, " + townGroupSql + "as  GROUP_ID   FROM  " + joinRecord_Person_CountryStr + " where CM_RECORD.PUBDATE > " + yearBegin.getTime().getTime() /1000+" AND CM_RECORD.SCORE < 0 AND " +  validDateSql   + "  AND " + limitCountryListSql +" GROUP BY " + townGroupSql;
		
		// 加分
		String Sql3 = "SELECT sum( cm_record.score) as sumAddScore," + townGroupSql + " as GROUP_ID  FROM " + joinRecord_Person_CountryStr + " where cm_record.SCORE > 0 AND " + validDateSql   + "  AND " + limitCountryListSql + " GROUP BY  " + townGroupSql ;
		//String Sql3 = "SELECT sum( cm_record.score) as sumAddScore," + townGroupSql + " GROUP_ID   ,  CASE WHEN cm_record.SCORE < 0 THEN 'sub' WHEN cm_record.SCORE > 0 THEN 'add' ELSE NULL END SCORE_T   FROM " + joinRecord_Person_CountryStr + " GROUP BY  " + townGroupSql + ", CASE WHEN cm_record.SCORE < 0 THEN 'sub' WHEN  cm_record.SCORE > 0 THEN 'add' ELSE NULL END";
		 
		// 减分
		String Sql4 = "SELECT sum( cm_record.score) as sumSubScore," + townGroupSql + "as  GROUP_ID  FROM " + joinRecord_Person_CountryStr + " where cm_record.SCORE < 0  AND " + validDateSql   + "  AND " + limitCountryListSql + " GROUP BY  "  + townGroupSql ;
					
		 // SUM(CM_RECORD.SCORE)   GROUP_ID               SCORE_T 
		 //---------------------- ---------------------- ------- 
		//		 -400                   10                     减分    
		//		 -10352                 13                     减分    
		//		 150                    10                     加分   
		
		 //String totalSql = "select CM_COUNTRY.Name as name , s1.numberOfLessZeroPerson as numberOfLessZeroPerson, s2.numberOfAllPerson as numberOfAllPerson, s3.sumAddScore as sumAddScore ,s4.sumSubScore as sumSubScore from (" + Sql1 + ")s1,(" + Sql2 + ")s2,( "+ Sql3 + ")s3,( "+ Sql4 + ")s4 , cm_country where s1.GROUP_ID = cm_country.id AND s1.GROUP_ID = s2.GROUP_ID AND s1.GROUP_ID = s3.GROUP_ID AND s1.GROUP_ID = s4.GROUP_ID";
		String totalSql = "select CM_COUNTRY.Name as name , s1.numberOfAllPerson as numberOfAllPerson, s2.numberOfLessZeroPerson as numberOfLessZeroPerson, s3.sumAddScore as sumAddScore ,s4.sumSubScore as sumSubScore from (((((" + Sql1 + ")s1 LEFT JOIN (" + Sql2 + ")s2 on s1.GROUP_ID = s2.GROUP_ID )  LEFT JOIN ( "+ Sql3 + ")s3 on s1.GROUP_ID = s3.GROUP_ID )  LEFT JOIN ( "+ Sql4 + ")s4 on s1.GROUP_ID = s4.GROUP_ID ) LEFT JOIN  cm_country on  s1.GROUP_ID = cm_country.id  )";
		 
		List result = null;
		try {
			result = getRsBySqlForPage( totalSql , page , recordsPerPage );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<StatisticsChengxinObj> chengxinObjList = sqlResultToStatisticsChengxinObjList( result);
		
		
		return chengxinObjList;
	 	
    }
    
    
  //取得所有所有人的 诚信列表 ,town 在cmCountry里面的ID ， 如果是县级管理员进入则 townId = -1
    public List<StatisticsChengxinObj>  getPeopleChengxinObjList( CmCountryDAO cmCountryDAO , int page , int recordsPerPage )
    {
    	Short[] visiableCountryList = getVisiableCountryForShort(cmCountryDAO);
    		
    	String joinRecord_Person_CountryStr = "( CM_RECORD JOIN CM_PERSON  on CM_RECORD.PERSON_ID = CM_PERSON.ID) JOIN CM_COUNTRY on CM_PERSON.country_id = CM_COUNTRY.id ";
		
    	//限制需要的村列表SQL 语句
    	String limitCountryListSql = " cm_country.ID IN ( ";
		for( int i = 0 ; i < visiableCountryList.length ; i++ )
		{
			limitCountryListSql = limitCountryListSql + visiableCountryList[i];
			
			if( i < visiableCountryList.length - 1 )
			{
				limitCountryListSql = limitCountryListSql + ',' ;
			}
		}
		
		limitCountryListSql = limitCountryListSql + ") ";
		
    	String townGroupSql = " cm_person.id ";
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		System.out.println(df.format(now));// new Date()为获取当前系统时间
		long nowTime = now.getTime()/1000;
	
		Calendar   yearBegin=Calendar.getInstance();
		yearBegin.set(Calendar.DAY_OF_YEAR, 1);
		yearBegin.set(Calendar.HOUR_OF_DAY , 0 );
		yearBegin.set(Calendar.MINUTE , 0 );

		
		
		// 在有效期内的记录列表
		String validDateSql = " CM_RECORD .DATELINE > " +  Long.toString(nowTime);
				
		//记录中共有多少人
		String Sql1 = "select 1 as numberOfAllPerson, " + townGroupSql + "as GROUP_ID  from  " + joinRecord_Person_CountryStr + " where " + validDateSql  + "  AND " + limitCountryListSql + " GROUP BY  " + townGroupSql;

		
		//从本年度1月1日开始小于0的人的个数
		String Sql2 = "SELECT COUNT(DISTINCT CM_RECORD.PERSON_ID) as numberOfLessZeroPerson, " + townGroupSql + "as  GROUP_ID   FROM  " + joinRecord_Person_CountryStr + " where CM_RECORD.PUBDATE > " + yearBegin.getTime().getTime() /1000+" AND CM_RECORD.SCORE < 0 AND " +  validDateSql   + "  AND " + limitCountryListSql +" GROUP BY " + townGroupSql;
		
		// 加分
		String Sql3 = "SELECT sum( cm_record.score) as sumAddScore," + townGroupSql + " as GROUP_ID  FROM " + joinRecord_Person_CountryStr + " where cm_record.SCORE > 0 AND " + validDateSql   + "  AND " + limitCountryListSql + " GROUP BY  " + townGroupSql ;
		//String Sql3 = "SELECT sum( cm_record.score) as sumAddScore," + townGroupSql + " GROUP_ID   ,  CASE WHEN cm_record.SCORE < 0 THEN 'sub' WHEN cm_record.SCORE > 0 THEN 'add' ELSE NULL END SCORE_T   FROM " + joinRecord_Person_CountryStr + " GROUP BY  " + townGroupSql + ", CASE WHEN cm_record.SCORE < 0 THEN 'sub' WHEN  cm_record.SCORE > 0 THEN 'add' ELSE NULL END";
		 
		// 减分
		String Sql4 = "SELECT sum( cm_record.score) as sumSubScore," + townGroupSql + "as  GROUP_ID  FROM " + joinRecord_Person_CountryStr + " where cm_record.SCORE < 0  AND " + validDateSql   + "  AND " + limitCountryListSql + " GROUP BY  "  + townGroupSql ;
					
		//NAME             NUMBEROFALLPERSON      NUMBEROFLESSZEROPERSON SUMADDSCORE            SUMSUBSCORE            
		//-------------------------------------------------- ---------------------- ---------------------- ---------------------- ---------------------- 
		//爱国村                                             3                      1                      100                    -100                   
		//胜利村                                             1                                             50                                            
		//北兴村                                             1                      1                                             -9999        
		
		 //String totalSql = "select CM_COUNTRY.Name as name , s1.numberOfLessZeroPerson as numberOfLessZeroPerson, s2.numberOfAllPerson as numberOfAllPerson, s3.sumAddScore as sumAddScore ,s4.sumSubScore as sumSubScore from (" + Sql1 + ")s1,(" + Sql2 + ")s2,( "+ Sql3 + ")s3,( "+ Sql4 + ")s4 , cm_country where s1.GROUP_ID = cm_country.id AND s1.GROUP_ID = s2.GROUP_ID AND s1.GROUP_ID = s3.GROUP_ID AND s1.GROUP_ID = s4.GROUP_ID";
		String totalSql = "select cm_person.TRUENAME as name , s1.numberOfAllPerson as numberOfAllPerson, s2.numberOfLessZeroPerson as numberOfLessZeroPerson, s3.sumAddScore as sumAddScore ,s4.sumSubScore as sumSubScore from (((((" + Sql1 + ")s1 LEFT JOIN (" + Sql2 + ")s2 on s1.GROUP_ID = s2.GROUP_ID )  LEFT JOIN ( "+ Sql3 + ")s3 on s1.GROUP_ID = s3.GROUP_ID )  LEFT JOIN ( "+ Sql4 + ")s4 on s1.GROUP_ID = s4.GROUP_ID ) LEFT JOIN  cm_person on  s1.GROUP_ID = cm_person.id  )";
		 
		List result = null;
		try {
			result = getRsBySqlForPage( totalSql , page , recordsPerPage );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<StatisticsChengxinObj> chengxinObjList = sqlResultToStatisticsChengxinObjList( result);
		
		
		return chengxinObjList;
	 	
    }
   
 
}
