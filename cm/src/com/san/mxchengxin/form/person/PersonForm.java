package com.san.mxchengxin.form.person;
/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 07-04-2016
 * 
 * XDoclet definition:
 * @struts.form name="personForm"
 */
public class PersonForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** person_ssid property */
	private String person_ssid;

	/** country_id property */
	private Short country_id;

	/** person_truename property */
	private String person_truename;

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
	 * Returns the person_ssid.
	 * @return String
	 */
	public String getPerson_ssid() {
		return person_ssid;
	}

	/** 
	 * Set the person_ssid.
	 * @param person_ssid The person_ssid to set
	 */
	public void setPerson_ssid(String person_ssid) {
		this.person_ssid = person_ssid;
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
	 * Returns the person_truename.
	 * @return String
	 */
	public String getPerson_truename() {
		return person_truename;
	}

	/** 
	 * Set the person_truename.
	 * @param person_truename The person_truename to set
	 */
	public void setPerson_truename(String person_truename) {
		this.person_truename = person_truename;
	}
}