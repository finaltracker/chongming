package com.san.mxchengxin.action;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.san.mxchengxin.form.LevelForm;
import com.san.mxchengxin.form.TargetForm;
import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.model.level.CmLevelDAO;
import com.san.mxchengxin.model.level.CmLevelEnhance;
import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.model.target.CmTargetEnhance;

public class LevelAction extends ChengxinBaseAction {
	private CmLevelDAO cmLevelDAO;

	
	public CmLevelDAO geCmLevelDAO() {
		return cmLevelDAO;
	}
	
	public void setCmLevelDAO(CmLevelDAO cmLevelDAO) {
		this.cmLevelDAO = cmLevelDAO;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		super.execute(mapping, form, request, response);
		
		if(request.getParameter("id") != null) {
			//删除操作
			Short levelId = Short.valueOf(request.getParameter("id"));
			System.out.println("[delete] id : "+levelId);
			
			CmLevel cl = cmLevelDAO.findById(levelId);
			saveMessageToLog("删除等级: " + cl.getLevelName() , request );
			
			cmLevelDAO.delete(cl);

		}
		
		LevelForm targetForm = (LevelForm) form;
		String level_name;
		level_name = targetForm.getlevel_name();
		
/* 设置查询target表条件 */
		List<CmLevelEnhance> levelEnhanceList = new ArrayList<CmLevelEnhance>(); 
		
		DetachedCriteria searDc =	DetachedCriteria.forClass( CmLevel.class);
		
		
		if( level_name != null && ( !level_name.isEmpty() ))
		{
			searDc.add(Restrictions.like("levelName", level_name ,MatchMode.ANYWHERE).ignoreCase()); 
		}
		//search by condition in target table

		List<CmLevel> levelList = cmLevelDAO.getHibernateTemplate ().findByCriteria( searDc );
		
		for(int i=0;i<levelList.size();i++) {
			CmLevelEnhance  levelEnhance = new CmLevelEnhance( levelList.get(i) );
			levelEnhanceList.add( levelEnhance );
			
			//System.out.println("name: "+cc.getTargetName());
		}
		
		
		request.setAttribute("level_name", level_name);
		request.setAttribute("list", levelEnhanceList);
		
		return mapping.findForward( "levelForword" );
	}
}
