/*
 * Finder.java
 * 功能：		通用的查询器类
 * 创建日期： 2005-3-25
 * 作者： 	盛海军
 * 版本：		0.1
 * 修订历史：
 * 			
 * 
 * 最后版本： 0.1
 **/
package com.san.tools.hibernate.finder;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.san.tools.hibernate.dao.SimpleDao;
import com.san.tools.hibernate.dao.IDao;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate3.session.SessionManager;
import com.san.tools.string.StringUtil;


/**
 * 一个查询类，可以根据传入的数据对象的clazz属性和条件进行查询，相对HibernateFinder的灵活性差一点，但使用更方便
 * 在传入查询条件时注意：所要查询的数据对象的别名统一用'item'
 */
public class Finder
{
    private IDao dao = null;         //数据访问对象
    private PageFinder pageFinder = new PageFinder();   //分页查询器
    private String configFile = "SessionFactoryBySpring";
    
    /**
     * 缺省构造函数
     *
     */
    public Finder()
    {
        dao = new SimpleDao();
        
        try
        {
            initialize();
        }
        catch (InitializationException e)
        {
            e.printStackTrace();
        }
    }
    
    public void initialize() throws InitializationException
    {
        try
        {
            dao.initialize(configFile);
        }
        catch (InitializationException e)
        {
            throw new InitializationException(e);
        }

    }
    /**
     * 构造函数
     * @param cfgFile
     *      hibernate配置文件名
     * @throws Exception
     */
    public Finder(String cfgFile)throws Exception
    {
        dao = new SimpleDao();
        configFile = cfgFile;
        initialize();
    }
    
    /**
     * 带参构造函数
     * @param baseDao
     *      DAO对象
     */
    public Finder(IDao baseDao)
    {
        dao = baseDao;
    }
    
    /**
     * 获取所有的数据对象
     * @param clazz
     *      需要查询的数据对象的类对象
     * @return
     *      数据对象列表
     * @throws Exception
     */
    public List findAll(Class clazz) throws Exception
    {
        List list = new ArrayList();
        String sqlClause = "";
        sqlClause = "from "+ StringUtil.getSimpleName(clazz);
        list = dao.find(sqlClause);
        
        return list;
    }
    
    /**
     * 分页无条件获取数据对象集
     * @param clazz
     *      需要获取的数据对象的类对象
     * @param pageNo
     *      页码
     * @param pageSize
     *      每页查询数量
     * @return
     *      List：数据对象列表
     * @throws Exception
     */
    public List findAll(Class clazz, int pageNo, int pageSize)
                        throws Exception
    {
        List list = new ArrayList();
        String sqlClause = "";
        sqlClause = "from "+StringUtil.getSimpleName(clazz);
        pageFinder.setPageNo(pageNo);
        pageFinder.setPageSize(pageSize);
        Session session = SessionManager.getInstance().getSession(configFile);
        try
        {
            list = pageFinder.find(session, sqlClause);
        }
        finally
        {
            SessionManager.closeSession(session);
        }
                
        return list;
    }
    
    /**
     * 根据传入的条件获取数据对象集
     * @param clazz
     *      需要查询的数据对象的类对象
     * @param condition
     *      查询条件，所要查询的数据对象的别名统一用'item'
     * @param orderProperty
     *      排序条件
     * @return
     *      数据对象列表
     * @throws Exception
     */
    public List find(Class clazz, String condition, String orderProperty)
                    throws Exception
    {
        List list = new ArrayList();
        String sqlClause = "";
        if(orderProperty == null)
        {
            orderProperty="";
        }
        sqlClause = "from "+StringUtil.getSimpleName(clazz)+ "  item "+condition + " "+ orderProperty;
        
        list = dao.find(sqlClause);
        
        return list;
    }
    
    /**
     * 根据传入的条件分页获取数据对象集
     * @param clazz
     *      需要查询的数据对象的类对象
     * @param condition
     *      查询条件，所要查询的数据对象的别名统一用'item'
     * @param orderProperty
     *      排序条件
     * @param pageNo
     *      页码
     * @param pageSize
     *      每页查询数量
     * @return
     *      数据对象列表
     *      
     * @throws Exception
     */
    public List find(Class clazz, String condition, String orderProperty, int pageNo, int pageSize)
                    throws Exception
    {
        List list =  new ArrayList();
        String sqlClause = "";
        if(orderProperty == null)
        {
            orderProperty="";
        }
        sqlClause = "from "+StringUtil.getSimpleName(clazz)+ "  item "+condition + " "+ orderProperty;
        pageFinder.setPageNo(pageNo);
        pageFinder.setPageSize(pageSize);
        Session session = SessionManager.getInstance().getSession(configFile);
        
        try
        {
            list = pageFinder.find(session, sqlClause);
        }
        finally
        {
            SessionManager.closeSession(session);
        }
        
        return list;
    }
    
    /**
     * 根据传入的HQL查询语句查询
     * @param HQL
     *      HQL查询语句
     * @return
     *      返回数据对象列表
     * @throws Exception
     */
    public List find(String HQL) throws Exception
    {
        List list = new ArrayList();
        list = dao.find(HQL);
        return list;
    }
    
    
    /**
     * 根据传入的HQL语句分页查询
     * @param HQL
     *      HQL查询语句
     * @param pageNo
     *      页码
     * @param pageSize
     *      每页数量
     * @return
     *      返回数据对象列表
     */
    public List find(String HQL, int pageNo, int pageSize) throws Exception
    {
        List list = new ArrayList();
        pageFinder.setPageNo(pageNo);
        pageFinder.setPageSize(pageSize);
        
        Session session = SessionManager.getInstance().getSession(configFile);
        try
        {
            list = pageFinder.find(session, HQL);
        }
        finally
        {
            SessionManager.closeSession(session);
        }
        return list;
    }
    /**
     * 获取符合条件的数据记录的数量
     * @param clazz
     *      需要查询的数据对象的类对象
     * @param condition
     *      查询条件，所要查询的数据对象的别名统一用'item'
     * @return
     *      Integer：返回数据记录数量
     * @throws Exception
     */
    public Integer getCount(Class clazz, String condition) throws Exception
    {
        Integer count = new Integer(0); 
        int i = 0;
        
        i = (int)dao.getCount(clazz, condition);        
        count = new Integer(i);
        
        return count;
    }
    
    /**
     * 根据查询语句获取记录集的数量
     * @param query
     *      查询语句
     * @return
     *      返回记录集的数量
     * @throws Exception
     */
    public Integer getCount(String query) throws Exception
    {
        Integer count = new Integer(0);
        int i = 0;
        i=(int)dao.getCount(query);
        count = new Integer(i);
        return count;
    }
    
    
    /**
     * 定制组合查询根据传入的条件获取数据对象集
     * @param clazz
     *      需要查询的数据对象的类对象
     * @param condition
     *      查询条件，所要查询的数据对象的别名统一用'item'
     * @param orderProperty
     *      排序条件
     * @return
     *      数据对象列表
     * @throws Exception
     */
    public List sqlfind(Class clazz, String sqlClause)
                    throws Exception
    {
        List list = new ArrayList();
        list = dao.sqlfind(sqlClause);
        
        return list;
    }
    
    /**
     * 保存对象
     * @param clazz
     * @return
     * @throws Exception
     */
    public void saveObject(Object clazz) throws Exception
    {
        dao.saveOrUpdate(clazz);
    }
}
