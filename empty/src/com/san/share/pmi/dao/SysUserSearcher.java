/*
 * 文件名：	SysUserSearcher.java
 * 功能：		
 * 创建日期：	${date}
 * 作者：		${author}
 * 版本：		0.1
 * 修订历史：	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */

package com.san.share.pmi.dao;

import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.san.tools.hibernate.finder.Finder;
import com.san.tools.string.StringUtil;
import com.san.tools.hibernate.exception.FindException;
import com.san.share.pmi.SysUser;

/**
 *
 *
 */
public class SysUserSearcher
{
    private static final Logger logger = Logger.getLogger(SysUserSearcher.class);

    private static Finder       finder = new Finder();      //查询器

	/**
	 *缺省构造函数
	 *
	 */
    public SysUserSearcher()
    {

    }

    /**
     * 根据条件查询
     * @param queryCondition
     *		查询条件
     * @return
     *		List：数据对象列表
     * @throws FindException
     */
    public static List findSysUserByCondition(String queryCondition) throws FindException
    {
        List list = new ArrayList();

        try
        {
            list = finder.find(SysUser.class, queryCondition, "");
        }
        catch (Exception e)
        {
            logger.error("错误发生在:findSysUserByCondition(queryCondition = " + queryCondition + ")", e);
            throw new FindException(e);
        }

        return list;
    }


    /**
     * 根据条件分页查询
     * @param queryCondition
     *		查询条件
     * @param pageNo
     *		页码
     * @param pageSize
     *		每页数量
     * @return
     *		List：数据对象列表
     * @throws FindException
     */
    public static List findSysUserByCondition(String queryCondition, int pageNo, int pageSize) throws FindException
    {
        List list = new ArrayList();

        try
        {       
            list = finder.find(SysUser.class, queryCondition, "", pageNo,pageSize);
        }
        catch (Exception e)
        {
            logger.error("错误发生在:findSysUserByCondition(queryCondition = "
                    + queryCondition + ")", e);
            throw new FindException(e);
        }

        return list;
    }

    /**
     * 根据主键获取
     * @param id
     *		主键
     * @return
     * 		{class.ValueObjectClassName}：数据对象
     * @throws FindException
     */
    public static SysUser findSysUserByPK(String id) throws FindException
    {
        SysUser sysUser = null;
        
        String hqlClause = "where item." + SysUser.PROP_ID + " = " + StringUtil.quoteString(id);

        try
        {        
            List list = finder.find(SysUser.class, hqlClause, "");

            if (list != null && !list.isEmpty())
            {
                sysUser = (SysUser) list.get(0);
            }
        }
        catch (Exception e)
        {
            logger.error("错误发生在:find{class.ValueObjectClassName}ByPK(id = " + id + ")", e);
            throw new FindException(e);
        }

        return sysUser;
    }

    
    /**
     * 后去加密以后的信息
     * 根据主键获取
     * @param id
     *		主键
     * @return
     * 		{class.ValueObjectClassName}：数据对象
     * @throws FindException
     */
    public static SysUser md5findSysUserByPK(String id) throws FindException
    {
        SysUser sysUser = null;
        
        String hqlClause = "select CN,SN,O,OU,EMAIL,PUBLICKEY,USER_STATUS,decrypt256(PWD)," +
        		"CREATEPOSITION,DISPLAYORDER,CREATEDATE from SYS_USER where cn = " + StringUtil.quoteString(id);
        try
        {        
            List list = finder.sqlfind(SysUser.class,hqlClause);

            if (list != null && !list.isEmpty())
            {
            	sysUser=new SysUser();
            	Object []ob=(Object[]) list.get(0);
                sysUser.setId(ob[0].toString());
                sysUser.setSn(ob[1].toString());
                sysUser.setO(ob[2].toString());
                sysUser.setOu(ob[3].toString());
                sysUser.setPwd(ob[7].toString());
                sysUser.setUserStatus(new Integer(ob[6].toString()).intValue());
            }
        }
        catch (Exception e)
        {
            logger.error("错误发生在:find{class.ValueObjectClassName}ByPK(id = " + id + ")", e);
            throw new FindException(e);
        }

        return sysUser;
    }

    /**
     * 获取符合条件的记录数
     * @param queryCondition
     *		查询条件
     * @return
     *		int：记录数
     * @throws FindException
     */
    public static int getQueryCount(String queryCondition) throws FindException
    {
        int count = 0;
        try
        {       
            count = finder.getCount(SysUser.class, queryCondition).intValue();
        }
        catch (Exception e)
        {
            logger.error("错误发生在:getQueryCount(queryCondition = " + queryCondition + ")", e);        	
            throw new FindException(e);
        }
        
        return count;
    }

    /**
     * 保存记录信息
     * @param clazz
     * @throws Exception
     */
    public static void saveObject (Object clazz) throws Exception{
    	finder.saveObject(clazz);
    }
    /**
     * 查询数据
     * @param clazz
     * @throws Exception
     */
    public static List finderListinfo (String hql) throws Exception{
    	List list=finder.find(hql);
    	return list;
    }
}
