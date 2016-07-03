package com.san.mxchengxin.action;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.form.LevelAddForm;
import com.san.mxchengxin.form.part.PartAddForm;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class PartAddAction extends Action {

	private  String pageInfo_action ;
	private String  part_name;


	private CmPartDAO cmPartDAO;

	public CmPartDAO geCmPartDAO() {
		return cmPartDAO;
	}
	
	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
	}
	
	
	//点击增加等级 处理
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		

		
		pageInfo_action = "增加";

		
		request.setAttribute("pageInfo_action", pageInfo_action);
		
		
		PartAddForm addF = (PartAddForm)form;
		
		if( addF != null )
		{
			part_name = addF.getpart_name();
		}
		
		
		if(part_name != null)
		{ // submit
			CmPart cp = new CmPart();
			cp.setPartName( part_name );
			
			cmPartDAO.save( cp );
			
			
		}
		else
		{
			// click add button here , do nothing
		}
		return mapping.findForward("partAddForword");
		
	}

	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		pageInfo_action = "修改";
		
		request.setAttribute("pageInfo_action", pageInfo_action);
		
		
		if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
			Short part_id = Short.valueOf(request.getParameter("id"));
			System.out.println("[update] id : "+part_id);
			
			CmPart cmPart = cmPartDAO.findById(part_id);
			
			request.setAttribute("part_id", part_id );
			request.setAttribute("part_name", cmPart.getPartName());
		}
		else if(request.getParameter("xid")!=null &&!request.getParameter("xid").isEmpty())
		{

			
			PartAddForm addF = (PartAddForm)form;
			
			if( addF != null )
			{
				part_name = addF.getpart_name();
			}
			

			if(part_name != null)
			{ // submit
				CmPart cp = new CmPart();
				cp.setPartName( part_name );

				Short xId = Short.valueOf(request.getParameter("xid"));
				cp.setId( xId );
				
				cmPartDAO.update( cp );
				
				
			}
			
		}
		
		return mapping.findForward("partAddForword");

	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("method") != null && !request.getParameter("method").isEmpty()) {
			Short actionMethod = Short.valueOf(request.getParameter("method"));
			System.out.println(" level op action : "+actionMethod);
			request.setAttribute("action_method", request.getParameter("method"));
			if(actionMethod == 1) {
				System.out.println("add action");
				
				
				return add(mapping,form,request,response);
				
			} 
			
			else if (actionMethod == 3) {
				System.out.println("modify action");
				
				return update(mapping,form,request,response);
			} else {
				System.out.println("others action");
			}
	
		}
		
		// 
		//String partListSel = sb.toString();
		//request.setAttribute("partListSel", partListSel);
		return mapping.findForward("levelAddForword");
	}
}
