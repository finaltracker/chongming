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
import com.san.mxchengxin.model.country.CmCountry;
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
	Integer catSelect = 0;
	final int MACRO_TOWN_VALID	= 2;
	final int MACRO_COUNTRY_VALID	= 1;
	final int MACRO_PEOPLE_VALID	= 0;
	final int MACRO_INVALID	= -1;
	
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
		catSelect = reportForm.getCatSelect();
		
		/*获取所属乡镇要显示的字符串 */
		Short[] countryList = null;
		StringBuffer sb = new StringBuffer();
		Short[] userSeenCountryList = getVisiableCountryForShort( this.cmCountryDAO  );
		cmCountryDAO.formatToJspString( cmCountryDAO.packCountryMapAsLevelByIdList(userSeenCountryList) , countryId , 0 , sb );
		String countryListStr = sb.toString();
		
		if( ( countryId == null) || (countryId == 0 ) )
		{//根据登陆的用户名来确定
			countryList = userSeenCountryList;
		}
		else
		{//用户指定(村或镇)
			countryList = getVisiableCountryForShortAsCountryId( cmCountryDAO , countryId );
			//自动设置合适的等级
			int countryType = getCountryType( countryId , cmCountryDAO );
			if( countryType == COUNTRY_FLAG )
			{
				if( ( catSelect == null ) || ( catSelect == MACRO_TOWN_VALID ) )
				{
					catSelect = MACRO_COUNTRY_VALID;
				}
			}
		}
		
		//用户能看见的等级

		int userSeenCatValid = makeSureCatSelectAccordUser();
		
		if( catSelect == null )
		{
			catSelect = userSeenCatValid;
		}
		 
		
		
		 
		List<StatisticsChengxinObj> levelList = null;
		 
		 String catSelectStr = buildCatSelectStr( userSeenCatValid ,catSelect );
		 //县级权限登录，查询所有的镇

		 Short[] VisiableContryLimit = countryList ; 
		 if( catSelect == MACRO_TOWN_VALID )
		 { // 县级权限，town列表显示
			 levelList = getTownChengxinObjList( cmCountryDAO , VisiableContryLimit , 1 , 9999 );
		 }
		 else if(catSelect == MACRO_COUNTRY_VALID )
		 {
			 levelList = getCountryChengxinObjList( cmCountryDAO , VisiableContryLimit , 1, 9999);
		 }
		 else if(catSelect == MACRO_PEOPLE_VALID )
		 { 
			 levelList = getPeopleChengxinObjList( cmCountryDAO ,VisiableContryLimit , null , null ,1, 9999);
		 }
		 //else
		 {
			 
		 }
		
		List<levelCatigoryObj> lcoList = null;

		lcoList = new ArrayList<levelCatigoryObj>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Integer count = 0;
		if( levelList != null )
		{
			for(int i = 0 ; i<levelList.size();i++) {
				if(map.get(levelList.get(i).getRank()) == null) {
					count = 1;
				} else {
					count = map.get(levelList.get(i).getRank())+1;
				}
				map.put(levelList.get(i).getRank(), count);
			}
		}
		for (String key : map.keySet()) {  
			  
			levelCatigoryObj lco = new levelCatigoryObj();
			List<CmLevel> temp = cmLevelDAO.findByLevelName(key);
			lco.setLevelId( String.valueOf(temp.get(0).id) );
			lco.setLevelName( key );
			lco.setHowmanyPeople( String.valueOf(map.get(key)) );
			lcoList.add( lco );
		  
		}  
		
		String part_name = ouName;
		if( part_name.equals( "系统管理部") )
		{
			part_name = "崇明县";
		}
		request.setAttribute("catSelectStr", catSelectStr);
		request.setAttribute("countrySelect", countryListStr );
		request.setAttribute("Level_List", lcoList );
		request.setAttribute("part_name", part_name );
		return mapping.findForward( "reportForword" );
	}
	
	//更加用户名确定可以看到的等级
	private int makeSureCatSelectAccordUser()
	{
		int ret = MACRO_INVALID;
		
		if( this.isAllVisiable() )
		{//最高能看到 towns
			ret = MACRO_TOWN_VALID;
		}
		else
		{
			List< CmCountry> countryList = cmCountryDAO.findByName( ouName );
			
			if( countryList.size() > 0 )
			{
				CmCountry cc = countryList.get(0);
				countryId = cc.getId();
				if( cc.getParentid() == 0 )
				{ // 是 town ， 看见的是村级
					ret = MACRO_COUNTRY_VALID;
				}
				else
				{
					ret = MACRO_PEOPLE_VALID;
				}
			}
		}
		
		return ret;
	}
	
	//topShowCat: 2：显示到镇   1： 显示到村   0： 显示到人
	//selected : which cat is select 
	private String buildCatSelectStr( int topShowCat , int selected )
	{
		StringBuffer sb = new StringBuffer();
		
		String s="";
		switch (topShowCat)
		{
		case MACRO_TOWN_VALID:
			if( selected == MACRO_TOWN_VALID )
			{
				s = String.format("<option value=2 selected>乡镇</option>" );
			}
			else
			{
				s = String.format("<option value=2 >乡镇</option>" );
			}
			
			sb.append(s);
		case MACRO_COUNTRY_VALID:
			if( selected == this.MACRO_COUNTRY_VALID )
			{
				s = String.format("<option value=1 selected>村</option>" );
			}
			else
			{
				s = String.format("<option value=1 >村</option>" );
			}
			
			sb.append(s);
		case MACRO_PEOPLE_VALID:
			if( selected == MACRO_PEOPLE_VALID )
			{
				s = String.format("<option value=0 selected>人员</option>" );
			}
			else
			{
				s = String.format("<option value=0 >人员</option>" );
			}
			
			sb.append(s);
			break;
		default:
			break;
		}
		
		return sb.toString();
	}
}
