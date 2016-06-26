package com.san.pdwm.appInit.usermenuinit.web;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.san.pdwm.appInit.usermenuinit.service.AppInitService;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.UserPrivilegeDelegate;
import com.san.share.pmi.LdapApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.san.tools.generator.UUIDFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.san.chengxin.common.web.struts.action.BaseAction;




public class AppInitAction extends BaseAction{
	
	
	//初始化用户权限菜单数据
	public ActionForward initMenu(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		
		   ActionForward actionForward = null;
		   
		   String userId = LoginUserInfoDelegate.getCnFromRequest(request);//获取当前用户
		   List userMenuList = new ArrayList();
		   
		   AppInitService appInitServiceImpl = (AppInitService)getBean("AppInitServiceImpl");
		   
		   try
		   {
			   
//			   userId="admin";
			   userMenuList = appInitServiceImpl.initMenu(userId);//获取用户权限菜单数据
			   request.setAttribute("userMenuList", userMenuList);
			   actionForward = mapping.findForward("goMenuPage");
		   }
		   catch(Exception ex){
			   
			   System.out.print("userMenuInitModel error info " + ex);
			   actionForward = mapping.findForward("error");
		   }
		   
		   return actionForward;
	}
}
