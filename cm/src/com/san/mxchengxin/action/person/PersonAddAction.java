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

import com.san.mxchengxin.form.person.PersonAddForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.utils.Utils;
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
		
		PersonAddForm addF = (PersonAddForm)form;
		String trueName = addF.getTruename();
		String personSsid = addF.getSsid();
		String sex = addF.getSex();
		String personZzmm = addF.getZzmm();
		String personWhcd = addF.getWhcd();
		Short countryId = addF.getCountry_id();
		String phone = addF.getPhone();
		String birthDay = addF.getBirthday();
		String address = addF.getAddress();
		String remark = addF.getRemark();
		
		if (trueName != null && personSsid != null && sex != null && phone !=null && personZzmm !=null 
				&& birthDay!= null && remark != null && personWhcd != null && countryId != null) {
			CmPerson cp = new CmPerson();
			cp.setTruename(trueName);
			cp.setAddress(address);
			cp.setBirthday(birthDay);
			cp.setCountryId(countryId);
			cp.setPhone(phone);
			cp.setRemark(remark);
			//TODO:score
			//cp.setScore(score);
			cp.setSex(sex);
			cp.setSsid(personSsid);
	
			cp.setWhcd(personWhcd);
			cp.setZzmm(personZzmm);
			
		
			LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
			cp.setAuthor(userInfo.getCn());
			
			/*
			boolean isAdmin = Utils.isAdmin(userInfo.getOuname());
			cp.setStat(isAdmin);
			
			cp.setPartId(userInfo.getOuid());
			*/
			//TODO: for test
			cp.setStat(true);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			System.out.println(df.format(now));// new Date()为获取当前系统时间
			cp.setPubdate(now.getTime()/1000);
			
			cmPersonDAO.save(cp);
		} else {
			
			List<CmCountry> afterList = cmCountryDAO.queryParentZero();
			request.setAttribute("parentlist", afterList);
		}
			
		System.out.println("jump to add jsp");
		return mapping.findForward("personaddForword");
	}
	
	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
			Integer personId = Integer.valueOf(request.getParameter("id"));
			System.out.println("[update] id : "+ personId);
			
			CmPerson updateCc = cmPersonDAO.findById(personId);
			
			request.setAttribute("person_truename", updateCc.getTruename());
			request.setAttribute("person_ssid", updateCc.getSsid());
			//TODO: sex
			request.setAttribute("person_zzmm", updateCc.getZzmm());
			request.setAttribute("person_whcd", updateCc.getWhcd());
			request.setAttribute("country_id", updateCc.getCountryId());
			request.setAttribute("person_phone", updateCc.getPhone());
			request.setAttribute("person_birthday", updateCc.getBirthday());
			request.setAttribute("person_address", updateCc.getAddress());
			request.setAttribute("person_remark", updateCc.getRemark());
			
			List<CmCountry> afterList = cmCountryDAO.queryParentZero();
			request.setAttribute("parentlist", afterList);
			request.setAttribute("person_id", personId);
			
		}
		
		if(request.getParameter("xid")!=null &&!request.getParameter("xid").isEmpty()) {
			PersonAddForm addF = (PersonAddForm)form;
			String trueName = addF.getTruename();
			String personSsid = addF.getSsid();
			String sex = addF.getSex();
			String personZzmm = addF.getZzmm();
			String personWhcd = addF.getWhcd();
			Short countryId = addF.getCountry_id();
			String phone = addF.getPhone();
			String birthDay = addF.getBirthday();
			String address = addF.getAddress();
			String remark = addF.getRemark();
			
			if (trueName != null && personSsid != null && sex != null && phone !=null && personZzmm !=null 
					&& birthDay!= null && remark != null && personWhcd != null && countryId != null) {
				CmPerson cp = new CmPerson();
				cp.setTruename(trueName);
				cp.setAddress(address);
				cp.setBirthday(birthDay);
				cp.setCountryId(countryId);
				cp.setPhone(phone);
				cp.setRemark(remark);
				//TODO:score
				//cp.setScore(score);
				cp.setSex(sex);
				cp.setSsid(personSsid);

				cp.setWhcd(personWhcd);
				cp.setZzmm(personZzmm);

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				Date now = new Date();
				System.out.println(df.format(now));// new Date()为获取当前系统时间
				cp.setPubdate(now.getTime()/1000);
				Integer xId = Integer.valueOf(request.getParameter("xid"));
				System.out.println("[update item] : "+xId);
				cp.setId(xId);
				LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
				cp.setAuthor(userInfo.getCn());
				
				/*
				boolean isAdmin = Utils.isAdmin(userInfo.getOuname());
				cp.setStat(isAdmin);
				
				cp.setPartId(userInfo.getOuid());
				*/
				//TODO: for test
				cp.setStat(true);
				cmPersonDAO.update(cp);
			}
		}
		return mapping.findForward("personaddForword");
	}
	
	private ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
			Integer personId = Integer.valueOf(request.getParameter("id"));
			System.out.println("[query] id : "+ personId);
			
			CmPerson updateCc = cmPersonDAO.findById(personId);
			
			request.setAttribute("person_truename", updateCc.getTruename());
			request.setAttribute("person_ssid", updateCc.getSsid());
			//TODO: sex
			request.setAttribute("sex", updateCc.getSex());
			request.setAttribute("person_zzmm", updateCc.getZzmm());
			request.setAttribute("person_whcd", updateCc.getWhcd());
			request.setAttribute("country_id", updateCc.getCountryId());
			if (cmCountryDAO.findById(updateCc.getCountryId()) != null) {
				String countryName = cmCountryDAO.findById(updateCc.getCountryId()).getName();
				request.setAttribute("countryName", countryName);
			} else {
				request.setAttribute("countryName", "");
			}
			request.setAttribute("person_phone", updateCc.getPhone());
			request.setAttribute("person_birthday", updateCc.getBirthday());
			request.setAttribute("person_address", updateCc.getAddress());
			request.setAttribute("person_remark", updateCc.getRemark());
			
			List<CmCountry> afterList = cmCountryDAO.queryParentZero();
			request.setAttribute("parentlist", afterList);
			request.setAttribute("person_id", personId);
			
		}
		
		return mapping.findForward("personinfoForword");
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("method") != null && !request.getParameter("method").isEmpty()) {
			Short actionMethod = Short.valueOf(request.getParameter("method"));
			System.out.println("op action : "+actionMethod);
			if(actionMethod == 1) {
				System.out.println("add action");
				request.setAttribute("pageInfo_actionTitle", "增加");
				request.setAttribute("pageInfo_action", 1);
				return add(mapping,form,request,response);
			} else if (actionMethod == 3) {
				System.out.println("modify action");
				request.setAttribute("pageInfo_actionTitle", "更新");
				request.setAttribute("pageInfo_action", 3);
				return update(mapping,form,request,response);
			} else if (actionMethod == 4) {
				System.out.println("query action");
				request.setAttribute("pageInfo_actionTitle", "查看");
				request.setAttribute("pageInfo_action", 4);
				return query(mapping,form,request,response);
			} else {
				System.out.println("others action");
			}
		}
		
		List<CmCountry> afterList = cmCountryDAO.queryParentZero();
		request.setAttribute("parentlist", afterList);
		
		return mapping.findForward( "personaddForword" );
	}
}
