/**
 * 
 */
package com.san.mhcx.mkdz.web;

import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.TextAnchor;

import com.san.chengxin.common.service.DateUtil;
import com.san.chengxin.common.web.struts.action.BaseAction;
import com.san.mhcx.mkdz.model.TMkdzInfo;
import com.san.mhcx.mkdz.service.IMkdzService;
import com.san.mhcx.uploadlogs.model.TUploadLogs;
import com.san.mhcx.uploadlogs.service.IUpLoadLogsService;


import com.san.share.pmi.service.LoginUserInfoDelegate;
import com.san.tools.generator.UUIDFactory;
import com.san.tools.pagetag.util.PageFindUtil;
import com.sjmu.base.M0201Table;

/**
 * 数据长传日志action
 * @author yangyj
 *
 */
public class MkdzAction extends BaseAction {
	
	
	
	/**
	 * 获取模块定制列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward mkdzInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MkdzForm eForm = (MkdzForm) form;

		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		int count = 0;

		// 得到实现类的一个实例
		IMkdzService impl = (IMkdzService) getBean("MkdzServiceImpl");

		// 取页面传来的数据
		String mkName=eForm.getMkName();//
		String zt=eForm.getZt();
		String jflx=eForm.getJflx();
		
		
		List mkdzList = new ArrayList();
		try {

			
			// 查询数量
			count = impl.mkdzInfoCount(mkName);
			count = impl.mkdzInfoCount(zt);
			count = impl.mkdzInfoCount(jflx);
			// 结果集
			mkdzList = impl.mkdzInfo(mkName,zt,jflx ,pageNo, pageSize);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list",mkdzList);
		request.setAttribute("totalCount", new Integer(count));

		return mapping.findForward("mkdzInfo");
	}

	/**
	 * 添加模块信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addMkdz(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MkdzForm MkdzForm = (MkdzForm) form;
		
		// 得到实现类的一个实例
		IMkdzService impl = (IMkdzService) getBean("MkdzServiceImpl");
		String mkName=MkdzForm.getMkName();//
		String jflx=MkdzForm.getJflx();//
		String jfsc = MkdzForm.getJfsc();//
		String jf = MkdzForm.getJf();//
		String zt = MkdzForm.getZt();//
		String jfsclx = MkdzForm.getJfsclx();
		TMkdzInfo mkdzInfo=new TMkdzInfo();
		String mkId=UUIDFactory.getUUIDKeyGenerator().generateKey().toString();
		mkdzInfo.setMkId(mkId);
		mkdzInfo.setMkName(mkName);
		mkdzInfo.setJflx(jflx);
		if(jfsc!=null && !"".equals(jfsc)){
			mkdzInfo.setJfsc(Integer.valueOf(jfsc));
		}
		
		mkdzInfo.setJf(Integer.valueOf(jf));
		mkdzInfo.setZt(zt);
		mkdzInfo.setJfsclx(jfsclx);
		
		
		try {
			//信息入库
			impl.addObject(mkdzInfo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.setAttribute("bigColumnList", bigColumnList);
		return mapping.findForward("toListPage");
	}

	/**
	 * 根据模块编号查询当前模块信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward getMkdzInfoById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MkdzForm eForm = (MkdzForm) form;
		
		// 得到实现类的一个实例
		IMkdzService impl = (IMkdzService) getBean("MkdzServiceImpl");
		
		String mkId=request.getParameter("mkId");
		
		try {
			List list=impl.getMkdzById(mkId);
			
			if(list.size()>0){
				TMkdzInfo info=(TMkdzInfo) list.get(0);
				String mkName=info.getMkName();
				String jflx=info.getJflx();
				String jfsc=info.getJfsc().toString();
				String jf=info.getJf().toString();
				String zt=info.getZt();
				String jfsclx=info.getJfsclx();
				eForm.setMkId(mkId);
				eForm.setMkName(mkName);
				eForm.setJflx(jflx);
				eForm.setJfsc(jfsc);
				eForm.setJf(jf);
				eForm.setZt(zt);
				eForm.setJfsclx(jfsclx);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping.findForward("toUpdatePage");
	}
	
	/**
	 * 修改企业信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updateMkdz(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MkdzForm eForm = (MkdzForm) form;
		
		// 得到实现类的一个实例
		IMkdzService impl = (IMkdzService) getBean("MkdzServiceImpl");
		
		String mkId=eForm.getMkId();//企业编号
		String mkName=eForm.getMkName();//企业名称
		String jflx=eForm.getJflx();//工商注册号
		String jfsc = eForm.getJfsc();//注册资本
		String jf = eForm.getJf();//注册资本
		String zt = eForm.getZt();
		String jfsclx = eForm.getJfsclx();
		try {
			List list=impl.getMkdzById(mkId);
			
			if(list.size()>0){
				TMkdzInfo info=(TMkdzInfo) list.get(0);
				info.setMkName(mkName);
				info.setJflx(jflx);
				info.setJfsc(Integer.valueOf(jfsc));
				info.setJf(Integer.valueOf(jf));
				info.setZt(zt);
				info.setJfsclx(jfsclx);
				
				impl.updateObject(info);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping.findForward("toListPage");
	}
	
	

	/**
	 * 删除模块信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteMkdzInfoById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MkdzForm eForm = (MkdzForm) form;
		
		// 得到实现类的一个实例
		IMkdzService impl = (IMkdzService) getBean("MkdzServiceImpl");
		
		String mkId=request.getParameter("mkId");//
		
		try {
			impl.deleteMkdzInfo(mkId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping.findForward("toListPage");
	}
	
	
	
	
	
}
