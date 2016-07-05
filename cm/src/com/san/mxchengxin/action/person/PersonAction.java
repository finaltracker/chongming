package com.san.mxchengxin.action.person;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
			System.out.println("[person delete] id : "+countryId);
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
			for(int i=0;i<beforeList.size();i++) {
				CmPerson item = beforeList2.get(i);
				if(countryId == item.getCountryId().shortValue()) {
					System.out.println("has people, so not delete ");
					tipMessage = "该村镇下存在相关人员不能直接删除";
					canDelete = false;
				}
			}
			
			if(canDelete) {
				System.out.println("we can delete ");
				cmCountryDAO.delete(cmCountryDAO.findById(countryId));
			} else {
				request.setAttribute("tipMessage", tipMessage);
			}

		}
		
		//for pagination
		int page = 1;
		int recordsPerPage = 10;
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
		
		if( countryId == null ) 
		{
			countryId = 0;
		}
		
		System.out.println("log user info: "+cn+" : "+ouId+" : "+ouName);
		
		//countryList = getVisiableCountry(cmCountryDAO);
		countryList = cmCountryDAO.findAll();
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmPerson.class);
		
		if( personSsid != null && ( !personSsid.isEmpty() )) 
		{
			searDc.add(Restrictions.eq("ssid", personSsid )); 
		}
		
		if( personTrueName != null && ( !personTrueName.isEmpty() ))
		{
			searDc.add(Restrictions.like("truename", personTrueName,MatchMode.ANYWHERE).ignoreCase()); 
		}
		
		searDc.addOrder( Order.asc("id") );
		
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
			}
		}
		
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("noOfRecords", noOfRecords);

		Short parentId = 0;
		String countrySelect = getCountrySelect(countryId.shortValue(),parentId,1);
		System.out.println("country select result: "+countrySelect);
		request.setAttribute("countrySelect", countrySelect);
		request.setAttribute("person_truename", personTrueName);
		request.setAttribute("ssid", personSsid);
		request.setAttribute("plist", cpdList);
		
		return mapping.findForward( "personForword" );
	}
	
	private void dumpToExcel(HttpServletRequest request, HttpServletResponse response, List<CmPersonAd> list) throws IOException
	{

		String[] excelHeader = { "序号", "姓名", "身份证号","所属村镇","手机号","录入人","录入时间"};    
        HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("Campaign");    
        HSSFRow row = sheet.createRow((int) 0);    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
    
        for (int i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell((short) i);    
            cell.setCellValue(excelHeader[i]);    
            cell.setCellStyle(style);    
            //sheet.autoSizeColumn(i);    
        }    
    
        for (int i = 0; i < list.size(); i++) {    
            row = sheet.createRow(i + 1);    
            CmPersonAd cp = list.get(i);    
            row.createCell((short)0).setCellValue(cp.getId());    
            row.createCell((short)1).setCellValue(cp.getTruename());    
            row.createCell((short)2).setCellValue(cp.getSsid());    
        }        
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=person.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close(); 
		
		
	}
}
