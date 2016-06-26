/*
 * 文件名：	PageFinder.java
 * 功能：		分页查询的辅助类
 * 创建日期： 2004-11-17
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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 分页查询的类
 *  
 */
public class PageFinder
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PageFinder.class);

	private int m_pageNo = 0;			//页码
	private int m_pageSize = 0;		//每页数量
	
	/**
	 * 查询
	 * @param session
	 * 		数据访问对象
	 * @param sqlClause
	 * 		查询语句
	 * @return
	 * 		List：与数据表对应的VO对象的列表
	 */
	public List find(Session session, String sqlClause)
	{
		List list = new ArrayList();
		Query query = null;
        
        if(session == null)
        {
            return list;
        }
		
		try
		{
			query = session.createQuery(sqlClause);
			query.setFirstResult(m_pageSize*(m_pageNo-1));
			query.setMaxResults(m_pageSize);
			list = query.list();
		}
		catch (HibernateException e)
		{
			logger.error("find(sqlClause = " + sqlClause + ") - 分页查询时发生错误！", e);
		}

		return list;
	}
	
	/**
	 * 设定页码
	 * @param pageNo
	 * 		页码
	 * @return
	 * 		void
	 */
	public void setPageNo(int pageNo)
	{
		this.m_pageNo = pageNo;
	}
	/**
	 * 设定每页查询数量
	 * @param pageSize 
	 * 		每页数量
	 * @return
	 * 		void
	 */
	public void setPageSize(int pageSize)
	{
		this.m_pageSize = pageSize;
	}
	
}
