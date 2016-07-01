package com.san.mxchengxin.action;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.form.statistics.StatisticsForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPersonDAO;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.objects.RecordListObj;
import com.san.mxchengxin.objects.StatisticsChengxinObj;
import com.san.mxchengxin.utils.ComparatorCmLevel;
import com.san.mxchengxin.utils.util;

public class StatisticsAction extends ChengxinBaseAction {
	private CmCountryDAO cmCountryDAO;
	private CmRecordDAO cmRecordDAO;
	private CmLevelDAO cmLevelDAO;
	private CmPersonDAO	cmPersonDAO;
	
	int MAX_PAGE_SIZE_9999 = 9999;
	final int MACRO_TOWN_VALID	= 2;
	final int MACRO_COUNTRY_VALID	= 1;
	final int MACRO_PEOPLE_VALID	= 0;
	final int MACRO_INVALID	= -1;
	
	
	Short countryId = -1 ;
	
	int catSelectInt = -1; // -1 invalid
	short country_idShort = -1;// -1 invalid
	
	String searchMap_truename = "";
	String searchMap_ssid = "";
	
	Short levelId = 0;
	
	//for pagination
	int page = 1;
	int recordsPerPage = 20;
	int noOfPages = 0;
	
	public CmCountryDAO getCmCountryDAO() {
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
	
	public CmLevelDAO getCmLevelDAO() {
		return cmLevelDAO;
	}
	
	public void setCmLevelDAO(CmLevelDAO cmLevelDAO) {
		this.cmLevelDAO = cmLevelDAO;
	}
	
	public CmPersonDAO getCmPersonDAO() {
		return cmPersonDAO;
	}
	
	public void setCmPersonDAO(CmPersonDAO cmPersonDAO) {
		this.cmPersonDAO = cmPersonDAO;
	}
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		super.execute(mapping, form, request, response);
		
		
		if(request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		} 

		if( request.getParameter("search") != null )
		{// search button,每次搜索都应该从头开始
			page = 1; //设置从头开始
		}
		if(request.getParameter("showAll") != null) {
			catSelectInt = -1;    // 重新设置cat 选择为无效
			country_idShort = -1; // 重新设置country 选择为无效
			page = 1; //设置从头开始
		}

		StatisticsForm statForm = (StatisticsForm)form;
		
		Integer catSelect = statForm.getCatSelect();
		if( catSelect != null )
		{
			if( catSelectInt != catSelect.intValue() )
			{
				page = 1; //设置从头开始
			}
			catSelectInt = catSelect.intValue();
		}
		
		if( statForm.getCountry_id() != null)
		{
			country_idShort = statForm.getCountry_id();
		}
		
		/*获取所属乡镇要显示的字符串 */
		Short[] countryList = null;
		StringBuffer sb = new StringBuffer();
		Short[] userSeenCountryList = getVisiableCountryForShort( this.cmCountryDAO  );
		cmCountryDAO.formatToJspString( cmCountryDAO.packCountryMapAsLevelByIdList(userSeenCountryList) , country_idShort , 0 , sb );
		String countryListStr = sb.toString();
		
		
		if( ( country_idShort == -1 ) || ( country_idShort == 0 ) )
		{//根据登陆的用户名来确定
			countryList = userSeenCountryList;
		}
		else
		{//用户指定(村或镇)
			countryList = getVisiableCountryForShortAsCountryId( cmCountryDAO , country_idShort );
			//自动设置合适的等级
			int countryType = getCountryType( country_idShort , cmCountryDAO );
			if( countryType == COUNTRY_FLAG )
			{
				if( ( catSelectInt == -1 ) || ( catSelectInt == MACRO_TOWN_VALID ) )
				{
					catSelectInt = MACRO_COUNTRY_VALID;
				}
			}
		}
		
		//用户能看见的等级

		int userSeenCatValid = makeSureCatSelectAccordUser();
		
		if( catSelectInt == -1 )
		{
			catSelectInt = userSeenCatValid;
		}
		 
		
		
		 
		 List<StatisticsChengxinObj>  statisticsChengxinOjbList = null;
		 
		 String catSelectStr = buildCatSelectStr( userSeenCatValid ,catSelectInt );
		 //县级权限登录，查询所有的镇

		 Short[] VisiableContryLimit = countryList ; 
		 if( catSelectInt == MACRO_TOWN_VALID )
		 { // 县级权限，town列表显示
			 statisticsChengxinOjbList = getTownChengxinObjList( cmCountryDAO , VisiableContryLimit , 1 , 100 );
		 }
		 else if(catSelectInt == MACRO_COUNTRY_VALID )
		 {
			 statisticsChengxinOjbList = getCountryChengxinObjList( cmCountryDAO , VisiableContryLimit , 1 ,MAX_PAGE_SIZE_9999);
		 }
		 else if(catSelectInt == MACRO_PEOPLE_VALID )
		 {  
			 statisticsChengxinOjbList = getPeopleChengxinObjList( cmCountryDAO ,VisiableContryLimit , statForm.getPerson_truename() , statForm.getPerson_ssid() , 1 , MAX_PAGE_SIZE_9999 );
		 }
		 //else
		 {
			 
		 }
		
		
	
		int noOfRecords = statisticsChengxinOjbList.size();
		noOfPages = ( noOfRecords + (recordsPerPage-1))/ recordsPerPage;
		
		int listSize = recordsPerPage;
		
		int startP =  (page-1) * recordsPerPage ;
		if( startP + listSize >  noOfRecords )
		{
			listSize = noOfRecords - startP;
		}
		
		List<StatisticsChengxinObj>  showStatisticsChengxinOjbList = new ArrayList<StatisticsChengxinObj>();
		for( int i = 0 ; i < listSize ; i++ )
		{
			showStatisticsChengxinOjbList.add( statisticsChengxinOjbList.get( startP + i ));
		}
		
		//export excel
		if(request.getParameter("opt") != null) {
			int opt = Integer.valueOf(request.getParameter("opt"));
			if(opt==21) {
				boolean doDumpToExcel = false;
				if( this.isAllVisiable() )
				{// 系统管理员
					doDumpToExcel = true;
				}
				else
				{
					if( showStatisticsChengxinOjbList.size() == 1 )
					{ // 只允许导出一个记录(一般是用户进行查询获得)
						doDumpToExcel = true;
					}
					else						
					{
						doDumpToExcel = false;
					}
				}
				if( doDumpToExcel )
				{ // do export to excel
					try {
						dumpToExcel(request, response, showStatisticsChengxinOjbList);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					Map failReason  = new HashMap<String, String>();
					failReason.put("failCause","只允许导出一个记录");
					JSONArray jsonObject = JSONArray.fromObject( failReason );//装换json
					
					ajaxResponse( response , jsonObject );
				}
				
				return null;
			}
			
		}
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("noOfRecords", noOfRecords);
		request.setAttribute("currentPage", page);
		
		request.setAttribute("catSelectStr", catSelectStr);
		request.setAttribute("list" , showStatisticsChengxinOjbList );
		request.setAttribute("countrySelect", countryListStr );
		
		return mapping.findForward( "statisticsForword" );
		
		
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
	
	private void dumpToExcel(HttpServletRequest request, HttpServletResponse response, List<StatisticsChengxinObj> list) throws IOException
	{

		String[] excelHeader = { "序号", "名称", "基础分","诚信积累(加分)","诚信流失(减分)","诚信总分","等级"};    
        HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("statistics");    
        HSSFRow row = sheet.createRow(0);    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
    
        saveMessageToLog("导出诚信统计列表" , request );
        
        for (short i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell(i);  
            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue(excelHeader[i]);    
            cell.setCellStyle(style);    
            //sheet.autoSizeColumn(i);    
        }    
    
        for (int i = 0; i < list.size(); i++) {    
            row = sheet.createRow(i + 1);    
            StatisticsChengxinObj scx = list.get(i);    
            //csCell.setEncoding(HSSFCell.ENCODING_UTF_16);
            HSSFCell cell0 = row.createCell((short)0);
            cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell0.setCellValue(i+1);  
            HSSFCell cell1 = row.createCell((short)1);
            cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell1.setCellValue(scx.getName());  
            HSSFCell cell2 = row.createCell((short)2);
            cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell2.setCellValue(scx.getBaseScore());  
            
            HSSFCell cell3 = row.createCell((short)3);
            cell3.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell3.setCellValue(scx.getSubScore());  
            
            HSSFCell cell4 = row.createCell((short)4);
            cell4.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell4.setCellValue(scx.getAddScore());  
            
            HSSFCell cell5 = row.createCell((short)5);
            cell5.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell5.setCellValue(scx.getTotalScore()); 
            
            HSSFCell cell6 = row.createCell((short)6);
            cell6.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell6.setCellValue(scx.getRank()); 
            
        }        
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = df.format(new Date());
        String fileName =  "chengxinRecord"+date+".xls";  
        response.setHeader("Content-disposition", "attachment;filename="+fileName); 
        response.addHeader("Pargam", "no-cache");  
        response.addHeader("Cache-Control", "no-cache");  
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close(); 
		
		
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

}
