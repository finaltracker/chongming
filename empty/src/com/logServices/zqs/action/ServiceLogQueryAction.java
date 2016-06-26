package com.logServices.zqs.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.logServices.zqs.form.ServiceLogForm;
import com.logServices.zqs.model.PerformaceStatisInfo;
import com.logServices.zqs.services.ILogServicesManger;
import com.logServices.zqs.services.PerformInfoServicesManager;
import com.san.chengxin.common.service.DateUtil;
import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.jingtai.model.JingTaiLogInfo;
import com.san.mhcx.uploadlogs.model.TUploadLogs;
import com.san.mhcx.uploadlogs.service.IUpLoadLogsService;
import com.san.mhcx.uploadlogs.web.UpLoadLogsForm;
import com.san.share.ca.newtest;
import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.tools.generator.UUIDFactory;
import com.san.tools.pagetag.util.PageFindUtil;
import com.san.util.Vo;
import com.san.ysjgl.service.YsjglService;

/**
 * 接口日志查询Actin
 * 
 * @author 张庆生
 *
 */
public class ServiceLogQueryAction extends BaseAction{
	
	/**
	 * 日志查询（Action）
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward queryListLogInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			ILogServicesManger ilogServices = (ILogServicesManger)this.getBean("ilogServicesManger");
			YsjglService service=(YsjglService)this.getBean("ysjglserviceimpl");
			//下拉部门
        	String sql2=" select  ouid,ouname from sys_oulist t where 1=1 ";
    		sql2+=" order by t.displayorder ";
    		Vo v2 =service.getSQL(sql2);
    		request.setAttribute("bmlist",v2.getList());
    		//end
    		
			if(null!=ilogServices){
				//前台数据获取
				String quName = !"".equals(request.getParameter("qu_name")) ? String.valueOf(request.getParameter("qu_name")) : "";
				String quState = !"".equals(request.getParameter("qu_state")) ? String.valueOf(request.getParameter("qu_state")) : "";
				String quType = !"".equals(request.getParameter("qu_type")) ? String.valueOf(request.getParameter("qu_type")) : "";
				String startDate = !"".equals(request.getParameter("start_Date")) ? String.valueOf(request.getParameter("start_Date")) : "";
				String endDate = !"".equals(request.getParameter("end_Date")) ? String.valueOf(request.getParameter("end_Date")) : "";
				//具体查询内容
				int pageNo = PageFindUtil.getPageNo(request);
        		int pageSize = PageFindUtil.getPageSize(request,10);
        		int count = 0;
        		if(!"".equals(quName) || !"".equals(quState) || !"".equals(quType) || !"".equals(startDate) || !"".equals(endDate)){
        			count = ilogServices.queryCountManager("1", quName, quState, quType, startDate, endDate, "");
        		}
        		else{
        			count = ilogServices.queryCountManager("0", quName, quState, quType, startDate, endDate, "");
        		}
        		request.setAttribute("totalCount",count);
        		List<JingTaiLogInfo> list = ilogServices.getListLogInfoManager(quName, quState, quType, startDate, endDate, "", pageNo, pageSize);
        		request.setAttribute("quNames", quName);
        		request.setAttribute("quStates", quState);
        		request.setAttribute("quTypes", quType);
        		request.setAttribute("startDates", startDate);
        		request.setAttribute("endDates", endDate);
        		request.setAttribute("list",list);
        		ActionForward actionForward = mapping.findForward("queryLogSuccess");
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	
	/**
	 * 根据查询用户(Ajax)
	 */
	public ActionForward deptAdminAjax(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try {
			ILogServicesManger ilogServices = (ILogServicesManger)this.getBean("ilogServicesManger");
			List tempList = new ArrayList();
			String dept = !"".equals(request.getParameter("d")) ? String.valueOf(request.getParameter("d")) : "";
			tempList = ilogServices.queryAdminManger(dept);
			if(tempList!=null&&tempList.size()>0){
				JSONArray jsonObject = JSONArray.fromObject(tempList);//装换json
				response.setContentType("text/html;charset=UTF-8"); 
				response.setHeader("Cache-Control", "no-cache"); 
				final PrintWriter out = response.getWriter();
				out.write(jsonObject.toString()); 
				out.flush();
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 绩效统计
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward queryListPerForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
			ServiceLogForm serForm = (ServiceLogForm)form;
			if(null!=perimpl){
				/**
				 * 用户统计
				 */
				List<PerformaceStatisInfo> listUser = perimpl.querUserNamesManger("2");//查询部门
				List<PerformaceStatisInfo> listtemp = new ArrayList<PerformaceStatisInfo>();
				
				String depart = serForm.getDapartString();
				String startDate = !"".equals(request.getParameter("start_Date"))&&null!=request.getParameter("start_Date") ? String.valueOf(request.getParameter("start_Date")) : "";
				String endDate = !"".equals(request.getParameter("end_Date"))&&null!=request.getParameter("end_Date") ? String.valueOf(request.getParameter("end_Date")) : "";
				//具体查询内容
				int pageNo = PageFindUtil.getPageNo(request);
        		int pageSize = PageFindUtil.getPageSize(request,10);
        		int count = 0;
        		if(((null!=depart)&&(!"".equals(depart))) || !"".equals(startDate) || !"".equals(endDate)){
        			count = perimpl.queryPerInfoManager("1",depart,startDate,endDate);//获取总数
        			listtemp = perimpl.getListAllManger(depart,startDate,endDate, pageNo, pageSize);//查询实体类
        			serForm.setDapartString(depart);
            		request.setAttribute("startDates", startDate);
            		request.setAttribute("endDates", endDate);
        		}
        		else{
        			count = perimpl.queryPerInfoManager("","","","");
        			listtemp = perimpl.getListAllManger("","","", pageNo, pageSize);
        		}
        		request.setAttribute("totalCount",count);
//        		request.setAttribute("quNames", quName);
//        		request.setAttribute("quStates", quState);
//        		request.setAttribute("quTypes", quType);
//        		request.setAttribute("startDates", startDate);
//        		request.setAttribute("endDates", endDate);
        		request.setAttribute("list",listtemp);
        		request.setAttribute("listUser",listUser);
        		ActionForward actionForward = mapping.findForward("queryPerSuccess");
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	/**
	 * 总数统计
	 */
	public ActionForward queryDetailAllForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
			
			if(null!=perimpl){
				/**
				 * 用户统计
				 */
				List<PerformaceStatisInfo> listUser = perimpl.querUserNamesManger("2");//查询部门
				List<PerformaceStatisInfo> listtemp = new ArrayList<PerformaceStatisInfo>();
				//具体查询内容
				int pageNo = PageFindUtil.getPageNo(request);
        		int pageSize = PageFindUtil.getPageSize(request,5);
        		int count = 0;
        		listtemp = perimpl.getListDetailManager(pageNo, pageSize);//获取总数记录
        		if((null!=listtemp) && (listtemp.size()>0)){
        			count = listtemp.size();
        		}
        		request.setAttribute("totalCount",count);//分页总数
        		request.setAttribute("list",listtemp);//实体类封装
        		request.setAttribute("listUser",listUser);//查询已有用户
        		ActionForward actionForward = mapping.findForward("queryDetailSuccess");
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	/**
	 * 统计查询
	 */
	
	public ActionForward queryConditionForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
			ServiceLogForm serForm = (ServiceLogForm)form;
			if(null!=perimpl){
				/**
				 * 用户统计
				 */
				List<PerformaceStatisInfo> listUser = perimpl.querUserNamesManger("2");//查询部门
				List<PerformaceStatisInfo> listtemp = new ArrayList<PerformaceStatisInfo>();
				//具体查询内容
//				获取表单参数
        		String depart = serForm.getDapartString();
				String startDate = !"".equals(request.getParameter("start_Date"))&&null!=request.getParameter("start_Date") ? String.valueOf(request.getParameter("start_Date")) : "";
				String endDate = !"".equals(request.getParameter("end_Date"))&&null!=request.getParameter("end_Date") ? String.valueOf(request.getParameter("end_Date")) : "";
        		
				
				int pageNo = PageFindUtil.getPageNo(request);
        		int pageSize = PageFindUtil.getPageSize(request,5);
        		int count = 0;
        		
				if(((null!=depart)&&(!"".equals(depart))) || !"".equals(startDate) || !"".equals(endDate)){
        			//查询实体数据
					listtemp = perimpl.getListCondititonDetailManger(depart,startDate,endDate, pageNo, pageSize);//查询实体类
        			if((null!=listtemp) && (listtemp.size()>0)){
            			count = listtemp.size();//当前记录总数
            		}
        			serForm.setDapartString(depart);
            		request.setAttribute("startDates", startDate);
            		request.setAttribute("endDates", endDate);
        		}
				
        		request.setAttribute("totalCount",count);
        		request.setAttribute("list",listtemp);
        		request.setAttribute("listUser",listUser);
        		ActionForward actionForward = mapping.findForward("queryConditionSuccess");
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	/**
	 * 用户首页展示
	 */
	public ActionForward querycrentForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
			
			if(null!=perimpl){
//				List<PerformaceStatisInfo> listUser = perimpl.querUserNamesManger("2");
				List<PerformaceStatisInfo> listtemp = new ArrayList<PerformaceStatisInfo>();
				//具体查询内容
				int pageNo = PageFindUtil.getPageNo(request);
        		int pageSize = PageFindUtil.getPageSize(request,5);
        		int count = 0;
        		listtemp = perimpl.getListDetailManager(pageNo, pageSize);//查询用户
        		if((null!=listtemp) && (listtemp.size()>0)){
        			count = listtemp.size();
        		}
        		request.setAttribute("totalCount",count);
        		request.setAttribute("listCrent",listtemp);
//        		request.setAttribute("listUser",listUser);
        		ActionForward actionForward = mapping.findForward("querycrentSuccess");
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	/**
	 * 用户图形界面操作
	 */
	public ActionForward queryAnyCharForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
			String flag = !"".equals(request.getParameter("flag"))&&null!=request.getParameter("flag") ? String.valueOf(request.getParameter("flag")) : "";
			String result = "queryAnyCharSuccess";
			if(null!=perimpl){
				List<PerformaceStatisInfo> listtemp = new ArrayList<PerformaceStatisInfo>();
				//具体查询内容
        		listtemp = perimpl.querAnyCharAllManger("");
        		
        		if(!"".equals(flag)){
        			if("1".equals(flag)){//首页显示
        				result = "fistWebSuccess";
        			}
        			if("2".equals(flag)) {
        				listtemp = perimpl.querMontherAnyCharAllManger("");
						result = "piewebSuccess";//饼状图显示
					}
        		}
        		request.setAttribute("listanyChar",listtemp);
        		ActionForward actionForward = mapping.findForward(result);
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	/**
	 * 详细查询
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward queryDetailDepartForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
		
		try{
			PerformInfoServicesManager perimpl = (PerformInfoServicesManager) getBean("perInfoServicesManagerImpl");
			ServiceLogForm serForm = (ServiceLogForm)form;
			if(null!=perimpl){
				
				//具体查询内容
				//获取表单参数
				String str = new String(request.getParameter("flag").getBytes("ISO-8859-1"),"utf-8");
        		String depart = !"".equals(str)&&null!=str ? str : "";;
				int pageNo = PageFindUtil.getPageNo(request);
        		int pageSize = PageFindUtil.getPageSize(request,10);
        		int count = 0;
        		List<PerformaceStatisInfo> listtemp = new ArrayList<PerformaceStatisInfo>();
				if(((null!=depart)&&(!"".equals(depart)))){
        			//查询实体数据
					listtemp = perimpl.getListAllManger(depart,"","", pageNo, pageSize);//根据具体条件精确查询
        			if((null!=listtemp) && (listtemp.size()>0)){
            			count = listtemp.size();//当前记录总数
            		}
        			serForm.setDapartString(depart);
        		}
				
        		request.setAttribute("totalCount",count);
        		request.setAttribute("list",listtemp);
        		ActionForward actionForward = mapping.findForward("detailSuccess");
        		return actionForward;
			}else {
				return mapping.findForward("error");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
	
	/**
	 * 新增
	 */
	
	
}
