/**
 * 
 */
package com.san.mhcx.uploadlogs.service;

import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

/**
 * 对视图v_upload_logs的操作
 * 
 * @author yangyj
 *
 */
public interface IUpLoadLogsService {
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
	public List queryLogsInfo(String logUser,String deptId,String beginDate,String endDate,String tableId,String logStates,int pageNo, int pageSize) throws Exception;
	
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
	public Integer getLogsCounts(String logUser,String deptId,String beginDate,String endDate,String tableId,String logStates) throws Exception;

	/**
	 * 根据部门编号得到表信息
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List getTableInfoByDeptId(String deptId) throws Exception ;
	
	/**
	 * 得到所有部门信息
	 * @return
	 * @throws Exception
	 */
	public List getDeptInfo() throws Exception ;
	
	/**
	 * 根据日志编号得到日志信息
	 * @param logId
	 * @return
	 * @throws Exception
	 */
	public List getLogById(String logId) throws Exception ;
	
	/**
	 * 根据表编号得到表信息
	 * @param tableId
	 * @return
	 * @throws Exception
	 */
	public List getTableInfoById(String tableId) throws Exception ;
	
	/**
	 * 根据日志编号得到导入失败的日志信息
	 * @param logId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List getLogErrorByLogId(String logId,int pageNo, int pageSize) throws Exception ;
	
	/**
	 * 根据日志编号得到导入失败的日志总数
	 * @param logId
	 * @return
	 * @throws Exception
	 */
	public Integer getLogErrorCountByLogId(String logId) throws Exception ;
	
	
	/**
	 * 根据部门编号，开始时间，结束时间查询导入日志信息
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByC(String deptId,String beginDate,String endDate,String field9) throws Exception ;
	/**
	 * 根据部门编号统计部门上传数据量
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByDeptId(String deptId,String beginDate,String endDate) throws Exception ;
	
	/**
	 * 根据部门编号统计部门上传数据量
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByDeptIdForPie(String deptId,String beginDate,String endDate) throws Exception ;
	
	/**
	 * 获取一组模型数据集对象 -- (柱状图)
	 * @param logList
	 * @return
	 * @throws Exception
	 */
	public CategoryDataset getDataSet(List logList) throws Exception;
	/**
	 * 获取一组模型数据集对象 -- (饼状图)
	 * @param logList
	 * @return
	 * @throws Exception
	 */
	public PieDataset getPieDataSet(List logList) throws Exception;
	
	/**
	 * 得到日志所有信息时间排序(大->小)
	 * @return
	 * @throws Exception
	 */
	public List getAllLogBtoS() throws Exception ;
	
	/**
	 * 得到日志所有信息时间排序(小->大)
	 * @return
	 * @throws Exception
	 */
	public List getAllLogStoB() throws Exception ;
	
	/**
	 * 删除某一批次导入的数据
	 * @param logId
	 * @param tname
	 * @param hname
	 * @param date
	 * @throws Exception
	 */
	public void deleteLog(String logId,String tname,String hname,String date)
			throws Exception ;
	/**
	 * 根据部门编号，开始时间，结束时间查询导入日志信息
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List getLogInfoByY(String deptId,String beginDate,String endDate,String ayt,String field9) throws Exception ;
	
	/**
	 * 转换密码
	 * @param userPwd
	 * @param userName
	 * @throws Exception
	 */
	public void getSetPwd(String userPwd,String userName) throws Exception;
	
	/**
	 * 获取用户密码
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public String getUserPwd(String userName) throws Exception;
}
