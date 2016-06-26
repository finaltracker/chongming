package com.san.share.pmi.struts;

import com.san.share.pmi.SysAppauthorize;
import com.san.share.pmi.dao.LdapApplicationSearcher;
import com.san.share.pmi.dao.SysAppauthorizeSearcher;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.struts.form.SysAppauthorizeForm;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

public class DoSysAppauthorizeFindByUserAction extends Action
{

    private static final Logger logger;

    public DoSysAppauthorizeFindByUserAction()
    {
    }

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        SysAppauthorizeForm sysAppauthorizeForm = (SysAppauthorizeForm)actionForm;
        try
        {
        	
        	System.out.println("ririririririri");
        	
            logger.debug("Form data get");
            String operator = LoginUserInfoDelegate.getCnFromRequest(httpServletRequest);
            operator="admin";
            List ldapApplicationList = null;
            if(operator.equals("admin"))
            {
                ldapApplicationList = LdapApplicationSearcher.findLdapApplicationByCondition("");
            } else
            {
                ldapApplicationList = LdapApplicationSearcher.findLdapApplication("SELECT a from LdapApplication a, SysDomain b, SysDomainapplication c Where (a.id" +
" = c.applicationId) and (c.domainId = b.Id) and (b.domainadminId = '"
 + operator + "')");
                if(ldapApplicationList.isEmpty())
                {
                    return actionMapping.findForward("notDomainAdmin");
                }
            }
            String authtoId = httpServletRequest.getParameter("authtoId");
            logger.debug("authtoId:" + authtoId);
            if(authtoId == null)
            {
                authtoId = (String)httpServletRequest.getAttribute("authtoId");
            }
            
            
            httpServletRequest.setAttribute("authtoId", authtoId);
            httpServletRequest.setAttribute("authtotype", httpServletRequest.getParameter("authtotype"));
            List sysAppauthorizes = SysAppauthorizeSearcher.findSysAppauthorizeByCondition("Where item.AuthtoId = '" + authtoId + "'");
            LinkedHashMap resultList = new LinkedHashMap();
            Iterator iter = sysAppauthorizes.iterator();
            for(int i = 0; i < sysAppauthorizes.size(); i++)
            {
                logger.debug("i:" + i);
                SysAppauthorize sysAppauthorize = (SysAppauthorize)iter.next();
                resultList.put(sysAppauthorize.getApplicationId(), sysAppauthorize.getId());
            }

            httpServletRequest.setAttribute("ldapApplicationList", ldapApplicationList);
            httpServletRequest.setAttribute("appauthList", resultList);
            //判断全选与全不选的标志
            
            int lcont=0;
            int sqlcont=0;
            
            lcont=LdapApplicationSearcher.getQueryCount(" where 1=1");
            sqlcont=SysAppauthorizeSearcher.getQueryCount(" where item.AuthtoId='"+authtoId+"'");
            
            if(lcont==sqlcont){
            	httpServletRequest.setAttribute("allchecked","checked");
            }else{
            	httpServletRequest.removeAttribute("allchecked");
            }
            
            logger.debug("appauthList Success");
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        return actionMapping.findForward("success");
    }

    static 
    {
        logger = Logger.getLogger(com.san.share.pmi.struts.DoSysAppauthorizeFindByUserAction.class);
    }
}
