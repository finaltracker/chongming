/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.san.mxchengxin.form.statistics;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 07-11-2016
 * 
 * XDoclet definition:
 * @struts.form name="StatisticsForm"
 */
public class StatisticsForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** truename property */
	private String truename;

	/** country_id property */
	private Short country_id;

	/** ssid property */
	private String ssid;

	/** level_id property */
	private Short level_id;

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
	 * Returns the level_id.
	 * @return Short
	 */
	public Short getLevel_id() {
		return level_id;
	}

	/** 
	 * Set the level_id.
	 * @param level_id The level_id to set
	 */
	public void setLevel_id(Short level_id) {
		this.level_id = level_id;
	}
}