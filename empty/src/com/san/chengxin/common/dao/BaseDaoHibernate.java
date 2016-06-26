package com.san.chengxin.common.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.chengxin.common.dao.Dao;

/**
 * 基础Dao实现
 * @author shmilyLT
 *
 */
public class BaseDaoHibernate extends HibernateDaoSupport implements Dao {
    protected final Log log = LogFactory.getLog(getClass());
    
    /**
     * 添加对象
     * @param object 实体类
     * @throws Exception 
     */
    public void saveObject(Object object)  throws Exception {
        String entityName = getEntityName(object);
        getHibernateTemplate().save(entityName,object);
    }

    /**
     * 更新对象
     * @param object 实体对象
     * @throws Exception
     */
    public void updateObject(Object object) {
         String entityName = getEntityName(object);
         getHibernateTemplate().update(entityName,object);
    }
    
    /**
     * 删除对象
     * @param clazz 实体类
     * @param id 主键
     * @throws Exception
     */
    public void removeObject(Class clazz, Serializable id) {
        getHibernateTemplate().delete(getObject(clazz, id));
    }
    
    
    /**
     * 通过传入hql语句进行批量更新对象
     * @param hqlStr HQL语句
     * @throws Exception
     */
    public void updateObjects(String hqlStr) throws Exception {
        Session session = null;
        
        try{
           session = getHibernateTemplate().getSessionFactory().openSession();
           
           Query query = session.createQuery(hqlStr);
           query.executeUpdate();
           
           
        }catch(Exception ex){
            
            throw new RuntimeException("" + ex);
            
        }finally{
            
            closeResouce(session);
        }
        
    }
    
    /**
     * 获取单一对象
     * @param clazz 实体类
     * @param id 主键
     * @return
     */
    public Object getObject(Class clazz, Serializable id) {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null) {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    /**
     * 获取对象集
     * @param clazz 实体类
     * @return 对象集 
     */
    public List getObjects(Class clazz) {
        return getHibernateTemplate().loadAll(clazz);
    }

    
    /**
     * 通过传入hql语句获取记录集,并支持分页功能
     * @param hqlStr HQL语句
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsByHql(String hqlStr, int pageNo, int pageSize) throws Exception {
        List list = new ArrayList();
        Session session = null;
        try
        {
            session = getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery(hqlStr);
            query.setFirstResult(getFirstSize(pageNo,pageSize));
            query.setMaxResults(pageSize);
            list = query.list();
            return list;
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(ex + "");
        }
        finally
        {
            closeResouce(session);
        }
    }
    
    
    /**
     * 通过传入标准sql语句获取记录集
     * @param sqlStr SQL语句
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsBySql(String sqlStr) throws Exception {
        Session session = null;
        try
        {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
            return sqlQuery.list();
        }
        catch(HibernateException ex)
        { 
            throw new RuntimeException(" " + ex);
        }
        finally
        {
            closeResouce(session);
        }
    }
    
    
    /**
     * 通过传入标准sql语句获取记录集,并支持分页
     * @param sqlStr SQL语句
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsBySql(String sqlStr, int pageNo, int pageSize) throws Exception {
        Session session = null;
        try
        {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
            sqlQuery.setFirstResult(getFirstSize(pageNo,pageSize));
            sqlQuery.setMaxResults(pageSize);
            return sqlQuery.list();
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
        }
        finally
        {
            closeResouce(session);
        }
    }
        
    
    /**
     * 通过传入标准sql语句获取记录集行数
     * @param sqlStr SQL语句
     * @return 返回记录集数量
     * @throws Exception
     */
    public Integer getRsCountsBySql(String sqlStr) throws Exception {
        // TODO Auto-generated method stub
        Session session = null;
        Integer count = new Integer(0);
        try
        {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
            List list = sqlQuery.list();
            if(null != list && list.size() > 0)
            {
                count = new Integer((list.get(0)).toString());
            }
            return count;
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
            
        }
        finally
        {
            closeResouce(session);
        }
    }
    
    /**
     * 通过传入标准hql语句获取记录集行数
     * @param hqlStr HQL语句
     * @throws Exception
     */
    public Integer getRsCountsByHql(String hqlStr) throws Exception {
        // TODO Auto-generated method stub
        Session session = null;
        Integer count = new Integer(0);
        try
        {
            session = getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery(hqlStr);
            List list = query.list();
            if(null != list && list.size() > 0)
            {
                count = new Integer((list.get(0)).toString());
            }
            return count;
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
            
        }
        finally
        {
            closeResouce(session);
        }
    }
    
    /**
     * 通过传入hql语句获取记录集
     * @param hqlStr HQL语句
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsByHql(String hqlStr) throws Exception {
        return getHibernateTemplate().find(hqlStr);
        
    }
    
    
    /**
     * 批量删除数据
     * @param hqlStr HQL语句
     * @throws Exception
     */
    public void deleteStr(String hqlStr) throws Exception {
        Session session = null;
        try{
           session = getHibernateTemplate().getSessionFactory().openSession();
           Query query = session.createQuery(hqlStr);
           query.executeUpdate();
           
        }catch(Exception ex){
            
            throw new RuntimeException("" + ex);
            
        }finally{
            
            closeResouce(session);
        }

    }
    
    /**
     * 删除数据
     * @param object 实体对象
     */
    public void deletes(Object object) throws Exception {
    	try {
    		getHibernateTemplate().delete(object);
    	} catch (Exception e) {
			throw new RuntimeException("" + e);
		}
    }
    
    /**
     * 批量删除数据
     * @param list 实体集
     * @throws Exception 
     */
    public void deletes(List list) throws Exception {
    	try {
    		getHibernateTemplate().deleteAll(list);
    	} catch (Exception e) {
			throw new RuntimeException(""+e);
		}
    }
    
    
    /**
     * 关闭资源
     * @param object
     * @throws Exception
     */
    private void closeResouce(Object object) throws Exception {    
        if(null == object) return;
        
        if(object instanceof Connection){
            Connection conn = (Connection)object;
            conn.close();
        }else if(object instanceof Statement){
            Statement statement = (Statement)object;
            statement.close();
        }else if(object instanceof PreparedStatement){
            PreparedStatement prepared = (PreparedStatement)object;
            prepared.close();
        }else if(object instanceof ResultSet){
            ResultSet rs = (ResultSet)object;
            rs.close();
        }else if(object instanceof Session){
            Session session = (Session)object;
            session.close();
        }
        
    }

    /**
     * 获得实体对象名称
     * @param object 实体对象
     * @return
     */
    private String getEntityName (Object object){
        String entityName = new String("");
        try{
        Class objectClass = object.getClass();
        entityName = objectClass.getName();
        }catch(Exception ex){
            throw new RuntimeException("" + ex); 
        }
        return entityName;
    }
    
    /**
     * 保存或更新一个实体对象
     * @param object 实体对象
     * @throws Exception 异常信息
     */
    public void saveOrUpdate(Object object)  throws Exception {
    	getHibernateTemplate().saveOrUpdate(object);
    	
    }
    
    /**
     * 批量保存或更新数据
     * @param list 数据集
     * @throws Exception 异常信息
     */
    public void saveOrUpdate(List list) throws Exception {
    	Session session = getHibernateTemplate().getSessionFactory().openSession();
    	Transaction tran = session.beginTransaction();
    	getHibernateTemplate().saveOrUpdateAll(list);
    	tran.commit();
    }
    
    
    /**
     * 获得当前分页开始的记录数
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 当前分页开始记录数
     */
    private int getFirstSize(int pageNo,int pageSize){
        int firstSize = 0;
        firstSize = (pageNo -1) * pageSize;
        return firstSize;
    }
    
    
    public void updateSql (String sql) throws Exception{
    	
    	Session session = null;
    	Connection con=null;
    	Statement stat=null;
    	Transaction tran=null;
        try{
           session = getHibernateTemplate().getSessionFactory().openSession();
           tran=session.beginTransaction();
           tran.begin();
           con=session.connection();
           stat=con.createStatement();
           stat.execute(sql);
           tran.commit();
           
        }catch(Exception ex){
        	tran.rollback();
            throw new RuntimeException("" + ex);
        }finally{
            stat.close();
            con.close();
            session=null;
            //closeResouce(session);
        }
    }    
    /**
     * 调用存储过程信息
     * @param stroName
     * @throws Exception
     */
    public void getcallStor(String stroName,String parm) throws Exception{
    	 Session session = null;
    	 Connection conn=null;
    	 CallableStatement proc = null;
          try
          {
             session = getHibernateTemplate().getSessionFactory().openSession();
             conn=session.connection();
             proc = conn.prepareCall("{ call "+stroName+" }");
             if(null!=parm && !"".equals(parm)){
            	 proc.setString(0,parm);
             }
             proc.execute();
         }
         catch(HibernateException ex)
         { 
             throw new RuntimeException(" " + ex);
         }
         finally
         {
             closeResouce(session);
         }
    }
    
    //通过传入标准sql建立视图
    public void createView(String sqlStr) throws Exception {
        Session session = null;
        try
        {
            session = getHibernateTemplate().getSessionFactory().openSession();
//            Query query = session.createQuery(sqlStr);
//            query.executeUpdate();
            Connection conn;
            conn=session.connection();
            conn.createStatement().execute(sqlStr);
        }
        catch(HibernateException ex)
        {
            throw new RuntimeException(" " + ex);
        }
        finally
        {
            closeResouce(session);
        }
    }

	public void deletes(String hqlStr) throws Exception {
		Session session = null;
        try{
           session = getHibernateTemplate().getSessionFactory().openSession();
           Query query = session.createQuery(hqlStr);
           query.executeUpdate();
           
        }catch(Exception ex){
            
            throw new RuntimeException("" + ex);
            
        }finally{
            
            closeResouce(session);
        }
		
	}
}
