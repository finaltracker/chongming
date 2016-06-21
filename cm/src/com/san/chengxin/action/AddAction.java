package com.san.chengxin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.form.AddForm;
import com.san.chengxin.model.part.CmPart;
import com.san.chengxin.model.part.CmPartDAO;
import com.san.chengxin.model.target.CmTarget;
import com.san.chengxin.model.target.CmTargetDAO;

public class AddAction extends Action {
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
		
		AddForm addF = (AddForm)form;
		String name = addF.getTarget_name();
		Short score = addF.getTarget_score();
		Short part = addF.getPart_id();
		Long dateline = addF.getDateline();
		
		System.out.println("who come here??+name: "+name+" part: "+part);
		
		if (name != null && score != null && part != null && dateline !=null) {
			System.out.println("there are not null!!");
			CmTarget ct = new CmTarget();
			ct.setTargetName(name);
			ct.setDateline(dateline);
			ct.setPartId(part);
			ct.setTargetScore(score);
			//for test
			ct.setAuthor("cm");
			java.util.Date date = new java.util.Date();
			ct.setPubdate((long)date.getDate());
			//Short forkId = new Short(15);
			//ct.setId(forkId);
			
			cmTargetDAO.save(ct);
			
			return mapping.findForward("addForword");
		}
		
		//查询 part表
		List<CmPart> partList = cmPartDAO.findAll();

		StringBuffer sb = new StringBuffer();
		
		/*
		 * <option value='12' selected>乡镇</option>
		 * <option value='13' >村</option>
		*/
		for(int i=0;i<partList.size();i++) {
			CmPart cc = (CmPart)partList.get(i);
			//System.out.println("name: "+cc.getPartName()+cc.getId());
			String s;
			s = String.format("<option value='%d'>%s</option>", cc.getId(),cc.getPartName());
			sb.append(s);
			
		}
		String partListSel = sb.toString();
		request.setAttribute("partListSel", partListSel);
		return mapping.findForward("addForword");
	}
}
