package com.san.mxchengxin.action.country;

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
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class CtyAddAction extends Action {
	private CmCountryDAO cmCountryDAO;
	List<CmCountry> countryList;
	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
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
			/*
			 userInfo.getCn();//获得用户登录名
			 
			userInfo.getOuid();//获得用户所属部门ID
			userInfo.getOuname();//获得用户所属部门名称
			userInfo.getSn();//获得用户姓名
			*/
			ct.setAuthor(userInfo.getCn());
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			System.out.println(df.format(now));// new Date()为获取当前系统时间
			ct.setPubdate(now.getTime()/1000);
			
			cmCountryDAO.save(ct);
		} else {
			List<CmCountry> partList = cmCountryDAO.findAll();
			
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<partList.size();i++) {
				CmCountry cc = (CmCountry)partList.get(i);
				//System.out.println("name: "+cc.getPartName()+cc.getId());
				String s;
				s = String.format("<option value='%d'>%s</option>", cc.getId(),cc.getName());
				sb.append(s);
				
			}
			String partListSel = sb.toString();
			request.setAttribute("partListSel", partListSel);
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
				/*
				 userInfo.getCn();//获得用户登录名
				 
				userInfo.getOuid();//获得用户所属部门ID
				userInfo.getOuname();//获得用户所属部门名称
				userInfo.getSn();//获得用户姓名
				*/
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
		return mapping.findForward( "ctyaddForword" );
	}

}
