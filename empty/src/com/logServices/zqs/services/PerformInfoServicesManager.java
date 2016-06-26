package com.logServices.zqs.services;

import java.util.Date;
import java.util.List;

import com.logServices.zqs.model.PerformaceStatisInfo;

public interface PerformInfoServicesManager {
	
	/**
	 * 查询列表明细
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<PerformaceStatisInfo> getListAllManger(String depart, String fristDate, String endDate,int pageNo, int pageSize);
	
	/**
	 * 统计总数
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<PerformaceStatisInfo> getListDetailManager(int pageNo, int pageSize);
	
	/**
	 * 带条件的查询
	 */
	public List<PerformaceStatisInfo> getListCondititonDetailManger(String depart, String fristDate, String endDat,int pageNo, int pageSize);
	
	/**
	 * 验证是否在有效时间内
	 * @param sql
	 * @return
	 */
	public String vailDatePerInfoManager(String nowDate, String usName, String uptype,String pid);
	
	/**
	 * 验证上传时间
	 * @param nowDate
	 * @param usName
	 * @param pointType
	 * @param tableid
	 * @return
	 */
	public int vailDateupFileManager(String nowDate,String usName,String pointType,String tableid);
	/**
	 * 登陆积分验证
	 */
	public int vailDateLogManager(String nowDate, String usName,String pointType,String pid);
	
	/**
	 * 查询积分验证
	 * @param nowDate
	 * @param usName
	 * @param pointType
	 * @param condition
	 * @return
	 */
	public String vailDateJingTaiManager(String nowDate, String usName,String pointType,String pid);
	
	/**
	 * 更新积分数据
	 * @param sql
	 * @return
	 */
	public int updatePerInfoManager(String pid,String flag,int jf);
	
	/**
	 * 更新查询条件
	 * @return
	 */
	public int updateContectManager(String pid,String flag,int jf,String contect);
	
	/**
	 * 查询已有匹配规则
	 * @author nico
	 */
	public List<PerformaceStatisInfo> queryNamePerInfoManager(String username, String type);
	
	/**
	 * 更新限制条件
	 * @param endDate
	 * @return
	 */
	public int updatePerDateManager(String pid, String startDate, String endDate,String jftx);
	
	/**
	 * 更新历史记录
	 * @param pid
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int updateTypeManager(String pid, String ex_3);
	
	/**
	 * 获取总数
	 * @param sql
	 * @return
	 */
	public int queryPerInfoManager(String str, String userNames, String fristDate, String endDate);
	
	/**
	 * 保存数据
	 * @param obj
	 */
	public void  savePerInfoManager(Object obj);
	
	/**
	 * 查询部门
	 * @param sql
	 * @return
	 */
	public List<PerformaceStatisInfo> querUserNamesManger(String username);
	
	/**
	 * 图形统计查询
	 * 统计类型：部门总计
	 */
	public List<PerformaceStatisInfo> querAnyCharAllManger(String sql);
	
	
	/**
	 * 图形统计查询
	 * 统计类型：月度统计
	 */
	public List<PerformaceStatisInfo> querMontherAnyCharAllManger(String sql);
	/**
	 * 图形统计查询
	 * 统计类型：部门下的人员统计
	 */
	public List<PerformaceStatisInfo> querAnyCharEmployManger(String sql);
}
