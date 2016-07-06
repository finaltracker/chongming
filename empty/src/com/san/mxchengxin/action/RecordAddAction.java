package com.san.mxchengxin.action;

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
		
		
		
		request.setAttribute("pageInfo_action", pageInfo_action );
		request.setAttribute("pageInfo_actionTitle", pageInfo_actionTitle );
		request.setAttribute("targetSelect", targetSelectStr );
		
		return mapping.findForward( "recordAddForword" );
		
	}
	
	
}
