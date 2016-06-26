package com.logServices.zqs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.logServices.zqs.dao.PerformInfoDao;
import com.logServices.zqs.model.PerformaceStatisInfo;
import com.logServices.zqs.util.MyUtil;
import com.san.chengxin.common.dao.hibernate.BaseDaoHibernate;
import com.san.jingtai.model.JingTaiLogInfo;
import com.san.jingtai.util.DateFormatUtil;

public class PerformInfoDaoImpl extends BaseDaoHibernate implements PerformInfoDao{
	
	
	//工具类
	MyUtil myutil = new MyUtil();
	DateFormatUtil dateUtil = new DateFormatUtil();
	
	
	public List<PerformaceStatisInfo> getListAll(String sql, int pageNo, int pageSize) {
        Session session = null;
        try
        {	
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlquery = session.createSQLQuery(sql);
            sqlquery.setFirstResult(myutil.getFirstSize(pageNo,pageSize));
            sqlquery.setMaxResults(pageSize);
            List tempList = sqlquery.list();
            return null!=tempList & tempList.size()>0 ?  tempList : null;
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

	public List<PerformaceStatisInfo> getListDetail(String sql, int pageNo, int pageSize) {
		Session session = null;
        try
        {	
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlquery = session.createSQLQuery(sql);
            sqlquery.setFirstResult(myutil.getFirstSize(pageNo,pageSize));
            sqlquery.setMaxResults(pageSize);
            List tempList = sqlquery.list();
            return null!=tempList & tempList.size()>0 ?  tempList : null;
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

	public int updatePerInfo(String sql) {
		Session session = null;
        try
        {	
        	int i = -1;
        	session = getHibernateTemplate().getSessionFactory().openSession();
        	Query query = session.createQuery(sql);
            i = query.executeUpdate();
	        return i;
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

	public int vailDatePerInfo(String sql) {
		Session session = null;
        try
        {	
        	int i = -1;
	        session = getHibernateTemplate().getSessionFactory().openSession();
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        List listTemp = sqlQuery.list();
	        if((null!=listTemp) && (listTemp.size()>0)){
	        	String s = listTemp.get(0).toString();
	        	i = Integer.valueOf(s);
	        }
	        return i;
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
	
	
	
	
	//获取总数
	public int queryPerInfo(String sql) {
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

	public List<PerformaceStatisInfo> queryUserNames(String sql) {
		Session session = null;
        try
        {	
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlquery = session.createSQLQuery(sql);
            List tempList = sqlquery.list();
            return null!=tempList & tempList.size()>0 ?  tempList : null;
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

	public List<PerformaceStatisInfo> queryInfopu(String sql) {
		Session session = null;
        try
        {	
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlquery = session.createSQLQuery(sql);
            List tempList = sqlquery.list();
            return null!=tempList & tempList.size()>0 ?  tempList : null;
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

	public String vailJingPerInfo(String sql) {
		Session session = null;
        try
        {	
        	String str = "";
	        session = getHibernateTemplate().getSessionFactory().openSession();
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        List listTemp = sqlQuery.list();
	        if((null!=listTemp) && (listTemp.size()>0)){
	        	str = listTemp.get(0).toString();
	        }
	        return str;
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

	public String vaildateImpPerInfo(String sql) {
		Session session = null;
        try
        {	
        	String str = "";
	        session = getHibernateTemplate().getSessionFactory().openSession();
	        SQLQuery sqlQuery = session.createSQLQuery(sql);
	        List listTemp = sqlQuery.list();
	        if((null!=listTemp) && (listTemp.size()>0)){
	        	str = listTemp.get(0).toString();
	        }
	        return str;
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
}
