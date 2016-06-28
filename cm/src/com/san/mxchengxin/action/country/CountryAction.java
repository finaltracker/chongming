package com.san.mxchengxin.action.country;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.form.country.CountryForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryAd;
import com.san.mxchengxin.model.country.CmCountryDAO;

public class CountryAction extends Action {
	private CmCountryDAO cmCountryDAO;
	List<CmCountry> countryList;
	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	private String getCountrySelect(Short selectedId, Short parentId, int level) {
		if(countryList.size() == 1)
		{
			CmCountry cc = (CmCountry)countryList.get(0);
			String isSelected = "";
			if(cc.getId() == selectedId) {
				isSelected = " selected";
			}
			
			return String.format("<option value='%d'%s>%s</option>", cc.getId(),isSelected,"├─"+cc.getName());
		}
		
		String select = "";
		for(int i=0;i<countryList.size();i++) {
			CmCountry cc = (CmCountry)countryList.get(i);
			if(cc.getParentid() != parentId.shortValue()) continue;
			
			String empty="";
			for(int x=1;x<level;x++)
				empty +="&nbsp;&nbsp;";
			
			String isSelected = "";
			if(cc.getId() == selectedId) {
				isSelected = " selected";
			}
			
			select += String.format("<option value='%d'%s>%s</option>", cc.getId(),isSelected,empty+"├─"+cc.getName());
			//System.out.println("temp select : "+select);
			select += getCountrySelect(selectedId,cc.getId(),level+1);
		}
		
		return select;
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String countryName = "";
		Short countryId = 0 ;
		CountryForm countryForm = (CountryForm)form;
		countryId = countryForm.getCountry_id();
		countryName = countryForm.getCountry_name();
		
		countryList = cmCountryDAO.findAll();
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmCountry.class);
		
		if( countryId == null ) 
		{
			countryId = 0;
		} else if( countryId != 0 ) 
		{
			searDc.add(Restrictions.eq("id", countryId.shortValue() )); 
		}
		
		if( countryName != null && ( !countryName.isEmpty() ))
		{
			searDc.add(Restrictions.like("name", countryName,MatchMode.ANYWHERE).ignoreCase()); 
		}
		
		List<CmCountry> targetList = cmCountryDAO.getHibernateTemplate ().findByCriteria( searDc );
		
		List<CmCountryAd> cadList = new ArrayList<CmCountryAd>();
		for(int i=0;i<targetList.size();i++) {
			CmCountry target = (CmCountry)targetList.get(i);
			CmCountryAd cca = new CmCountryAd(target);
			if (target.getParentid().shortValue() == 0) {
				cca.setParentName("崇明县");
			}else {
				cca.setParentName("崇明县>"+cmCountryDAO.findById(target.getParentid()).getName());
			}
			System.out.println("name: "+target.getName());
			cadList.add(cca);
		}
		
		
		Short parentId = 0;
		String countrySelect = getCountrySelect(countryId,parentId,1);
		System.out.println("country select result: "+countrySelect);
		request.setAttribute("countrySelect", countrySelect);
		request.setAttribute("country_name", countryName);
		request.setAttribute("clist", cadList);
		
		return mapping.findForward( "countryForword" );
	}

}
