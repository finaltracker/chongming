package com.san.mxchengxin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.form.statistics.ReportForm;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.objects.StatisticsChengxinObj;
import com.san.mxchengxin.objects.levelCatigoryObj;


public class ReportAction extends ChengxinBaseAction {

	private CmLevelDAO cmLevelDAO;
	private CmRecordDAO cmRecordDAO;
	private CmCountryDAO cmCountryDAO;
	
	Short countryId = 0 ;
	
	public CmCountryDAO geCmCountryDAO() {
		return cmCountryDAO;
	}
	
	public void setCmCountryDAO(CmCountryDAO cmCountryDAO) {
		this.cmCountryDAO = cmCountryDAO;
	}
	
	public CmLevelDAO geCmLevelDAO() {
		return cmLevelDAO;
	}
	
	public void setCmLevelDAO(CmLevelDAO cmLevelDAO) {
		this.cmLevelDAO = cmLevelDAO;
	}
	
	public CmRecordDAO geCmRecordDAO() {
		return cmRecordDAO;
	}
	
	public void setCmRecordDAO(CmRecordDAO cmRecordDAO) {
		this.cmRecordDAO = cmRecordDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		super.execute( mapping, form, request, response);
		
		ReportForm reportForm = (ReportForm)form;
		countryId = reportForm.getCountry_id();
		
		/*获取所属乡镇要显示的字符串 */
		Short[] countryList = null;
		StringBuffer sb = new StringBuffer();
		Short[] userSeenCountryList = getVisiableCountryForShort( this.cmCountryDAO  );
		cmCountryDAO.formatToJspString( cmCountryDAO.packCountryMapAsLevelByIdList(userSeenCountryList) , countryId , 0 , sb );
		String countryListStr = sb.toString();
		request.setAttribute("countrySelect", countryListStr);
		
		List<StatisticsChengxinObj> levelList = getTownChengxinObjList( cmCountryDAO, getVisiableCountryForShort(cmCountryDAO), 1, 9999 );
		List<levelCatigoryObj> lcoList = null;

		lcoList = new ArrayList<levelCatigoryObj>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Integer count = 0;
		for(int i = 0 ; i<levelList.size();i++) {
			if(map.get(levelList.get(i).getRank()) == null) {
				count = 1;
			} else {
				count = map.get(levelList.get(i).getRank())+1;
			}
			map.put(levelList.get(i).getRank(), count);
		}
		
		for (String key : map.keySet()) {  
			  
			levelCatigoryObj lco = new levelCatigoryObj();
			List<CmLevel> temp = cmLevelDAO.findByLevelName(key);
			lco.setLevelId( String.valueOf(temp.get(0).id) );
			lco.setLevelName( key );
			lco.setHowmanyPeople( String.valueOf(map.get(key)) );
			lcoList.add( lco );
		  
		}  

		
		request.setAttribute("Level_List", lcoList );
		request.setAttribute("part_name", ouName );
		return mapping.findForward( "reportForword" );
	}
}
