/*
 * 文件名：	HibernateFinder.java
 * 功能：		
 * 创建日期： 2004-11-18
 * 作者： 	盛海军
 * 版本：		0.1
 * 修订历史：
 * 			
 * 
 * 最后版本：
 * 
 * Copyright 2004 - Shanghai 30Wish Infomation Security Co. Ltd.
 * 
 */
package com.san.tools.hibernate3.finder;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.san.tools.collection.util.CollectionUtil;
import com.san.tools.hibernate.dao.SimpleDao;
import com.san.tools.hibernate.dao.IDao;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate3.session.SessionManager;
import com.san.tools.sql.SQLExpression;
import com.san.tools.sql.SQLOrderClause;

/**
 * 一个Hibernate查询类,可以根据数据对象名来获取数据，也可以自定HQL语句进行查询
 * 同时可以进行分页查询
 */
public class HibernateFinder
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HibernateFinder.class);

	private static final String DEFAULT_ALIAS = "item";
	private SQLExpression sqlExpression = new SQLExpression();		//where 字句构造器
	private SQLOrderClause orderClause = new SQLOrderClause();		//order by 子句构造器
	private String m_alias = DEFAULT_ALIAS;							//别名
	private String m_poName = null;									//持久对象的名称
	private String selector = null;
	private String countSelector = null;
	private int m_pageNo = 0;											//页码
	private int m_pageSize = 0;										//每页数量
	private String configFile = "SessionFactoryBySpring";
	private IDao dao = new SimpleDao();
	private PageFinder pageFinder = new PageFinder();
	
	/**
	 * 缺省构造函数
	 *
	 */
	public HibernateFinder()
	{
		try
		{
			dao.initialize(configFile);
		}
		catch (InitializationException e)
		{
			logger.error("OrderFinder() - 初始话Hibernate时发生错误！", e);
		}
	}
	
	/**
	 * 带参数的构造函数
	 * @param poname
	 * 		持久对象的类名
	 */
	public HibernateFinder(String poname)
	{
		try
		{
			dao.initialize(configFile);
		}
		catch (InitializationException e)
		{
			logger.error("OrderFinder() - 初始话Hibernate时发生错误！", e);
		}
		
		setPoName(poname);
	}
	/**
	 * 设置order by条件
	 * @param field
	 * 		字段名
	 */
	public void setOrderCondition(String field)
	{
		orderClause.clearCondition();
		orderClause.addOrderCondition(getAliasField(field));
	}
	/**
	 * 设定过滤条件
	 * @param field
	 * 		字段名
	 * @param value
	 * 		字段值，如果字段是字符串型的话，必须用单引号括起来
	 * @param compareOperator
	 * 		比较操作符
	 */
	public void setOrFilter(String field, String value, String compareOperator)
	{
		String operator = getCompareOperator(compareOperator);
		
		sqlExpression.orWhereClause(getAliasField(field), value, compareOperator);		
	}
	
	/**
	 * 
	 * @param field
	 * 		字段名
	 * @param value
	 * 		字段值，如果字段是字符串型的话，必须用单引号括起来
	 * @param compareOperator
	 * 		比较操作符
	 */
	public void setAndFilter(String field, String value, String compareOperator)
	{
		String operator = getCompareOperator(compareOperator);
		
		sqlExpression.andWhereClause(getAliasField(field), value, compareOperator);
	}
	

	/**
	 * 清空过滤器
	 * @return
	 * 		void
	 *
	 */
	public void clearFilter()
	{
		sqlExpression.clear();
	}
	
	/**
	 * 根据设定的条件查找数据对象
	 * @return
	 * 		List：数据对象的列表
	 */
	public List findVOs()
	{
		List list = new ArrayList();
		String sqlClause = selector + sqlExpression.getWhereClause() + " "  + orderClause.getOrderClause();
		
		try
		{
			list = dao.find(sqlClause);
		}
		catch (FindException e)
		{
			logger.error("findVOs() - 查询的时候发生错误！ : sqlClause = " + sqlClause, e);
		}
		
		return list;
	}

	public List findVOs(String select)
	{
		List list = new ArrayList();
		String sqlClause = select; //+ sqlExpression.getWhereClause() + " "  + orderClause.getOrderClause();
		
		try
		{
			list = dao.find(sqlClause);
		}
		catch (FindException e)
		{
			logger.error("findVOs() - 查询的时候发生错误！ : sqlClause = " + sqlClause, e);
		}
		
		return list;
	}
	
	
	/**
	 * 根据设定的条件分页查找数据对象
	 * @return
	 * 		List：数据对象的列表,查不到则返回空的列表
	 */
	public List findVOsPage()
	{
		List list = new ArrayList();
		String sqlClause = selector + sqlExpression.getWhereClause();
		pageFinder.setPageNo(m_pageNo);
		pageFinder.setPageSize(m_pageSize);
        
        Session session = null; 
        try
        {
            session = SessionManager.getInstance().getSession(configFile);
            list = pageFinder.find(session, sqlClause);
        }
        catch (HibernateException e)
        {
            logger.error("findVOsPage() - 查询的时候发生错误！",e);
        }
        finally
        {
            closeSession(session);
        }
		
		return list;
	}

	/**
     * @param session
     */
    private void closeSession(Session session)
    {
        try
        {
            SessionManager.closeSession(session);
        }
        catch(HibernateException e)
        {
            logger.error(e);
        }
    }

    /**
     * 
     * @param select
     * @return list
     */
	public List findVOsPage(String select)
	{
		List list = new ArrayList();
		String sqlClause = select + sqlExpression.getWhereClause();
		pageFinder.setPageNo(m_pageNo);
		pageFinder.setPageSize(m_pageSize);
        Session session = null;
        try
        {
            session = SessionManager.getInstance().getSession(configFile);
            list = pageFinder.find(session, sqlClause);
        }
        catch (HibernateException e)
        {
            logger.error("findVOsPage(String select = "+select+")",e);
        }
        finally
        {
            closeSession(session);
        }
		
		return list;
	}

	/**
	 * 根据条件获取订单数量
	 * @return
	 * 		订单数量
	 */
	public int getVOCount()
	{
		int count = 0;
		List list = null;
		String sqlClause = countSelector + sqlExpression.getWhereClause();
		try
		{
			list = dao.find(sqlClause);
			if(!list.isEmpty())
			{
				count = Integer.parseInt(list.get(0).toString().trim());
			}
		}
		catch (FindException e)
		{
			logger.error("getVOCount() - 获取记录数量时发生错误！ : String sqlClause = "
					+ sqlClause, e);
		}
        
		return count;
	}
    
    /**
     * 获取记录数
     * @param query
     * @return
     */
    public int getCount(String query)
    {
        int count = 0;
        List list = null;
        
        try
        {
            list = dao.find(query);
            
            if(CollectionUtil.isValid(list))
            {
                count = list.size();
            }
        }
        catch(FindException e)
        {
            logger.error("getCount() - 获取记录数量时发生错误！: String query = " + query, e);
        }
        
        return count;
    }
	/**
	 * 根据上一次的分页查询条件和参数查找下一页的数据对象列表
	 * @return
	 * 		List：数据对象的列表
	 */
	public List nextPage()
	{
		m_pageNo += 1;
		return findVOsPage();
	}
	
	/**
	 * 得到添加了别名后的字段名
	 * @param field
	 * 		字段名
	 * @return
	 * 		String：添加了别名后的字段名
	 */
	private String getAliasField(String field)
	{
		String aliasName = "";
		if(field==null || field.trim().length()<=0)
		{
			return null;
		}
		int lastIndex = field.lastIndexOf(".");
		//是否存在'.'
		if(lastIndex != -1)
		{
			field = field.substring(lastIndex);
		}
		
		aliasName = m_alias+"."+field;
		return aliasName;
	}
	/**
	 * 获取比较操作符
	 * @param compareOperator
	 * 		传入的比较操作符
	 * @return
	 * 		字符串型的比较操作符，如"=",">","like"等
	 */
	private String getCompareOperator(String compareOperator)
	{
		String operator = compareOperator;
		if(operator == null || operator.trim().length() <=0)
		{
			operator = "=";
		}
		return operator;
	}

	
	
	/**
	 * 设置分页查询时的页码
	 * @param pageNo The pageNo to set.
	 * @return
	 * 		void
	 */
	public void setPageNo(int pageNo)
	{
		this.m_pageNo = pageNo;
	}
	
	/**
	 * 设置分页查询时每页查询数量
	 * @param pageSize 
	 * 		The pageSize to set.
	 * @return
	 * 		 void
	 */
	public void setPageSize(int pageSize)
	{
		this.m_pageSize = pageSize;
	}

	/**
	 * 设置别名
	 * @param alias The alias to set.
	 * @return
	 * 		void
	 */
	public void setAlias(String alias)
	{
		this.m_alias = alias;
		if(this.m_poName != null && this.m_poName.trim().length() >0)
		{
			selector = " from " + this.m_poName + " as " + this.m_alias + " ";			
			countSelector = " select count(*) from " + m_poName + " as " + this.m_alias + " ";
		}
	}
	
	/**
	 * @param poName 
	 * 		持久对象的名称，在调用查找方法之前必须调用该方法
	 * @return
	 * 		void
	 */
	public void setPoName(String poName)
	{
		this.m_poName = poName;
		selector = " from " + poName + " as " + this.m_alias + " ";
		countSelector = " select count(*) from " + poName + " as " + this.m_alias + " ";
	}
	/**
	 * @return Returns the alias.
	 */
	public String getAlias()
	{
		return m_alias;
	}
}
