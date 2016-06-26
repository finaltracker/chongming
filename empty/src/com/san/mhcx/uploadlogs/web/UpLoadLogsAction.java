/**
 * 
 */
package com.san.mhcx.uploadlogs.web;

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
public class UpLoadLogsAction extends BaseAction {
	
	public  DateFormat formatSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	/**
	 * 获取日志信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
//	@SuppressWarnings("unchecked")
	public ActionForward getlogsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;
		
		return forward;
		
	}

	/**
	 * 根据日志编号得到日志信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward getLogInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;
		IUpLoadLogsService impl=(IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");
		String logId=request.getParameter("logId");
		List list=new ArrayList();
		try {
			list=impl.getLogById(logId);
			if(list.size()>0){
				TUploadLogs logs=(TUploadLogs) list.get(0);
				String remark1=logs.getRemark();
				String remark2=logs.getRemark2();
				String tableId=logs.getLogTableId();
				List tableList=impl.getTableInfoById(tableId);
				if(tableList.size()>0){
					M0201Table table=(M0201Table) tableList.get(0);
					String tableName=table.getTablecname();
					request.setAttribute("tableName", tableName);
				}
				request.setAttribute("remark1", remark1);
				request.setAttribute("remark2", remark2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward("openErrorInfo");
		
	}
	
	/**
	 * 获取日志错误信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward getlogsErrorList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;
		int count =0;
		int pageNo = PageFindUtil.getPageNo(request);
		int pageSize = PageFindUtil.getPageSize(request,10);
		IUpLoadLogsService impl=(IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");//获取业务辅助类的实例;
		
		String logId=request.getParameter("logId");
		
		List logErrorList=new ArrayList();
		try {
			//查询数据列表
			logErrorList = impl.getLogErrorByLogId(logId, pageNo, pageSize);
//			查询记录数
			count = impl.getLogErrorCountByLogId(logId).intValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("logErrorList", logErrorList);
		forward=mapping.findForward("logsErrorList");
		request.setAttribute("totalCount",new Integer(count));
		return forward;
		
	}
	
	/**
	 * 开始统计日志信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward getTjLogsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		
		
		return forward;
		
	}
	
	/**
	 * 创建模型信息图
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward zhuChar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;

		// 得到实现类的一个实例
		IUpLoadLogsService impl=(IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");

		//获取部门信息
		String deptId=request.getParameter("deptId");
		//获取开始时间
		String beginDate=request.getParameter("beginDate");
		//获取结束时间
		String endDate=request.getParameter("endDate");
		
		//模型集合
		List loglList = new ArrayList();
//		FileOutputStream fos_jpg = null;
		try {

			// 结果集
			loglList = impl.getLogInfoByDeptId(deptId,beginDate,endDate);
			CategoryDataset dataset = impl.getDataSet(loglList);
			JFreeChart chart = ChartFactory.createBarChart3D(
					"部门数据导入总量统计", // 图表标题
					"部门", // 目录轴的显示标签
					"数量", // 数值轴的显示标签
					dataset, // 数据集
					PlotOrientation.VERTICAL, // 图表方向：水平、垂直
					true, 	// 是否显示图例(对于简单的柱状图必须是false)
					false, 	// 是否生成工具
					true 	// 是否生成URL链接
					);
//			fos_jpg = new FileOutputStream("D:\\fruit.jpg");
//			ChartUtilities.writeChartAsJPEG(fos_jpg,1.0f,chart,600,300,null);
			CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot(); 

			//柱状图顶端显示数值
			BarRenderer3D customBarRenderer = (BarRenderer3D) plot.getRenderer(); 
			customBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值 
			customBarRenderer.setBaseItemLabelsVisible(true); 
			//注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题 
			customBarRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition( 
			ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
			customBarRenderer.setItemLabelAnchorOffset(10D);// 设置柱形图上的文字偏离值 
			customBarRenderer.setItemLabelsVisible(true); //是否显示数值
			plot.setRenderer(customBarRenderer); 
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(), chart, 400, 350);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			} catch (Exception e) {}
		}
		return mapping.findForward(null);
	}
	
	
	/**
	 * 创建模型区域等级分布图
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward pieChat(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;

		// 得到实现类的一个实例
		IUpLoadLogsService impl=(IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");

		//获取部门信息
		String deptId=request.getParameter("deptId");
		//获取开始时间
		String beginDate=request.getParameter("beginDate");
		//获取结束时间
		String endDate=request.getParameter("endDate");
		
		//模型集合
		List loglList = new ArrayList();
		try {
			// 结果集
			loglList = impl.getLogInfoByDeptIdForPie(deptId,beginDate,endDate);
			PieDataset dataset = impl.getPieDataSet(loglList);
			JFreeChart chart = ChartFactory.createPieChart3D("部门数据导入总量统计",  //图形标题名称
                    dataset,   // dataset
                    true,      // legend?
                    true,     // tooltips?
                    false);  //URLs?
			PiePlot pieplot = (PiePlot)chart.getPlot();  //通过JFreeChart 对象获得 plot：PiePlot！！
			pieplot.setNoDataMessage("未获取到数据");// 没有数据的时候显示的内容
			pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: ({1}, {2})"));
			pieplot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}: ({1}, {2})"));
			pieplot.setForegroundAlpha(0.6f);
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(), chart, 400, 370);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			} catch (Exception e) {}
		}
		return mapping.findForward(null);
	}
	
	/**
	 * 获取日志错误信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;
		
		IUpLoadLogsService impl=(IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");//获取业务辅助类的实例;
		
		String logId=request.getParameter("logId");
		String tableId=request.getParameter("tableId");
		String date=request.getParameter("date");
		
		List tableList=new ArrayList();
		try {
			//查询数据列表
			tableList = impl.getTableInfoById(tableId);
			
			if(tableList.size()>0){
				M0201Table table=(M0201Table) tableList.get(0);
				String hname=table.getTableename();
				String tname="Z"+table.getTableename().substring(1, table.getTableename().length());
				
//				System.out.println("h表："+hname +"   t表："+tname+"   logId："+logId+"   date："+date);
				impl.deleteLog(logId, tname, hname, date);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mapping.findForward("emptyPage");
		
	}
	
	/**
	 * 新增代码
	 */
	public ActionForward getNewList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=null;
		UpLoadLogsForm logsForm = (UpLoadLogsForm) form;
		IUpLoadLogsService impl=(IUpLoadLogsService) getBean("UpLoadLogsServiceImpl");//获取业务辅助类的实例;
		//获取部门信息
		String deptId=request.getParameter("deptId");
		//获取开始时间
		String beginDate=request.getParameter("beginDate");
		//获取结束时间
		String endDate=request.getParameter("endDate");
		//判断anychat统计图
//		String ayt=request.getParameter("ayt");
		String field9=request.getParameter("field9");
		request.setAttribute("deptId", deptId);
		request.setAttribute("beginDate", beginDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("field9", field9);
		String bDate="";
		String eDate="";
		List logList=new ArrayList();
		List logList2=new ArrayList();
		try {
			logList = impl.getLogInfoByC(deptId, beginDate, endDate,field9);
//			}
			//查询数据列表
//			if("2".equals(ayt)){
//				logList2 = impl.getLogInfoByY(deptId, beginDate, endDate,ayt,field9);
//			}else{
//			logList = impl.getLogInfoByC(deptId, beginDate, endDate,field9);
//			}
			//ayt=1表示首页数据上传统计图
//			if("1".equals(ayt)){
//				
//				String hangXmlH = MyTools.aytbblxml(logList);//柱状图XML
//				
//				String paths = this.getServlet().getServletContext().getRealPath(
//				"/")
//				+ "picXml";
//				MyTools.fileXmlOperation(paths, "scslXmlList", hangXmlH);
//
//				//ayt=1表示首页近一个月统计图	
//			}
			//开始时间
			if(beginDate != null && !"".equals(beginDate)){
				bDate=beginDate;
			}else{
				List sList=impl.getAllLogStoB();
				if(sList.size()>0){
					TUploadLogs logs=(TUploadLogs) sList.get(0);
					bDate=DateUtil.toString(logs.getLogTime());
				}
			}
			//结束时间
			if(endDate != null && !"".equals(endDate)){
				eDate=endDate;
			}else{
				List bList=impl.getAllLogBtoS();
				if(bList.size()>0){
					TUploadLogs logs=(TUploadLogs) bList.get(0);
					eDate=DateUtil.toString(logs.getLogTime());
				}
			}
			
			
			
			
			
			
			//------------------------系统日志------------------------
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("logList", logList);
		request.setAttribute("logList2", logList2);
		request.setAttribute("bDate", bDate);
		request.setAttribute("eDate", eDate);
		forward=mapping.findForward("anyNewSuccess");
		return forward;
		
	}
	
	
}
