package com.san.mxchengxin.form.country;
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
 * Creation date: 06-28-2016
 * 
 * XDoclet definition:
 * @struts.form name="CountryForm"
 */
public class CountryForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** country_id property */
	private Short country_id;

	/** country_name property */
	private String country_name;

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
	 * Returns the country_name.
	 * @return String
	 */
	public String getCountry_name() {
		return country_name;
	}

	/** 
	 * Set the country_name.
	 * @param country_name The country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
}