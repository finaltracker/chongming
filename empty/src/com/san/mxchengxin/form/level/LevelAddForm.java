/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.san.mxchengxin.form.level;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 06-21-2016
 * 
 * XDoclet definition:
 * @struts.form name="LevelAddForm"
 */
public class LevelAddForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** target_name property */
	private String level_name;
	
	private String level_score;

	/*
	 * Generated Methods
	 */

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public String getLevel_score() {
		return level_score;
	}

	public void setLevel_score(String level_score) {
		this.level_score = level_score;
	}

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
}