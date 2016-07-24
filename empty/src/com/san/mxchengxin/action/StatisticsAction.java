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
	
	
	String searchMap_truename = "";
	String searchMap_ssid = "";
	Short countryId = 0 ;
	Short levelId = 0;
	
	List<CmCountry> countryList;
	List<CmLevel> levels;
	//for pagination
	int page = 1;
	int recordsPerPage = 30;
	
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
		

		if(request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		} else {

			StatisticsForm statForm = (StatisticsForm)form;

		}
		
		
		/* 获取看得见的country 列表*/
		String[] visiableCountry = getVisiableCountryForString( cmCountryDAO );
		
			
		Calendar   yearBegin=Calendar.getInstance();
		yearBegin.set(Calendar.MONTH, 1);
		yearBegin.set(Calendar.DAY_OF_MONTH , 1 );
		
		
		 
		
		//加分项和减分项的分数和
		//String sql4 ="SELECT SUM(SCORE), CASE WHEN SCORE < 0 THEN '减分' WHEN SCORE > 0 THEN '加分' ELSE NULL END SCORE_T FROM   CM_RECORD GROUP BY CASE WHEN SCORE < 0 THEN '减分' WHEN SCORE > 0 THEN '加分' ELSE NULL END;";
		
		//按固定村组合来分组
		//String Sql5 = "SELECT  CM_RECORD.*  FROM  ( CM_RECORD JOIN CM_PERSON  on CM_RECORD.PERSON_ID = CM_PERSON.ID) JOIN CM_COUNTRY on CM_PERSON.country_id = CM_COUNTRY.id where CM_COUNTRY.ID IN ( 14 , 16  )";
							
		//镇分组
		// String  Sql6 = "SELECT sum(ID),	 CASE PARENTID	 WHEN 0     THEN id	 ELSE PARENTID  END GROUP_ID FROM    cm_country	 GROUP BY CASE PARENTID	 WHEN 0     THEN id	 ELSE PARENTID  END;";			
					
		//分镇算出分数增和 
		 String Sql7 = "SELECT   sum( cm_record.score), CASE CM_COUNTRY.PARENTID	 WHEN 0     THEN CM_COUNTRY.id	 ELSE CM_COUNTRY.PARENTID  END GROUP_ID    FROM  ( CM_RECORD JOIN CM_PERSON  on CM_RECORD.PERSON_ID = CM_PERSON.ID) JOIN CM_COUNTRY on CM_PERSON.country_id = CM_COUNTRY.id GROUP BY CASE cm_country.PARENTID	 WHEN 0     THEN cm_country.id	 ELSE cm_country.PARENTID  END;"; 
		
		 
		 
		 List<StatisticsChengxinObj>  statisticsChengxinOjbList = null;
		 //县级权限登录，查询所有的镇
		 if( true )
		 {
			 statisticsChengxinOjbList = getTownChengxinObjList(30);
		 }
		 
		 request.setAttribute("list" , statisticsChengxinOjbList );
		 
		return mapping.findForward( "statisticsForword" );
		
		
	}
	

	private List<CmRecord>  clusterListData(List<CmRecord>  list) {
		
		Map<String, CmRecord> ssidCluster = new HashMap<String, CmRecord>();
		
		for( int i = 0 ; i < list.size() ; i++ )
		{
			CmRecord temp = ssidCluster.get(list.get(i).getPerson().getSsid());
			if (temp == null)
				ssidCluster.put( list.get(i).getPerson().getSsid(), list.get(i) );
			else {
				Short score = (short) (list.get(i).getScore()+temp.getScore());
				list.get(i).setScore(score);
				ssidCluster.put( list.get(i).getPerson().getSsid(), list.get(i) );
			}
		}
		
		List<CmRecord> rloList = new ArrayList<CmRecord>(ssidCluster.values());

		return rloList;
	}
	private void dumpToExcel(HttpServletRequest request, HttpServletResponse response, List<RecordListObj> list) throws IOException
	{

		String[] excelHeader = { "序号", "姓名", "身份证号","诚信得分","所属等级"};    
        HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("Person");    
        HSSFRow row = sheet.createRow(0);    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
    
        saveMessageToLog("导出人员列表" , request );
        
        for (short i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell(i);  
            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue(excelHeader[i]);    
            cell.setCellStyle(style);    
            //sheet.autoSizeColumn(i);    
        }    
    
        for (int i = 0; i < list.size(); i++) {    
            row = sheet.createRow(i + 1);    
            RecordListObj cp = list.get(i);    
            //csCell.setEncoding(HSSFCell.ENCODING_UTF_16);
            HSSFCell cell0 = row.createCell((short)0);
            cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell0.setCellValue(i+1);  
            HSSFCell cell1 = row.createCell((short)1);
            cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell1.setCellValue(cp.getTruename());  
            HSSFCell cell2 = row.createCell((short)2);
            cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell2.setCellValue(cp.getSsid());  
            
            HSSFCell cell3 = row.createCell((short)3);
            cell3.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell3.setCellValue(cp.getScore());  
            HSSFCell cell4 = row.createCell((short)4);
            cell4.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell4.setCellValue(cp.getLevelName());  
            
        }        
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = df.format(new Date());
        String fileName =  "person"+date+".xls";  
        response.setHeader("Content-disposition", "attachment;filename="+fileName); 
        response.addHeader("Pargam", "no-cache");  
        response.addHeader("Cache-Control", "no-cache");  
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close(); 
		
		
	}

}
