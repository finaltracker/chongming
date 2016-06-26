package com.logServices.zqs.dao;

import java.util.List;

import com.logServices.zqs.model.PerformaceStatisInfo;
import com.san.chengxin.common.dao.Dao;

public interface PerformInfoDao extends Dao{
	
	/**
	 * 查询列表明细
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<PerformaceStatisInfo> getListAll(String sql, int pageNo, int pageSize);
	
	/**
	 * 统计总数
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<PerformaceStatisInfo> getListDetail(String sql,int pageNo, int pageSize);
	
	/**
	 * 验证是否在有效时间内
	 * @param sql
	 * @return
	 */
	public int vailDatePerInfo(String sql);
	
	
	/**
	 * 验证法人查询及自然人查询
	 */
	public String vailJingPerInfo(String sql);
	
	/**
	 * 验证数据导入
	 * @param sql
	 * @return
	 */
	public String vaildateImpPerInfo(String sql);
	
	/**
	 * 更新数据
	 * @param sql
	 * @return
	 */
	public int updatePerInfo(String sql);
	
	/**
	 * 获取总数
	 * @param sql
	 * @return
	 */
	public int queryPerInfo(String sql);
	
	/**
	 * 查询用户
	 */
	public List<PerformaceStatisInfo> queryUserNames(String sql);
	
	 
	/**
	 * 共用查询公共信息
	 */
	public List<PerformaceStatisInfo> queryInfopu(String sql);
}
