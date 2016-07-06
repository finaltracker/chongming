package com.san.mxchengxin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.form.TargetForm;
import com.san.mxchengxin.form.record.RecordForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;
import com.san.mxchengxin.model.target.CmTargetEnhance;


public class RecordAction extends ChengxinBaseAction {
	
	private CmCountryDAO cmCountryDAO;
	private CmRecordDAO cmRecordDAO;
	private CmTargetDAO cmTargetDAO;
	
	public CmCountryDAO geCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public CmRecordDAO getCmRecordDAO() {
		return cmRecordDAO;
	}
	
	public void setCmRecordDAO(CmRecordDAO cmRecordDAO) {
		this.cmRecordDAO = cmRecordDAO;
	}
	
	public CmTargetDAO getCmTargetDAO() {
		return cmTargetDAO;
	}
	
	public void setCmTargetDAO(CmTargetDAO cmTargetDAO) {
		this.cmTargetDAO = cmTargetDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		super.execute( mapping, form, request, response);
		
		RecordForm recordForm = (RecordForm) form;
		
		/*  */
		Short[] countryList = null;
		
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmRecord.class);
		
		searDc.setFetchMode("person", FetchMode.JOIN); 
		searDc.createAlias("person", "person");  
		
		
		if( recordForm.getCountry_id() == null )
		{//根据登陆的用户名来确定
			countryList = getVisiableCountryForShort( this.cmCountryDAO );
		}
		else
		{//用户指定
			countryList = new Short[1];
			countryList[0] = recordForm.getCountry_id();
		}
		searDc.add(Restrictions.in("person.countryId", countryList ));
		if( recordForm.getTruename() != null )
		{
			searDc.add(Restrictions.eq("person.truename", recordForm.getTruename()));  
		}
		if( recordForm.getSsid() != null )
		{
			searDc.add(Restrictions.eq("person.ssid", recordForm.getSsid() )); 
		}
		
		if( recordForm.getTarget_id() != null )
		{
			searDc.add(Restrictions.eq("targetId", (int) (recordForm.getTarget_id() )));
		}

		List<CmRecord>  list = cmRecordDAO.getHibernateTemplate ().findByCriteria( searDc );
	
		
		/* 将contry list 由ID 转换为 string */
		String countryListStr = cmCountryDAO.formatToJspString( cmCountryDAO.packCountryMapAsLevelByIdList(countryList) , recordForm.getCountry_id() );
		
		List<CmTarget> targetList = cmTargetDAO.findAll(); 
		String targetSelectStr = cmTargetDAO.formatToJspString( targetList , recordForm.getTarget_id() );
		
		request.setAttribute("countrySelect", countryListStr );
		request.setAttribute("targetSelect", targetSelectStr );
		request.setAttribute("truename", recordForm.getTruename() );
		request.setAttribute("ssid", recordForm.getSsid() );
		
		return mapping.findForward( "recordForword" );
	}
	
	
}
