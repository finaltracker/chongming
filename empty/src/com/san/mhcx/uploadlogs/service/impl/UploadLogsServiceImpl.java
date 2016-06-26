/**
 * 
 */
package com.san.mhcx.uploadlogs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import com.san.mhcx.uploadlogs.dao.IUpLoadLogsDao;
import com.san.mhcx.uploadlogs.model.LogTjByDeptPO;
import com.san.mhcx.uploadlogs.service.IUpLoadLogsService;

/**
 * @author 吕海涛
 * 
 */
public class UploadLogsServiceImpl implements IUpLoadLogsService {

	private IUpLoadLogsDao dao;
	/**
	 * @return the dao
	 */
	public IUpLoadLogsDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(IUpLoadLogsDao dao) {
		this.dao = dao;
	}
	/**
	 * 得到日志信息的总条数
	 * @param logUser
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @param tableId
	 * @param logStates
	 * @return
	 * @throws Exception
	 */
	public Integer getLogsCounts(String logUser, String deptId,
			String beginDate, String endDate, String tableId, String logStates) throws Exception {
		String hql=" from VUploadLogs where 1=1 ";
		//开始拼接hql
		if(logUser != null && !"".equals(logUser)){
			hql+="and logUser like '%"+logUser+"%' ";
		}
		if(deptId != null && !"".equals(deptId)){
			hql+="and ouid = '"+deptId+"' ";
		}
		if(beginDate != null && !"".equals(beginDate)){
//			hql+="and logTime  >= '"+beginDate+"' ";
			hql+="and logTime  >= to_date('"+beginDate+"','yyyy-mm-dd') ";
		}
		if(endDate != null && !"".equals(endDate)){
//			hql+="and logTime <= '"+endDate+" 23:59:59' ";
			hql+="and logTime  <= to_date('"+endDate+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		if(tableId != null && !"".equals(tableId)){
			hql+="and tableId = '"+tableId+"' ";
		}
		if(logStates != null && !"".equals(logStates)){
			hql+="and logStates = '"+logStates+"' ";
		}
		
		List list=dao.getRsByHql(hql);
		System.out.println("+++++++++"+list.size()+"++++++++");
		
		
		return Integer.valueOf(dao.getRsByHql(hql).size());
	}
	/**
	 * 获取所有日志信息
	 * @param logUser
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @param tableId
	 * @param logStates
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List queryLogsInfo(String logUser, String deptId, String beginDate,
			String endDate, String tableId, String logStates, int pageNo,
			int pageSize) throws Exception {
		String hql=" from VUploadLogs where 1=1 ";
		//开始拼接hql
		if(logUser != null && !"".equals(logUser)){
			hql+="and logUser like '%"+logUser+"%' ";
		}
		if(deptId != null && !"".equals(deptId)){
			hql+="and ouid = '"+deptId+"' ";
		}
		if(beginDate != null && !"".equals(beginDate)){
//			hql+="and logTime  >= '"+beginDate+"' ";
			hql+="and logTime  >= to_date('"+beginDate+"','yyyy-mm-dd') ";
		}
		if(endDate != null && !"".equals(endDate)){
//			hql+="and logTime <= '"+endDate+" 23:59:59' ";
			hql+="and logTime  <= to_date('"+endDate+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		if(tableId != null && !"".equals(tableId)){
			hql+="and tableId = '"+tableId+"' ";
		}
		if(logStates != null && !"".equals(logStates)){
			hql+="and logStates = '"+logStates+"' ";
		}
		hql+="order by logTime desc";
		List list=dao.getRsByHql(hql, pageNo, pageSize);
		return list;
	}
	/**
	 * 根据部门编号得到表信息
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List getTableInfoByDeptId(String deptId) throws Exception {
			String hqlStr=" from M0201Table where departmentId='"+deptId+"' and isImport='1'";
			List list=dao.getRsByHql(hqlStr);
			return list;
	}
	/**
	 * 得到所有部门信息
	 * @return
	 * @throws Exception
	 */
	public List getDeptInfo() throws Exception {
		String hqlStr=" from SysOulist";
		List list=dao.getRsByHql(hqlStr);
		return list;
	}
	/**
	 * 根据日志编号得到日志信息
	 * @param logId
	 * @return
	 * @throws Exception
	 */
	public List getLogById(String logId) throws Exception {
		String hqlStr=" from TUploadLogs where logId='"+logId+"'";
		List list=dao.getRsByHql(hqlStr);
		return list;
	}
	/**
	 * 根据表编号得到表信息
	 * @param tableId
	 * @return
	 * @throws Exception
	 */
	public List getTableInfoById(String tableId) throws Exception {
		String hqlStr=" from M0201Table where tableId='"+tableId+"'";
		List list=dao.getRsByHql(hqlStr);
		return list;
	}
	/**
	 * 根据日志编号得到导入失败的日志信息
	 * @param logId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List getLogErrorByLogId(String logId, int pageNo, int pageSize)
			throws Exception {
		String hqlStr=" from TUploadErrorLogs where logNumber='"+logId+"'";
		List list=dao.getRsByHql(hqlStr,pageNo,pageSize);
		return list;
	}
	/**
	 * 根据日志编号得到导入失败的日志总数
	 * @param logId
	 * @return
	 * @throws Exception
	 */
	public Integer getLogErrorCountByLogId(String logId) throws Exception {
		String hqlStr=" from TUploadErrorLogs where logNumber='"+logId+"'";
		return Integer.valueOf(dao.getRsByHql(hqlStr).size());
	}
	/**
	 * 根据部门编号统计部门上传数据量
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByDeptIdForPie(String deptId,String beginDate,String endDate) throws Exception {
		String sql="select a.ouid,a.ouname,count(c.log_upload_size) as all_count," +
		"case when sum(c.log_upload_size) is null  then 0 else sum(c.log_upload_size) end as all_upload_size " +
		"from SYS_OULIST a left join M0201_TABLE b on a.ouid=b.department_id left join T_UPLOAD_LOGS c on b.table_id=c.log_tableId where 1=1 ";
		
		//部门编号
		if (deptId != null && !"".equals(deptId)) {
			sql += "and a.ouid in("+deptId+") ";
		}
		sql+=" and a.ouid !='OuLi20070529174221891' ";
//		//开始时间
//		if(beginDate != null && !"".equals(beginDate)){
//			sql+="and c.log_time >= '"+beginDate+"' ";
//		}
//		//结束时间
//		if(endDate != null && !"".equals(endDate)){
//			sql+="and c.log_time <= '"+endDate+" 23:59:59' ";
//		}
		
		if(beginDate != null && !"".equals(beginDate)){
//			hql+="and logTime  >= '"+beginDate+"' ";
			sql+="and c.log_time  >= to_date('"+beginDate+"','yyyy-mm-dd') ";
		}
		if(endDate != null && !"".equals(endDate)){
//			hql+="and logTime <= '"+endDate+" 23:59:59' ";
			sql+="and c.log_time  <= to_date('"+endDate+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		
		
		sql +="group by a.ouid,a.ouname order by sum(c.log_upload_size) desc";
		List list=dao.getRsBySql(sql);
		
		List logList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			LogTjByDeptPO deptPO=new LogTjByDeptPO();
			Object[] obj = (Object[]) list.get(i);
			//部门编号
			if (obj[0] != null) {
				deptPO.setDeptId(obj[0].toString());
			}
			//部门名称
			if (obj[1] != null) {
				deptPO.setDeptName(obj[1].toString());
			}
			//导入次数
			if (obj[2] != null) {
				deptPO.setAllCount(Integer.parseInt(obj[2].toString()));
			}
			//导入成功总数
			if (obj[3] != null) {
				deptPO.setAllUpLoadSize(Integer.parseInt(obj[3].toString()));
			}
			logList.add(deptPO);
		}
		
		return logList;
	}
	
	/**
	 * 获取一组模型数据集对象 -- (柱状图)
	 * @param logList
	 * @return
	 * @throws Exception
	 */
	public CategoryDataset getDataSet(List logList) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < logList.size(); i++) {
			LogTjByDeptPO modelInfoId = (LogTjByDeptPO) logList.get(i);
			dataset.addValue(modelInfoId.getAllUpLoadSize(), modelInfoId.getDeptName(), "");
		}
		return dataset;
	}
	
	
	/**
	 * 获取一组模型数据集对象 -- (饼状图)
	 * @param logList
	 * @return
	 * @throws Exception
	 */
	public PieDataset getPieDataSet(List logList) throws Exception {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (int i = 0; i < logList.size(); i++) {
			LogTjByDeptPO modelInfoId = (LogTjByDeptPO) logList.get(i);
			dataset.setValue(modelInfoId.getDeptName(),modelInfoId.getAllUpLoadSize());
		}
		return dataset;
	}
	/**
	 * 根据部门编号，开始时间，结束时间查询导入日志信息
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByC(String deptId, String beginDate, String endDate,String field9)
			throws Exception {
		
		String sql="select a.ouid,a.ouname,count(c.log_upload_size) as all_count," +
		"case when sum(c.log_upload_size) is null  then 0 else sum(c.log_upload_size) end as all_upload_size " +
		"from SYS_OULIST a left join sys_table b on a.ouid=b.depid left join T_UPLOAD_LOGS c on b.tableid=c.log_tableId where 1=1 ";
		/*
		//部门编号
		if (deptId != null && !"".equals(deptId)) {
			sql += "and a.ouid in("+deptId+") ";
		}*/
		
		sql+=" and a.ouid !='OuLi20070529174221891' ";
		sql+=" and a.ouid !='OuLi20130416104235593' ";
//		//开始时间
//		if(beginDate != null && !"".equals(beginDate)){
//			sql+="and c.log_time >= '"+beginDate+"' ";
//		}
//		//结束时间
//		if(endDate != null && !"".equals(endDate)){
//			sql+="and c.log_time <= '"+endDate+" 23:59:59' ";
//		}
		
		if(beginDate != null && !"".equals(beginDate)){
//			hql+="and logTime  >= '"+beginDate+"' ";
			sql+="and c.log_time  >= to_date('"+beginDate+"','yyyy-mm-dd') ";
		}
		if(endDate != null && !"".equals(endDate)){
//			hql+="and logTime <= '"+endDate+" 23:59:59' ";
			sql+="and c.log_time  <= to_date('"+endDate+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
//		
//		if(field9 != null && !"".equals(field9)){
//			sql+="and b.field9="+field9;
//		}
		
		sql +=" group by a.ouid,a.ouname order by all_upload_size desc";
		List list=dao.getRsBySql(sql);
		
		List logList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			LogTjByDeptPO deptPO=new LogTjByDeptPO();
			Object[] obj = (Object[]) list.get(i);
			//部门编号
			if (obj[0] != null) {
				deptPO.setDeptId(obj[0].toString());
			}
			//部门名称
			if (obj[1] != null) {
				deptPO.setDeptName(obj[1].toString());
			}
			//导入次数
			if (obj[2] != null) {
				deptPO.setAllCount(Integer.parseInt(obj[2].toString()));
			}
			//导入成功总数
			if (obj[3] != null) {
				deptPO.setAllUpLoadSize(Integer.parseInt(obj[3].toString()));
			}
			logList.add(deptPO);
		}
		
		return logList;
	}
	/**
	 * 根据部门编号统计部门上传数据量
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByDeptId(String deptId, String beginDate,
			String endDate) throws Exception {
		String sql="select a.ouid,a.ouname,count(c.log_upload_size) as all_count," +
		"case when sum(c.log_upload_size) is null  then 0 else sum(c.log_upload_size) end as all_upload_size " +
		"from SYS_OULIST a left join M0201_TABLE b on a.ouid=b.department_id left join T_UPLOAD_LOGS c on b.table_id=c.log_tableId where 1=1 ";
		
		//部门编号
		if (deptId != null && !"".equals(deptId)) {
			sql += "and a.ouid in("+deptId+") ";
		}
		
		sql+=" and a.ouid !='OuLi20070529174221891' ";
		//开始时间
//		if(beginDate != null && !"".equals(beginDate)){
//			sql+="and c.log_time >= '"+beginDate+"' ";
//		}
//		//结束时间
//		if(endDate != null && !"".equals(endDate)){
//			sql+="and c.log_time <= '"+endDate+" 23:59:59' ";
//		}
		
		if(beginDate != null && !"".equals(beginDate)){
//			hql+="and logTime  >= '"+beginDate+"' ";
			sql+="and c.log_time  >= to_date('"+beginDate+"','yyyy-mm-dd') ";
		}
		if(endDate != null && !"".equals(endDate)){
//			hql+="and logTime <= '"+endDate+" 23:59:59' ";
			sql+="and c.log_time  <= to_date('"+endDate+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		
		sql +="group by a.ouid,a.ouname order by sum(c.log_upload_size) desc";
		List list=dao.getRsBySql(sql);
		
		List logList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			LogTjByDeptPO deptPO=new LogTjByDeptPO();
			Object[] obj = (Object[]) list.get(i);
			//部门编号
			if (obj[0] != null) {
				deptPO.setDeptId(obj[0].toString());
			}
			//部门名称
			if (obj[1] != null) {
				deptPO.setDeptName(obj[1].toString());
			}
			//导入次数
			if (obj[2] != null) {
				deptPO.setAllCount(Integer.parseInt(obj[2].toString()));
			}
			//导入成功总数
			if (obj[3] != null) {
				deptPO.setAllUpLoadSize(Integer.parseInt(obj[3].toString()));
			}
			logList.add(deptPO);
		}
		
		return logList;
	}
	/**
	 * 得到日志所有信息时间排序(大->小)
	 * @return
	 * @throws Exception
	 */
	public List getAllLogBtoS() throws Exception {
		String hql=" from TUploadLogs order by logTime desc";
		
		return dao.getRsByHql(hql);
	}
	/**
	 * 得到日志所有信息时间排序(小->大)
	 * @return
	 * @throws Exception
	 */
	public List getAllLogStoB() throws Exception {
		String hql=" from TUploadLogs order by logTime";
		
		return dao.getRsByHql(hql);
	}
	
	
	/**
	 * 删除某一批次导入的数据
	 * @param logId
	 * @param tname
	 * @param hname
	 * @param date
	 * @throws Exception
	 */
	public void deleteLog(String logId,String tname,String hname,String date)
			throws Exception {
		String sql1=" delete from "+tname+" where INPUT_DATE =to_date('"+date+"','yyyy-mm-dd hh24:mi:ss')";
		dao.createView(sql1);
		String sql2=" delete from "+hname+" where INPUT_DATE =to_date('"+date+"','yyyy-mm-dd hh24:mi:ss')";
		dao.createView(sql2);
		String sql3=" delete from T_UPLOAD_LOGS where LOG_ID ='"+logId+"'";
		dao.createView(sql3);
	}
	
	/**
	 * 根据部门编号，开始时间，结束时间查询导入日志信息
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByY(String deptId, String beginDate, String endDate,String ayt,String field9)
			throws Exception {
		String sql="";
		if("2".equals(ayt)){
			sql="select a.ouid,a.ouname,count(c.log_upload_size) as all_count," +
			"case when sum(c.log_upload_size) is null  then 0 else sum(c.log_upload_size) end as all_upload_size,to_char(c.LOG_TIME,'yyyy-mm') LOG_TIME " +
			"from SYS_OULIST a left join M0201_TABLE b on a.ouid=b.department_id left join T_UPLOAD_LOGS c on b.table_id=c.log_tableId where 1=1 ";
		}else if("1".equals(ayt)){
		 sql="select a.ouid,a.ouname,count(c.log_upload_size) as all_count," +
		"case when sum(c.log_upload_size) is null  then 0 else sum(c.log_upload_size) end as all_upload_size " +
		"from SYS_OULIST a left join M0201_TABLE b on a.ouid=b.department_id left join T_UPLOAD_LOGS c on b.table_id=c.log_tableId where 1=1 ";
		}
		/**
		//部门编号
		if (deptId != null && !"".equals(deptId)) {
			sql += "and a.ouid in("+deptId+") ";
		}
		**/
		sql+=" and a.ouid !='OuLi20070529174221891' ";
		sql+=" and a.ouid !='OuLi20130416104235593' ";
//		//开始时间
//		if(beginDate != null && !"".equals(beginDate)){
//			sql+="and c.log_time >= '"+beginDate+"' ";
//		}
//		//结束时间
//		if(endDate != null && !"".equals(endDate)){
//			sql+="and c.log_time <= '"+endDate+" 23:59:59' ";
//		}
		
		if(beginDate != null && !"".equals(beginDate)){
//			hql+="and logTime  >= '"+beginDate+"' ";
			sql+="and c.log_time  >= to_date('"+beginDate+"','yyyy-mm-dd') ";
		}
		if(endDate != null && !"".equals(endDate)){
//			hql+="and logTime <= '"+endDate+" 23:59:59' ";
			sql+="and c.log_time  <= to_date('"+endDate+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		
		if(field9 != null && !"".equals(field9)){
			sql+="and b.field9="+field9;
		}
		
		if("2".equals(ayt)){
			sql+=" and to_char(c.LOG_TIME,'yyyy-mm')=(select MAX(to_char(t.LOG_TIME,'yyyy-mm')) dates from T_UPLOAD_LOGS t) ";
			sql +="group by a.ouid,a.ouname,to_char(c.LOG_TIME,'yyyy-mm') order by all_upload_size desc";
		}else if("1".equals(ayt)){
		
		sql +="group by a.ouid,a.ouname order by all_upload_size desc";
		}
		List list=dao.getRsBySql(sql);
		List logList=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			LogTjByDeptPO deptPO=new LogTjByDeptPO();
			Object[] obj = (Object[]) list.get(i);
			//部门编号
			if (obj[0] != null) {
				deptPO.setDeptId(obj[0].toString());
			}
			//部门名称
			if (obj[1] != null) {
				deptPO.setDeptName(obj[1].toString());
			}
			//导入次数
			if (obj[2] != null) {
				deptPO.setAllCount(Integer.parseInt(obj[2].toString()));
			}
			//导入成功总数
			if (obj[3] != null) {
				deptPO.setAllUpLoadSize(Integer.parseInt(obj[3].toString()));
			}
			if("2".equals(ayt)){
			if (obj[4] != null) {
				deptPO.setStrdate(obj[4].toString());
			}
			logList.add(deptPO);
		}
		}
		
		return logList;
	}	
	
	
	/**
	 * 转换密码
	 * @param userPwd
	 * @param userName
	 * @throws Exception
	 */
	public void getSetPwd(String userPwd,String userName) throws Exception {

		String sql="update sys_user set pwd=encrypt256('"+userPwd+"') where cn='"+userName+"'"; 
		
		dao.createView(sql);
		
	}

	/**
	 * 获取用户密码
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public String getUserPwd(String userName) throws Exception {
		List list = dao.getRsBySql("select decrypt256(pwd) as pwd from sys_user where cn='"+userName+"'");
		
		String str="";
		
		if(list.get(0)!=null){
			str=list.get(0)+"";
		}
		
		return str;
	}
	
	
}
