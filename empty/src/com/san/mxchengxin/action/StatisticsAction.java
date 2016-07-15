package com.san.mxchengxin.action;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import com.san.mxchengxin.objects.RecordListObj;
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
	int recordsPerPage = 15;
	
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
			searchMap_ssid = statForm.getSsid();
			searchMap_truename = statForm.getTruename();
			countryId = statForm.getCountry_id();
			levelId = statForm.getLevel_id();
		}
		
		//来自图标统计的url
		if( request.getParameter("level_id") != null &&  !request.getParameter("level_id").isEmpty() )
		{
			levelId = Short.valueOf( request.getParameter("level_id") );
		}
		
		
		System.out.println("log user info: "+cn+" : "+ouId+" : "+ouName);
		
		countryList = getVisiableCountry(cmCountryDAO);
		levels = cmLevelDAO.findAll();

		// 调用排序方法，参数二为自定义的排序工具类
		Collections.sort(levels, new ComparatorCmLevel(true));

		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmRecord.class);
		searDc.setFetchMode("person", FetchMode.JOIN); 
		searDc.createAlias("person", "person");  
		
		if( searchMap_ssid != null && ( !searchMap_ssid.isEmpty() )) 
		{
			searDc.add(Restrictions.like("person.ssid", searchMap_ssid, MatchMode.ANYWHERE )); 
		}
		
		if( searchMap_truename != null && ( !searchMap_truename.isEmpty() ))
		{
			searDc.add(Restrictions.like("person.truename", searchMap_truename,MatchMode.ANYWHERE).ignoreCase()); 
		}
		
		if( countryId == null ) 
		{
			//当前管理员所属的镇村，及其下级村
			Short[] countryIds = new Short[countryList.size()];
			if(countryList != null) {
				for(int i = 0; i<countryList.size();i++) {
					CmCountry cc = countryList.get(i);
					countryIds[i] = cc.getId();
					System.out.println("country id :"+countryIds[i]);
				}
				searDc.add(Restrictions.in("person.countryId", countryIds));
			} 
			if(isAllVisiable())
				countryId = 0;
			else {
				Short min = countryIds[0];
				for(int i=0;i<countryIds.length;i++)
				{
				System.out.print(i+" : "+ countryIds[i]+" ");
				if(countryIds[i]<min)   // 判断最小值
					min=countryIds[i];
				}
				countryId = min;
			}
			
		} else if( countryId != 0 ) 
		{
			searDc.add(Restrictions.eq("person.countryId", countryId.shortValue() )); 
		}
		
		if(levelId == null) {
			levelId = 0;
		} else if (levelId != null) {
			for(int xi = 0;xi < levels.size();xi++) {
				if(levels.get(xi).id.equals(levelId)) {
					if(xi == levels.size()-1) {
						searDc.add(Restrictions.ge("score", Short.valueOf(levels.get(xi).levelScore) ) );
						break;
					} else {
						searDc.add(Restrictions.ge("score", Short.valueOf(levels.get(xi).levelScore) ) );
						searDc.add(Restrictions.lt("score", Short.valueOf(levels.get(xi+1).levelScore) ) );
						break;
					}
				}
			}
		
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<levels.size();i++) {
			CmLevel cc = (CmLevel)levels.get(i);
			String s;
			if( cc.getId() == levelId.shortValue() )
			{
				s = String.format("<option value='%d' selected>%s</option>", cc.getId(), cc.getLevelName());
			}
			else
			{
				s = String.format("<option value='%d'>%s</option>", cc.getId(), cc.getLevelName());
				
			}
			sb.append(s);
		}
		String levelSel = sb.toString();
		request.setAttribute("levelSelect", levelSel);
		
		searDc.addOrder( Order.asc("id") );
		if(countryList != null) {

			List<CmRecord> targetList = cmRecordDAO.getHibernateTemplate ().findByCriteria( searDc );
			List<RecordListObj> cpdList = new ArrayList<RecordListObj>();
			//for pagination
			int noOfRecords = targetList.size();
			int noOfPages = (int)Math.ceil(noOfRecords*1.0/recordsPerPage);
			int startPos = (page-1)*recordsPerPage;
			int endPos = (page*recordsPerPage - noOfRecords)>0?noOfRecords:page*recordsPerPage;
			
			for(int i=startPos;i<endPos;i++) {
				CmRecord target = targetList.get(i);
				int id = target.getId();
				String countryName = "";
				String truename = target.getPerson().getTruename();
				String levelName = "";
				String ssid = target.getPerson().getSsid();
				Short score = target.getScore();
				String pubdate = util.dateLongToString( target.getPubdate() ) ;
				String dateline = util.dateLongToString( target.getDateline() ) ;
				if (cmCountryDAO.findById(target.getPerson().getCountryId()) != null) {
					countryName = cmCountryDAO.findById(target.getPerson().getCountryId()).getName();
				}

				
				if(target.getScore() != null) {
					
					for(int ix = 0; ix<levels.size();ix++) {
						if(ix == (levels.size()-1)) {
							levelName = levels.get(ix).getLevelName();
							break;
						} 
						
						Short score1 = Short.valueOf(levels.get(ix).getLevelScore());
						Short socre2 = Short.valueOf(levels.get(ix+1).getLevelScore());
						if(score1.compareTo(score) <= 0  && socre2.compareTo(score) > 0) {
							levelName = levels.get(ix).getLevelName();
							System.out.println("level score "+score+" and name: "+levels.get(ix).getLevelName());
							break;
						} else {
							continue;
						}
							
						
					}
				} 
				
				cpdList.add( new RecordListObj(
						id ,
						truename,
						ssid,
						countryName,
						levelName,
						score,
						pubdate,
						dateline
						) );
			}
	
		
			//export excel
			if(request.getParameter("opt") != null) {
				int opt = Integer.valueOf(request.getParameter("opt"));
				if(opt==21) {
					try {
						dumpToExcel(request, response, cpdList);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
				
			}
			
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("noOfRecords", noOfRecords);
			request.setAttribute("plist", cpdList);
		}
		
		if(countryList != null) {
			Short parentId = 0;
			String countrySelect = getCountrySelect(countryId.shortValue(),parentId,1);
			//System.out.println("country select result: "+countrySelect);
			request.setAttribute("countrySelect", countrySelect);
		}
		request.setAttribute("truename", searchMap_truename);
		request.setAttribute("ssid", searchMap_ssid);
		request.setAttribute("level_id", levelId);
		request.setAttribute("country_id", countryId);
		
		return mapping.findForward( "statisticsForword" );
		
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
