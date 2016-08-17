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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.log.CmLog;
import com.san.mxchengxin.model.log.CmLogDAO;
import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.statistics.CmStatistics;
import com.san.mxchengxin.model.statistics.CmStatisticsDAO;
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
	
	int noOfRecords = 0;

	private String[] specifyPartmentList = {
	"系统管理部",
	"崇明县"	
	};
	
	public int COUNTRY_FLAG 			= 1;
	public int TOWN_FLAG 				= 2;
	public int INVALID_COUNTRY_FLAG 	= 3;
	
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
		cl.setIp( request.getRemoteAddr().length() > 15 ? "unknown": request.getRemoteAddr());
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
		PrintWriter out = null;
		if( jasonOut != null )
		{
			JSONArray jsonObject = JSONArray.fromObject( jasonOut );//装换json
			
			try {
				out = response.getWriter();
		
				out.write(jsonObject.toString()); 
				out.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				if( out != null )
				{
					out.close();
				}
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
    
    protected int getCountryType( short countryId , CmCountryDAO cmCountryDAO  )
    {
    	int ret = INVALID_COUNTRY_FLAG;
    	
    	CmCountry cc = cmCountryDAO.findById( countryId );
    	
    	if( cc!= null )
    	{
    		if(cc.getParentid() == 0 )
    		{
    			ret = TOWN_FLAG;
    		}
    		else
    		{
    			ret = COUNTRY_FLAG;
    		}
    	}
    	
    	return ret;
    }
    
    
    //根据person的记录调整对应此人的statistics的记录
    static public void adjustStatisticsForPerson( CmRecordDAO cmRecordDAO , CmStatisticsDAO cmStatisticsDAO , CmPersonDAO cmPersonDAO , int personId )
	{
		CmPerson cp = cmPersonDAO.findById( personId );
		if( cp == null )
		{
			//没有找到对应的人
			return ; 
		}
		List<CmStatistics> csList = cmStatisticsDAO.findByPersonId( personId );
		
		CmStatistics cs = null;
		if( ( csList == null ) || ( csList.size() == 0 ) )
		{  // 产生一个新的记录
			
			cs = new CmStatistics( personId );
			cs.setCountryId( cp.getCountryId() ); //设置属于哪个村
		}
		else
		{ // 用原来存在的记录
			cs = csList.get(0);
		}
		
		//
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmRecord.class);
		searDc.add(Restrictions.eq("person", cp ));
		
		//刨除已过期的记录
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		long currentTime = now.getTime()/1000;
		
		searDc.add( Restrictions.ge(  "dateline", currentTime ) );
		
		searDc.addOrder( Order.desc( "pubdate" ) );
		List<CmRecord>  crList = cmRecordDAO.getHibernateTemplate ().findByCriteria( searDc );
		

		Calendar   curentTime=Calendar.getInstance(); // 当前时间
		Calendar peoplePubTime= Calendar.getInstance();
		peoplePubTime.setTimeInMillis( cp.getPubdate() * 1000 ); // people 登记时间
		
		/* 计算出出现负值的年计数*/
		int NscoreYearCount = 0;
		int totalYears = curentTime.get(curentTime.YEAR) - peoplePubTime.get(Calendar.YEAR);
		for( int i = curentTime.get(Calendar.YEAR); i < peoplePubTime.get(curentTime.YEAR) ;i++ )
		{
			for(  int j = 0 ; j < crList.size(); j++ )
			{
				if( crList.get(j).getScore() >0 )
				{ //不统计正分数
					continue;
				}
				Calendar   recordPubTime = Calendar.getInstance();
				recordPubTime.setTimeInMillis( crList.get(j).getPubdate() * 1000 );
				if( recordPubTime.get(Calendar.YEAR) == i )
				{
					NscoreYearCount ++; // 找到了负数record
					break;// 进行下一年统计
				}
			}
		
		}
		
		// 设置基础分
		cs.setScoreBase( (short) (1000 + ( totalYears - NscoreYearCount )* 99) ); //初始分 + 逐年累加分
		cs.setScoreSub((short) 0);
		cs.setScoreAdd((short) 0);
		
		// 设置正分和负分
		for( int i = 0 ; i < crList.size() ; i++  )
		{
			CmRecord cr = crList.get(i);
			if( cr.getScore() < 0 )
			{
				cs.setScoreSub( (short) (cs.getScoreSub() + cr.getScore()) );
			}
			else
			{
				cs.setScoreAdd( (short) (cs.getScoreAdd() + cr.getScore()) );
			}
				
		}
		

		if( ( csList == null ) || ( csList.size() == 0 ) )
		{
			cmStatisticsDAO.save( cs );
		}
		else
		{
			cmStatisticsDAO.update(cs);
		}
	}
 

	public List<StatisticsChengxinObj>  getPeopleChengxinObjList(  Short[] VisiableContryLimit, String name , String ssid ,int page , int recordsPerPage )
    {
		List<StatisticsChengxinObj> scxList = null;
		String commonWhere = " where cm_statistics.person_id = cm_person.id  ";
		String from = " from cm_statistics  ,cm_person ";
		
    		
    	if( (name != null) && (!name.isEmpty()) )
    	{
    		commonWhere += " AND cm_person.TRUENAME like '%"+ name +"%' ";
    	}
    	if( (ssid != null) && (!ssid.isEmpty()) )
		{
			commonWhere += " AND  cm_person.SSID like '%"+ ssid +"%' ";
		}
    	
    	Short[] visiableCountryList = VisiableContryLimit;
		
		if( visiableCountryList != null )
		{
			/*产生限制需要的村列表SQL 语句 begin */
	    	String limitCountryListSql = " cm_statistics.country_id IN ( ";
			for( int i = 0 ; i < visiableCountryList.length ; i++ )
			{
				limitCountryListSql = limitCountryListSql + visiableCountryList[i];
				
				if( i < visiableCountryList.length - 1 )
				{
					limitCountryListSql = limitCountryListSql + ',' ;
				}
			}
			
			limitCountryListSql = limitCountryListSql + ") ";
			
			commonWhere += " AND "+ limitCountryListSql;
		}
		
		
		
		String totalSql = "select cm_person.trueName , cm_statistics.score_base, cm_statistics.score_add, cm_statistics.score_sub , ( cm_statistics.score_add + cm_statistics.score_sub) as score_total" + from + commonWhere ;
		
		String totalCountSql = "select COUNT(cm_statistics.id) "+ from + commonWhere ;
		
		if( noOfRecords == 0 )
		{
			try {
				noOfRecords =  ((BigDecimal )(getRsBySql( totalCountSql  ).get(0))).intValue();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List result = null;
		try {
			result = getRsBySqlForPage( totalSql , page , recordsPerPage );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( result != null )
		{
			scxList = getPeopleChengxinObjListToStatisticsUiShowObjList( result );
		}
		return scxList;
     
    }
	
	public List<StatisticsChengxinObj> getPeopleChengxinObjListToStatisticsUiShowObjList( List sqlResult )
    {
    	List<StatisticsChengxinObj> ret = new ArrayList<StatisticsChengxinObj>();
    	
    	for( int i = 0 ; i < sqlResult.size() ; i++ )
    	{
    		Object[] subject = (Object[]) sqlResult.get(i);
    		
    		String name = (String)subject[0];
    		long baseScore =((BigDecimal )subject[1]).longValue();
    		long addScore = ((BigDecimal )subject[2]).longValue();
    		long subScore = ((BigDecimal )subject[3]).longValue();
    		long totalScore = baseScore + addScore + subScore;
    		
    		
    		String rankName =""  ;
    		
    		rankName = getRankLevelStrAccordingToScore(totalScore);
    		
    		ret.add( new StatisticsChengxinObj( name ,
    											subScore,
    											addScore,
    											baseScore,
    											totalScore,
    											rankName
    											) );
    	}
    	
    	// 调用排序方法，参数二为自定义的排序工具类
		//Collections.sort(ret, new ComparatorTownChengxinObj(false));
		// des order
    			
    	return ret;
    }

	//取得所有村的诚信列表 ,town 在cmCountry里面的ID ， 如果是县级管理员进入则 townId = -1
    public List<StatisticsChengxinObj> getCountryChengxinObjList( CmCountryDAO cmCountryDAO ,Short[] VisiableContryLimit ,int page , int recordsPerPage )
    {
    	List<StatisticsChengxinObj> scxList = null;
		String commonWhere = " where 1=1  ";
		String from = " from cm_statistics  ";
		String group = " group by cm_statistics.country_id ";
    	
    	Short[] visiableCountryList = VisiableContryLimit;
		
		if( visiableCountryList != null )
		{
			/*产生限制需要的村列表SQL 语句 begin */
	    	String limitCountryListSql = " cm_statistics.country_id IN ( ";
			for( int i = 0 ; i < visiableCountryList.length ; i++ )
			{
				limitCountryListSql = limitCountryListSql + visiableCountryList[i];
				
				if( i < visiableCountryList.length - 1 )
				{
					limitCountryListSql = limitCountryListSql + ',' ;
				}
			}
			
			limitCountryListSql = limitCountryListSql + ") ";
			
			commonWhere += " AND "+ limitCountryListSql;
		}
		
		
		
		String totalSql = "select cm_statistics.country_id , avg(cm_statistics.score_base), avg(cm_statistics.score_add), avg(cm_statistics.score_sub) , avg( cm_statistics.score_add + cm_statistics.score_sub) as score_total" + from + commonWhere + group;
		
		String totalCountSql = "select COUNT(COUNT(cm_statistics.country_id)) "+ from + commonWhere + group;
		
		if( noOfRecords == 0 )
		{
			try {
				noOfRecords =  ((BigDecimal )(getRsBySql( totalCountSql  ).get(0))).intValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List result = null;
		try {
			result = getRsBySqlForPage( totalSql , page , recordsPerPage );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( result != null )
		{
			scxList = getCountryChengxinObjListToStatisticsUiShowObjList( cmCountryDAO ,result );
		}
		return scxList;	
    }
    
    public List<StatisticsChengxinObj> getTownChengxinObjList( CmCountryDAO cmCountryDAO ,Short[] VisiableContryLimit ,int page , int recordsPerPage )
    {
    	List<StatisticsChengxinObj> scxList = null;
		String commonWhere = " where cm_statistics.country_id = cm_country.id  ";
		String from = " from cm_statistics  ,cm_country ";
		String townGroupSql = " CASE CM_COUNTRY.PARENTID	 WHEN 0     THEN CM_COUNTRY.id	 ELSE CM_COUNTRY.PARENTID  END ";
		String group = " group by " + townGroupSql ;
		
    	
    	Short[] visiableCountryList = VisiableContryLimit;
		
		if( visiableCountryList != null )
		{
			/*产生限制需要的村列表SQL 语句 begin */
	    	String limitCountryListSql = " cm_statistics.country_id IN ( ";
			for( int i = 0 ; i < visiableCountryList.length ; i++ )
			{
				limitCountryListSql = limitCountryListSql + visiableCountryList[i];
				
				if( i < visiableCountryList.length - 1 )
				{
					limitCountryListSql = limitCountryListSql + ',' ;
				}
			}
			
			limitCountryListSql = limitCountryListSql + ") ";
			
			commonWhere += " AND "+ limitCountryListSql;
		}
		
		
		
		String totalSql = "select "+ townGroupSql + " as country_id , avg(cm_statistics.score_base), avg(cm_statistics.score_add), avg(cm_statistics.score_sub) , avg( cm_statistics.score_add + cm_statistics.score_sub) as score_total" + from + commonWhere + group;
		
		String totalCountSql = "select COUNT(COUNT("+ townGroupSql + " )) " +from + commonWhere + group;
		
		if( noOfRecords == 0 )
		{
			try {
				noOfRecords =  ((BigDecimal )(getRsBySql( totalCountSql  ).get(0))).intValue();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List result = null;
		try {
			result = getRsBySqlForPage( totalSql , page , recordsPerPage );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( result != null )
		{
			scxList = getCountryChengxinObjListToStatisticsUiShowObjList( cmCountryDAO ,result );
		}
		return scxList;	
    }
    
    public String getRankLevelStrAccordingToScore( long totalScore )
    {
    	String rankName = "";
    	

		String levelSql = "select LEVEL_NAME from CM_LEVEL where  LEVEL_SCORE <= "+totalScore+"   ORDER BY LEVEL_SCORE DESC  " ;
		List levelList = null;
		try {
			levelList = getRsBySql( levelSql );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( levelList != null && ( levelList.size() > 0 ))
		{
			rankName = (String)levelList.get(0);
		
		}
		
		return rankName;
    }
    
    public List<StatisticsChengxinObj> getCountryChengxinObjListToStatisticsUiShowObjList( CmCountryDAO cmCountryDAO ,List sqlResult )
    {
    	List<StatisticsChengxinObj> ret = new ArrayList<StatisticsChengxinObj>();
    	
    	for( int i = 0 ; i < sqlResult.size() ; i++ )
    	{
    		Object[] subject = (Object[]) sqlResult.get(i);
    		
    		int  countryId = ((BigDecimal)subject[0]).intValue();
    		String name = cmCountryDAO.findById( (short) countryId ).getName();
    		long baseScore =((BigDecimal )subject[1]).longValue();
    		long addScore = ((BigDecimal )subject[2]).longValue();
    		long subScore = ((BigDecimal )subject[3]).longValue();
    		long totalScore = baseScore + addScore + subScore;
    		
    		String rankName =""  ;
    		
    		rankName = getRankLevelStrAccordingToScore(totalScore);
    		
    		ret.add( new StatisticsChengxinObj( name ,
    											subScore,
    											addScore,
    											baseScore,
    											totalScore,
    											rankName
    											) );
    	}
    	
    	// 调用排序方法，参数二为自定义的排序工具类
		//Collections.sort(ret, new ComparatorTownChengxinObj(false));
		// des order
    			
    	return ret;
    }
}
