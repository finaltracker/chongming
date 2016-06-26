package com.san.jingtai.service;

import java.util.List;

import org.jfree.data.category.CategoryDataset;

import com.san.jingtai.model.JingTaiLogInfo;

/**
 * 业务接口类
 * @author 吕海涛
 *
 */
public interface IJingtaiService {
	
	/**
	 * 生成个人基本信息xml
	 * @throws Exception
	 */
	public void createPersonalBaseXml() throws Exception;
	
	/**
	 * 生成企业基本信息xml
	 * @throws Exception
	 */
	public void createEnterpriseBaseXml() throws Exception;
	
	public void getEnterpriseToDataBase() throws Exception;
	
	/**
	 * 生成企业基本信息xml
	 * 
	 * @throws Exception
	 */
	public void createEnterpriseBaseXmlJl(String enterpriseId) throws Exception;
	
	/**
	 * 企业编辑指标
	 * 
	 * @throws Exception
	 */
	public void enterprsieXmlEdit() throws Exception;
	
	/**
	 * 生成个人基本信息xml
	 * 
	 * @throws Exception
	 */
	public void createPersonalBaseXmlJl() throws Exception;
	
	/**
	 * 个人编辑指标
	 * 
	 * @throws Exception
	 */
	public void personalXmlEdit() throws Exception;
	
	/**
	 * 生成个人基本信息xml
	 * 
	 * @throws Exception
	 */
	public void personalNoXml(String personalId) throws Exception;
	
	/**
	 * 创建企业大表
	 * @throws Exception
	 */
	public void createEnterpriseTable() throws Exception;
	
	/**
	 * 创建个人大表
	 * @throws Exception
	 */
	public void createPersonalTable() throws Exception;
	
	/**
	 * 生成企业xml
	 * @param enterpriseId
	 * @throws Exception
	 */
	public void creEntrsXml(String enterpriseId) throws Exception;
	
	/**
	 * 生成个人xml
	 * 
	 * @param personalId
	 * @throws Exception
	 */
	public void crePersonXml(String personalId) throws Exception;
	
	/**
	 * 获取出生年月
	 * @param personalId
	 * @return
	 * @throws Exception
	 */
	public String getCsny(String personalId) throws Exception;
	
	/**
	 * 存入查询信息
	 * @author 张庆生
	 */
	public int saveJingTaiInfoService(JingTaiLogInfo jingtaiInfo);
	
	/**
	 * 获取部门
	 * @author 张庆生
	 */
	public List<String> getListdeptListManger(String ouid);
	
}
