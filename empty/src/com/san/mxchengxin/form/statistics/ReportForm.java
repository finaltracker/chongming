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
public class ReportForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** catSelect property */
	private Integer catSelect;

	/** country_id property */
	private Short country_id;

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
	
	
	public Integer getCatSelect() {
		return catSelect;
	}

	public void setCatSelect(Integer catSelect) {
		this.catSelect = catSelect;
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

}