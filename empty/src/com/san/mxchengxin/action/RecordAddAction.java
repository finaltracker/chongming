package com.san.mxchengxin.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;


public class RecordAddAction extends ChengxinBaseAction {
	CmTargetDAO	cmTargetDAO;
	
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
			String q ;
			String page;
			
			if( opt.equals("ajaxList") ) 
			{
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=utf-8");
				q = request.getParameter("q");
				page = request.getParameter("page");
				if( q!=null)
				{
					
					 PrintWriter out = null;
					try {
						out = response.getWriter();
					
				        // out.print("Hello World");  
				  

				        String json = "[{" + '"'+ "data" + '"'  +":" + '"' + " 210727197810080014 }]" ;  
				        out.append(json);
				        out.print(json);   
				        out.flush(); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  finally {  
				        if (out != null) {  
				            out.close();  
				        }  
				    }  
					
					
					  
				}
				
				return null;
			}
			else if( opt.equals("infoAjax") )
			{
				int id =  Integer.valueOf(request.getParameter("id")) ;

			}
			
		}
		
		request.setAttribute("pageInfo_action", pageInfo_action );
		request.setAttribute("pageInfo_actionTitle", pageInfo_actionTitle );
		request.setAttribute("targetSelect", targetSelectStr );
		
		return mapping.findForward( "recordAddForword" );
		
	}
	
	
}
