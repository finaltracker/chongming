/*
 * 文件名：	IDao.java
 * 功能：		数据访问对象接口
 * 创建日期：	2005-6-24
 * 作者：		盛海军
 * 版本：		0.1
 * 修订历史：	
 *
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */
package com.san.tools.hibernate.dao;

import java.util.List;

import com.san.tools.hibernate.exception.DeleteException;
import com.san.tools.hibernate.exception.FindException;
import com.san.tools.hibernate.exception.InitializationException;
import com.san.tools.hibernate.exception.InsertException;
import com.san.tools.hibernate.exception.UpdateException;

/**
 * 数据访问接口，完成CRUD操作
 */
public interface IDao
{
    /**
     * 初始化环境
     * @param obj
     *      包含配置信息的对象
     * @throws InitializationException
     */
    public void initialize(Object obj) throws InitializationException;
    
    /**
     * 获取配置信息
     * @return
     *      返回包含配置信息的对象，可以是配置文件名或其他
     */
    public Object getConfig();
    
    /**
     * 执行查询操作
     * @param query
     *      查询语句
     * @return
     *      返回List形式的数据集
     * @throws FindException
     */
    public List find(String query) throws FindException;
    
    /**
     * 获取所有clazz数据对象的记录
     * @param clazz
     *      需要查询的数据表对应的数据对象的Class
     * @return
     *      返回List形式的数据集
     * @throws FindException
     */
    public List findAll(Class clazz) throws FindException;
    
    /**
     * 获取所有名称为VoName的数据对象的记录
     * @param VoName
     *      数据对象名
     * @return
     *      返回List形式的数据集
     * @throws FindException
     */
    public List findAll(String VoName) throws FindException;
    
    /**
     * 更新数据
     * @param entity
     *      被更新的数据记录
     * @throws UpdateException
     *      如果更新失败则抛出该异常
     */
    public void update(Object entity) throws UpdateException;
    
    /**
     * 删除数据记录
     * @param entity
     *      被删除的数据记录对象
     * @throws DeleteException
     *      如果删除失败则抛出该异常
     */
    public void delete(Object entity) throws DeleteException;
    
    /**
     * 插入数据记录
     * @param entity
     *      被插入的数据记录对象
     * @throws InsertException
     *      如果插入失败则抛出该异常
     */
    public void insert(Object entity) throws InsertException;
    
    /**
     * 插入或更新记录
     * @param entity
     *      被操作的数据记录对象
     * 
     * @throws UpdateException
     */
    public void saveOrUpdate(Object entity) throws UpdateException;
        

    /**
     * @param clazz
     * @param condition
     * @return long
     * @throws FindException
     */
    public long getCount(Class clazz, String condition) throws FindException;
    
    /**
     * 获取数据集的大小
     * @param query
     *      查询语句
     * @return
     *      返回数据集的大小，为长整型
     * @throws FindException
     *      如果获取失败则抛出该异常
     */
    public long getCount(String query) throws FindException;
    
    public long getCountFast(String VoName) throws FindException;
    
    
    //2009-2-11新加方法
    /**
     * 更新密码 是加密以后的更新
     */
    public void md5update(String pwd,String cn) throws UpdateException;
    
    /**
     * sql查询find
     */
    public List sqlfind(String query) throws FindException;
    
}
