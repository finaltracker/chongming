package com.san.mxchengxin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;
import com.san.mxchengxin.objects.PersonSimpleObj;
import com.san.mxchengxin.utils.util;


public class RecordAddAction extends ChengxinBaseAction {
	CmTargetDAO	cmTargetDAO;
	CmPersonDAO cmPersonDAO;
	CmCountryDAO	cmCountryDAO;
	
	final int pageSize = 30;
	

	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}

	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public CmPersonDAO getCmPersonDAO() {
		return cmPersonDAO;
	}

	public void setCmPersonDAO(CmPersonDAO cmPersonDAO) {
		this.cmPersonDAO = cmPersonDAO;
	}

	public CmTargetDAO getCmTargetDAO() {
		return cmTargetDAO;
	}

	public void setCmTargetDAO(CmTargetDAO cmTargetDAO) {
		this.cmTargetDAO = cmTargetDAO;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		super.execute(mapping, form, request, response);
		
		
		String pageInfo_action = "录入";
		String pageInfo_actionTitle = "录入"; 
		
		List<CmTarget> targetList = cmTargetDAO.findAll(); 
		String targetSelectStr = cmTargetDAO.formatToJspString( targetList , (short)(-1) );
		
		
		if(request.getParameter("opt") != null) {
			String opt = request.getParameter("opt");
			
			
			if( opt.equals("ajaxList") ) 
			{
				// ajax requestion
				return ajaxListReq( request , response );
			}
			else if( opt.equals("infoAjax") )
			{
				return infoAjaxReq( request , mapping );
			}
			
			
		}
		
		request.setAttribute("pageInfo_action", pageInfo_action );
		request.setAttribute("pageInfo_actionTitle", pageInfo_actionTitle );
		request.setAttribute("targetSelect", targetSelectStr );
		
		return mapping.findForward( "recordAddForword" );
		
	}
	
	public List<PersonSimpleObj> personListToRecordSimpleList( List<CmPerson> personList ,Map< Short , CmCountry > countryMap )
	{
		List<PersonSimpleObj> ret = new ArrayList<PersonSimpleObj>( personList.size() );
		
		for( int i = 0 ; i < personList.size() ; i++ )
		{
			CmPerson cp = personList.get(i);
			
			ret.add( new PersonSimpleObj( cp.getTruename() , cp.getSsid() , cp.getId().toString() , countryMap.get( cp.getCountryId() ).getName() ) );
		}
		
		return ret;
	}
	
	public ActionForward ajaxListReq( HttpServletRequest request, HttpServletResponse response )
	{
		String q  = null;
		String page;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		q = request.getParameter("q");
		try {
			q = URLDecoder.decode( q, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		// page NO 
		String p = request.getParameter("page");
		if( p == null ) 
		{
			p = "0";
		}
		if( (q != null ) && (!q.isEmpty()) )
		{
			/* 设置查询person表条件 */
			
			Session s = cmPersonDAO.getSessionFactory().openSession();
			Criteria searDc =  s.createCriteria( CmPerson.class );
			
			if( util.isNumeric(q) )
			{
				searDc.add( Restrictions.like("ssid", q, MatchMode.START )  );
				searDc.addOrder( Order.asc("ssid") );

			}
			else
			{
				searDc.add( Restrictions.like("truename", q, MatchMode.START )  );
				searDc.addOrder( Order.asc("truename") );
			}
			
			searDc.setFirstResult( Integer.valueOf(p) * pageSize );
			searDc.setMaxResults( pageSize );
			
			List<CmPerson> personList = searDc.list();
			Map< Short , CmCountry > countryMap = cmCountryDAO.listAsMap();
			
			List<PersonSimpleObj> rsoList = personListToRecordSimpleList( personList , countryMap );
			
		
			JSONArray jsonObject = JSONArray.fromObject( rsoList );//装换json
			response.setContentType("text/html;charset=UTF-8"); 
			response.setHeader("Cache-Control", "no-cache"); 
			PrintWriter out;
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
		
		return null;
	}
	
	public ActionForward infoAjaxReq( HttpServletRequest request, ActionMapping mapping )
	{
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String idString = request.getParameter("id");
		int id = 0;
		if( ( idString != null ) && (!idString.isEmpty() ) )
		{
			id =  Integer.valueOf( idString ) ;
			CmPerson cp = cmPersonDAO.findById( id );
			String countryName = "";
			CmCountry cc = cmCountryDAO.findById( cp.getCountryId() );
			if( cc != null )
			{
				countryName = cc.getName();
			}
			request.setAttribute("person", cp );
			request.setAttribute("countryName", countryName );
			
			return mapping.findForward( "infoAjaxForword" );
			
		}
		
		
		return null;
	}
	
}
