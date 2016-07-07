package com.san.mxchengxin.action.person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.action.ChengxinBaseAction;
import com.san.mxchengxin.form.person.PersonAddForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.share.pmi.dto.LoginUserInfo;
import com.san.share.pmi.service.LoginUserInfoDelegate;

public class PersonAddAction extends ChengxinBaseAction {
	private CmCountryDAO cmCountryDAO;
	private CmPersonDAO cmPersonDAO;
	List<CmCountry> countryList;
	String trueName;
	String personSsid;
	String sex;
	String personZzmm;
	String personWhcd;
	Short countryId;
	String phone;
	String birthDay;
	String address;
	String remark;
	
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
	
	private void passFormToVar(ActionForm form) {
		PersonAddForm addF = (PersonAddForm)form;
		trueName = addF.getTruename();
		personSsid = addF.getSsid();
		sex = addF.getSex();
		personZzmm = addF.getZzmm();
		personWhcd = addF.getWhcd();
		countryId = addF.getCountry_id();
		phone = addF.getPhone();
		birthDay = addF.getBirthday();
		address = addF.getAddress();
		remark = addF.getRemark();
	}
	
	private void passDataToDb(CmPerson cp) {
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
		
		//TODO: not use, there is no way to transfer ouid to part id
		//cp.setPartId(userInfo.getOuid());

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		System.out.println(df.format(now));// new Date()为获取当前系统时间
		cp.setPubdate(now.getTime()/1000);
	}
	
	private Integer saveDataToDbPerson(String author , HttpServletRequest request  ) {
		CmPerson cp = new CmPerson();
		passDataToDb(cp);
		cp.setAuthor(author);

		boolean isAdmin = isAllVisiable();
		cp.setStat(isAdmin);
		saveMessageToLog("新增人员: " + cp.getTruename() , request );
		cmPersonDAO.save(cp);
		return cp.getId();
	}
	
	private void updateDataToDbPerson(CmPerson oldPerson) {
		passDataToDb(oldPerson);
		boolean isAdmin = isAllVisiable();
		oldPerson.setStat(isAdmin);
		cmPersonDAO.update(oldPerson);
	}
	
	private ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("save")!=null &&!request.getParameter("save").isEmpty()) {
			System.out.println("save save3333");
			if(request.getParameter("id")!=null &&!request.getParameter("id").isEmpty()) {
				Integer personId = Integer.valueOf(request.getParameter("id"));
				System.out.println("[save and update] id : "+ personId);
				
				CmPerson updateCc = cmPersonDAO.findById(personId);
				updateCc.setStat(true);
				saveMessageToLog("提交人员: " + updateCc.getTruename() , request );
				cmPersonDAO.update(updateCc);
			}
		} else {
		
			passFormToVar(form);
			
			if (trueName != null && personSsid != null && sex != null && phone !=null && personZzmm !=null 
					&& birthDay!= null && remark != null && personWhcd != null && countryId != null) {
	
				LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
	
				saveDataToDbPerson(userInfo.getCn() ,request );
				
				
			} else {
				
				List<CmCountry> afterList = getVisiableCountry(cmCountryDAO);
				if(afterList != null) {
					Short parentId = 0;
					Short selectedCountryId = 0;
					String countrySelect = getCountrySelect(afterList, selectedCountryId ,parentId,1);
					
					request.setAttribute("countrySelect", countrySelect);
				}
				
				//for ajax
				request.setAttribute("person_stat", false);
				Integer xid = cmPersonDAO.getMaxId();
				System.out.println("save xid: "+xid);
				request.setAttribute("person_id", xid+1);
			}
		}
			
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
			request.setAttribute("sex", updateCc.getSex());
			request.setAttribute("person_zzmm", updateCc.getZzmm());
			request.setAttribute("person_whcd", updateCc.getWhcd());
			request.setAttribute("country_id", updateCc.getCountryId());
			request.setAttribute("person_phone", updateCc.getPhone());
			request.setAttribute("person_birthday", updateCc.getBirthday());
			request.setAttribute("person_address", updateCc.getAddress());
			request.setAttribute("person_remark", updateCc.getRemark());
			
			List<CmCountry> afterList = getVisiableCountry(cmCountryDAO);
			if (afterList != null) {
				Short parentId = 0;
				Short selectedCountryId = Short.valueOf(updateCc.getCountryId());
				String countrySelect = getCountrySelect(afterList, selectedCountryId ,parentId,1);
				System.out.println("country select: "+countrySelect);
				request.setAttribute("countrySelect", countrySelect);
			}
			request.setAttribute("person_id", personId);
			
			//for ajax
			request.setAttribute("person_stat", updateCc.getStat());
			
		}
		
		if(request.getParameter("xid")!=null &&!request.getParameter("xid").isEmpty()) {
			
			Integer xId = Integer.valueOf(request.getParameter("xid"));
			System.out.println("[update item] : "+xId);
			CmPerson oldPerson = cmPersonDAO.findById(xId);
			
			if(request.getParameter("save")!=null &&!request.getParameter("save").isEmpty()) {
				oldPerson.setStat(true);
				saveMessageToLog("提交人员: " + oldPerson.getTruename() , request );
				cmPersonDAO.update(oldPerson);
			} else {
				passFormToVar(form);
				
				if (trueName != null && personSsid != null && sex != null && phone !=null && personZzmm !=null 
						&& birthDay!= null && remark != null && personWhcd != null && countryId != null) {
	
					//LoginUserInfo userInfo = LoginUserInfoDelegate.getLoginUserInfoFromRequest(request);
	
					updateDataToDbPerson(oldPerson);
				}
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
			
			request.setAttribute("person_id", personId);

		}
		
		return mapping.findForward("personinfoForword");
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		super.execute(mapping, form, request, response);
		
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
		
		List<CmCountry> afterList = getVisiableCountry(cmCountryDAO);
		if(afterList != null) {
			Short parentId = 0;
			Short selectedCountryId = 0;
			String countrySelect = getCountrySelect(afterList, selectedCountryId ,parentId,1);
			System.out.println("country select: "+countrySelect);
			request.setAttribute("countrySelect", countrySelect);
		}
		return mapping.findForward( "personaddForword" );
	}
	
	private String getCountrySelect(List<CmCountry> list, Short selectedId, Short parentId, int level) {
		if(list.size() == 1)
		{
			CmCountry cc = (CmCountry)list.get(0);
			String isSelected = "";
			if(cc.getId().shortValue() == selectedId) {
				isSelected = " selected";
			}
			
			return String.format("<option value='%d'%s>%s</option>", cc.getId(),isSelected,"├─"+cc.getName());
		}
		
		String select = "";
		for(int i=0;i<list.size();i++) {
			CmCountry cc = (CmCountry)list.get(i);
			if(cc.getParentid() != parentId.shortValue()) continue;
			
			String empty="";
			for(int x=1;x<level;x++)
				empty +="&nbsp;&nbsp;";
			
			String isSelected = "";
			if(cc.getId().shortValue() == selectedId) {
				isSelected = " selected";
			}
			
			select += String.format("<option value='%d'%s>%s</option>", cc.getId(),isSelected,empty+"├─"+cc.getName());
			select += getCountrySelect(list, selectedId,cc.getId(),level+1);
		}
		
		return select;
	}
}
