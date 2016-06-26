package com.san.mxchengxin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.san.share.pmi.dto.LoginUserInfo; 
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class ChengxinBaseAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
				return null;
		
		
	}
	
	public boolean authCheck( HttpServletRequest request )
	{
		boolean ret = true;
		LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
		userInfo.getCn();//获得用户登录名
		userInfo.getOuid();//获得用户所属部门ID
		userInfo.getOuname();//获得用户所属部门名称
		userInfo.getSn();//获得用户姓名

		return ret ;
	}
}
