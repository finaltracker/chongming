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
import com.san.chengxin.utils.Constants;
import com.san.share.pmi.dto.LoginUserInfo; 
import com.san.share.pmi.service.LoginUserInfoDelegate;

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
	
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		AddForm addF = (AddForm)form;
		String name = addF.getTarget_name();
		Short score = addF.getTarget_score();
		Short part = addF.getPart_id();
		Long dateline = addF.getDateline();
		
		if (name != null && score != null && part != null && dateline !=null) {
			CmTarget ct = new CmTarget();
			ct.setTargetName(name);
			ct.setDateline(dateline);
			ct.setPartId(part);
			ct.setTargetScore(score);
			//for test
			ct.setAuthor("cm");
			/*
			LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
			userInfo.getCn();//获得用户登录名
			userInfo.getOuid();//获得用户所属部门ID
			userInfo.getOuname();//获得用户所属部门名称
			userInfo.getSn();//获得用户姓名
			ct.setAuthor(userInfo.getCn());
			*/
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			System.out.println(df.format(now));// new Date()为获取当前系统时间
			ct.setPubdate(now.getTime()/1000);
			
			cmTargetDAO.save(ct);
		} else {
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
		}
			
		return mapping.findForward("addForword");
	}
	
	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
			Short targetId = Short.valueOf(request.getParameter("id"));
			System.out.println("[update] id : "+targetId);
			
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
		}
		
		if(request.getParameter("xid")!=null &&!request.getParameter("xid").isEmpty()) {
			AddForm addF = (AddForm)form;
			String name = addF.getTarget_name();
			Short score = addF.getTarget_score();
			Short part = addF.getPart_id();
			Long dateline = addF.getDateline();
			
			if (name != null && score != null && part != null && dateline !=null) {
				CmTarget ct = new CmTarget();
				ct.setTargetName(name);
				ct.setDateline(dateline);
				ct.setPartId(part);
				ct.setTargetScore(score);

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				Date now = new Date();
				System.out.println(df.format(now));// new Date()为获取当前系统时间
				ct.setPubdate(now.getTime()/1000);
				Short xId = Short.valueOf(request.getParameter("xid"));
				System.out.println("[update item] : "+xId);
				ct.setId(xId);
				ct.setAuthor(cmTargetDAO.findById(xId).getAuthor());
				cmTargetDAO.update(ct);
			}
		}
		return mapping.findForward("addForword");
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("method") != null && !request.getParameter("method").isEmpty()) {
			Short actionMethod = Short.valueOf(request.getParameter("method"));
			System.out.println("op action : "+actionMethod);
			if(actionMethod == 1) {
				System.out.println("add action");
				request.setAttribute("pageInfo_action", "增加");
				request.setAttribute("action_method", 1);
				return add(mapping,form,request,response);
			} else if (actionMethod == 3) {
				System.out.println("modify action");
				request.setAttribute("pageInfo_action", "更新");
				request.setAttribute("action_method", 3);
				return update(mapping,form,request,response);
			} else {
				System.out.println("others action");
			}
		}
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
