package com.san.mxchengxin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.model.country.CmPerson;
import com.san.mxchengxin.model.log.CmLog;
import com.san.mxchengxin.model.log.CmLogDAO;
import com.san.mxchengxin.model.log.CmLogEnhance;
import com.san.mxchengxin.utils.util;

public class LogAction extends ChengxinBaseAction  {

	//for pagination
	int page = 1;
	int recordsPerPage = 25;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List<CmLogEnhance> clEnhanceList = new ArrayList<CmLogEnhance>();
		//for pagination
		if(request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		
		Session s = cmLogDAO.getSessionFactory().openSession();
		Criteria searDc =  s.createCriteria( CmLog.class );
		
		
		searDc.setFirstResult( (page-1) * recordsPerPage );
		searDc.setMaxResults( recordsPerPage );
		searDc.addOrder(Order.desc("pubdate"));
		List<CmLog> clList =  searDc.list();
		
		s.close();
		for(int i= 0 ;i< clList.size() ;i++)
		{
			clEnhanceList.add( new CmLogEnhance(clList.get(i)) );
		}
		
		String hql = "select count(*) from CmLog";
		Object number = s.createQuery(hql).uniqueResult();
		
		
		int noOfRecords = Integer.parseInt(String.valueOf(number));
		
		request.setAttribute("list", clEnhanceList );
		request.setAttribute("noOfPages", ( noOfRecords + recordsPerPage -1 ) / recordsPerPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("noOfRecords", noOfRecords  );
		
		return mapping.findForward( "logForword" );
	}
}
