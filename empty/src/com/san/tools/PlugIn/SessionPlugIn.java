/*
 * Created on 2007-3-6
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.san.tools.PlugIn;

import javax.servlet.ServletException;

import com.san.tools.hibernate3.session.SessionManager;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.hibernate.SessionFactory;
/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


public class SessionPlugIn implements PlugIn{

    private ApplicationContext ctx;
    private SessionManager sessionManager;
    private String beanName;
    /* (non-Javadoc)
     * @see org.apache.struts.action.PlugIn#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
     */
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        // TODO Auto-generated method stub
        System.out.print("执行Plug-In开始");
        try{
        ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
        
        getBean();
        }catch(Exception ex){
            System.out.print("发生错误的详细信息是" + ex);
        }
        System.out.print("执行Plug-In结束");
    }
    
    private void getBean(){
        System.out.print("beanName value is"+beanName);
        SessionFactory sessionFactory 
                     = (SessionFactory)ctx.getBean("sessionFactory");
        
        sessionManager = sessionManager.getInstance();
        
        sessionManager.initialize("SessionFactoryBySpring",sessionFactory);
    }
  
}
