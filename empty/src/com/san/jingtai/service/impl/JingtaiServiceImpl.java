package com.san.jingtai.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

import sun.misc.BASE64Encoder;

import com.san.chengxin.common.service.DateUtil;
import com.san.jingtai.dao.IJingtaiDao;
import com.san.jingtai.model.JingTaiLogInfo;
import com.san.jingtai.service.IJingtaiService;
import com.san.jingtai.service.XmlUtil;

public class JingtaiServiceImpl implements IJingtaiService {

	private static ArrayList filelist = new ArrayList();

	private IJingtaiDao dao;

	public IJingtaiDao getDao() {
		return dao;
	}

	public void setDao(IJingtaiDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 创建企业大表
	 * 
	 * @throws Exception
	 */
	public void createEnterpriseTable() throws Exception {}

	/**
	 * 创建个人大表
	 * 
	 * @throws Exception
	 */
	public void createPersonalTable() throws Exception {}

	/**
	 * 生成企业xml
	 * 
	 * @param enterpriseId
	 * @throws Exception
	 */
	public void creEntrsXml(String enterpriseId) throws Exception {}
	
	
	/**
	 * 生成个人xml
	 * 
	 * @param personalId
	 * @throws Exception
	 */
	public void crePersonXml(String personalId) throws Exception {}
	
	/**
	 * 生成个人基本信息xml
	 * 
	 * @throws Exception
	 */
	public void createPersonalBaseXml() throws Exception {}

	/**
	 * 生成企业基本信息xml
	 * 
	 * @throws Exception
	 */
	public void createEnterpriseBaseXml() throws Exception {}

	/**
	 * 写数据库企业信息
	 * 
	 * @throws Exception
	 */
	public void getEnterpriseToDataBase() throws Exception {}

	public static void refreshFileList(String strPath) {}

	/**
	 * 生成企业基本信息xml
	 * 
	 * @throws Exception
	 */
	public void createEnterpriseBaseXmlJl(String enterpriseId) throws Exception {}

	/**
	 * 企业编辑指标
	 * 
	 * @throws Exception
	 */
	public void enterprsieXmlEdit() throws Exception {}

	/**
	 * 生成个人基本信息xml
	 * 
	 * @throws Exception
	 */
	public void createPersonalBaseXmlJl() throws Exception {}

	/**
	 * 个人编辑指标
	 * 
	 * @throws Exception
	 */
	public void personalXmlEdit() throws Exception {}

	/**
	 * 生成个人基本信息xml
	 * 
	 * @throws Exception
	 */
	public void personalNoXml(String personalId) throws Exception {}
	
	/**
	 * 获取出生年月
	 * @param personalId
	 * @return
	 * @throws Exception
	 */
	public String getCsny(String personalId) throws Exception{
		String str="";
		String sql="select substr(t.csny,0,4) as csny from hzcx_gr_base t where personal_id='"+personalId+"' ";
		List list=dao.getRsBySql(sql);
		if(list.size()>0){
			str=list.get(0)+"";
		}
		return str;
	}
	
	/**
	 * 持久化查询信息
	 * @param jingtaiInfo
	 * @author zhangqs
	 */
	public int saveJingTaiInfoService(JingTaiLogInfo jingtaiInfo) {
		int i = -1;
		try{
			dao.saveObject(jingtaiInfo);
			i = 1;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 获取部门
	 */
	public List<String> getListdeptListManger(String ouid) {
		if(null!=ouid && !"".equals(ouid)){
			try{
				String sqlStr = "select t.ouname from sys_oulist t where t.ouid = '" + ouid + "'";
				return dao.getRsBySql(sqlStr);
			}
			catch (Exception e) {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	
	

}
