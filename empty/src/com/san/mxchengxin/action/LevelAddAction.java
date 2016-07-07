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
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class LevelAddAction extends ChengxinBaseAction {
	private CmLevelDAO cmLevelDAO;
	private  String pageInfo_action ;
	private  String pageInfo_actionTitle;
	private  String action_method;
	private  String level_id;
	private  String level_level_name;
	private  String level_level_score;
	
	public CmLevelDAO geCmLevelDAO() {
		return cmLevelDAO;
	}
	
	public void setCmLevelDAO(CmLevelDAO cmLevelDAO) {
		this.cmLevelDAO = cmLevelDAO;
	}
	
	//点击增加等级 处理
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		pageInfo_action = "增加";
		pageInfo_actionTitle = pageInfo_action;
		
		request.setAttribute("pageInfo_action", pageInfo_action);
		request.setAttribute("pageInfo_actionTitle", pageInfo_actionTitle);
		
		String level_name = null;
		String level_score = null;
		
		LevelAddForm addF = (LevelAddForm)form;
		
		if( addF != null )
		{
			level_name = addF.getLevel_name();
			level_score = addF.getLevel_score();
		}
		
		
		if( (level_name != null) && ( level_score != null ))
		{ // submit
			CmLevel cl = new CmLevel();
			LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
			cl.setAuthor(userInfo.getCn());
			cl.setLevelName( level_name );
			cl.setLevelScore( level_score );
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			System.out.println(df.format(now));// new Date()为获取当前系统时间
			cl.setPubdate(now.getTime()/1000);
			
			saveMessageToLog("增加等级: " + cl.getLevelName() , request );
			cmLevelDAO.save( cl );
			
			
		}
		else
		{
			// click add button here , do nothing
		}
		return mapping.findForward("levelAddForword");
		
	}

	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		pageInfo_action = "修改";
		pageInfo_actionTitle = pageInfo_action;
		
		request.setAttribute("pageInfo_action", pageInfo_action);
		request.setAttribute("pageInfo_actionTitle", pageInfo_actionTitle);
		
		
		if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
			Short leveId = Short.valueOf(request.getParameter("id"));
			System.out.println("[update] id : "+leveId);
			
			CmLevel cmLevel = cmLevelDAO.findById(leveId);
			
			request.setAttribute("level_id", leveId );
			request.setAttribute("level_name", cmLevel.getLevelName());
			request.setAttribute("level_score", cmLevel.getLevelScore());
		}
		else if(request.getParameter("xid")!=null &&!request.getParameter("xid").isEmpty())
		{

			String level_name = null;
			String level_score = null;
			
			LevelAddForm addF = (LevelAddForm)form;
			
			if( addF != null )
			{
				level_name = addF.getLevel_name();
				level_score = addF.getLevel_score();
			}
			
			if( (level_name != null) && ( level_score != null ))
			{
				CmLevel cl = new CmLevel();
				LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
				cl.setAuthor(userInfo.getCn());
				cl.setLevelName( level_name );
				cl.setLevelScore( level_score );
				
				Short xId = Short.valueOf(request.getParameter("xid"));
				cl.setId( xId );
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				Date now = new Date();
				System.out.println(df.format(now));// new Date()为获取当前系统时间
				cl.setPubdate(now.getTime()/1000);
				saveMessageToLog("更新等级: " + cl.getLevelName() , request );
				cmLevelDAO.update( cl );
				
				
			}
			
		}
		
		return mapping.findForward("levelAddForword");

	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		super.execute(mapping, form, request, response);
		
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
