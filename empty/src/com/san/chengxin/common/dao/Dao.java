package com.san.chengxin.common.dao;

import java.util.List;
import java.io.Serializable;
/**
 * 基础Dao接口
 * @author shmilyLT
 *
 */
public interface Dao {

    /**
     * 获取对象集
     * @param clazz 实体类
     * @return 对象集
     */
    public List getObjects(Class clazz);
    
    /**
     * 获取单一对象
     * @param clazz 实体类
     * @param id 主键
     * @return
     */
    public Object getObject(Class clazz,Serializable id);
    
    /**
     * 添加对象
     * @param object 实体类
     * @throws Exception
     */
    public void saveObject(Object object) throws Exception;
    
    /**
     * 更新对象
     * @param object 实体对象
     * @throws Exception
     */
    public void updateObject(Object object) throws Exception;
    
    /**
     * 通过传入hql语句进行批量更新对象
     * @param hqlStr HQL语句
     * @throws Exception
     */
    public void updateObjects(String hqlStr) throws Exception;
    
    /**
     * 删除对象
     * @param clazz 实体类
     * @param id 主键
     * @throws Exception
     */
    public void removeObject(Class clazz, Serializable id) throws Exception;
    
    /**
     * 通过传入标准sql语句获取记录集
     * @param sqlStr SQL语句
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsBySql(String sqlStr) throws Exception;
    
    /**
     * 通过传入标准sql语句获取记录集,并支持分页
     * @param sqlStr SQL语句
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsBySql(String sqlStr,int pageNo,int pageSize) throws Exception;
    
    /**
     * 通过传入hql语句获取记录集,并支持分页功能
     * @param hqlStr HQL语句
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsByHql(String hqlStr,int pageNo,int pageSize) throws Exception;
    
    /**
     * 批量删除数据
     * @param hqlStr HQL语句
     * @throws Exception
     */
    public void deleteStr(String hqlStr) throws Exception;
    
    /**
     * 通过传入hql语句获取记录集
     * @param hqlStr HQL语句
     * @return 返回记录集
     * @throws Exception
     */
    public List getRsByHql(String hqlStr) throws Exception;
    
    /**
     * 通过传入标准sql语句获取记录集行数
     * @param sqlStr SQL语句
     * @return
     * @throws Exception
     */
    public Integer getRsCountsBySql(String sqlStr) throws Exception;
    
    /**
     * 通过传入标准hql语句获取记录集行数
     * @param hqlStr HQL语句
     * @return
     * @throws Exception
     */
    public Integer getRsCountsByHql(String hqlStr) throws Exception;
    
    /**
     * 删除数据
     * @param object 实体对象
     */
    public void deletes(Object object) throws Exception;
    
    /**
     * 保存或更新一个实体对象
     * @param object 实体对象
     * @throws Exception 异常信息
     */
    public void saveOrUpdate(Object object)  throws Exception;
    
    /**
     * 批量保存或更新数据
     * @param list 数据集
     * @throws Exception 异常信息
     */
    public void saveOrUpdate(List list) throws Exception;
    
    /**
     * 批量删除数据
     * @param list 实体集
     * @throws Exception 
     */
    public void deletes(List list) throws Exception;
    
    public void updateSql (String sql) throws Exception;
    /**
     * 调用存储过程信息
     * @param stroName
     * @throws Exception
     */
    public void getcallStor(String stroName,String parm) throws Exception;
    
    //创建视图
    public void createView(String sql) throws Exception;
    
}    

