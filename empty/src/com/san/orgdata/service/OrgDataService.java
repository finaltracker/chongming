/**
 * 
 */
package com.san.orgdata.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Title:[机构数据管理service接口] </p>
 * <p>Description: [类功能描述]</p>
 * <p>Copyright© 2014 Shanghai 30wish Information Security Co.,Ltd.</p>
 * <p>All right reserved.</p>
 * 
 * @version 1.0 
 * Created by [liangkd] [2014-12-24]
 * Midified by [修改人] [修改时间]
 * 
 */
public interface OrgDataService {

	
	/**
	 * <p>Description:[机构配置信息查询] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-4]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param userCname 用户id ，为null查所有
	 * @return
	 * @throws Exception
	 */
	public Map queryOrgDataConfigInfo(String userCname) throws Exception;
	
	/**
	 * 
	 * <p>Description:[加载业务数据] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-20]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param sysOuVOMap   组织机构集合
	 * @param enterpriseId  机构编码
	 * @return
	 * @throws Exception
	 */
	
	public Map loadOrgDataConfigInfo(Map sysOuVOMap ,String enterpriseId) throws Exception;
	
		 
	 /**
	  * 
	  * <p>Description:[用户配置显示信息保存] </p>
	  * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	  * All right reserved.
	  * Created by [liangkd] [2015-1-15]
	  * Midified by [修改人] [修改时间]
	  *
	  * @param tableId  表编码
	  * @param userCname 用户名
	  */
	 public void saveUserTableInfo(String [] tableId,String userCname) throws Exception;
	 
	 /**
	  *
	  * <p>Description:[查询用户配置显示信息] </p>
	  * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	  * All right reserved.
	  * Created by [liangkd] [2015-1-15]
	  * Midified by [修改人] [修改时间]
	  *
	  *@param userCname 用户名
	  * @return
	  */
	 public Map queryUserTableInfo(String userCname) throws Exception;

	 /**
	  * 
	  *
	  * <p>Description:[查询企业基本信息] </p>
	  * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	  * All right reserved.
	  * Created by [liangkd] [2015-1-21]
	  * Midified by [修改人] [修改时间]
	  *
	  * @param enterpriseId
	  * @return
	  * @throws Exception
	  */
	 public List queryQyBase(String enterpriseId) throws Exception;
	 
}
