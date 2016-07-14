/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.san.mxchengxin.form.person;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 07-04-2016
 * 
 * XDoclet definition:
 * @struts.form name="PersonAddForm"
 */
public class PersonInfoForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** whcd property */
	private String whcd;

	/** birthday property */
	private String birthday;

	/** phone property */
	private String phone;

	/** sex property */
	private String sex;

	/** remark property */
	private String remark;

	/** address property */
	private String address;

	/** truename property */
	private String truename;

	/** country_id property */
	private Short country_id;

	/** ssid property */
	private String ssid;

	/** zzmm property */
	private String zzmm;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
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

	/** 
	 * Returns the whcd.
	 * @return String
	 */
	public String getWhcd() {
		return whcd;
	}

	/** 
	 * Set the whcd.
	 * @param whcd The whcd to set
	 */
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	/** 
	 * Returns the birthday.
	 * @return String
	 */
	public String getBirthday() {
		return birthday;
	}

	/** 
	 * Set the birthday.
	 * @param birthday The birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/** 
	 * Returns the phone.
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/** 
	 * Set the phone.
	 * @param phone The phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** 
	 * Returns the sex.
	 * @return String
	 */
	public String getSex() {
		return sex;
	}

	/** 
	 * Set the sex.
	 * @param sex The sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/** 
	 * Returns the remark.
	 * @return String
	 */
	public String getRemark() {
		return remark;
	}

	/** 
	 * Set the remark.
	 * @param remark The remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** 
	 * Returns the address.
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/** 
	 * Set the address.
	 * @param address The address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** 
	 * Returns the truename.
	 * @return String
	 */
	public String getTruename() {
		return truename;
	}

	/** 
	 * Set the truename.
	 * @param truename The truename to set
	 */
	public void setTruename(String truename) {
		this.truename = truename;
	}

	/** 
	 * Returns the country_id.
	 * @return Short
	 */
	public Short getCountry_id() {
		return country_id;
	}

	/** 
	 * Set the country_id.
	 * @param country_id The country_id to set
	 */
	public void setCountry_id(Short country_id) {
		this.country_id = country_id;
	}

	/** 
	 * Returns the ssid.
	 * @return String
	 */
	public String getSsid() {
		return ssid;
	}

	/** 
	 * Set the ssid.
	 * @param ssid The ssid to set
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	/** 
	 * Returns the zzmm.
	 * @return String
	 */
	public String getZzmm() {
		return zzmm;
	}

	/** 
	 * Set the zzmm.
	 * @param zzmm The zzmm to set
	 */
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
}