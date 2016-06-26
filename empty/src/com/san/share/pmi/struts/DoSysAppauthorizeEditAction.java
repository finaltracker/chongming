package com.san.share.pmi.struts;

import com.san.share.pmi.SysAppauthorize;
import com.san.share.pmi.dao.SysAppauthorizeCtrl;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.struts.form.SysAppauthorizeForm;
import com.san.share.pubutil.GetAutoID;
import com.san.ywcx.data.newbusiness.t0101.T0101EnterpriseBaseDao;
import com.san.ywcx.sqx.QxInfoDao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

public class DoSysAppauthorizeEditAction extends DispatchAction
{

    private static final Logger logger;
    private static final Date currentDate = new Date(System.currentTimeMillis());
    private String operator;
    private static final String TABLENAME = "SYS_AppAuthorize";

    public DoSysAppauthorizeEditAction()
    {
        operator = "";
    }

    /**
     * 单节点信息的添加与录入
     * @param actionMapping
     * @param actionForm
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public ActionForward add(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        logger.debug("Start DoSysAppauthorizeEditAction add!");
        SysAppauthorizeForm sysAppauthorizeForm = (SysAppauthorizeForm)actionForm;
        try
        {
            logger.debug("Form Data get!");
            operator = LoginUserInfoDelegate.getCnFromRequest(httpServletRequest);
            String autoID = GetAutoID.getAutoID("SYS_AppAuthorize");
            sysAppauthorizeForm.setId(autoID);
            sysAppauthorizeForm.setSysAppauthorize();
            httpServletRequest.setAttribute("authtoId", sysAppauthorizeForm.getAuthtoId());
            SysAppauthorizeCtrl.addSysAppauthorize(sysAppauthorizeForm.getSysAppauthorize());
            logger.debug("DoSysAppauthorizeEditAction ---> add complete!");
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        return actionMapping.findForward("success");
    }

    /**
     * 全选
     * @param actionMapping
     * @param actionForm
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public ActionForward addAll(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
         logger.debug("Start DoSysAppauthorizeEditAction addAll!");
         SysAppauthorizeForm sysAppauthorizeForm = (SysAppauthorizeForm)actionForm;
        try
        {
        	QxInfoDao dao=new QxInfoDao();
  		  	String dleteSql="delete from sys_appauthorize where authto_id='"+sysAppauthorizeForm.getAuthtoId()+"'";
  		  	dao.updateSql(dleteSql);//先删除所有的权限
  		  
  		  StringBuffer sql=new StringBuffer("select application_id from ladp_application");
 		 
		  com.san.ywcx.data.newbusiness.t0101.T0101EnterpriseBaseDao t010dao=new T0101EnterpriseBaseDao();
		  List sqllist=t010dao.getList(sql.toString());
		  String flagId="";//记录授权Id信息
		  for(int i=0;i<sqllist.size();i++){
            logger.debug("Form Data get!");
            operator = LoginUserInfoDelegate.getCnFromRequest(httpServletRequest);
            String autoID = GetAutoID.getAutoID("SYS_AppAuthorize");
            while(flagId.equals(autoID)){
            	autoID=GetAutoID.getAutoID("SYS_AppAuthorize");
            }
            SysAppauthorize app=new SysAppauthorize();
            String apid=(String) sqllist.get(i);
            app.setApplicationId(apid);
            app.setAuthtoId(sysAppauthorizeForm.getAuthtoId());
            app.setId(autoID);
            SysAppauthorizeCtrl.addSysAppauthorize(app);
            flagId=autoID;
            logger.debug("DoSysAppauthorizeEditAction ---> add complete!");
		  }
          httpServletRequest.setAttribute("authtoId", sysAppauthorizeForm.getAuthtoId());
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        return actionMapping.findForward("success");
    }
    
    /**
     * 全不选
     * @param actionMapping
     * @param actionForm
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public ActionForward notaddAll(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
    	
         logger.debug("Start DoSysAppauthorizeEditAction addAll!");
         SysAppauthorizeForm sysAppauthorizeForm = (SysAppauthorizeForm)actionForm;
        try
        {
        	QxInfoDao dao=new QxInfoDao();
  		  	String dleteSql="delete from sys_appauthorize where authto_id='"+sysAppauthorizeForm.getAuthtoId()+"'";
  		  	dao.updateSql(dleteSql);//先删除所有的权限
  		  	httpServletRequest.setAttribute("authtoId", sysAppauthorizeForm.getAuthtoId());
        }
        catch(Exception ex)
        {
            httpServletRequest.setAttribute("message", "Error while performing finder. : " + ex.getMessage());
            return actionMapping.findForward("unknown-error");
        }
        return actionMapping.findForward("success");
    }
    
    
    /**
     * 移除节点信息
     * @param actionMapping
     * @param actionForm
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public ActionForward remove(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        logger.debug("Start DoSysAppauthorizeEditAction remove!");
        SysAppauthorizeForm sysAppauthorizeForm = (SysAppauthorizeForm)actionForm;
        try
        {
            SysAppauthorizeCtrl.deleteSysAppauthorizeByPK(sysAppauthorizeForm.getId());
            httpServletRequest.setAttribute("authtoId", sysAppauthorizeForm.getAuthtoId());
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
        logger = Logger.getLogger(com.san.share.pmi.struts.DoSysAppauthorizeEditAction.class);
    }
}
