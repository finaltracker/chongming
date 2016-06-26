package com.san.share.pmi.struts;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.logServices.zqs.services.ILogServicesManger;
import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.jingtai.model.JingTaiLogInfo;
import com.san.share.pmi.dao.LdapApplicationSearcher;
import com.san.share.pmi.dao.SysOrglistSearcher;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.struts.form.SysOrglistForm;
import com.san.tools.pagetag.util.PageFindUtil;
import com.san.util.Vo;
import com.san.ysjgl.service.YsjglService;

public class DoFullOrgFindAllAction extends Action
{

    private static final Logger logger;

    public DoFullOrgFindAllAction()
    {
    }

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        SysOrglistForm sysOrglistActionForm = (SysOrglistForm)actionForm;
        try
        {
            String dispatch = httpServletRequest.getParameter("dispatch");
            logger.debug("DoFullOrgFindAllAction -------> dispatch = " + dispatch);
            String operator = LoginUserInfoDelegate.getCnFromRequest(httpServletRequest);
            operator="admin";
            boolean passed = false;
            if(operator.equals("admin"))
            {
                passed = true;
            } else
            if(dispatch.equals("selectUser") || dispatch.equals("selectOu") || dispatch.equals("selectOuUser"))
            {
                passed = true;
            } else
            if(dispatch.equals("toAuthor"))
            {
                if(LdapApplicationSearcher.getQueryCount("SysDomainApplication as sda, SysDomain as sd WHERE sd.domainadminId='" + operator + "' and item.id=sda.applicationId and sd.id=sda.domainId ORDER BY item.application" +
"Name,item.subsystemName,item.workflowName,item.stepName"
) > 0)
                {
                    passed = true;
                }
            } //市接口日志新加
            else if (dispatch.equals("queryServiceLog")) {
            	passed = true;
			}
            else
            {
                passed = false;
                return actionMapping.findForward("notAdmin");
            }
            /*下拉部门*/
            if(dispatch.equals("queryServiceLog")){
            	ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
            	YsjglService service=(YsjglService)ctx.getBean("ysjglserviceimpl");
            	String sql2=" select  ouid,ouname from sys_oulist t where 1=1 ";
        		sql2+=" order by t.displayorder ";
        		Vo v2 =service.getSQL(sql2);
        		httpServletRequest.setAttribute("bmlist",v2.getList());
        		
        		/*初始查询*/
        		ILogServicesManger logServices=(ILogServicesManger)ctx.getBean("ilogServicesManger");
        		int pageNo = PageFindUtil.getPageNo(httpServletRequest);
        		int pageSize = PageFindUtil.getPageSize(httpServletRequest,10);
        		int count = logServices.queryCountManager("0", "", "", "", "", "", "");
        		httpServletRequest.setAttribute("totalCount",count);
        		
        		List<JingTaiLogInfo> list = logServices.getListLogInfoManager("", "", "", "", "", "", pageNo, pageSize);
        		httpServletRequest.setAttribute("list",list);
            }
            
    		/*end*/
    		
            java.util.List sysOrglists = SysOrglistSearcher.findSysOrglistByCondition("");
            httpServletRequest.getSession().setAttribute("sysOrglists", sysOrglists);
            logger.debug("dispatch:" + dispatch);
            return actionMapping.findForward(dispatch);
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "DoFullOrgFindAllAction\u53D1\u751F\u9519\u8BEF\uFF1A" + ex.getMessage());
            logger.error("DoFullOrgFindAllAction\u53D1\u751F\u9519\u8BEF\uFF1A-->" + ex);
            return actionMapping.findForward("unknown-error");
        }
    }
    static 
    {
        logger = Logger.getLogger(com.san.share.pmi.struts.DoFullOrgFindAllAction.class);
    }
   
}
