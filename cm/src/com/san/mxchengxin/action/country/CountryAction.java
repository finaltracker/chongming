package com.san.mxchengxin.action.country;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.model.country.CmCountryDAO;

public class CountryAction extends Action {
	private CmCountryDAO cmCountryDAO;
	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmTargetDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward( "countryForword" );
	}

}
