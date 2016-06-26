/*
 * �ļ�����	SysUserSearcher.java
 * ���ܣ�		
 * �������ڣ�	${date}
 * ���ߣ�		${author}
 * �汾��		0.1
 * �޶���ʷ��	
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

    private static Finder       finder = new Finder();      //��ѯ��

	/**
	 *ȱʡ���캯��
	 *
	 */
    public SysUserSearcher()
    {

    }

    /**
     * ����������ѯ
     * @param queryCondition
     *		��ѯ����
     * @return
     *		List�����ݶ����б�
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
            logger.error("��������:findSysUserByCondition(queryCondition = " + queryCondition + ")", e);
            throw new FindException(e);
        }

        return list;
    }


    /**
     * ����������ҳ��ѯ
     * @param queryCondition
     *		��ѯ����
     * @param pageNo
     *		ҳ��
     * @param pageSize
     *		ÿҳ����
     * @return
     *		List�����ݶ����б�
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
            logger.error("��������:findSysUserByCondition(queryCondition = "
                    + queryCondition + ")", e);
            throw new FindException(e);
        }

        return list;
    }

    /**
     * ����������ȡ
     * @param id
     *		����
     * @return
     * 		{class.ValueObjectClassName}�����ݶ���
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
            logger.error("��������:find{class.ValueObjectClassName}ByPK(id = " + id + ")", e);
            throw new FindException(e);
        }

        return sysUser;
    }

    
    /**
     * ��ȥ�����Ժ����Ϣ
     * ����������ȡ
     * @param id
     *		����
     * @return
     * 		{class.ValueObjectClassName}�����ݶ���
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
            logger.error("��������:find{class.ValueObjectClassName}ByPK(id = " + id + ")", e);
            throw new FindException(e);
        }

        return sysUser;
    }

    /**
     * ��ȡ���������ļ�¼��
     * @param queryCondition
     *		��ѯ����
     * @return
     *		int����¼��
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
            logger.error("��������:getQueryCount(queryCondition = " + queryCondition + ")", e);        	
            throw new FindException(e);
        }
        
        return count;
    }

    /**
     * �����¼��Ϣ
     * @param clazz
     * @throws Exception
     */
    public static void saveObject (Object clazz) throws Exception{
    	finder.saveObject(clazz);
    }
    /**
     * ��ѯ����
     * @param clazz
     * @throws Exception
     */
    public static List finderListinfo (String hql) throws Exception{
    	List list=finder.find(hql);
    	return list;
    }
}
