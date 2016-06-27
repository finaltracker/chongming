package com.san.mxchengxin.action.country;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.chengxin.model.part.CmPart;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;

public class CountryAction extends Action {
	private CmCountryDAO cmCountryDAO;
	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("country execute!! ");
		List<CmCountry> countryList = cmCountryDAO.findAll();
		StringBuffer sb = new StringBuffer();

		for(int i=0;i<countryList.size();i++) {
			CmCountry cc = (CmCountry)countryList.get(i);
			
			String s = String.format("<option value='%d'>%s</option>", cc.getId(),cc.getName());
		
			sb.append(s);
			
		}
		System.out.println("country select result: "+sb.toString());
		String countrySelect = sb.toString();
		request.setAttribute("countrySelect", countrySelect);
		
		return mapping.findForward( "countryForword" );
	}

}
