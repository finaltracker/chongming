/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.san.mhcx.mkdz.web;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/** 
 * MyEclipse Struts
 * Creation date: 06-18-2008
 * 
 * XDoclet definition:
 */
public class MkdzForm extends ActionForm {

	
	private String mkId;
	private String mkName;
	private String jflx;
	private String jfsc;
	private String jf;
	private String zt;
	private String jfsclx;
	

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

	public String getMkId() {
		return mkId;
	}

	public void setMkId(String mkId) {
		this.mkId = mkId;
	}

	public String getMkName() {
		return mkName;
	}

	public void setMkName(String mkName) {
		this.mkName = mkName;
	}

	public String getJflx() {
		return jflx;
	}

	public void setJflx(String jflx) {
		this.jflx = jflx;
	}

	public String getJfsc() {
		return jfsc;
	}

	public void setJfsc(String jfsc) {
		this.jfsc = jfsc;
	}

	public String getJf() {
		return jf;
	}

	public void setJf(String jf) {
		this.jf = jf;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getJfsclx() {
		return jfsclx;
	}

	public void setJfsclx(String jfsclx) {
		this.jfsclx = jfsclx;
	}

	
}