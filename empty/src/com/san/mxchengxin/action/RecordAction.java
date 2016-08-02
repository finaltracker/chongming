package com.san.mxchengxin.action;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.form.record.RecordForm;
import com.san.mxchengxin.form.target.TargetForm;
import com.san.mxchengxin.model.country.CmCountry;
import com.san.mxchengxin.model.country.CmCountryDAO;
import com.san.mxchengxin.model.country.CmPersonAd;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.mxchengxin.model.record.CmRecord;
import com.san.mxchengxin.model.record.CmRecordDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;
import com.san.mxchengxin.model.target.CmTargetEnhance;
import com.san.mxchengxin.objects.RecordListObj;
import com.san.mxchengxin.utils.util;


public class RecordAction extends ChengxinBaseAction {
	
	private CmCountryDAO cmCountryDAO;
	private CmRecordDAO cmRecordDAO;
	private CmTargetDAO cmTargetDAO;

	String truename = "";
	String ssid = "" ;
	Short country_id = 0 ;
	Short target_id = 0;
	
	//for pagination
	int page = 1;
	int recordsPerPage = 15;
	
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
	
	public CmPartDAO getCmPartDAO() {
		return cmPartDAO;
	}
	
	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
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
		
		if( recordForm != null )
		{
			if( recordForm.getTruename() != null )
			{
				truename = recordForm.getTruename();
			}
			if( recordForm.getSsid() != null )
			{
				ssid = recordForm.getSsid() ;
			}
			if( recordForm.getCountry_id() != null )
			{
				country_id = recordForm.getCountry_id() ;
			}
			if( recordForm.getTarget_id() != null )
			{
				target_id = recordForm.getTarget_id();
			}
		}
		
		
		if(request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		} 
		if( request.getParameter("search") != null )
		{// search button,每次搜索都应该从头开始
			page = 1; //设置从头开始
		}
		if(request.getParameter("showAll") != null) {
			page = 1; //设置从头开始
			truename = null;
			ssid = null ;
			country_id = 0 ;
			target_id = 0 ;
		}
		if(request.getParameter("id") != null) {
			//删除操作
			Integer recordId = Integer.valueOf(request.getParameter("id"));
			System.out.println("[delete] id : "+recordId);
			
			DetachedCriteria DelSearDc =	DetachedCriteria.forClass( CmRecord.class);
			
			DelSearDc.setFetchMode("person", FetchMode.JOIN); 
			DelSearDc.createAlias("person", "person");  
			
			DelSearDc.add(Restrictions.eq("id", recordId));
			//CmRecord cr = cmRecordDAO.findById( recordId );
			List<CmRecord>  list = cmRecordDAO.getHibernateTemplate ().findByCriteria( DelSearDc );
			CmRecord cr = null;
			if( list.size() > 0 )
			{
				cr = list.get( 0 );
			}
			saveMessageToLog("删除考核记录: 名字" + cr.getPerson().getTruename() + " 考核项目: " + cr.getTargetId() , request );
			
			cmRecordDAO.delete( cr );

		}
		
		/*  根据条件进行内容过滤，查询  */
		Short[] countryList = null;
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmRecord.class);
		
		searDc.setFetchMode("person", FetchMode.JOIN); 
		searDc.createAlias("person", "person");  
		
		Short[] userSeenCountryList = getVisiableCountryForShort( this.cmCountryDAO  );
		if( ( country_id == null) || (country_id  == 0 ) )
		{//根据登陆的用户名来确定
			countryList = userSeenCountryList;
		}
		else
		{//用户指定(村或帧)
			countryList = getVisiableCountryForShortAsCountryId( cmCountryDAO , country_id );
		}
		if( countryList != null )
		{
			//country
			searDc.add(Restrictions.in("person.countryId", countryList ));
		}
		//name
		if( ( truename != null )&& (!truename.isEmpty())  )
		{
			searDc.add(Restrictions.like("person.truename", truename , MatchMode.ANYWHERE ));  
		}
		//ssid
		if( ( ssid != null ) && (!ssid.isEmpty()))
		{
			searDc.add(Restrictions.like("person.ssid", ssid , MatchMode.ANYWHERE )); 
		}
		
		//target, 用户选择做了选择
		if( (target_id != null) && ( target_id != 0 ) )
			
		{
			searDc.add(Restrictions.eq("targetId", (int) (target_id )));
		}
		else
		{//
			
		}
		
		//刨除已过期的记录
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date now = new Date();
		System.out.println(df.format(now));// new Date()为获取当前系统时间
		long currentTime = now.getTime()/1000;
		
		searDc.add( Restrictions.ge(  "dateline", currentTime ) );
		
		searDc.addOrder( Order.desc( "pubdate" ) );
		List<CmRecord>  list = cmRecordDAO.getHibernateTemplate ().findByCriteria( searDc );
	
		
		/* 将contry list 由ID 转换为 string */
		StringBuffer sb = new StringBuffer();
		cmCountryDAO.formatToJspString( cmCountryDAO.packCountryMapAsLevelByIdList(userSeenCountryList) , country_id , 0 , sb );
		String countryListStr = sb.toString();
		
		/* 查询 可用的target */
		DetachedCriteria targetDc =	DetachedCriteria.forClass( CmTarget.class);
		
		List<CmTarget>  targetList = cmTargetDAO.getHibernateTemplate ().findByCriteria( targetDc );
		String targetSelectStr = cmTargetDAO.formatToJspString( targetList , target_id );
		
		//for pagination
		int noOfRecords = list.size();
		int noOfPages = (int)Math.ceil(noOfRecords*1.0/recordsPerPage);
		int startPos = (page-1)*recordsPerPage;
		int endPos = (page*recordsPerPage - noOfRecords)>0?noOfRecords:page*recordsPerPage;
		
		List<RecordListObj> enhanceRecordList = recordToRecordListObj( list , startPos, endPos);
		

		//export excel
		if(request.getParameter("opt") != null) {
			int opt = Integer.valueOf(request.getParameter("opt"));
			if(opt==21) {
				try {
					dumpToExcel(request, response, enhanceRecordList);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
		}
		
		int isadmin = 0;
		if( this.isAllVisiable() )
		{
			isadmin = 1;
		}
		
		short partId = this.getPartId(cmPartDAO, cmCountryDAO);
		
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("noOfRecords", noOfRecords);
		
		request.setAttribute("countrySelect", countryListStr );
		request.setAttribute("targetSelect", targetSelectStr );
		request.setAttribute("truename", truename );
		request.setAttribute("ssid", ssid );
		request.setAttribute("isadmin", isadmin );
		request.setAttribute("list", enhanceRecordList );
		request.setAttribute("partId", partId );
		request.setAttribute("partName", this.ouName );
		return mapping.findForward( "recordForword" );
	}
	
	

	List<RecordListObj> recordToRecordListObj( List<CmRecord>  list , int start, int end )
	{
		
		Map< Short , CmCountry > countryMap = cmCountryDAO.listAsMap();
		Map< Short , CmTarget > targetMap = cmTargetDAO.listAsMap();
		Map< Short , CmPart > partMap = cmPartDAO.listAsMap();
		
		List<RecordListObj> rloList = new ArrayList<RecordListObj>();
		
		for( int i = start ; i < end ; i++ )
		{
			CmRecord rlo = list.get(i);
			
			int    id = rlo.getId();
			String truename = rlo.getPerson().getTruename();
			String ssid = rlo.getPerson().getSsid();
			String countryName = "";
			if( countryMap.get( rlo.getPerson().getCountryId() ) != null )
			{
				countryName = countryMap.get( rlo.getPerson().getCountryId() ).getName() ;
			}
			
			String target_name = "";
			if( targetMap.get( rlo.getTargetId().shortValue() ) != null )
			{
				target_name = targetMap.get( rlo.getTargetId().shortValue() ).getTargetName() ;
			}
			Short score = rlo.getScore();
			String author = rlo.getAuthor();
			String part_name = "";
			
			if( partMap.get( rlo.getPartId().shortValue() ) != null )
			{
				part_name = partMap.get( rlo.getPartId().shortValue() ).getPartName();
			}
			
			String pubdate = util.dateLongToString( rlo.getPubdate() ) ;
			String dateline = util.dateLongToString( rlo.getDateline() ) ;
			int stat = (rlo.getStat())? 1 : 0 ;
			rloList.add( new RecordListObj(
					id ,
					truename,
					ssid,
					countryName,
					target_name,
					score,
					author,
					part_name,
					pubdate,
					dateline,
					stat
					) );
		}
		
		return rloList;
	}
	
	
	private void dumpToExcel(HttpServletRequest request, HttpServletResponse response, List<RecordListObj> list) throws IOException
	{

		String[] excelHeader = { "序号" ,"姓名" , "身份证号" ,"所属乡镇" ,"考核指标" ,"分数" ,"考核人" ,"考核单位" ,"考核时间" ,"有效期" };    
        HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("record");    
        HSSFRow row = sheet.createRow(0);    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
    
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
            cell3.setCellValue(cp.getCountryName());  
            
            HSSFCell cell4 = row.createCell((short)4);
            cell4.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell4.setCellValue(cp.getTarget_name());  
            
            HSSFCell cell5 = row.createCell((short)5);
            cell5.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell5.setCellValue(cp.getScore());  
            
            HSSFCell cell6 = row.createCell((short)6);
            cell6.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell6.setCellValue(cp.getAuthor()); 
            
            HSSFCell cell7 = row.createCell((short)7);
            cell7.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell7.setCellValue(cp.getPart_name());  
            
            HSSFCell cell8 = row.createCell((short)8);
            cell8.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell8.setCellValue(cp.getPubdate());  
            
            HSSFCell cell9 = row.createCell((short)9);
            cell9.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell9.setCellValue(cp.getDateline());  
            
        }        
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = df.format(new Date());
        String fileName =  "record"+date+".xls";  
        response.setHeader("Content-disposition", "attachment;filename="+fileName); 
        response.addHeader("Pargam", "no-cache");  
        response.addHeader("Cache-Control", "no-cache");  
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close(); 
		
		
	}
	
}
