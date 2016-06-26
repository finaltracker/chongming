/**
 * 
 */
package com.san.orgdata.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.san.chengxin.common.dao.BaseDaoHibernate;
import com.san.orgdata.action.OrgDataAction;
import com.san.orgdata.dao.OrgDataDao;
import com.san.orgdata.model.vo.SysDataConfigVO;
import com.san.util.Util;

/**
 * 
 * <p>Title:[机构数据管理DAO实现类] </p>
 * <p>Description: [类功能描述]</p>
 * <p>Copyright© 2014 Shanghai 30wish Information Security Co.,Ltd.</p>
 * <p>All right reserved.</p>
 * 
 * @version 1.0 
 * Created by [liangkd] [2014-12-24] 
 * Midified by [修改人] [修改时间]
 * 
 */
public class OrgDataDaoImpl extends BaseDaoHibernate implements OrgDataDao {
	private static final Logger logger = Logger.getLogger(OrgDataDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.san.orgdata.service.OrgDataService#queryOrgData(java.lang.String)
	 */
	@Override
	public List querySysField(String dataType) throws Exception {


		StringBuffer sql = new StringBuffer();
		sql.append(" select t3.ouid, ");//--机构编码
		sql.append(" t3.ouname, ");//--机构名称
		sql.append(" t3.displayorder, ");
		sql.append(" t1.tableid, ");
		sql.append(" t1.cname tablename, ");
		sql.append(" t1.ywlb, ");//--业务类别('1登记类','2 管理类','3 监管类','4 资质类' )
		sql.append(" t1.sjlx, ");// --数据类型（1 自然人，0 法人）
		sql.append(" t1.kfdj, ");
		sql.append(" t1.shunx, ");
		sql.append(" t2.fieldid, ");//--字段编号
		sql.append(" t2.cname , ");//--字段中文名
		sql.append(" t2.ename, ");//表名
		sql.append(" t2.sfzj, ");//--是否主键
		sql.append(" t2.sfxs,");//是否显示
		sql.append(" t2.xsxx ");

		sql.append(" from sys_field t2, sys_table t1, sys_oulist t3 ");
		sql.append(" where t2.tableid = t1.tableid ");
		sql.append(" and t1.depid = t3.ouid ");
		sql.append(" and t1.lx = 'table' ");
		if(null != dataType && !"".equals(dataType))
			sql.append(" and t1.sjlx ='"+dataType+"' ");	
		sql.append(" order by t3.ouid,t1.shunx,t2.xsxx ");


		List list = this.getRsBySql(sql.toString()) ;


		List ListVO = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			SysDataConfigVO info = new SysDataConfigVO();
			Object[] obj = (Object[]) list.get(i);

			info.setOuid(null==obj[0]?"":obj[0].toString());
			info.setOuname(null==obj[1]?"":obj[1].toString());
			info.setDisplayorder(null==obj[2]?"":obj[2].toString());
			info.setTableid(null==obj[3]?"":obj[3].toString());

			info.setYwlb(null==obj[5]?"":obj[5].toString());
			info.setSjlx(null==obj[6]?"":obj[6].toString());
			info.setKfdj(null==obj[7]?"":obj[7].toString());
			info.setShunx(null==obj[8]?"":obj[8].toString());
			info.setFieldid(null==obj[9]?"":obj[9].toString());
			info.setCname(null==obj[10]?"":obj[10].toString());
			info.setEname(null==obj[11]?"":obj[11].toString());
			info.setSfzj(null==obj[12]?"":obj[12].toString());
			info.setSfxs(null==obj[13]?"":obj[13].toString());
			info.setXsxx(null==obj[14]?"":obj[14].toString());

			ListVO.add(info);
		}

		return ListVO;
	}

	@Override
	public List querySysTable(String dataType,String userCname) throws Exception {
		if(null == userCname)
			throw new Exception("参数用户名不能为空");

		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t3.ouid, ");//--机构编码
		sql.append(" t3.ouname, ");//--机构名称
		sql.append(" t3.displayorder, ");
		sql.append(" t1.tableid, ");
		sql.append(" t1.cname, ");
		sql.append(" t1.ywlb, ");//--业务类别('1登记类','2 管理类','3 监管类','4 资质类' )
		sql.append(" t1.sjlx, ");// --数据类型（1 自然人，0 法人）
		sql.append(" t1.kfdj, ");
		sql.append(" t1.shunx, ");
		sql.append(" t1.ename ");

		sql.append(" from  sys_table t1, sys_oulist t3 ,sys_table_user t2");
		sql.append(" where t1.depid = t3.ouid ");
		sql.append(" and t1.tableid = t2.tableid ");
		sql.append(" and t1.lx = 'table' ");
		
		if(null != userCname && !"".equals(userCname))
			sql.append("and t2.usercn ='"+userCname+"'");
		 
		if(null != dataType && !"".equals(dataType))
			sql.append(" and t1.sjlx ='"+dataType+"' ");

		sql.append(" order by t3.ouid,t1.shunx ");

		List list = this.getRsBySql(sql.toString()) ;
		List ListVO = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			SysDataConfigVO info = new SysDataConfigVO();
			Object[] obj = (Object[]) list.get(i);

			info.setOuid(null==obj[0]?"":obj[0].toString());
			info.setOuname(null==obj[1]?"":obj[1].toString());
			info.setDisplayorder(null==obj[2]?"":obj[2].toString());
			info.setTableid(null==obj[3]?"":obj[3].toString());
			info.setCname(null==obj[4]?"":obj[4].toString());
			info.setYwlb(null==obj[5]?"":obj[5].toString());
			info.setSjlx(null==obj[6]?"":obj[6].toString());
			info.setKfdj(null==obj[7]?"":obj[7].toString());
			info.setShunx(null==obj[8]?"":obj[8].toString());
			info.setEname(null==obj[9]?"":obj[9].toString());

			ListVO.add(info);
		}

		return ListVO;
	}

	@Override
	public List querySysTable(String dataType) throws Exception {

		
		StringBuffer sql = new StringBuffer();
		sql.append(" select t3.ouid, ");//--机构编码
		sql.append(" t3.ouname, ");//--机构名称
		sql.append(" t3.displayorder, ");
		sql.append(" t1.tableid, ");
		sql.append(" t1.cname, ");
		sql.append(" t1.ywlb, ");//--业务类别('1登记类','2 管理类','3 监管类','4 资质类' )
		sql.append(" t1.sjlx, ");// --数据类型（1 自然人，0 法人）
		sql.append(" t1.kfdj, ");
		sql.append(" t1.shunx, ");
		sql.append(" t1.ename ");

		sql.append(" from  sys_table t1, sys_oulist t3 ");
		sql.append(" where t1.depid = t3.ouid ");	
		sql.append(" and t1.lx = 'table' ");	
		 
		if(null != dataType && !"".equals(dataType))
			sql.append(" and t1.sjlx ='"+dataType+"' ");

		sql.append(" order by t3.ouid,t1.shunx ");

		List list = this.getRsBySql(sql.toString()) ;
		List ListVO = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			SysDataConfigVO info = new SysDataConfigVO();
			Object[] obj = (Object[]) list.get(i);

			info.setOuid(null==obj[0]?"":obj[0].toString());
			info.setOuname(null==obj[1]?"":obj[1].toString());
			info.setDisplayorder(null==obj[2]?"":obj[2].toString());
			info.setTableid(null==obj[3]?"":obj[3].toString());
			info.setCname(null==obj[4]?"":obj[4].toString());
			info.setYwlb(null==obj[5]?"":obj[5].toString());
			info.setSjlx(null==obj[6]?"":obj[6].toString());
			info.setKfdj(null==obj[7]?"":obj[7].toString());
			info.setShunx(null==obj[8]?"":obj[8].toString());
			info.setEname(null==obj[9]?"":obj[9].toString());

			ListVO.add(info);
		}

		return ListVO;
	}
	
	@Override
	public List querySysTableData(String sql) throws Exception {
		List list = this.getRsBySql(sql.toString()) ;
		return list;
	}

	@Override
	public Map queryUserTableInfo(String userCname)  throws Exception{
		if(null == userCname)
			throw new Exception("参数用户名不能为空");

		String sql = "select tableid from SYS_TABLE_USER t where t.usercn ='"+userCname+"'";

		List list = this.getRsBySql(sql.toString());
		Map tbidMap = new HashMap();

		for (int i = 0; i < list.size(); i++) {
			String tableId = (String)list.get(i);
			tbidMap.put(tableId,tableId);
		}
		return tbidMap;
	}

	@Override
	public void saveUserTableInfo(String[] tableId, String userCname)  throws Exception{
		if(null == userCname || "".equals(userCname))
			throw new Exception("参数用户名不能为空");

		//先删除
		String sql = "delete from sys_table_user t where t.usercn ='"+userCname+"'";
		this.updateSql(sql);
		//后增加
		for (int i = 0; i < tableId.length; i++) {
			String tId = (String)tableId[i];
			String sql1 = "insert into sys_table_user (tableid, usercn) values ('"+tId+"', '"+userCname+"')";

			this.updateSql(sql1);

		}

	}

	@Override
	public List queryQyBase(String enterpriseId) throws Exception {
		
		if(null == enterpriseId || "".equals(enterpriseId))
			throw new Exception("参数企业id不能为空");
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select qymc,zzjgdm,gszch,frdbxm from hzcx_qy_base t   where 1=1 ");
		sql.append("  and enterprise_id = '"+enterpriseId+"'");
		
		return this.getRsBySql(sql.toString());
	}

}
