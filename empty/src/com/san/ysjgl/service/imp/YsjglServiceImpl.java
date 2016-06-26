package com.san.ysjgl.service.imp;

import com.san.util.Vo;
import com.san.ysjgl.dao.YsjglDao;
import com.san.ysjgl.service.YsjglService;

public class YsjglServiceImpl implements YsjglService {
	private YsjglDao dao;
	public YsjglDao getDao() {
		return dao;
	}

	public void setDao(YsjglDao dao) {
		this.dao = dao;
	}
	
	public boolean add(Object obj){
		boolean b=true;
		try {
			dao.saveObject(obj);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	public boolean update(Object obj){
		boolean b=true;
		try {
			dao.updateObject(obj);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	public Vo getHQL(int page, int rows, String hql) {
		Vo v=new Vo();	
			try {
				if(page==0 && rows==0){
					v.setList(dao.getRsByHql(hql));
				}else{
					v.setList(dao.getRsByHql(hql,page,rows));
				}
				v.setPageCount(dao.getRsByHql(hql).size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		return v;
	}
	public Vo getSQL(int page, int rows, String sql) {	
		Vo v=new Vo();	
		try {
			if(page==0 && rows==0){
				v.setList(dao.getRsBySql(sql));
			}else{
				v.setList(dao.getRsBySql(sql,page,rows));
			}
			v.setPageCount(dao.getRsBySql(sql).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	/**
	 * 不查询总条数
	 */
	public Vo getSQL_2(int page, int rows, String sql) {	
		Vo v=new Vo();	
		try {
			v.setList(dao.getRsBySql(sql,page,rows));
			//v.setPageCount(dao.getRsBySql(sql).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
public Vo getHQL(String hql) {
		Vo v=new Vo();	
		try {
			v.setList(dao.getRsByHql(hql));
			v.setPageCount(v.getList().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	return v;
}
public Vo getSQL(String sql) {	
	Vo v=new Vo();	
	try {
		v.setList(dao.getRsBySql(sql));
		v.setPageCount(v.getList().size());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return v;
}
	

	public boolean exedeleteSQL(String hql){
		boolean b=true;
		try {
		System.out.println("---------------"+hql);
		dao.updateSql(hql);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}	
			
		return b;
	}
}
