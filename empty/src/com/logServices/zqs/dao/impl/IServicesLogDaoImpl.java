package com.logServices.zqs.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.logServices.zqs.dao.IServiceLogDao;
import com.logServices.zqs.util.MyUtil;
import com.san.chengxin.common.dao.hibernate.BaseDaoHibernate;
import com.san.jingtai.model.JingTaiLogInfo;
import com.san.jingtai.util.DateFormatUtil;
import com.san.share.ca.newtest;

public class IServicesLogDaoImpl extends BaseDaoHibernate implements IServiceLogDao{
	
	
	//工具类
	MyUtil myutil = new MyUtil();
	DateFormatUtil dateUtil = new DateFormatUtil();
	
	//查询语句
	public List<JingTaiLogInfo> queryListDao(String sql,int pageNo, int pageSize) {
		
		List<JingTaiLogInfo> list = new ArrayList<JingTaiLogInfo>();
        Session session = null;
        try
        {	
        	
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlquery = session.createSQLQuery(sql);
            sqlquery.setFirstResult(myutil.getFirstSize(pageNo,pageSize));
            sqlquery.setMaxResults(pageSize);
            List tempList = sqlquery.list();
            if((null != tempList)&&(tempList.size()>0)){
            	for(int i = 0; i<tempList.size(); i++){
            		JingTaiLogInfo ingInfo = new JingTaiLogInfo();
            		Object[] objects = (Object[])tempList.get(i);
            		if(null != objects && objects.length >0){
//            			//封装对象
            			ingInfo.setQu_name(String.valueOf(objects[0]));
            			ingInfo.setQu_condtition(String.valueOf(objects[1]));
            			ingInfo.setQu_date(dateUtil.parseStrToDate(String.valueOf(objects[2])));
            			ingInfo.setQu_state(String.valueOf(objects[3]).equals("0") ? "是" : "否");
            			ingInfo.setQu_type(String.valueOf(objects[4]).equals("0") ? "个人" : "法人");
            			ingInfo.setSys_id(String.valueOf(objects[5]));
            			ingInfo.setQu_dept(String.valueOf(objects[6]));
            			list.add(ingInfo);
            		}
            	}
            }
            return list;
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(ex + "");
        }
        finally
        {
            try {
            	myutil.closeSource(session);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	//获取总数
	public int queryCount(String sql) {
		Session session = null;
        try
        {
	        session = getHibernateTemplate().getSessionFactory().openSession();
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        return sqlQuery.list().size()>0 ? sqlQuery.list().size() : 0;
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
        }
        finally
        {
        	myutil.closeSource(session);
        }
	}
	
	
	//根据部门查用户
	public List queryDepart(String dept) {
		Session session = null;
		
        try
        {	
        	//联动查询
        	String sql = "select distinct(u.cn) from sys_oulist t join sys_user u on " +
        			"(select s.ouid from sys_oulist s where s.ouid=:dept) = u.ou";
	        session = getHibernateTemplate().getSessionFactory().openSession();
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        sqlQuery.setString("dept", !"".equals(dept) ? dept : "OuLi20070529174221891");
	        List listTemp = new ArrayList();
	        if((sqlQuery.list().size()>0) && (null!=sqlQuery.list())){
	        	List list = new ArrayList();
	        	list = sqlQuery.list();
	        	for(int i = 0; i<list.size(); i++){
	        		String obj = (String)list.get(i);
		        	listTemp.add(obj);
	        	}
	        }
	        return listTemp;
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
        }
        finally
        {
        	myutil.closeSource(session);
        }
	}
	
	
	public String pressDate(String str,String flag){
		return "";
	}
	

}
