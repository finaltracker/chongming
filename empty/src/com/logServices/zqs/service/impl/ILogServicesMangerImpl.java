package com.logServices.zqs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.logServices.zqs.dao.IServiceLogDao;
import com.logServices.zqs.services.ILogServicesManger;
import com.san.jingtai.model.JingTaiLogInfo;
import com.san.util.Vo;

public class ILogServicesMangerImpl implements ILogServicesManger{
	
	public IServiceLogDao ilogServicesdao;
	
	//查询内容
	public List<JingTaiLogInfo> getListLogInfoManager(String qu_name, String qu_state, String qu_type, 
			String startDate, String endDate, String depart, int pageNo, int pageSize) {
		List<JingTaiLogInfo> list = new ArrayList<JingTaiLogInfo>();
		try{
			StringBuffer buf=new StringBuffer("select t.qu_name, t.qu_condition, to_char(QU_DATE,'yyyy-MM-dd HH:mm:ss'), t.qu_state, t.qu_type, t.sys_id, t.qu_dept from l_jiantai_qu t where 1=1 ");
			
			
			if(qu_name != null && !"".equals(qu_name)){
				buf.append( "and t.qu_name like '%"+qu_name+"%' ");
			}
			if(qu_state != null && !"".equals(qu_state)){
				buf.append( "and t.qu_state = '"+qu_state+"' ");
			}
			if(qu_type != null && !"".equals(qu_type)){
				buf.append( "and t.qu_type = '"+qu_type+"' ");
			}
			if(startDate != null && !"".equals(startDate)){
				buf.append( "and t.qu_date >= to_date('" + startDate + "','yyyy-MM-dd') ");
			}
			if(endDate != null && !"".equals(endDate)){
				buf.append( "and t.qu_date <=  to_date('" + endDate + " 23:59:59','yyyy-MM-dd hh24:mi:ss') ");
			}
			buf.append("order by t.SYS_ID desc");
			list=ilogServicesdao.queryListDao(buf.toString(),pageNo,pageSize);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	//总数查询
	public int queryCountManager(String str, String qu_name, String qu_state, String qu_type, String startDate, String endDate, String depart) {
		int i = 0;
		try {
			//是否带条件查询(1:带条件查询，0：无条件查询）
			if("1".equals(str)){
				StringBuffer buf=new StringBuffer("select t.sys_id from l_jiantai_qu t where 1=1 ");
				if(qu_name != null && !"".equals(qu_name)){
					buf.append( "and t.qu_name like  '%"+qu_name+"%' ");
				}
				if(qu_state != null && !"".equals(qu_state)){
					buf.append( "and t.qu_state = '"+qu_state+"' ");
				}
				if(qu_type != null && !"".equals(qu_type)){
					buf.append( "and t.qu_type = '"+qu_type+"' ");
				}
				if(startDate != null && !"".equals(startDate)){
					buf.append( "and t.qu_date > to_date('" + startDate + "','yyyy-MM-dd')");
				}
				if(endDate != null && !"".equals(endDate)){
					buf.append( "and t.qu_date <  to_date('" + endDate + "','yyyy-MM-dd') ");
				}
				buf.append("order by t.SYS_ID desc");
				i = ilogServicesdao.queryCount(buf.toString());
			}
			else{
				StringBuffer buf=new StringBuffer("select t.sys_id from l_jiantai_qu t where 1=1 order by t.SYS_ID desc");
				i = ilogServicesdao.queryCount(buf.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public IServiceLogDao getIlogServicesdao() {
		return ilogServicesdao;
	}

	public void setIlogServicesdao(IServiceLogDao ilogServicesdao) {
		this.ilogServicesdao = ilogServicesdao;
	}



	public Vo getSQL(int page, int rows, String sql) {
		Vo v=new Vo();	
		try {
			if(page==0 && rows==0){
				v.setList(ilogServicesdao.getRsBySql(sql));
			}else{
				v.setList(ilogServicesdao.getRsBySql(sql,page,rows));
			}
			v.setPageCount(ilogServicesdao.getRsBySql(sql).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public List queryAdminManger(String dept) {
		// TODO Auto-generated method stub
		return ilogServicesdao.queryDepart(dept);
	}
	
}
