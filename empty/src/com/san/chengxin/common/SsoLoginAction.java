package com.san.chengxin.common;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.share.pmi.SysUser;
import com.san.share.pmi.dao.SysUserSearcher;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.service.UserPrivilegeDelegate;

public class SsoLoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("loginUserInfoBean");
			session.removeAttribute("com.san.share.pmi.currentLoginUser");
			session.removeAttribute("com.san.share.pmi.currentLoginUserCn");
			session.removeAttribute("com.san.share.pmi.loggedIn");
			session.invalidate();
		}

		String cn = request.getParameter("cn");
		String code = request.getParameter("code");

		try {
			session = request.getSession();
			session.setAttribute("com.san.share.pmi.loggedIn", "2");
			if (cn != null) {
				SysUser sysUser = SysUserSearcher.findSysUserByPK(cn);
				if (sysUser != null && code != null) {
					if (code.equals((SsoUtil.sso(cn)).trim())) {

						LoginUserInfo loginUserInfo = new LoginUserInfo();
						UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();

						loginUserInfo.setSysUser(sysUser);
						loginUserInfo.setUserPrivilege(userPrivilegeDelegate
								.getUserPrivilegeList(cn));

						session.setAttribute("com.san.share.pmi.loggedIn", "1");
						session.setAttribute(
								"com.san.share.pmi.currentLoginUser", sysUser
										.getSn());
						session.setAttribute(
								"com.san.share.pmi.currentLoginUserCn", sysUser
										.getId());
						session.setAttribute(
								"com.san.share.pmi.currentLoginUserOuid",
								sysUser.getOu().trim());
						session.setAttribute(
								LoginUserInfoDelegate.LOGINUSERINFOBEAN_NAME,
								loginUserInfo);

						if (cn.equals(LoginUserInfoDelegate.SYSTEM_ADMIN))
							return mapping.findForward("inUser");
						else
							return mapping.findForward("outUser");
					}
				}
			}
			request.setAttribute("message", "√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î£°");
			return mapping.findForward("loginError");
		} catch (Exception nse) {
			request.setAttribute("message", "µ«¬º ß∞‹£¨«Î÷ÿ ‘£°");
			return mapping.findForward("loginError");
		}
	}
}
