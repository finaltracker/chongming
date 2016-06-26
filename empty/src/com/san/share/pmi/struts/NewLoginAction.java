package com.san.share.pmi.struts;

import java.util.Date;
import java.util.List;

import com.san.chengxin.common.service.DateUtil;
import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.share.pmi.SysUser;
import com.san.share.pmi.dao.SysUserSearcher;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.share.pmi.service.UserPrivilegeDelegate;
import com.san.tools.generator.UUIDFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class NewLoginAction extends BaseAction
{
  private static final Logger logger = Logger.getLogger(NewLoginAction.class);

  public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
  {
	  
    HttpSession session = httpServletRequest.getSession();
    if (session != null) {
      session.removeAttribute("loginUserInfoBean");
      session.removeAttribute("com.san.share.pmi.currentLoginUser");
      session.removeAttribute("com.san.share.pmi.currentLoginUserCn");
      session.removeAttribute("com.san.share.pmi.loggedIn");
      session.invalidate();
    }

    String cn = ((LoginActionForm)actionForm).getCn();
    String password = ((LoginActionForm)actionForm).getPassword();
    String loginType = ((LoginActionForm)actionForm).getLoginType();
    try {
      session = httpServletRequest.getSession();
      session.setAttribute("com.san.share.pmi.loggedIn", "2");
      if (cn != null)
      {
    	  
        SysUser sysUser = SysUserSearcher.md5findSysUserByPK(cn);
        if(sysUser!=null){
        	session.setAttribute("logCn",sysUser.getId());//Ϊ��־׼��
        }else{
        	session.setAttribute("logCn",cn);//Ϊ��־׼��
        }
        
        
      //------------------------ϵͳ��־------------------------
		
//		ISelectService rzimpl = (ISelectService) getBean("SelectServiceImpl");
		
//		String logId=UUIDFactory.getUUIDKeyGenerator().generateKey().toString();
//		String userId=cn;
//		String ipAddress=httpServletRequest.getRemoteAddr();
//		Date optTime=new Date();
//		String optMenu="�û���¼";
		
		//------------------------ϵͳ��־------------------------
        
        if ((sysUser != null) && 
          (password.equals(sysUser.getPwd().trim()))) {
          logger.debug("passed");
          LoginUserInfo loginUserInfo = new LoginUserInfo();
          UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();

          loginUserInfo.setSysUser(sysUser);
          loginUserInfo.setUserPrivilege(userPrivilegeDelegate.getUserPrivilegeList(cn));
          logger.debug("�û���Ϣ��¼���");

          session.setAttribute("com.san.share.pmi.loggedIn", "1");
          session.setAttribute("com.san.share.pmi.currentLoginUser", sysUser.getSn());
          session.setAttribute("com.san.share.pmi.currentLoginUserCn", sysUser.getId());
          session.setAttribute("com.san.share.pmi.currentLoginUserOuid", sysUser.getOu().trim());
          
          session.setAttribute("loginUserInfoBean", loginUserInfo);
          logger.debug("�û���Ϣ����Session");
          //if (cn.equals("admin")) {
           // return actionMapping.findForward("inUser");
          //}
          String optContent="��¼�û���"+cn+"����¼�ɹ���";
            String sdate=DateUtil.toString(DateUtil.getNfztime(5), "yyyy-MM-dd HH:mm:ss");
	  		System.out.println(sdate);
	  		//String qcsql="select log_id from T_OPT_LOG where user_id='"+userId+"' and ip_address ='"+ipAddress+"' and opt_menu='"+optMenu+"' and opt_content ='"+optContent+"' ";
	  		//qcsql+=" and opt_time>= to_date('"+sdate+"','yyyy-MM-dd HH24:mi:ss')";
	  		//List qcList=rzimpl.getResultBySql(qcsql,1,10);
	  		//if(qcList.size()==0){
//	  			TOptLog log=new TOptLog();
//	  			log.setLogId(logId);
//	  			log.setIpAddress(ipAddress);
//	  			log.setUserId(userId);
//	  			log.setOptMenu(optMenu);
//	  			log.setOptTime(optTime);
//	  			log.setOptContent(optContent);
//	  			rzimpl.saveObject(log);
	  		//}
          return actionMapping.findForward("inUser");
        }
        
        String optContent="��¼�û���"+cn+"����¼ʧ�ܡ�";
        String sdate=DateUtil.toString(DateUtil.getNfztime(5), "yyyy-MM-dd HH:mm:ss");
 		System.out.println(sdate);
 		//String qcsql="select log_id from T_OPT_LOG where user_id='"+userId+"' and ip_address ='"+ipAddress+"' and opt_menu='"+optMenu+"' and opt_content ='"+optContent+"' ";
 		//qcsql+=" and opt_time>= to_date('"+sdate+"','yyyy-MM-dd HH24:mi:ss')";
 		//List qcList=rzimpl.getResultBySql(qcsql,1,10);
 		//if(qcList.size()==0){
// 			TOptLog log=new TOptLog();
// 			log.setLogId(logId);
// 			log.setIpAddress(ipAddress);
// 			log.setUserId(userId);
// 			log.setOptMenu(optMenu);
// 			log.setOptTime(optTime);
// 			log.setOptContent(optContent);
// 			rzimpl.saveObject(log);
 		//}
        
      }

      
       
		
      httpServletRequest.setAttribute("message", "����������������룡");

      return actionMapping.findForward("loginError");
    }
    catch (Exception nse) {
      httpServletRequest.setAttribute("message", "��¼ʧ�ܣ������ԣ�");
      logger.error("��¼ʧ��--->", nse);
    }

    return actionMapping.findForward("loginError");
  }
}