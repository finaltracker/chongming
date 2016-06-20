package com.san.chengxin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.form.TargetForm;
import com.san.chengxin.model.part.CmPart;
import com.san.chengxin.model.part.CmPartDAO;
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
	
	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		Integer pardId = 0 ;
		String  targetName = "";
		
		if( form instanceof TargetForm  )
		{
			TargetForm targetForm = (TargetForm) form;
			pardId		=    targetForm.getPart_id();
			targetName  = targetForm.getTarget_name();
		}
/*		List<CmTarget> ccs = cmTargetDAO.findAll();
		for(int i=0;i<ccs.size();i++) {
			CmTarget cc = (CmTarget)ccs.get(i);
			System.out.println("name: "+cc.getTargetName());
		}*/
		List<CmPart> ccs = cmPartDAO.findAll();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ccs.size();i++) {
			CmPart cc = (CmPart)ccs.get(i);
			//System.out.println("name: "+cc.getPartName()+cc.getId());
			String s = String.format("<option value='%d'>%s</option>", cc.getId(),cc.getPartName());
			sb.append(s);
		}
		//<option value='12' selected>涔￠晣</option><option value='13' >鏉�/option><option value='15' >
		System.out.println("result: "+sb.toString());
		String partListSel = sb.toString();
		request.setAttribute("partListSel", partListSel);
		
		return mapping.findForward( "targetForword" );
	}
}
