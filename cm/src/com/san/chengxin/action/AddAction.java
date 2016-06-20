package com.san.chengxin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.model.target.CmTargetDAO;

public class AddAction extends Action {
	private CmTargetDAO cmTargetDAO;
	public CmTargetDAO geCmTargetDAO() {
		return cmTargetDAO;
	}
	
	public void setCmTargetDAO(CmTargetDAO cmTargetDAO) {
		this.cmTargetDAO = cmTargetDAO;
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward("addForward");
	}
}
