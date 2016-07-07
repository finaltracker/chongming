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


public class PartAction extends ChengxinBaseAction {
	private CmPartDAO cmPartDAO;

	public CmPartDAO geCmPartDAO() {
		return cmPartDAO;
	}
	
	public void setCmPartDAO(CmPartDAO cmPartDAO) {
		this.cmPartDAO = cmPartDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		super.execute(mapping, form, request, response);
		
		if(request.getParameter("id") != null) {
			//删除操作
			Short partId = Short.valueOf(request.getParameter("id"));
			System.out.println("[delete] id : "+partId);
			
			CmPart cp = cmPartDAO.findById(partId);
			
			saveMessageToLog("删除部门: " + cp.getPartName() , request );
			
			cmPartDAO.delete( cp );

		}
		
		
		//查询 part表
		List<CmPart> partList = cmPartDAO.findAll();
		
		request.setAttribute("list", partList);
				
		return mapping.findForward( "partForword" );
	}
}
