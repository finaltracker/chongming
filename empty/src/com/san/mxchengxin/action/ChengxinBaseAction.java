package com.san.mxchengxin.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.log.CmLogDAO;
import com.san.mxchengxin.objects.CountryMapObj;
import com.san.share.pmi.dto.LoginUserInfo; 
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class ChengxinBaseAction extends Action {
	
	protected String cn ;
	protected String ouId ;
	protected String ouName ;
	protected String sn ;
	
	CmLogDAO cmLogDAO = null; 
	
	private String[] specifyPartmentList = {
	"系统管理部",
	"崇明县"	
	};
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		//Object o = getBean("com.san.mxchengxin.model.log.CmLogDAO");
		
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
		
		//for test 
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
			}
			
			DetachedCriteria searDc =	DetachedCriteria.forClass( CmCountry.class);
	
			searDc.add(Restrictions.or( Restrictions.eq("id", cmCountry.get(0).getId() )  , Restrictions.eq("parentid", cmCountry.get(0).getId() )));
					
			countryList = cmCountryDAO.getHibernateTemplate ().findByCriteria( searDc );
			
		}
		return countryList;
	}
	
	// out: String[] names = {"AAA","BBB","CCC"};
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
	
	/**
     * Convenience method to get Spring-initialized beans
     *
     * @param name
     * @return Object bean from ApplicationContext
     */
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
        return ctx.getBean(name);
    }
}
