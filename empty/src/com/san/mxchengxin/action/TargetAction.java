package com.san.mxchengxin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Map;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.san.mxchengxin.form.target.TargetForm;
import com.san.mxchengxin.model.part.CmPart;
import com.san.mxchengxin.model.part.CmPartDAO;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetDAO;
import com.san.mxchengxin.model.target.CmTargetEnhance;


public class TargetAction extends ChengxinBaseAction {
	private CmTargetDAO cmTargetDAO;

	
	public CmTargetDAO geCmTargetDAO() {
		return cmTargetDAO;
	}
	
	public void setCmTargetDAO(CmTargetDAO cmTargetDAO) {
		this.cmTargetDAO = cmTargetDAO;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		super.execute(mapping, form, request, response);
		
		if(request.getParameter("id") != null) {
			Short targetId = Short.valueOf(request.getParameter("id"));
			System.out.println("[delete] id : "+targetId);
			CmTarget ct = cmTargetDAO.findById(targetId);
			saveMessageToLog("删除指标: " + ct.getTargetName()  , request );
			cmTargetDAO.delete(ct);

		}
		
		Integer pardId = 0 ;
		String  target_name = "";
		//传到 jsp中的数据列表
		List<CmTargetEnhance> targetEnhanceList = new ArrayList<CmTargetEnhance>(); 
		
		TargetForm targetForm = (TargetForm) form;
		pardId		=    targetForm.getPart_id();
		target_name  = targetForm.getTarget_name();
		
		//查询 part表
		List<CmPart> partList = cmPartDAO.findAll();
		HashMap<Integer , String > partMap = new HashMap<Integer , String>();
		for (CmPart cmPart : partList) {
			partMap.put( new Integer(cmPart.getId()) , cmPart.getPartName() );
		}		
		
		
		/* 设置查询target表条件 */
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmTarget.class);
		
		if( pardId == null ) 
		{
			pardId = 0;
		}
		else if( pardId != 0 ) 
		{
			searDc.add(Restrictions.eq("partId", pardId.shortValue() )); 
		}
		
		if( target_name != null && ( !target_name.isEmpty() ))
		{
			searDc.add(Restrictions.like("targetName", target_name,MatchMode.ANYWHERE).ignoreCase()); 
		}
		
		searDc.addOrder(Order.desc("targetScore"));
		//search by condition in target table

		List<CmTarget> targetList = cmPartDAO.getHibernateTemplate ().findByCriteria( searDc );
		
		
		for(int i=0;i<targetList.size();i++) {
			CmTarget target = (CmTarget)targetList.get(i);
			CmTargetEnhance  targetEnhance = new CmTargetEnhance( target );
			targetEnhance.setPartName( partMap.get( new Integer(target.getPartId() )) );
			targetEnhanceList.add( targetEnhance );
			
			//System.out.println("name: "+cc.getTargetName());
		}
		
		StringBuffer sb = new StringBuffer();
		
		/*
		 * <option value='12' selected>乡镇</option>
		 * <option value='13' >村</option>
		*/
		for(int i=0;i<partList.size();i++) {
			CmPart cc = (CmPart)partList.get(i);
			//System.out.println("name: "+cc.getPartName()+cc.getId());
			String s;
			if( cc.getId() == pardId.shortValue() )
			{
				s = String.format("<option value='%d' selected>%s</option>", cc.getId(),cc.getPartName());
			}
			else
			{
				s = String.format("<option value='%d'>%s</option>", cc.getId(),cc.getPartName());
				
			}
			sb.append(s);
			
		}
		
		System.out.println("result: "+sb.toString());
		String partListSel = sb.toString();
		request.setAttribute("partListSel", partListSel);
		request.setAttribute("target_name", target_name);
		request.setAttribute("list", targetEnhanceList);
		
		
		return mapping.findForward( "targetForword" );
	}
}
