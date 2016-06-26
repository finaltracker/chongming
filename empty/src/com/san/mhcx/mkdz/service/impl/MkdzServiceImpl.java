package com.san.mhcx.mkdz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.san.mhcx.mkdz.dao.IMkdzDao;
import com.san.mhcx.mkdz.service.IMkdzService;


public class MkdzServiceImpl implements IMkdzService{

	private IMkdzDao dao;
	public IMkdzDao getDao() {
		return dao;
	}

	public void setDao(IMkdzDao dao) {
		this.dao = dao;
	}
	
	/**
	 * ͨ���� 通过企业编号查询企业信息
	 * @param enterpriseId
	 * @return
	 * @throws Exception
	 */
	public List getMkdzById(String mkId) throws Exception {
		
		String hql=" from TMkdzInfo where mkId='"+mkId+"'";
		
		return dao.getRsByHql(hql);
	}
	/**
	 * 保存到数据库
	 * @param obj
	 * @throws Exception
	 */
	public void addObject(Object obj) throws Exception {
		dao.saveObject(obj);
		
	}
	/**
	 * 查找企业信息
	 * @param enterpriseName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List mkdzInfo(String mkName,String zt,String jflx ,int pageNo, int pageSize) throws Exception {
		String hql=" from TMkdzInfo where 1=1 ";
		
		if(mkName != null && !"".equals(mkName)){
			hql+="and mkName like '%"+mkName+"%' ";
		}

		if(zt != null && !"".equals(zt)){
			hql+="and zt like '%"+zt+"%' ";
		}
		if(jflx != null && !"".equals(jflx)){
			hql+="and jflx like '%"+jflx+"%' ";
		}
		List list=dao.getRsByHql(hql,pageNo,pageSize);
		return list;
	}
	/**
	 * 查出企业的条数
	 * @param enterpriseName
	 * @return
	 * @throws Exception
	 */
	public int mkdzInfoCount(String mkName , String zt , String jflx) throws Exception {
		String hql=" from TMkdzInfo where 1=1 ";
		
		if(mkName != null && !"".equals(mkName)){
			hql+="and mkName like '%"+mkName+"%' ";
		}
		if(zt != null && !"".equals(zt)){
			hql+="and zt like '%"+zt+"%' ";
		}
		if(jflx != null && !"".equals(jflx)){
			hql+="and jflx like '%"+jflx+"%' ";
		}
		List list=dao.getRsByHql(hql);
		int i=list.size();
		return i;
	}
	/**
	 * 修改
	 * @param obj
	 * @throws Exception
	 */
	public void updateObject(Object obj) throws Exception {
		dao.updateObject(obj);
	}
	
	/**
	 * 根据编号删除企业信息
	 * @param enterpriseId
	 * @throws Exception
	 */
	public void deleteMkdzInfo(String mkId) throws Exception {
		String hql=" delete from TMkdzInfo where mkId='"+mkId+"'";
		dao.deleteStr(hql );
		
//		String sql="delete T_MKDZ_INFO where mk_id='"+mkId+"'";
//		dao.updateSql(sql);
	}

	@Override
	public int mkdzInfoCount(String mkName) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List queryMkdzInfo(String mkType) throws Exception {
		String hql=" from TMkdzInfo where MK_TYPE='"+mkType+"' and ZT = '1'";
		return dao.getRsByHql(hql);
	}
}
