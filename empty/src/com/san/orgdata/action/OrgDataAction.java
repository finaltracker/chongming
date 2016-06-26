/**
 * 
 */
package com.san.orgdata.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.orgdata.model.vo.SysOuVO;
import com.san.orgdata.service.OrgDataService;
import com.san.share.pmi.service.LoginUserInfoDelegate;

/**
 * 
 * <p>Title:[机构数据管理Action类] </p>
 * <p>Description: [类功能描述]</p>
 * <p>Copyright© 2014 Shanghai 30wish Information Security Co.,Ltd.</p>
 * <p>All right reserved.</p>
 * 
 * @version 1.0 
 * Created by [liangkd] [2014-12-24] 
 * Midified by [修改人] [修改时间]
 * 
 */
public class OrgDataAction extends BaseAction {

	private static final Logger log = Logger.getLogger(OrgDataAction.class);

	/**
	 * 
	 * <p>Description:[查询信用信息] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2014-12-24]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward queryOrgData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		OrgDataForm orgDataForm = (OrgDataForm) form;
		String  enterprise_id = orgDataForm.getEnterprise_id();
		
		log.info("查询参数：企业编码为"+enterprise_id);
		
		OrgDataService service = (OrgDataService) getBean("orgDataServiceImpl");
		String userName = LoginUserInfoDelegate.getCnFromRequest(request);
		//System.out.println("===================queryOrgData");
		
		HashMap orgData=new HashMap();
		List list = new ArrayList();
		try {

			//查询用户配置显示的业务数据
			orgData = (HashMap)service.queryOrgDataConfigInfo(userName);
			service.loadOrgDataConfigInfo(orgData, enterprise_id);
			list = service.queryQyBase(enterprise_id);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("orgdata", orgData);
		request.setAttribute("list", list);

		return mapping.findForward("queryOrgData");
	}

	/**
	 *
	 * <p>Description:[信用数据配置加载] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-12]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward loadConfigOrgData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		OrgDataService service = (OrgDataService) getBean("orgDataServiceImpl");
		String userName = LoginUserInfoDelegate.getCnFromRequest(request);

		Map orgData=new HashMap();
		Map userTableInfo = new HashMap();

		try {

			//可配置数据表查询,全查
			orgData = service.queryOrgDataConfigInfo(null);
			
			//用户已选择配置表信息
			userTableInfo = service.queryUserTableInfo(userName);

		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("orgdatainfo", orgData);
		request.setAttribute("userTableInfo", userTableInfo);

		return mapping.findForward("loadConfigOrgData");
	}
	/**
	 *
	 * <p>Description:[[数据配置保存] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-12]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward saveConfigOrgData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String[] tableId = request.getParameterValues("tbid"); 

		OrgDataService service = (OrgDataService) getBean("orgDataServiceImpl");
		String deptId = LoginUserInfoDelegate.getOuidFromRequest(request);
		String userName = LoginUserInfoDelegate.getCnFromRequest(request);
		String mm = "保存成功";
		try {
			//保存用户业务数据显示配置
			service.saveUserTableInfo(tableId, userName);

		} catch (Exception e) {
			mm =  "保存失败";
			e.printStackTrace();
		}

		request.setAttribute("message", mm);
		request.setAttribute("urlInfo", "/web/orgDataAction.do?dispatch=loadConfigOrgData");

		return mapping.findForward("saveok");

	}
}
