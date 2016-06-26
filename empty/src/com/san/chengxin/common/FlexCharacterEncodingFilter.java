package com.san.chengxin.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FlexCharacterEncodingFilter implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest =(HttpServletRequest)request;
		
		
		
		httpRequest.setCharacterEncoding("gb2312");
		
		String s = new String();
		System.out.println(request.getCharacterEncoding());
//		String flex = request.getParameter("flex");
//		if(flex != null && !flex.equals("")) {
//			request.setCharacterEncoding("utf-8");
//		} else {
//			request.setCharacterEncoding("GB2312");
//		}
		chain.doFilter(httpRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
