package com.san.share.pmi.struts;

import java.util.Date;
import java.util.List;

import com.logServices.zqs.model.PerformaceStatisInfo;
import com.logServices.zqs.services.PerformInfoServicesManager;
import com.logServices.zqs.util.DateFormatUtil;
import com.san.chengxin.common.service.DateUtil;
import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.jingtai.service.IJingtaiService;
import com.san.mhcx.mkdz.model.TMkdzInfo;
import com.san.mhcx.mkdz.service.IMkdzService;
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

public class LoginAction extends BaseAction
{
  private static final Logger logger = Logger.getLogger(LoginAction.class);

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
        	session.setAttribute("logCn",sysUser.getId());//为日志准备
        }else{
        	session.setAttribute("logCn",cn);//为日志准备
        }
        
        
      //------------------------系统日志------------------------
		
//		ISelectService rzimpl = (ISelectService) getBean("SelectServiceImpl");
		
//		String logId=UUIDFactory.getUUIDKeyGenerator().generateKey().toString();
//		String userId=cn;
//		String ipAddress=httpServletRequest.getRemoteAddr();
//		Date optTime=new Date();
//		String optMenu="用户登录";
		
		//------------------------系统日志------------------------
        
        if ((sysUser != null) && 
          (password.equals(sysUser.getPwd().trim()))) {
          logger.debug("passed");
          LoginUserInfo loginUserInfo = new LoginUserInfo();
          UserPrivilegeDelegate userPrivilegeDelegate = new UserPrivilegeDelegate();

          loginUserInfo.setSysUser(sysUser);
          loginUserInfo.setUserPrivilege(userPrivilegeDelegate.getUserPrivilegeList(cn));
          logger.debug("用户信息记录完成");
          
          Date dt=new Date();
		  String date=DateUtil.toString(dt, "yyyy-MM-dd HH:mm:ss");
		  Date newDate=DateUtil.toDate(date, "yyyy-MM-dd HH:mm:ss");
		  Date jfDate = new Date();
		  IMkdzService imkimpl = (IMkdzService) getBean("MkdzServiceImpl");
          IJingtaiService impl = (IJingtaiService) getBean("JingtaiServiceImpl");
  		  PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
  		  //查询部门
  		  String ouid = loginUserInfo.getOuid();
  		  String qu_dept = "";
		  List list = impl.getListdeptListManger(ouid);
		  if((null!=list)&&(list.size()>0)){
			for(int i =0; i<list.size(); i++){
				qu_dept = list.get(i).toString();
			}
		  }
		  String mkType = "0";//登录类型
		  List listMkTem = imkimpl.queryMkdzInfo(mkType);//查询规则配置表
		  List<PerformaceStatisInfo> listPer = perimpl.queryNamePerInfoManager(!"".equals(cn) ? cn : "",mkType);
//		----------------------积分处理-------------------------
		  if((null!=listMkTem)&&(listMkTem.size()>0) && (null!=listPer)&&(listPer.size()>0)){
			  TMkdzInfo info=(TMkdzInfo) listMkTem.get(0);
			  PerformaceStatisInfo per = (PerformaceStatisInfo)listPer.get(0);
			  String jflx = info.getJflx();//是否有限制
			  String pzt = per.getPointType();//匹配字段
			  String jfcslx = info.getJfsclx();//时间类型
			  int jfsj = info.getJfsc();//时间范围
			  int jf = info.getJf();//积分
			  //计算时间
			  long date1 = per.getEndDate().getTime();
			  long date2 = per.getStartDate().getTime();
			  long ss=(date1-date2)/(1000);
			  int mm = 0;
			  if(jfcslx.equals("minute")){
				  mm = (int)ss/60;//共计分钟数
			  }
			  if(jfcslx.equals("hour")){
				  mm = (int)ss/3600;//共计小时数
			  }
			  String strval = String.valueOf(mm);
			  if((info.getZt().equals("1"))){
				  /**
				   * 匹配积分规则与积分配置是否一致
				   * false: 不匹配（更新最新限制条件）
				   * true:匹配（积分操作）
				   */
				  if(!jflx.equals(pzt) || !String.valueOf(jfsj).equals(strval)){//1:有限制;0:无限制
					  //更新
					  if(jfcslx.equals("hour")){//小时积分
						  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_HOUR);
					  }
					  if(jfcslx.equals("minute")){
						  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_MINUTE);
					  }
					  
					  //更新限制条件
					  int a = perimpl.updatePerDateManager(per.getPid(), date,DateUtil.toString(jfDate, "yyyy-MM-dd HH:mm:ss"),jflx);
					  
					  //有限制积分更新
					  if(jflx.equals("1")){
						  //积分操作
						  if((null!=cn) && (!"".equals(cn)) && (null!=qu_dept) && (!"".equals(qu_dept))){
							  int c = perimpl.vailDateLogManager(date,cn,"0",per.getPid());
							  //验证用户是否需要根据规则从新积分
							  if(c==-1){
								  //更新为历史记录
								  int x = perimpl.updateTypeManager(per.getPid(), "0");
								  if(x>-1){
									  //新增操作
									  PerformaceStatisInfo perInfos = new PerformaceStatisInfo(qu_dept,cn,"0",jf,newDate,newDate,jfDate,jflx,"","1");//封装数据
									  perimpl.savePerInfoManager(perInfos);//持久化对象
									  System.out.println("----积分已经加入-----");
								  }
								  else{
									  System.out.println("----积分异常-----");
								  }
							  }
//							  //符合积分规则
//							  if(c>-1){
//								  //更新数据
//								  perimpl.updatePerInfoManager(per.getPid(),"1",jf);
//								  System.out.println("----积分已更新-----");
//							  }
						  }
					  }
					  if(jflx.equals("0")){
						  perimpl.updatePerInfoManager(per.getPid(),"1",jf);
						  System.out.println("----积分已更新-----");
					  }
					  
				  }
				  /**
				   * true
				   */
				  else{
					  //积分操作
					  if((null!=cn) && (!"".equals(cn)) && (null!=qu_dept) && (!"".equals(qu_dept))){
						  if(jfcslx.equals("hour")){//小时积分
							  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_HOUR);
						  }
						  if(jfcslx.equals("minute")){//分钟计时
							  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_MINUTE);
						  }
						  //无限制判断
						  if(jflx.equals("0")){
							  //更新数据
							  perimpl.updatePerInfoManager(per.getPid(),"1",jf);
							  System.out.println("----积分已更新-----");
						  }
						  else{
							  int c = perimpl.vailDateLogManager(date,cn,"0",per.getPid());
							  //验证用户是否需要根据规则从新积分(-1:重新积分);
							  if(c==-1){
								  //更新为历史记录
								  int x = perimpl.updateTypeManager(per.getPid(), "0");
								  if(x>-1){
									  //新增操作
									  if(jfcslx.equals("hour")){//小时积分
										  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_HOUR);
									  }
									  if(jfcslx.equals("minute")){
										  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_MINUTE);
									  }
									  PerformaceStatisInfo perInfos = new PerformaceStatisInfo(qu_dept,cn,"0",jf,newDate,newDate,jfDate,jflx,"","1");//封装数据
									  perimpl.savePerInfoManager(perInfos);//持久化对象
									  System.out.println("----积分已经加入-----");
								  }
								  else{
									  System.out.println("----积分已异常-----");
								  }
							  }
//							  //符合积分规则
//							  else{
//								  //更新数据
//								  perimpl.updatePerInfoManager(per.getPid(),"1",jf);
//								  System.out.println("----积分已更新-----");
//							  }
						  }
					  }
				  }
			  }
			  //无效
			  else{
				  System.out.println("----规则无启用,无法计算积分-----");
			  }
		  }
		  //新增规则
		  else{
			  if((null!=listMkTem)&&(listMkTem.size()>0)){
				  TMkdzInfo info=(TMkdzInfo) listMkTem.get(0);
				  String jflx = info.getJflx();//是否有限制
				  int jf = info.getJf();//积分
				  String jfcslx = info.getJfsclx();//时间类型
				  int jfsj = info.getJfsc();//时间范围
				  if(jfcslx.equals("hour")){//小时积分
					  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_HOUR);
				  }
				  if(jfcslx.equals("minute")){
					  jfDate  = DateFormatUtil.addTime(newDate,jfsj,DateFormatUtil.TimeType.TIME_MINUTE);
				  }
				  //积分操作
				  if((null!=cn) && (!"".equals(cn)) && (null!=qu_dept) && (!"".equals(qu_dept))){
					  //新增操作
					  PerformaceStatisInfo perInfos = new PerformaceStatisInfo(qu_dept,cn,"0",jf,newDate,newDate,jfDate,jflx,"","1");//封装数据
					  perimpl.savePerInfoManager(perInfos);//持久化对象
					  System.out.println("----积分已经加入-----");
				  }
			  }
			  else{
				 System.out.println("----规则无启用,无法计算积分-----");
			  }
		  }
  		 //-------------------------end-------------------------
          
          
          session.setAttribute("com.san.share.pmi.loggedIn", "1");
          session.setAttribute("com.san.share.pmi.currentLoginUser", sysUser.getSn());
          session.setAttribute("com.san.share.pmi.currentLoginUserCn", sysUser.getId());
          session.setAttribute("com.san.share.pmi.currentLoginUserOuid", sysUser.getOu().trim());
          
          session.setAttribute("loginUserInfoBean", loginUserInfo);
          logger.debug("用户信息存入Session");
          //if (cn.equals("admin")) {
           // return actionMapping.findForward("inUser");
          //}
          String optContent="登录用户名："+cn+"；登录成功。";
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
          return actionMapping.findForward("outUser");
        }
        
        String optContent="登录用户名："+cn+"；登录失败。";
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

      
       
		
      httpServletRequest.setAttribute("message", "密码错误，请重新输入！");

      return actionMapping.findForward("loginError");
    }
    catch (Exception nse) {
      httpServletRequest.setAttribute("message", "登录失败，请重试！");
      logger.error("登录失败--->", nse);
    }

    return actionMapping.findForward("loginError");
  }
}