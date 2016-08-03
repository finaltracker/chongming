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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.action.ChengxinBaseAction;
import com.san.mxchengxin.form.country.CountryForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryAd;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonDAO;

public class CountryAction extends ChengxinBaseAction {
	private CmCountryDAO cmCountryDAO;
	private CmPersonDAO	cmPersonDAO;
	List<CmCountry> countryList;
	public CmCountryDAO getCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public CmPersonDAO getCmPersonDAO() {
		return cmPersonDAO;
	}
	
	public void setCmPersonDAO(CmPersonDAO cmPersonDAO) {
		this.cmPersonDAO = cmPersonDAO;
	}
	
	private String getCountrySelect(Short selectedId, Short parentId, int level) {
		if(countryList.size() == 1)
		{
			CmCountry cc = (CmCountry)countryList.get(0);
			String isSelected = "";
			if(cc.getId().shortValue() == selectedId) {
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
			if(cc.getId().shortValue() == selectedId) {
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
		
		super.execute(mapping, form, request, response);
		
		if(request.getParameter("id") != null) {
			Short countryId = Short.valueOf(request.getParameter("id"));
			System.out.println("[country delete] id : "+countryId);
			CmCountry cc = cmCountryDAO.findById(countryId);
			boolean canDelete = true;
			String tipMessage ="";
			
			List<CmCountry> beforeList = cmCountryDAO.findAll();
			for(int i=0;i<beforeList.size();i++) {
				CmCountry item = beforeList.get(i);
				if(countryId == item.getParentid().shortValue()) {
					System.out.println("has other country, so not delete ");
					tipMessage = "该村镇下存在其它村不能直接删除";
					canDelete = false;
				}
			}
			//todo: add person restriction
			List<CmPerson> beforeList2 = cmPersonDAO.findAll();
			for(int i=0;i<beforeList2.size();i++) {
				CmPerson item = beforeList2.get(i);
				if(countryId == item.getCountryId().shortValue()) {
					System.out.println("has people, so not delete ");
					tipMessage = "该村镇下存在相关人员不能直接删除";
					canDelete = false;
				}
			}
			
			if(canDelete) {
				System.out.println("we can delete ");
				CmCountry cmc = cmCountryDAO.findById(countryId);
				saveMessageToLog("删除村镇: " + cmc.getName() , request );
				cmCountryDAO.delete( cmc );
			} else {
				request.setAttribute("tipMessage", tipMessage);
			}

		}
		
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
			searDc.add(Restrictions.eq("parentid", countryId.shortValue() )); 
		}
		
		if( countryName != null && ( !countryName.isEmpty() ))
		{
			searDc.add(Restrictions.like("name", countryName,MatchMode.ANYWHERE).ignoreCase()); 
		}
		
		searDc.addOrder( Order.asc("name")  );
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
			cadList.add(cca);
		}
		
		
		Short parentId = 0;
		String countrySelect = getCountrySelect(countryId.shortValue(),parentId,1);
		System.out.println("country select result: "+countrySelect);
		request.setAttribute("countrySelect", countrySelect);
		request.setAttribute("country_name", countryName);
		request.setAttribute("clist", cadList);
		
		return mapping.findForward( "countryForword" );
	}

}
