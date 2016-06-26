package com.san.share.pmi.service;

import com.san.share.pmi.SysOrglist;
import com.san.share.pmi.SysUser;
import com.san.share.pmi.dao.SysOrglistSearcher;
import com.san.share.pmi.dto.LoginUserInfo;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserInfoDelegate
{
  public static final String LOGINUSERINFOBEAN_NAME = "loginUserInfoBean";
  public static final String SYSTEM_ADMIN = "admin";

  public static LoginUserInfo getLoginUserInfoFromRequest(HttpServletRequest httpServletRequest)
  {
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      return loginUserInfo;
    }
    return null;
  }

  public static String getCnFromRequest(HttpServletRequest httpServletRequest)
  {
    String cn = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        cn = loginUserInfo.getCn();
      }
    }
    return cn;
  }

  public static String getSnFromRequest(HttpServletRequest httpServletRequest)
  {
    String sn = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        sn = loginUserInfo.getSn();
      }
    }
    return sn;
  }

  public static String getOFromRequest(HttpServletRequest httpServletRequest)
  {
    String o = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        try {
          o = SysOrglistSearcher.findSysOrglistByPK(
            loginUserInfo.getSysUser().getO()).getOrgName();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return o;
  }

  public static String getOuFromRequest(HttpServletRequest httpServletRequest)
  {
    String ou = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        try {
          ou = loginUserInfo.getOuname();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return ou;
  }

  public static String getOrgidFromRequest(HttpServletRequest httpServletRequest)
  {
    String o = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        o = loginUserInfo.getSysUser().getO();
      }
    }
    return o;
  }

  public static String getOuidFromRequest(HttpServletRequest httpServletRequest)
  {
    String ou = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        ou = loginUserInfo.getOuid();
      }
    }
    return ou;
  }

  public static ArrayList getUserPrivilage(HttpServletRequest httpServletRequest)
  {
    ArrayList userPrivilage = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        userPrivilage = loginUserInfo.getUserPrivilege();
      }
    }
    return userPrivilage;
  }
  public static String getUserXzqy(HttpServletRequest httpServletRequest)
  {
	  String userPrivilage = null;
    HttpSession httpSession = httpServletRequest.getSession(false);
    if (httpSession != null) {
      LoginUserInfo loginUserInfo = (LoginUserInfo)httpSession.getAttribute("loginUserInfoBean");
      if (loginUserInfo != null) {
        userPrivilage = loginUserInfo.getSysUser().getEmail();
      }
    }
    return userPrivilage;
  }
  
  
  
  
  public static void main(String[] args) {
    LoginUserInfoDelegate loginUserInfoDelegate1 = new LoginUserInfoDelegate();
  }
}