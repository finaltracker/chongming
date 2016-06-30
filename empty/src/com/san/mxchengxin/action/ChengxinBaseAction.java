package com.san.mxchengxin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.share.pmi.dto.LoginUserInfo; 
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class ChengxinBaseAction extends Action {
	
	protected String cn ;
	protected String ouId ;
	protected String ouName ;
	protected String sn ;
	
	private String[] specifyPartmentList = {
	"系统管理部",
	"崇明县"	
	};
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
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
		if( ouName == "" ) ouName = "系统管理部";
		sn = userInfo.getSn();//获得用户姓名

		return ret ;
	}
	
	private boolean isAllVisiable()
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
		Integer[] names = new Integer[countryList.size()];
		
		for( int i = 0 ; i < countryList.size() ; i++ )
		{
			names[i] = new Integer((countryList.get(i).getId()));
		}
		
		return names;
	}
	
}
