package com.san.common.init;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 初始化ApplicationContext
 * @author wuwh
 *
 */
public class InitServlet implements Servlet{
	
	public static ApplicationContext ctx;
	public static String sysPath;
	private static final Log log = LogFactory.getLog(InitServlet.class);
	
	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
	
	public void init(ServletConfig servlet) throws ServletException {
		ctx = WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
		log.debug("初始化ApplicationContext成功");
		
		sysPath = servlet.getServletContext().getRealPath("/");
		log.debug("初始化系统路径成功,当前系统路径为" + sysPath);
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {

	}
}
