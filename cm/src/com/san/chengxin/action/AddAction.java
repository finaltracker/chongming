package com.san.chengxin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		if(request.getParameter("id") != null) {
			Short targetId = Short.valueOf(request.getParameter("id"));
			System.out.println("[update] id : "+targetId);
			request.setAttribute("pageInfo_action", "更新");
			
			CmTarget updateCT = cmTargetDAO.findById(targetId);
			
			request.setAttribute("target_name", updateCT.getTargetName());
			request.setAttribute("target_score", updateCT.getTargetScore());
			
			List<CmPart> partList = cmPartDAO.findAll();

			StringBuffer sb = new StringBuffer();
			
			for(int i=0;i<partList.size();i++) {
				CmPart cc = (CmPart)partList.get(i);
				//System.out.println("name: "+cc.getPartName()+cc.getId());
				String s;
				if( cc.getId() == updateCT.getPartId().shortValue() )
				{
					s = String.format("<option value='%d' selected>%s</option>", cc.getId(),cc.getPartName());
				}
				else
				{
					s = String.format("<option value='%d'>%s</option>", cc.getId(),cc.getPartName());
					
				}
				sb.append(s);
				
			}
			String partListSel = sb.toString();
			request.setAttribute("partListSel", partListSel);
			request.setAttribute("target_id", targetId);
			request.setAttribute("dateline", updateCT.getDateline());
			
			return mapping.findForward("addForword");
		}
		
		AddForm addF = (AddForm)form;
		String name = addF.getTarget_name();
		Short score = addF.getTarget_score();
		Short part = addF.getPart_id();
		Long dateline = addF.getDateline();
		
		
		if (name != null && score != null && part != null && dateline !=null) {
			System.out.println("[save]");
			CmTarget ct = new CmTarget();
			ct.setTargetName(name);
			ct.setDateline(dateline);
			ct.setPartId(part);
			ct.setTargetScore(score);
			//for test
			ct.setAuthor("cm");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			System.out.println(df.format(now));// new Date()为获取当前系统时间
			ct.setPubdate(now.getTime()/1000);
			
			if(!request.getParameter("xid").isEmpty()) {
				Short xId = Short.valueOf(request.getParameter("xid"));
				System.out.println("[update item] : "+xId);
				ct.setId(xId);
				cmTargetDAO.update(ct);
			} else {
				cmTargetDAO.save(ct);
			}
			
			return mapping.findForward("addForword");
		}
		
		request.setAttribute("pageInfo_action", "增加");
		
		List<CmPart> partList = cmPartDAO.findAll();

		StringBuffer sb = new StringBuffer();
		
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
