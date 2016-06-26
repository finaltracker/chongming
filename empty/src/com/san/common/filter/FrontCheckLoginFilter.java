/*
 * Created on 2007-5-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.san.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.san.share.pmi.service.LoginUserInfoDelegate;


/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FrontCheckLoginFilter implements Filter{
	
	private FilterConfig config = null;

	private String exceptablePages = null;

	private String frontLoginPage = null;

	private String[] pagesArray = null;

	private Logger log = Logger.getLogger(getClass());
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		log.debug("*************************init****************************");
		this.config = config;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest p_request, ServletResponse p_response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		
		
		
		HttpServletRequest request = (HttpServletRequest) p_request;
		HttpServletResponse response = (HttpServletResponse) p_response;
		String requestPath = request.getServletPath();
//		System.out.println(requestPath);
		String contextPath = request.getContextPath();
//		System.out.println(contextPath);

	    if (isExceptablePage(requestPath)) { 
			HttpSession session = ((HttpServletRequest) request)
					.getSession(false);
			String userId = LoginUserInfoDelegate.getCnFromRequest(request);
			String userName = LoginUserInfoDelegate.getSnFromRequest(request);
			String inputDeptName = LoginUserInfoDelegate.getOuFromRequest(request);
			if (null == session || null == userId) {
				((HttpServletResponse) response).sendRedirect("/web/logoutAction.do");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
//		System.out.println("*************************destroy****************************");
	}
	
	private boolean isExceptablePage(String page) {
		if(page.equals("/loginAction.do") || page.equals("/login.jsp") || page.equals("/logoutAction.do") || page.equals("/logerr.jsp") ){
			return false;
		}

		return true;
	}

}
