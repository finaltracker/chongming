package com.san.mxchengxin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.log.CmLog;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.objects.levelCatigoryObj;
import com.san.mxchengxin.utils.ComparatorCmLevel;


public class ReportAction extends ChengxinBaseAction {

	private CmLevelDAO cmLevelDAO;
	private CmRecordDAO cmRecordDAO;
	private CmCountryDAO cmCountryDAO;
	
	public CmCountryDAO geCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public CmLevelDAO geCmLevelDAO() {
		return cmLevelDAO;
	}
	
	public void setCmLevelDAO(CmLevelDAO cmLevelDAO) {
		this.cmLevelDAO = cmLevelDAO;
	}
	
	public CmRecordDAO geCmRecordDAO() {
		return cmRecordDAO;
	}
	
	public void setCmRecordDAO(CmRecordDAO cmRecordDAO) {
		this.cmRecordDAO = cmRecordDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		super.execute( mapping, form, request, response);
		
		// 获取所有的level 列表
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmLevel.class);
		
		List<CmLevel> levelList = cmLevelDAO.getHibernateTemplate ().findByCriteria( searDc );
		
		// 调用排序方法，参数二为自定义的排序工具类
		Collections.sort(levelList, new ComparatorCmLevel());
		// des order
		
		/*  */
		Short[] countryList = getVisiableCountryForShort( this.cmCountryDAO );
		
		
		List<levelCatigoryObj> lcoList = null;
		if( countryList != null )
		{
			//产生jsp 对应的对象
			lcoList = new ArrayList<levelCatigoryObj>();
			Session s = cmLogDAO.getSessionFactory().openSession();
			
			for( int i = 0 ; i < levelList.size() ; i++ )
			{
				// 遍历所有的level 列表
				Criteria searDcForRecord =  s.createCriteria( CmRecord.class );
				
				
				if( i != 0 )
				{
					//< 
					searDcForRecord.add(Restrictions.lt("score", new Short(levelList.get(i-1).levelScore ) ) );
				}
				//>= 
				searDcForRecord.add(Restrictions.ge("score", new Short(levelList.get(i).levelScore ) ) );
				
				searDcForRecord.setFetchMode("person", FetchMode.JOIN); 
				searDcForRecord.createAlias("person", "person");  
				
				if( (countryList!= null )&& ( countryList.length > 0 ))
				{
					searDcForRecord.add(Restrictions.in("person.countryId", countryList ));
				}
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				Date now = new Date();
				System.out.println(df.format(now));// new Date()为获取当前系统时间
				long currentTime = now.getTime()/1000;
				
				searDcForRecord.add( Restrictions.ge(  "dateline", currentTime ) );
				searDcForRecord.setProjection(Projections.rowCount());
				
				List<Integer> recordList = searDcForRecord.list();
				
				//List recordList = cmRecordDAO.getHibernateTemplate ().findByCriteria( searDcForRecord );
				
				levelCatigoryObj lco = new levelCatigoryObj();
				lco.setLevelId( levelList.get(i).getId().toString() );
				lco.setLevelName( levelList.get(i).getLevelName() );
				if( recordList.size() > 0 )
				{
					lco.setHowmanyPeople( String.valueOf(recordList.get(0)) );
				}
				lcoList.add( lco );
			}
		}
		
		request.setAttribute("Level_List", lcoList );
		request.setAttribute("part_name", ouName );
		return mapping.findForward( "reportForword" );
	}
}
