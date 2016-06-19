package com.san.chengxin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.model.part.CmPart;
import com.san.chengxin.model.part.CmPartDAO;
import com.san.chengxin.model.target.CmTarget;
import com.san.chengxin.model.target.CmTargetDAO;


public class TargetAction extends Action {
	private CmTargetDAO cmTargetDAO;
	private CmPartDAO cmPartDAO;
	
	public CmTargetDAO geCmTargetDAO() {
		return cmTargetDAO;
	}
	
	public void setCmTargetDAO(CmTargetDAO cmTargetDAO) {
		this.cmTargetDAO = cmTargetDAO;
	}
	
	public CmPartDAO geCmPartDAO() {
		return cmPartDAO;
	}
	
	public void setCmPartDAO(CmPartDAO cmTargetDAO) {
		this.cmPartDAO = cmPartDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

/*		List<CmTarget> ccs = cmTargetDAO.findAll();
		for(int i=0;i<ccs.size();i++) {
			CmTarget cc = (CmTarget)ccs.get(i);
			System.out.println("name: "+cc.getTargetName());
		}*/
		List<CmPart> ccs = cmPartDAO.findAll();
		for(int i=0;i<ccs.size();i++) {
			CmPart cc = (CmPart)ccs.get(i);
			System.out.println("name: "+cc.getPartName());
		}		
		request.setAttribute("partListSel", ccs);
		return mapping.findForward( "targetForword" );
	}
}
