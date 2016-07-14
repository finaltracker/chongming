package com.san.mxchengxin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;
import com.san.mxchengxin.objects.PersonSimpleObj;
import com.san.mxchengxin.utils.util;


public class RecordAddAction extends ChengxinBaseAction {
	CmTargetDAO	cmTargetDAO;
	CmPersonDAO cmPersonDAO;
	CmCountryDAO	cmCountryDAO;
	CmRecordDAO		cmRecordDAO;
	CmPartDAO	cmPartDAO;
	

	String pageInfo_action = "增加";
	String pageInfo_actionTitle = "录入"; 
	
	final int pageSize = 30;
	

	public CmRecordDAO getCmRecordDAO() {
		return cmRecordDAO;
	}

	public void setCmRecordDAO(CmRecordDAO cmRecordDAO) {
		this.cmRecordDAO = cmRecordDAO;
	}

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

	public CmPartDAO getCmPartDAO() {
		return cmPartDAO;
	}

	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		super.execute(mapping, form, request, response);
		
		

		
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
			else if( opt.equals("save"))
			{
				return saveReq( request ,response );
			}
			else if( opt.equals("save2"))
			{
				return save2Req( request ,response  );
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
	
	//save
	public ActionForward saveReq( HttpServletRequest request , HttpServletResponse response )
	{
		String action = request.getParameter("action");
		String score = request.getParameter("score");
		String target_id = request.getParameter("target_id");
		String person_id = request.getParameter("person_id");
		long part_id = getPartId( this.cmPartDAO , this.cmCountryDAO );
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		long pubdate = now.getTime()/1000;
		
		long  day = cmTargetDAO.findById( Short.valueOf(target_id ) ).getDateline();
		long dateLine = day * 24 * 60 * 60 + pubdate;
		
		if( action.equals( pageInfo_action ))
		{
			String author = cn;
			
			boolean stat = false;
			if( this.isAllVisiable() )
			{
				stat = true;
			}

			CmRecord cr = new CmRecord( cmPersonDAO.findById( Integer.valueOf( person_id )),
										Integer.valueOf( target_id ),
										Short.valueOf( score ),
										author,
										pubdate,
										stat,
										dateLine,
										part_id 
										) ;
			cmRecordDAO.save( cr );
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/javascript");
			Map<String , Object > jasonOut = new HashMap<String , Object >();
			jasonOut.put("stat", stat);
			jasonOut.put("id", cr.getId() );
			
			JSONArray jsonObject = JSONArray.fromObject( jasonOut );//装换json
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
	
	//confirm save 
		public ActionForward save2Req( HttpServletRequest request , HttpServletResponse response )
		{
			String id = request.getParameter("id");
			
			CmRecord cmRecord = cmRecordDAO.findById( Integer.valueOf( id ) );
			
			cmRecord.setStat( true );
			
			cmRecordDAO.update(cmRecord);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/javascript");

			return null;
		}
	
}