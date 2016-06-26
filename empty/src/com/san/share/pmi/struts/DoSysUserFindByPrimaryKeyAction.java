package com.san.share.pmi.struts;

import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.mhcx.uploadlogs.service.IUpLoadLogsService;
import com.san.share.pmi.SysDomain;
import com.san.share.pmi.dao.SysDomainSearcher;
import com.san.share.pmi.dao.SysUserSearcher;
import com.san.share.pmi.service.DepartCode;
import com.san.share.pmi.service.OrgCode;
import com.san.share.pmi.struts.form.SysUserForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

public class DoSysUserFindByPrimaryKeyAction extends BaseAction
{

    private static final Logger logger;

    public DoSysUserFindByPrimaryKeyAction()
    {
    }

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
    	
    	// 得到实现类的一个实例
//    	IXlsImportService impl = (IXlsImportService) getBean("XlsImportServiceImpl");
//    	IUpLoadLogsService impl = (IUpLoadLogsService) getBean("UploadLogsServiceImpl");
    	IUpLoadLogsService impl = (IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");
//    	System.out.println("------------------------------------------------");
    	
        SysUserForm sysUserForm = (SysUserForm)actionForm;
        try
        {
            logger.debug("DoSysUserFindByPrimaryKeyAction Started!");
            String dispatch = httpServletRequest.getParameter("dispatch");
            if(dispatch == null || dispatch.equals(""))
            {
                dispatch = (String)httpServletRequest.getAttribute("dispatch");
            }
            logger.debug("dispatch:" + dispatch);
            sysUserForm.setDispatch(dispatch);
            
//            List areaList=impl.getArea();
            
//            httpServletRequest.setAttribute("areaList", areaList);
            
            if(dispatch.equals("add"))
            {
                String orgid = httpServletRequest.getParameter("orgid");
                String ouid = httpServletRequest.getParameter("ouid");
                sysUserForm.setO(orgid);
                sysUserForm.setOu(ouid);
                sysUserForm.setOrgname(OrgCode.getInstance().getNameZh(orgid));
                sysUserForm.setOuname(DepartCode.getInstance().getNameZh(ouid));
                sysUserForm.setUserStatus(new Integer(1));
                sysUserForm.setDisplayorder(new Double(1.0D));
                sysUserForm.setAdminDomain("none");
            } else
            {
                String cn = httpServletRequest.getParameter("cn");
                if(cn == null || cn.equals(""))
                {
                    cn = (String)httpServletRequest.getAttribute("cn");
                }
                logger.debug("cn:" + cn);
                sysUserForm.setId(cn);
                com.san.share.pmi.SysUser sysUser = SysUserSearcher.findSysUserByPK(cn);
                sysUserForm.setSysUserValues(sysUser);
                sysUserForm.setPwd(impl.getUserPwd(cn));
                List list = SysDomainSearcher.findSysDomainByCondition("where item.DomainadminId = '" + cn + "'");
                if(list.size() > 0)
                {
                    sysUserForm.setAdminDomain(((SysDomain)list.get(0)).getDomainName());
                } else
                {
                    sysUserForm.setAdminDomain("none");
                }
            }
            try
            {
                sysUserForm.setOrgname(OrgCode.getInstance().getNameZh(sysUserForm.getO()));
                sysUserForm.setOuname(DepartCode.getInstance().getNameZh(sysUserForm.getOu()));
            }
            catch(Exception ex1)
            {
                logger.debug("set user orgname and ouname failed! \n" + ex1.toString());
            }
            httpServletRequest.setAttribute("sysUserForm", sysUserForm);
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
        logger = Logger.getLogger(com.san.share.pmi.struts.DoSysUserFindByPrimaryKeyAction.class);
    }
}
