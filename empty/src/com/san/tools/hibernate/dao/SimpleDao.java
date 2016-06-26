/*
 * 文件名：	SimpleDao.java
 * 功能：		以Hiberante作为持久层，对数据库进行CRUD操作，兼容Hibernate2.x版本
 * 创建日期：	2005-6-24
 * 作者：		盛海军
 * 版本：		0.1
 * 修订历史：	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */
package com.san.tools.hibernate.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.san.tools.collection.util.CollectionUtil;
import com.san.tools.hibernate.exception.DeleteException;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate.exception.InsertException;
import com.san.tools.hibernate.exception.UpdateException;
import com.san.tools.hibernate3.session.SessionManager;
import com.san.tools.string.StringUtil;


/**
 * 一个使用Hibernate作为数据持久层的基础DAO类
 */
/**
 *
 */
/**
 *
 */
public class SimpleDao implements IDao
{
    private String hiberanteConfigFile = null;

    private SessionManager sessionManager = null;

    public SimpleDao() {
        sessionManager = SessionManager.getInstance();
    }
    

    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#getConfig()
     */
    public Object getConfig()
    {
    	hiberanteConfigFile = "SessionFactoryBySpring";
        return hiberanteConfigFile;
    }

    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#delete(java.lang.Object)
     */
    public void delete(Object entity) throws DeleteException
    {
        Session session = null;
        Transaction transaction = null;
        hiberanteConfigFile = "SessionFactoryBySpring";

        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            transaction = SessionManager.beginTransaction(session);
            session.delete(entity);
            SessionManager.commitTransaction(transaction);
        }
        catch (HibernateException e)
        {
            if(transaction != null)
            {
                try
                {
                    transaction.rollback();
                }
                catch (HibernateException e1)
                {
                    throw new DeleteException(e);
                }
            }
            
            throw new DeleteException(e);
        }
        finally
        {
            closeSession(session);
        }
    }


    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#find(java.lang.String)
     */
    public List find(String query) throws FindException
    {
        List list = new ArrayList();
        Session session = null;
        hiberanteConfigFile = "SessionFactoryBySpring";

        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            list = session.createQuery(query).list();
        }
        catch (HibernateException e)
        {
        	e.printStackTrace();
            System.out.print("发生错误的详细信息是"+e);
            throw new FindException(e);
        }
        finally
        {
            closeSession(session);
        }

        return list;
    }
    
    
    /**
     * sql查询find
     */
    public List sqlfind(String query) throws FindException
    {
        List list = new ArrayList();
        Session session = null;
        hiberanteConfigFile = "SessionFactoryBySpring";

        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            list = session.createSQLQuery(query).list();
        }
        catch (HibernateException e)
        {
        	e.printStackTrace();
            System.out.print("发生错误的详细信息是"+e);
            throw new FindException(e);
        }
        finally
        {
            closeSession(session);
        }

        return list;
    }


    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#findAll(java.lang.Class)
     */
    public List findAll(Class clazz) throws FindException
    {
        String query = "from "+clazz.getName();
        return find(query);
    }


    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#findAll(java.lang.String)
     */
    public List findAll(String vo) throws FindException
    {
        List list = null;
        String query = "from " + vo;
        list = find(query);
        return list;
    }
    
    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#getCount(java.lang.Class, java.lang.String)
     */
    public long getCount(Class clazz, String condition) throws FindException
    {
    	//修改2009-7-7 在item后加入了一个逗号
        long count = 0;
        String query = "select count(*) from "+StringUtil.getSimpleName(clazz)
                      + "  item "+ condition;
        System.out.println("==========================="+query);
        List list = find(query);
        
        if(null != list && !list.isEmpty())
        {
            count = Long.parseLong(list.get(0).toString());
        }
        
        return count;
    }

    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#getCount(java.lang.String)
     */
    public long getCount(String hql) throws FindException
    {
        long count = 0;
        List list = null;
        list = find(hql);
        
        if(CollectionUtil.isValid(list))
        {
            count = list.size();
        }
        
        return count;
    }
    
    
    public long getCountFast(String voName) throws FindException
    {
        long count = 0;
        List list = null;
	       
        list = find("select count(item) from "+ voName +" item");
        count = ((Integer)list.iterator().next()).longValue();
        return count;
    }
    
    

    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#initialize(java.lang.Object)
     */
    public void initialize(Object obj) throws InitializationException
    {
        String config = obj.toString();
        hiberanteConfigFile = config;
        hiberanteConfigFile = "SessionFactoryBySpring";
        try
        {
            SessionManager.getInstance().initialize(config);
        }
        catch (HibernateException e)
        {
            throw new InitializationException(e);
        }

    }

    /**
     * 
     */
    /* (non-Javadoc)
     * @see com.san.tools.hibernate.dao.IDao#insert(java.lang.Object)
     */
    public void insert(Object entity) throws InsertException
    {
        Session session = null;
        Transaction transaction = null;
        hiberanteConfigFile = "SessionFactoryBySpring";
        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            transaction = SessionManager.beginTransaction(session);
            session.save(entity);
            SessionManager.commitTransaction(transaction);
        }
        catch (HibernateException e)
        {
            if(transaction != null)
            {
                try
                {
                    transaction.rollback();
                }
                catch (HibernateException e1)
                {
                    throw new InsertException(e);
                }
            }
            
            throw new InsertException(e);
        }
        finally
        {
            closeSession(session);
        }
    }

    /**
     * 
     */
    public void saveOrUpdate(Object entity) throws UpdateException
    {

        Session session = null;
        Transaction transaction = null;
        hiberanteConfigFile = "SessionFactoryBySpring";
        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            transaction = SessionManager.beginTransaction(session);
            session.saveOrUpdate(entity);
            SessionManager.commitTransaction(transaction);
        }
        catch (HibernateException e)
        {
            if(transaction != null)
            {
                try
                {
                    transaction.rollback();
                }
                catch (HibernateException e1)
                {
                    throw new UpdateException(e);
                }
            }
            
            throw new UpdateException(e);
        }
        finally
        {
            closeSession(session);
        }
    }

    /**
     * 
     */
    public void update(Object entity) throws UpdateException
    {
        Session session = null;
        Transaction transaction = null;
        hiberanteConfigFile = "SessionFactoryBySpring";
        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            transaction = SessionManager.beginTransaction(session);
            session.update(entity);
            SessionManager.commitTransaction(transaction);
        }
        catch (HibernateException e)
        {
            if(transaction != null)
            {
                try
                {
                    transaction.rollback();
                }
                catch (HibernateException e1)
                {
                    throw new UpdateException(e);
                }
            }
            
            throw new UpdateException(e);
        }
        finally
        {
            closeSession(session);
        }

    }

    
    /**
     * 更新密码 是加密以后的更新
     */
    public void md5update(String pwd,String cn) throws UpdateException
    {
        Session session = null;
        Transaction transaction = null;
        hiberanteConfigFile = "SessionFactoryBySpring";
        try
        {
            session = sessionManager.getSession(hiberanteConfigFile);
            transaction = SessionManager.beginTransaction(session);
            String sql="update SYS_USER set PWD=encrypt256('"+pwd+"') where cn='"+cn+"'";
            session.connection().createStatement().execute(sql);
            SessionManager.commitTransaction(transaction);
        }
        catch (HibernateException e)
        {
            if(transaction != null)
            {
                try
                {
                    transaction.rollback();
                }
                catch (HibernateException e1)
                {
                    throw new UpdateException(e);
                }
            }
            
            throw new UpdateException(e);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
            closeSession(session);
        }

    }

    
    
    
    /**
     * 关闭会话
     * @param session
     *      会话对象
     */
    private void closeSession(Session session)
    {
        try
        {
            SessionManager.closeSession(session);
        }
        catch (HibernateException e)
        {            
            e.printStackTrace();
        }
    }
}