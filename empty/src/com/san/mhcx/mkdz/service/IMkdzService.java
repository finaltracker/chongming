package com.san.mhcx.mkdz.service;

import java.util.List;



public interface IMkdzService{
	
	
	/**
	 * ͨ����通过企业编号查询企业信息
	 * @param enterpriseId
	 * @return
	 * @throws Exception
	 */
	public List getMkdzById(String mkId) throws Exception;
	
	
	/**
	 * 保存到数据库
	 * @param obj
	 * @throws Exception
	 */
	public void addObject(Object obj) throws Exception;
	
	/**
	 * 查出企业的条数
	 * @param enterpriseName
	 * @return
	 * @throws Exception
	 */
	public int mkdzInfoCount(String mkName) throws Exception;
	/**
	 * 查找企业信息
	 * @param enterpriseName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List mkdzInfo(String mkName, String zt ,String jflx ,int pageNo, int pageSize) throws Exception;
	
	/**
	 * 修改
	 * @param obj
	 * @throws Exception
	 */
	public void updateObject(Object obj) throws Exception;
	
	/**
	 * 根据编号删除企业信息
	 * @param enterpriseId
	 * @throws Exception
	 */
	public void deleteMkdzInfo(String mkId) throws Exception;
	
	
	/**
	 * 根据类型获取信息
	 * @author nico
	 * @param enterpriseId
	 * @throws Exception
	 */
	public List queryMkdzInfo(String mkType) throws Exception;
	
}
