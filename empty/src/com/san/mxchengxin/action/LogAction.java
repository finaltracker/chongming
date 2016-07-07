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

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List<CmLog> clList =  cmLogDAO.findAll();
		List<CmLogEnhance> clEnhanceList = new ArrayList<CmLogEnhance>();
		for( int i = 0 ; i < clList.size() ; i++ )
		{
			clEnhanceList.add( new CmLogEnhance(clList.get(i)) );
		}
		
		request.setAttribute("list", clEnhanceList );
		
		return mapping.findForward( "logForword" );
	}
}
