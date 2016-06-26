package com.log;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.action.ActionForward;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.log.config.LogConfigure;
import com.log.service.ILogInfoService;
import com.log.statistic.DataUsageStatistic;

import com.san.share.GetLoginUserInfo;
import com.san.tools.generator.UUIDFactory;
import com.san.tools.hibernate.exception.InsertException;


public class LogInterceptor implements MethodInterceptor {
    private Logger logger = Logger.getLogger(this.getClass().getName()); 
    private ILogInfoService service;
    private LogConfigure logConfigure = null;
    private String SERVICEPORT="portservice";
    
    public static String USERNAME;//用户名
    public static String USERID;//用户ID
    public static String DEPTNAME;//部门名称
    public static String DEPTID;//部门ID
    public static HttpServletRequest REQ;
    public static ApplicationContext ctx;
    public Object invoke(MethodInvocation invocation) {
    	System.out.print("--------------------9999-------------------------");
    	try {
        logConfigure = LogConfigure.getInstance();
    	Object ret = null;
    	HttpServletRequest request = (HttpServletRequest)invocation.getArguments()[2];  
    	ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
    	DEPTID = GetLoginUserInfo.getDeptIdFromSession(request);
		DEPTNAME = GetLoginUserInfo.getDeptNameFromSession(request);
		USERID = GetLoginUserInfo.getUserIdFromSession(request);
		USERNAME = GetLoginUserInfo.getUserNameFromSession(request);
		ret= invocation.proceed();
		//调用业务方法
        
//        ActionForward actionForward = (ActionForward)ret;
//        System.out.print("-----"+ret);
//        String path = "";
//        String methodName = "";
//        if(actionForward != null) {
//        	path = actionForward.getPath();
//        	methodName = request.getParameter("dispatch");//actionForward.getName();
//        	if(null==methodName || "".equals(methodName)){
//        		methodName="execute";
//        	}
//        }
//        
//        //String methodName = 
//        String info = logConfigure.getLogInfobyTarget(methodName+ " " +path);
//        String functionName = logConfigure.getLogInfobyFunctionName(methodName+ " " +path);
//        
//        String function = logConfigure.getLogInfobyFunction(methodName+ " " +path);
//
//        if(null != info && !info.equals("") && !info.equals("null null") && !info.equals("null")){       
//           writeLog(methodName,request,info,function,functionName); 
//        }

        System.out.println("拦截成功");
        return ret;
    	} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
        
    }    
    
    private void writeLog(String methodName,HttpServletRequest request,String info,String function,String functionName)
    {
    	
    	ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
    	service=(ILogInfoService) ctx.getBean(SERVICEPORT);
//      获取当前部门、用户、时间信息
        System.out.print("-------------------------------------------6");
        System.out.print("+++++++++++++++++++++++++++methodName+++++++++++++++++++++++++" + methodName);
		String deptId = GetLoginUserInfo.getDeptIdFromSession(request);
		String deptName = GetLoginUserInfo.getDeptNameFromSession(request);
		String userId = GetLoginUserInfo.getUserIdFromSession(request);
		String userName = GetLoginUserInfo.getUserNameFromSession(request);
		Date date = new Date();
		String instr=info.split(" ")[0];
        Enumeration enumeration = request.getParameterNames();
        if(null != function && function.equals("查询"))
        	instr += " 查询条件：" ;
        
        for(int i = 0;enumeration.hasMoreElements();i ++){
	    	String parameterName = (String)enumeration.nextElement();
	    	String parameterValue = request.getParameter(parameterName);
	    	if(null != parameterValue && !parameterValue.equals("") && parameterName.length() > 1 && 
	    			!parameterName.equals("dispatch") && !parameterName.equals("image.x") && 
	    			!parameterName.equals("image.y") && !parameterName.equals("image.x")&& 
	    			!parameterValue.equals("null") && !parameterName.equals("id") && 
	    			!parameterName.equals("out_id") && !parameterValue.equals("0") && !parameterName.equals("cztype")){
	    		
	    		if("userId".equals(parameterName)){
	    			instr = "的 "+userName+" " +instr;
	    		}
	    		
	    		if("deptId".equals(parameterName)){
	    			instr = " " + deptName+" "+ instr;
	    		}
	    		
	    		System.out.println(parameterValue);
	    	}
        }
        

        String isSuccess = request.getParameter("isSuccess");
        if(null != isSuccess && !isSuccess.equals(""))
        	instr += " " + isSuccess;
        
//		写日志
		DataUsageStatistic dataUsageStatistic = new DataUsageStatistic();

		String uuid = UUIDFactory.getUUIDKeyGenerator().generateKey().toString();
		dataUsageStatistic.setId(uuid);
		dataUsageStatistic.setDepartmentId(deptId);
		dataUsageStatistic.setDepartmentName(deptName);
		dataUsageStatistic.setUserId(userId);
		dataUsageStatistic.setUserName(userName);
		dataUsageStatistic.setOperateDesc(instr);
		dataUsageStatistic.setLogtype(info.split(" ")[1]);
		dataUsageStatistic.setOperateDate(date);
		dataUsageStatistic.setResourceId(functionName);
    		try
    		{
    			service.save(dataUsageStatistic);
    		}catch (Exception e) {
                e.printStackTrace();
            }
		} 
    }