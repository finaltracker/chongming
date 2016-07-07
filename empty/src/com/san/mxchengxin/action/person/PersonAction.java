package com.san.mxchengxin.action.person;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.action.ChengxinBaseAction;
import com.san.mxchengxin.form.person.PersonForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.country.CmPersonAd;
import com.san.mxchengxin.model.country.CmPersonDAO;

public class PersonAction extends ChengxinBaseAction {
	
	private CmCountryDAO cmCountryDAO;
	private CmPersonDAO	cmPersonDAO;
	List<CmCountry> countryList;
	//for pagination
	int page = 1;
	int recordsPerPage = 15;
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
			Integer personId = Integer.valueOf(request.getParameter("id"));
			System.out.println("[person delete] id : "+personId);
			
			CmPerson cp = cmPersonDAO.findById(personId);
			saveMessageToLog("删除人员: " + cp.getTruename() , request );
			
			cmPersonDAO.delete( cp );
		}
		

		if(request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		
		String personTrueName = "";
		String personSsid = "";
		Short countryId = 0 ;
		PersonForm personForm = (PersonForm)form;
		personSsid = personForm.getPerson_ssid();
		personTrueName = personForm.getPerson_truename();
		countryId = personForm.getCountry_id();
		

		
		System.out.println("log user info: "+cn+" : "+ouId+" : "+ouName);
		
		countryList = getVisiableCountry(cmCountryDAO);
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmPerson.class);
		
		if( personSsid != null && ( !personSsid.isEmpty() )) 
		{
			searDc.add(Restrictions.eq("ssid", personSsid )); 
		}
		
		if( personTrueName != null && ( !personTrueName.isEmpty() ))
		{
			searDc.add(Restrictions.like("truename", personTrueName,MatchMode.ANYWHERE).ignoreCase()); 
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
				searDc.add(Restrictions.in("countryId", countryIds));
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
			searDc.add(Restrictions.eq("countryId", countryId.shortValue() )); 
		}
		
		searDc.addOrder( Order.asc("id") );
		if(countryList != null) {
			List<CmPerson> targetList = cmPersonDAO.getHibernateTemplate ().findByCriteria( searDc );
			
			List<CmPersonAd> cpdList = new ArrayList<CmPersonAd>();
			//for pagination
			int noOfRecords = targetList.size();
			int noOfPages = (int)Math.ceil(noOfRecords*1.0/recordsPerPage);
			int startPos = (page-1)*recordsPerPage;
			int endPos = (page*recordsPerPage - noOfRecords)>0?noOfRecords:page*recordsPerPage;
			for(int i=startPos;i<endPos;i++) {
				CmPerson target = (CmPerson)targetList.get(i);
				CmPersonAd cpa = new CmPersonAd(target);
				if (cmCountryDAO.findById(target.getCountryId()) != null) {
					String countryName = cmCountryDAO.findById(target.getCountryId()).getName();
					cpa.setCountryName(countryName);
				} else {
					cpa.setCountryName("");
				}
				
				cpdList.add(cpa);
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
			System.out.println("country select result: "+countrySelect);
			request.setAttribute("countrySelect", countrySelect);
		}
		request.setAttribute("person_truename", personTrueName);
		request.setAttribute("ssid", personSsid);
		
		request.setAttribute("isadmin", isAllVisiable());
		
		return mapping.findForward( "personForword" );
	}
	
	private void dumpToExcel(HttpServletRequest request, HttpServletResponse response, List<CmPersonAd> list) throws IOException
	{

		String[] excelHeader = { "序号", "姓名", "身份证号","所属村镇","手机号","录入人","录入时间"};    
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
            CmPersonAd cp = list.get(i);    
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
            cell3.setCellValue(cp.getCountryName());  
            HSSFCell cell4 = row.createCell((short)4);
            cell4.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell4.setCellValue(cp.getPhone());  
            HSSFCell cell5 = row.createCell((short)5);
            cell5.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell5.setCellValue(cp.getAuthor());  
            HSSFCell cell6 = row.createCell((short)6);
            cell6.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell6.setCellValue(cp.getstringPubData());  
            
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
