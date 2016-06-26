package com.logServices.zqs.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ServiceLogForm extends ActionForm{
	
	
	private String sid;
	private String usernameString;
	private String dapartString;
	private String nowDateString;
	private String startString;
	private String endString;
	
	public String getDapartString() {
		return dapartString;
	}
	public void setDapartString(String dapartString) {
		this.dapartString = dapartString;
	}
	public String getEndString() {
		return endString;
	}
	public void setEndString(String endString) {
		this.endString = endString;
	}
	public String getNowDateString() {
		return nowDateString;
	}
	public void setNowDateString(String nowDateString) {
		this.nowDateString = nowDateString;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getStartString() {
		return startString;
	}
	public void setStartString(String startString) {
		this.startString = startString;
	}
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
}
