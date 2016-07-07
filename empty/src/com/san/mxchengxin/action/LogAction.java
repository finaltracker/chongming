package com.san.mxchengxin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.model.log.CmLog;
import com.san.mxchengxin.model.log.CmLogDAO;
import com.san.mxchengxin.model.log.CmLogEnhance;

public class LogAction extends ChengxinBaseAction  {

	//for pagination
	int page = 1;
	int recordsPerPage = 15;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List<CmLog> clList =  cmLogDAO.findAll();
		List<CmLogEnhance> clEnhanceList = new ArrayList<CmLogEnhance>();
		//for pagination
		if(request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		
		int noOfRecords = clList.size();
		int noOfPages = (int)Math.ceil(noOfRecords*1.0/recordsPerPage);
		int startPos = (page-1)*recordsPerPage;
		int endPos = (page*recordsPerPage - noOfRecords)>0?noOfRecords:page*recordsPerPage;
		for(int i=startPos;i<endPos;i++)
		{
			clEnhanceList.add( new CmLogEnhance(clList.get(i)) );
		}
		
		request.setAttribute("list", clEnhanceList );
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("noOfRecords", noOfRecords);
		
		return mapping.findForward( "logForword" );
	}
}
