/**
 * 
 */
package com.san.orgdata.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

//import org.springframework.beans.BeanUtils;

import com.san.orgdata.action.OrgDataAction;
import com.san.orgdata.dao.OrgDataDao;
import com.san.orgdata.model.vo.SysDataConfigVO;
import com.san.orgdata.model.vo.SysOuVO;
import com.san.orgdata.service.OrgDataService;

/**
 * 
 * <p>Title:[机构数据管理service实现类] </p>
 * <p>Description: [类功能描述]</p>
 * <p>Copyright© 2014 Shanghai 30wish Information Security Co.,Ltd.</p>
 * <p>All right reserved.</p>
 * 
 * @version 1.0 
 * Created by [liangkd] [2014-12-24] 
 * Midified by [修改人] [修改时间]
 * 
 */
public class OrgDataServiceImpl implements OrgDataService {

	private static final Logger logger = Logger.getLogger(OrgDataServiceImpl.class);
	/**
	 * 企业
	 */
	private static String DATATYPE_QY="0";   
	/**
	 * 自然人
	 */
	private static String DATATYPE_ZRR="1";

	private OrgDataDao dao;


	@Override
	public Map queryOrgDataConfigInfo(String userCname) throws Exception {

		//数据加载
		List sysTable = new ArrayList ();
		Map userTableInfo = new HashMap();
		if(null != userCname )
			userTableInfo = dao.queryUserTableInfo(userCname);

		//查本人配置显示的数据，否则全部显示
		if(null != userCname && (!userTableInfo.isEmpty() && userTableInfo.size()>0)){
			sysTable = dao.querySysTable(this.DATATYPE_QY,userCname);
		}else{
			sysTable = dao.querySysTable(this.DATATYPE_QY);
		}
		List sysField = dao.querySysField(this.DATATYPE_QY);

		HashMap sysOuVOMap = new HashMap();

		//数据组装处理
		for(int i=0;i<sysTable.size();i++){
			SysDataConfigVO v = (SysDataConfigVO)sysTable.get(i);


			SysOuVO sysOuVO = new SysOuVO();
			sysOuVO.setOuid(v.getOuid());
			sysOuVO.setOuName(v.getOuname());
			sysOuVO.setDisplayOrder(v.getDisplayorder());

			if(!sysOuVOMap.containsKey(v.getOuid())){

				//加载部门表与表字段定义
				List tbList = this.getTableList(sysTable, v.getOuid(),sysField) ;

				//加载各表业务数据对象集合
				//				if(isLoadBusinessData){
				//					this.loadTableData(tbList,enterpriseId);
				//				}
				sysOuVO.setSysTableList(tbList);

				sysOuVOMap.put(v.getOuid(), sysOuVO);

			}

		}
		return sysOuVOMap;
	}


	@Override
	public Map loadOrgDataConfigInfo(Map sysOuVOMap, String enterpriseId)
			throws Exception {
		if(null==sysOuVOMap)
			throw new Exception("参数sysOuVOMap为空");

		Iterator iter = sysOuVOMap.entrySet().iterator(); 
		//机构循环
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next(); 
			Object key = entry.getKey(); 
			SysOuVO ouvo = (SysOuVO)entry.getValue(); 

			List tbList = ouvo.getSysTableList() ;
			//加载各表业务数据对象集合
			this.loadTableData(tbList,enterpriseId);

		}

		return sysOuVOMap;
	}


	/**
	 *
	 * <p>Description:[机构业务数据配置表查询加载] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-4]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param sysTableList 表集合
	 * @param ouID	 部门编号
	 * @param sysField 表字段定义集合
	 * @return  某部门的配置表及表字段数据
	 * 
	 */
	private List getTableList(List sysTableList , String ouID, List sysField){

		List tblist = new ArrayList();

		
		return tblist;
	}


	/**
	 * 
	 *
	 * <p>Description:[机构业务数据加载] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-4]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param tbList
	 * @param enterpriseId
	 * @return
	 */
	private List loadTableData(List tbList,String enterpriseId){

		return tbList ;
	}
	/**
	 * 
	 *
	 * <p>Description:[临时sql语句拼接] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-4]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param sysTableVO
	 * @return
	 */
	


	public OrgDataDao getDao() {
		return dao;
	}
	public void setDao(OrgDataDao dao) {
		this.dao = dao;
	}

	@Override
	public void saveUserTableInfo(String[] tableId, String userCname) throws Exception {
		this.dao.saveUserTableInfo(tableId, userCname);
	}

	@Override
	public Map queryUserTableInfo(String userCname)  throws Exception{

		return this.dao.queryUserTableInfo(userCname);
	}


	@Override
	public List queryQyBase(String enterpriseId) throws Exception {
		
		return this.dao.queryQyBase(enterpriseId);
	}


}
