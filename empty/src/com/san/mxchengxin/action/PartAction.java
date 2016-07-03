package com.san.mxchengxin.action;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;


public class PartAction extends Action {
	private CmPartDAO cmPartDAO;

	public CmPartDAO geCmPartDAO() {
		return cmPartDAO;
	}
	
	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		
		if(request.getParameter("id") != null) {
			//删除操作
			Short partId = Short.valueOf(request.getParameter("id"));
			System.out.println("[delete] id : "+partId);
			cmPartDAO.delete(cmPartDAO.findById(partId));

		}
		
		
		//查询 part表
		List<CmPart> partList = cmPartDAO.findAll();
		
		request.setAttribute("list", partList);
				
		return mapping.findForward( "partForword" );
	}
}
