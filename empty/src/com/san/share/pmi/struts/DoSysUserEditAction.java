package com.san.share.pmi.struts;

import java.util.Date;
import java.util.List;

import com.san.mhcx.uploadlogs.service.IUpLoadLogsService;
import com.san.share.pmi.SysUser;
import com.san.share.pmi.dao.SysUserCtrl;
import com.san.share.pmi.dao.SysUserSearcher;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.struts.form.SysUserForm;
import com.san.tools.generator.UUIDFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

import com.san.chengxin.common.service.DateUtil;
import com.san.chengxin.common.web.struts.action.BaseAction;

public class DoSysUserEditAction extends BaseAction
{

    private static final Logger logger;

    public DoSysUserEditAction()
    {
    }

    public ActionForward add(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
    	
    	// �õ�ʵ�����һ��ʵ��
    	IUpLoadLogsService impl = (IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");
        logger.debug("Start user add!");
        SysUserForm sysUserForm = (SysUserForm)actionForm;
        try
        {
            logger.debug("Form Data get!");
            SysUser sysUser = SysUserSearcher.findSysUserByPK(sysUserForm.getId());
            if(sysUser != null)
            {
                httpServletRequest.setAttribute("message", "\u767B\u5F55\u540D\u91CD\u590D\uFF0C\u8BF7\u91CD\u65B0\u8F93\u5165\uFF01");
                return actionMapping.getInputForward();
            }
            sysUserForm.setCreatePosition(new Integer(0));
            logger.debug("UserInfo settled!");
            sysUserForm.setPwd(sysUserForm.getId());
            httpServletRequest.setAttribute("dispatch", "update");
            logger.debug("dispatch settled!");
            httpServletRequest.setAttribute("cn", sysUserForm.getId());
            logger.debug("cn settled!");
            sysUserForm.setSysUser();
            SysUserCtrl.addSysUser(sysUserForm.getSysUser());
            
            impl.getSetPwd(sysUserForm.getPwd(), sysUserForm.getId());
            
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        ActionForward af = new ActionForward();
        af.setPath("/pmi/orgmgt/userSetSuccess.htm");
        return af;
    }

    public ActionForward update(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
    	
    	// �õ�ʵ�����һ��ʵ��
    	IUpLoadLogsService impl = (IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");
    	
        logger.debug("Start user update!");
        SysUserForm sysUserForm = (SysUserForm)actionForm;
        try
        {
        	
//        	impl.getSetPwd(sysUserForm.getPwd(), sysUserForm.getId());
        	
            logger.debug("Form Data get!");
            
//            System.out.println("sysUserForm.getId()��"+sysUserForm.getId());
            
            SysUser sysUser = SysUserSearcher.findSysUserByPK(sysUserForm.getId());
            
//            System.out.println("sysUser.getPwd()��"+sysUser.getPwd());
            
//            sysUserForm.setPwd(sysUser.getPwd());
            sysUserForm.setSysUser();
            httpServletRequest.setAttribute("dispatch", "update");
            httpServletRequest.setAttribute("cn", sysUserForm.getId());
            SysUserCtrl.updateSysUser(sysUserForm.getSysUser());
            
            impl.getSetPwd(sysUserForm.getPwd(), sysUserForm.getId());
            logger.debug("SysUser settled!");
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        ActionForward af = new ActionForward();
        af.setPath("/pmi/orgmgt/doSysUserFindByPrimaryKeyAction.do");
        
        System.out.println("��ת");
        
        return af;
    }

    public ActionForward remove(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        logger.debug("Start user remove!");
        SysUserForm sysUserForm = (SysUserForm)actionForm;
        try
        {
            SysUserCtrl.deleteSysUserByPK(sysUserForm.getId());
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        ActionForward af = new ActionForward();
        af.setPath("/pmi/orgmgt/userSetSuccess.htm");
        return af;
    }

    public ActionForward move(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        logger.debug("Start user move!");
        SysUserForm sysUserForm = (SysUserForm)actionForm;
        try
        {
            logger.debug("Form Data get!");
            SysUser sysUser = SysUserSearcher.findSysUserByPK(sysUserForm.getId());
            sysUser.setO(sysUserForm.getO());
            sysUser.setOu(sysUserForm.getOu());
            logger.debug("sysUser settled!");
            httpServletRequest.setAttribute("dispatch", "update");
            logger.debug("dispatch settled!");
            httpServletRequest.setAttribute("cn", sysUserForm.getId());
            logger.debug("cn settled!");
            SysUserCtrl.updateSysUser(sysUser);
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        ActionForward af = new ActionForward();
        af.setPath("/pmi/orgmgt/doSysUserFindByPrimaryKeyAction.do");
        return af;
    }

    public ActionForward resetPass(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        ActionForward af = new ActionForward();
        af.setPath("/pmi/orgmgt/userSetSuccess.htm");
        return af;
    }

    public ActionForward changePass(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        ActionForward af = new ActionForward();
        af.setPath("/pmi/usertools/success.htm");
        return af;
    }

    static 
    {
        logger = Logger.getLogger(com.san.share.pmi.struts.DoSysUserEditAction.class);
    }
}
