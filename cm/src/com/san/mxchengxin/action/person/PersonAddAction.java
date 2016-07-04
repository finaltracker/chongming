package com.san.mxchengxin.action.person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.form.country.CtyAddForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class PersonAddAction extends Action {
	private CmCountryDAO cmCountryDAO;
	private CmPersonDAO cmPersonDAO;
	List<CmCountry> countryList;
	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public CmPersonDAO getCmPersonDAO() {
		return cmPersonDAO;
	}
	
	public void setCmPersonDAO(CmPersonDAO cmPersonDAO) {
		this.cmPersonDAO = cmPersonDAO;
	}
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		CtyAddForm addF = (CtyAddForm)form;
		String name = addF.getCountry_name();
		Short parentid = addF.getParent_id();
		String contact = addF.getCountry_contact();
		String phone = addF.getCountry_phone();
		String displayOrder = addF.getCountry_display_order();
		
		if (name != null && parentid != null && contact != null && phone !=null && displayOrder !=null) {
			CmCountry ct = new CmCountry();
			ct.setName(name);
			ct.setParentid(parentid);
			ct.setContact(contact);
			ct.setPhone(phone);
			ct.setDisplayOrder(Short.valueOf(displayOrder));
			
			LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
			ct.setAuthor(userInfo.getCn());
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			System.out.println(df.format(now));// new Date()为获取当前系统时间
			ct.setPubdate(now.getTime()/1000);
			
			cmCountryDAO.save(ct);
		} else {
			
			List<CmCountry> afterList = cmCountryDAO.queryParentZero();
			request.setAttribute("parentlist", afterList);
		}
			
		return mapping.findForward("ctyaddForword");
	}
	
	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
			Short countryId = Short.valueOf(request.getParameter("id"));
			System.out.println("[update] id : "+ countryId);
			
			CmCountry updateCc = cmCountryDAO.findById(countryId);
			
			request.setAttribute("country_name", updateCc.getName());
			request.setAttribute("country_contact", updateCc.getContact());
			request.setAttribute("country_phone", updateCc.getPhone());
			request.setAttribute("country_display_order", updateCc.getDisplayOrder());
			
			List<CmCountry> afterList = cmCountryDAO.queryParentZero();
			request.setAttribute("parentlist", afterList);
			request.setAttribute("country_id", countryId);
			request.setAttribute("ppid", updateCc.getParentid());
			
		}
		
		if(request.getParameter("xid")!=null &&!request.getParameter("xid").isEmpty()) {
			CtyAddForm addF = (CtyAddForm)form;
			String name = addF.getCountry_name();
			Short parentid = addF.getParent_id();
			String contact = addF.getCountry_contact();
			String phone = addF.getCountry_phone();
			String displayOrder = addF.getCountry_display_order();
			
			if (name != null && parentid != null && contact != null && phone !=null && displayOrder !=null) {
				CmCountry ct = new CmCountry();
				ct.setName(name);
				ct.setParentid(parentid);
				ct.setContact(contact);
				ct.setPhone(phone);
				ct.setDisplayOrder(Short.valueOf(displayOrder));

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				Date now = new Date();
				System.out.println(df.format(now));// new Date()为获取当前系统时间
				ct.setPubdate(now.getTime()/1000);
				Short xId = Short.valueOf(request.getParameter("xid"));
				System.out.println("[update item] : "+xId);
				ct.setId(xId);
				LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
				ct.setAuthor(userInfo.getCn());
				cmCountryDAO.update(ct);
			}
		}
		return mapping.findForward("ctyaddForword");
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("method") != null && !request.getParameter("method").isEmpty()) {
			Short actionMethod = Short.valueOf(request.getParameter("method"));
			System.out.println("op action : "+actionMethod);
			if(actionMethod == 1) {
				System.out.println("add action");
				request.setAttribute("pageInfo_action", "增加");
				request.setAttribute("action_method", 1);
				return add(mapping,form,request,response);
			} else if (actionMethod == 3) {
				System.out.println("modify action");
				request.setAttribute("pageInfo_action", "更新");
				request.setAttribute("action_method", 3);
				return update(mapping,form,request,response);
			} else {
				System.out.println("others action");
			}
		}
		
		List<CmCountry> afterList = cmCountryDAO.queryParentZero();
		request.setAttribute("parentlist", afterList);
		
		return mapping.findForward( "ctyaddForword" );
	}
}
