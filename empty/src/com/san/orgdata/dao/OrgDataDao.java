/**
 * 
 */
package com.san.orgdata.dao;

import java.util.List;
import java.util.Map;

import com.san.chengxin.common.dao.Dao;

/**
 * 
 * <p>Title:[机构数据管理DAO接口] </p>
 * <p>Description: [机构信息配置数据查询、信用信息查询]</p>
 * <p>Copyright© 2014 Shanghai 30wish Information Security Co.,Ltd.</p>
 * <p>All right reserved.</p>
 * 
 * @version 1.0 
 * Created by [liangkd] [2014-12-24]
 * Midified by [修改人] [修改时间]
 * 
 */
public interface OrgDataDao extends Dao {
	/**
	 * 
	 * <p>Description:[表配置数据项查询] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2014-12-25]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param dataType 数据类型（1 自然人，0 法人），不传全查
	 * @return
	 * @throws Exception
	 */
	public List querySysField(String dataType) throws Exception;

	/**
	 *
	 * <p>Description:[部门业务表查询] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2014-12-26]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param dataType 数据类型（1 自然人，0 法人），不传全查
	 * @param userCname 
	 * @return
	 * @throws Exception
	 */
	public List querySysTable(String dataType, String userCname) throws Exception;
	public List querySysTable(String dataType) throws Exception;
	/**
	 *
	 * <p>Description:[单位、个人数据查询] </p>
	 * Copyright © 2015  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-4]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List querySysTableData(String sql) throws Exception;

	/**
	 *
	 * <p>Description:[查询用户配置显示信息] </p>
	 * Copyright © 2015  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-15]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param userCname
	 * @return
	 */
	public Map queryUserTableInfo(String userCname) throws Exception;

	/**
	 *
	 * <p>Description:[用户配置显示信息保存] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-15]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param tableId
	 * @param userCname
	 */
	public void saveUserTableInfo(String[] tableId, String userCname) throws Exception;

	/**
	 * 
	 *
	 * <p>Description:[查询企业基本库记录] </p>
	 * Copyright © 2014  Shanghai 30wish Information Security Co.,Ltd.
	 * All right reserved.
	 * Created by [liangkd] [2015-1-21]
	 * Midified by [修改人] [修改时间]
	 *
	 * @param enterpriseId
	 * @return
	 */
	public List queryQyBase(String enterpriseId) throws Exception ;


}
