package com.san.share.pmi.service;

import javax.servlet.http.HttpServletRequest;

import com.san.share.pmi.dto.LoginUserInfo;

public class LoginUserInfoDelegate {

	static LoginUserInfo lui = null;
	
	public static LoginUserInfo getLoginUserInfoFromRequest( HttpServletRequest request )
	{
		return lui;
		
	}
	
	public static void setLui( LoginUserInfo l )
	{
		lui = l;
	}
}
