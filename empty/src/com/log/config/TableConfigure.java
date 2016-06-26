/*
 * 文件名：	TableConfigure.java
 * 功能：		
 * 创建日期：	2005-7-28
 * 作者：		盛海军     
 * 版本：		0.1
 * 修订历史：	2005-11-02 王骁 添加方法 getBusinessKeyTableNameOfDept
 *			
 * Copyright 2005 - Shanghai 30wish Infomation Security Co. Ltd.
 */
package com.log.config; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.dom4j.Node;

import com.san.tools.collection.util.CollectionUtil;
import com.san.tools.string.StringUtil;
import com.san.tools.xml.config.ConfigFactory;

public class TableConfigure extends ConfigFactory
{
    /**
     * Logger for this class
     */
    
	
    private static final Logger logger = Logger.getLogger(TableConfigure.class);

    private static TableConfigure instance = null; 

    private static final String defaultConfig = "TableConfig.xml";

    private static final String ELEMENT_TIME_KEY = "time-key";
    private static final String ELEMENT_BUSINESS_KEYS = "business-keys";
    private static final String ELEMENT_BUSINESS_KEY = "business-key";
    private static final String ELEMENT_COMPARE_KEYS = "compare-keys";
    private static final String ELEMENT_COMPARE_KEY = "compare-key";
    private static final String ELEMENT_CODE_COLUMN = "codecolumn";
    private static final String ELEMENT_TABLE_ID = "id";
    private static final String ELEMENT_ROOT = "table-configuration";
    private static final String ELEMENT_TABLE = "table";
    private static final String ELEMENT_INPUT_PROPERTY = "input-properties";
    private static final String ELEMENT_INPUT_URL = "input-url";
    private static final String ELEMENT_INPUT_METHOD = "input-method";
    private static final String ELEMENT_INPUT_CYCLE = "input-cycle";
    private static final String ELEMENT_DESCRIPTION = "description";
    private static final String ELEMENT_BUSINESS_KEY_TABLE = "is-key-business-table";
    private static final String ELEMENT_CODE_ENTERID = "enterpriseid";
    private static final String ELEMENT_FIELDINFO = "fieldinfo";
    private static final String ELEMENT_FIELNAME = "fieldname";
    private static final String ATTRIBUTE_VALUE_OBJECT_CLASS = "@valueobject";
    private static final String ATTRIBUTE_COLUMN = "@column";
    private static final String ATTRIBUTE_FORMAT = "@format";
    private static final String ATTRIBUTE_SHORT_NAME = "@shortname";
    private static final String ATTRIBUTE_TIME_FORMAT ="@format";
    private static final String ATTRIBUTE_TIME_TYPE ="@type";
    private static final String ATTRIBUTE_NAME = "@name";
    private static final String ATTRIBUTE_Alias = "@alias";
    private static final String ATTRIBUTE_CHINESENAME = "@chinesename";
    private static final String TABLE_TYPE = "@tabletype";
    private static final String ELEMENT_LOGFLAG = "isLog";
    private static final String ATTRIBUTE_IS_KEY_BUSINESS_TABLE="is-key-business-table";
    private static final String prefix = ELEMENT_TABLE + "["+ATTRIBUTE_NAME+"=\"";
    private static final String suffix  = "\"]/";

    private static final String ATTRIBUTE_PROVIDE_DEPARTMENT = "@provide-department";
    private static final String ATTRIBUTE_IS_BUSINESS_TABLE = "@is-key-business-table";
    private static final String ELEMENT_ENTERPRISE_NAME = "enterprisename";
    
    protected TableConfigure() {
        super(defaultConfig);
    }

    /**
     * 单例模式，获取唯一TableConfigure实例
     */
    public static TableConfigure getInstance()
    {
        if (instance == null)
        {
            synchronized (TableConfigure.class)
            {
                instance = new TableConfigure();
            }
        }

        return instance;
    }

    public void refreshConfig()
    {
        //        super.
    }


    public List getBusinessKeyByTableName(String table)
    {
        List keyList = new ArrayList();
        String BusinessKey = null;
        String xPath = prefix + table + suffix + ELEMENT_BUSINESS_KEYS 
        + "/" + ELEMENT_BUSINESS_KEY; 
        List list = null;
        System.out.println("getBusinessKeyByTableName xPath" + xPath );
        list = getConfigNodeList(xPath); 
        
        if(CollectionUtil.isValid(list))
        {
            Iterator iter = list.iterator();
            if(null != iter)
            {
                Node node = null;
                while(iter.hasNext())
                {
                    node  = (Node)iter.next();
                    BusinessKey = node.getStringValue();
                    if(StringUtil.isValid(BusinessKey))
                    {
                        keyList.add(BusinessKey);
                    }
                }
            }
        }
        return keyList;
    }
    
    /**
     * 根据表名获取该表主键需要比较的字段名列表
     * @param table
     *      数据表名
     * @return
     * 如果存在则返回需要比较的字段名列表，否则返回空字符串
     * 
     */
    public List getCompareKeyByTableName(String table)
    {
        List keyList = new ArrayList();
        String compareKey = null;
        String xPath = prefix + table + suffix + ELEMENT_COMPARE_KEYS 
        + "/" + ELEMENT_COMPARE_KEY; 
        List list = null;
        System.out.println("getCompareKeyByTableName xPath" + xPath );
        list = getConfigNodeList(xPath); 
        
        if(CollectionUtil.isValid(list))
        {
            Iterator iter = list.iterator();
            if(null != iter)
            {
                Node node = null;
                while(iter.hasNext())
                {
                    node  = (Node)iter.next();
                    compareKey = node.getStringValue();
                    if(StringUtil.isValid(compareKey))
                    {
                        keyList.add(compareKey);
                    }
                }
            }
        }
        return keyList;
    }
    
    

    public String getEnterpriseNamebyTable(String table)
    {
        String enterpriseName = null;
        String xPath = prefix + table + suffix + ELEMENT_ENTERPRISE_NAME;
        enterpriseName = getConfig(xPath);
        if(!StringUtil.isValid(enterpriseName))
        {
            logger.warn("getEnterpriseNamebyTable(table = " + table
                    + ") - 数据表中的企业机构名称没有正确配置，请检查配置文件！", null);            
        }
        return enterpriseName;
    }  
    
    
    /**
     * 根据表名获取该表主键在数据对象中对应的属性名
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回主键对应的属性名，否则返回空字符串
     * 
     */
    public String getPKNameByTableName(String table)
    {
        String pkName = null;
        String xPath = prefix + table + suffix + ELEMENT_TABLE_ID;
        pkName = getConfig(xPath);
        
        if(!StringUtil.isValid(pkName))
        {
            logger.warn("getPKNameByTableName(tableName = " + table
                    + ") - 数据表对应的主键名没有正确配置，请查看配置文件！", null);
        }
        
        return pkName;
    }
    
    /**
     * 
     * @param table
     * @return
     */
    public String getPKFieldByTableName(String table)
    {
        String pkField = null;
        String xPath = prefix + table + suffix + ELEMENT_TABLE_ID + "/" + ATTRIBUTE_COLUMN;
        pkField = getConfig(xPath);
        
        if(!StringUtil.isValid(pkField))
        {
            logger.warn("getPKFieldByTableName(tableName = " + table
                    + ") - 数据表对应的主键名没有正确配置，请查看配置文件！", null);            
        }
        
        return pkField;
    }
    /**
     * 根据数据表名获取数据表的时间字段
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回时间字段名，否则返回空字符串
     */
    public String getTimeFieldbyTable(String table)
    {
        String timeField = null;
        String xPath = prefix + table +  suffix + ELEMENT_TIME_KEY;
        timeField = getConfig(xPath);
        
        if(!StringUtil.isValid(timeField))
        {
            logger.warn("getTimeFieldbyTable(table = " + table
                    + ") - 数据表的时间字段不存在或没有正确配置，请检查配置文件进行确认！", null);            
        }
        return timeField;
    }

    /**
     * 根据数据表名获取时间字段的格式，如yyyy或yyyyMM
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回时间格式，否则返回空字符串
     * 
     */
    public String getTimeFieldFormatbyTable(String table)
    {
        String timeFormat = null;
        String xPath = prefix + table + suffix + ELEMENT_TIME_KEY+"/"+ATTRIBUTE_FORMAT;

        timeFormat = getConfig(xPath);
        
        if(!StringUtil.isValid(timeFormat))
        {
            logger.warn("getTimeFieldFormatbyTable(table = " + table
                    + ") - 数据表的时间字段不存在或其时间格式没有正确配置，请检查配置文件进行确认！", null);
            
        }
        
        return timeFormat;
    }

    /**
     * 根据数据表名获取数据表中的时间字段的数据类型
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回时间字段的数据类型，否则返回空字符串
     *  
     */
    public String getTimeDataTypebyTable(String table)
    {
        String timeDataType = null;
        String xPath = prefix + table + suffix + ELEMENT_TIME_KEY 
                     + "/" + ATTRIBUTE_TIME_TYPE;
        
        
        
        timeDataType = getConfig(xPath);
        
        if(!StringUtil.isValid(timeDataType))
        {
            logger.warn("getTimeDataTypebyTable(table = " + table
                    + ") - 数据表的时间字段不存在或其时间字段类型没有正确配置，请检查配置文件进行确认！", null);            
        }
        
        return timeDataType;
    }
    

    

    /**
     * 根据数据表名获取数据表中企业机构代码字段名
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回企业机构代码字段名，否则返回null
     * 
     */
    public String getEnterpriseCodeColumnbyTable(String table)
    {
        String enterpriseCodeColumn = null;
        String xPath = prefix + table + suffix + ELEMENT_CODE_COLUMN;
        enterpriseCodeColumn = getConfig(xPath);
        if(!StringUtil.isValid(enterpriseCodeColumn))
        {
            logger.warn("getEnterpriseCodeColumnbyTable(table = " + table
                    + ") - 数据表中的企业机构代码字段没有正确配置，请检查配置文件！", null);            
        }
        return enterpriseCodeColumn;
    }
    
    /**
     * 根据数据表名获取数据表企业唯一标识号
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回企业唯一标识号，否则返回null
     * 
     */
    public String getEnterpriseIDbyTable(String table){
    	String enterpriseId = "";
        String xPath = prefix + table + suffix + ELEMENT_CODE_ENTERID;
        enterpriseId = getConfig(xPath);
        if(!StringUtil.isValid(enterpriseId))
        {
            logger.warn("getEnterpriseIDbyTable(table = " + table
                    + ") - 数据表中的企业唯一代码字段没有正确配置，请检查配置文件！", null);            
        }
    	return enterpriseId;
    }
    /**
     * 根据数据对象名反向查找数据表名
     * @param voName
     *      数据对象名
     * @return
     *      如果存在就返回数据表名，否则返回null
     * 
     */
    public String getTableNamebyVOName(String voName)
    {
        String tableName = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_SHORT_NAME + "=\""
                    + voName + "\"]/" + ATTRIBUTE_NAME;
        logger.debug("xPath+++++++++++++++++++++++++++++++++"+xPath);
        tableName = getConfig(xPath);
        logger.debug("tableName++++++++++++++++++++++++++"+tableName);
        
        if(!StringUtil.isValid(tableName))
        {
            logger.debug("getTableNamebyVOName(voName = " + voName
                    + ") - 所给数据表数据对象对应的数据表没有配置，请检查配置文件！", null);            
        }

        return tableName;
    }

    public String getIsbusniessKey(String voName){
    	String isOrno = "";
    	
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_SHORT_NAME + "=\""
        + voName + "\"]/" + ATTRIBUTE_IS_BUSINESS_TABLE;
        isOrno = getConfig(xPath);
        if(!StringUtil.isValid(isOrno))
        {
            logger.debug("getTableNamebyVOName(voName = " + voName
                    + ") - 所给数据表数据对象对应的数据表没有配置，请检查配置文件！", null);            
        }
    	return isOrno;
    }
    /**
     * 根据数据表名获取数据表的数据输入URL
     * @param table
     *      数据表名
     * @return
     *      可以进行数据输入的URL
     */
    public String getInputURLbyTable(String table)
    {
        String url = null;
        String xPath = prefix + table + suffix + ELEMENT_INPUT_PROPERTY 
                     + "/" + ELEMENT_INPUT_URL;
        url = getConfig(xPath);
        
        if(!StringUtil.isValid(url))
        {
            logger.warn("getInputURLbyTable(table = " + table
                    + ") - 数据表对应的输入地址没有配置，请查看配置文件！", null);
        }

        return url;
    }

    /**
     * 获取数据表的输入方式
     * @param table
     *      数据表名
     * @return
     *      如果配置存在，则根据配置返回相应的值，否则返回默认值
     *      
     */
    public Integer getInputMethodTable(String table)
    {
        Integer method = new Integer(1);
        String methodStr = null;
        String xPath = prefix + table + suffix + ELEMENT_INPUT_PROPERTY 
                    + "/" + ELEMENT_INPUT_METHOD;
        methodStr = getConfig(xPath);
        
        if(!StringUtil.isValid(methodStr))
        {
            logger.warn("getInputMethodTable(table = " + table
                    + ") - 数据表的输入方式没有配置，请查看配置文件！", null);
        }
        else
        {
            if(methodStr.equalsIgnoreCase("update"))
            {
                method = new Integer(0);
            }
        }

        return method;
    }

    /**
     * 获取数据表的数据周期
     * @param table
     *      数据表名
     * @return
     */
    public Integer getCyclebyTable(String table)
    {
        Integer tableCycle = new Integer(0);
        String cycleStr = null;
        String xPath = prefix + table + suffix + ELEMENT_INPUT_PROPERTY
                    + "/" + ELEMENT_INPUT_CYCLE;
        cycleStr = getConfig(xPath);
        
        if(!StringUtil.isValid(cycleStr))
        {
            logger.warn("getCyclebyTable(table = " + table
                    + ") - 数据表的数据周期没有正确配置，请查看配置！", null);
        }
        else
        {
            if (cycleStr.equalsIgnoreCase("year"))
            {
                tableCycle = new Integer(2);
            }
            else if (cycleStr.equalsIgnoreCase("month"))
            {
                tableCycle = new Integer(1);
            }
            else if (cycleStr.equalsIgnoreCase("realtime"))
            {
                tableCycle = new Integer(0);
            }

        }

        return tableCycle;
    }
    
    //根据类名获得VoName
    public String getVoNamebyVOCalssName(String vOCalssName)
    {
        String tableName = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_VALUE_OBJECT_CLASS + "=\""
                    + vOCalssName + "\"]/" + ATTRIBUTE_SHORT_NAME;
        logger.debug("xPath+++++++++++++++++++++++++++++++++"+xPath);
        tableName = getConfig(xPath);
        logger.debug("tableName++++++++++++++++++++++++++"+tableName);
        
        if(!StringUtil.isValid(tableName))
        {
            logger.debug("getTableNamebyVOName(voName = " + vOCalssName
                    + ") - 所给数据表数据对象对应的数据表没有配置，请检查配置文件！", null);            
        }

        return tableName;
    }
    //根据类名获得表状态
    public String getIsbusniessKeyByVOClass(String voClassName){
    	String isOrno = "";
    	
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_VALUE_OBJECT_CLASS + "=\""
        + voClassName + "\"]/" + ATTRIBUTE_IS_BUSINESS_TABLE;
        isOrno = getConfig(xPath);
        if(!StringUtil.isValid(isOrno))
        {
            logger.debug("getTableNamebyVOName(voName = " + voClassName
                    + ") - 所给数据表数据对象对应的数据表没有配置，请检查配置文件！", null);            
        }
    	return isOrno;
    }


    /**
     * 根据表名获取数据对象的类名，如com.san.xhzx.data.object.logic.GS_202
     * @param table
     *      数据表名
     * @return
     */
    public String getVOClassbyTable(String table)
    {
        String voName = null;
        String xPath = "//"+ELEMENT_TABLE+"[@name=\"" + table.toUpperCase()+ "\"]/"+ATTRIBUTE_VALUE_OBJECT_CLASS;
        voName = getConfig(xPath);

        if (!StringUtil.isValid(voName))
        {
            logger.warn("getVOClassbyTable(table = " + table
                    + ") - 数据表对应的数据对象名没有正确配置，请查看配置文件！", null);
        }

        return voName;
    }
    
    
    /**
     * 根据表名获取该表的别名
     * @param table
     *      数据表名
     * @return
     *       
     */
    public String getAliasbyTable(String table)
    {
        String voName = null;
        String xPath = "//"+ELEMENT_TABLE+"[@name=\"" + table.toUpperCase()+ "\"]/"+ATTRIBUTE_Alias;
        voName = getConfig(xPath);

        if (!StringUtil.isValid(voName))
        {
            logger.warn("getVOClassbyTable(table = " + table
                    + ") - 数据表对应的数据对象名没有正确配置，请查看配置文件！", null);
        }

        return voName;
    }
    
    

    /**
     * 根据数据表名获取数据对象名
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回数据对象名，否则返回空字符串
     */
    public String getVONamebyTable(String table)
    {
        String voName = null;
        String xPath = prefix + table.toUpperCase()+ suffix + ATTRIBUTE_SHORT_NAME;
        voName = getConfig(xPath);
        if(!StringUtil.isValid(voName))
        {
            logger.warn("getVONamebyTable(table = " + table
                    + ") - 数据表对应的数据对象名没有正确配置，请查看配置文件！", null);            
        }
        return voName;
    }
    
    
    /**
     * 获取数据表所属的部门编号
     * @param table
     *      数据表名
     * @return
     *      部门编号
     */
    public String getProvidDepartment(String table)
    {
        String departId = null;
        String xPath = prefix + table + suffix + ATTRIBUTE_PROVIDE_DEPARTMENT;
        departId = getConfig(xPath);
        
        if(!StringUtil.isValid(departId))
        {
            logger.warn("getProvidDepartment(table = " + table
                    + ") - 数据表的所属部门编号没有配置，请查看配置文件！", null);
        }
        
        return departId;
    }

    /**
     * 获取数据表的中文名称
     * @param table
     *      数据表名（英文名）
     * @return
     *      数据表中文名称
     */
    public String getChineseName(String table)
    {
        String chineseName = null;
        String xPath = prefix + table + suffix + ATTRIBUTE_CHINESENAME;
        chineseName = getConfig(xPath);
        
        if(!StringUtil.isValid(chineseName))
        {
            logger.warn("getProvidDepartment(table = " + table
                    + ") - 数据表的中文名称没有配置，请查看配置文件！", null);
            
        }
        return chineseName;
    }
    
    /**
     * 获取数据表的类型
     * @param table
     *      数据表名（英文名）
     * @return
     *      数据表中文名称
     */
    public String getTableType(String table)
    {
        String tableType = null;
        String xPath = prefix + table + suffix + TABLE_TYPE;
        tableType = getConfig(xPath);
        
        if(!StringUtil.isValid(tableType))
        {
            logger.warn("getProvidDepartment(table = " + table
                    + ") - 数据表的中文名称没有配置，请查看配置文件！", null);
            
        }
        return tableType;
    }
    
    
    /**
     * 根据部门编号获取部门所属表的列表
     * @param deptId
     *      部门编号
     * @return
     *      返回数据表中文名称列表
     */
    public List getTablesOfDept(String deptId)
    {
        List list = new ArrayList();
        List nodeList = null;
        String tableName = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_PROVIDE_DEPARTMENT + "=\""
                     + deptId +"\"]/" + ATTRIBUTE_CHINESENAME;
        nodeList = getConfigNodeList(xPath);
        
        if(CollectionUtil.isValid(nodeList))
        {
            Node node = null;
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Node)nodeList.get(i);
                tableName = node.getStringValue();
                list.add(tableName);
            }
        }
        
        return list;
    }
    
    /**
     * 获取所有业务表名
     * @return
     *      返回数据表名
     */
    public List getAllBusinessTablesNames()
    {
        List list = new ArrayList();
        List nodeList = null;
        String tableName = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_IS_BUSINESS_TABLE + "=\""
                     + "Y" +"\"]/" + ATTRIBUTE_NAME;
        nodeList = getConfigNodeList(xPath);
        
        if(CollectionUtil.isValid(nodeList))
        {
            Node node = null;
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Node)nodeList.get(i);
                tableName = node.getStringValue();
                list.add(tableName);
            }
        }
        
        return list;
    }
    
    

    
    
    
    /**
     * 根据部门编号获取部门所属表的列表
     * @param deptId
     *      部门编号
     * @return
     *      返回数据表名
     */
    public List getTableNameListOfDept(String deptId)
    {
        List list = new ArrayList();
        List nodeList = null;
        String tableName = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_PROVIDE_DEPARTMENT + "=\""
                     + deptId +"\"]/" + ATTRIBUTE_NAME;
        nodeList = getConfigNodeList(xPath);
        
        if(CollectionUtil.isValid(nodeList))
        {
            Node node = null;
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Node)nodeList.get(i);
                tableName = node.getStringValue();
                list.add(tableName);
            }
        }
        
        return list;
    }
    
    
    /**
     * 根据部门编号获取部门所属表
     * @param deptId
     *      部门编号
     * @return
     *      返回部门所属表的列表，列表中元素是长度为2的数组，依次为中文名和英文名
     */
    public Map getTableNameOfDept(String deptId)
    {
        //List list = new ArrayList();
        List nodeList = null;
        //String[] tableName = new String[2];
        Map map = new HashMap();
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_PROVIDE_DEPARTMENT + "=\""
                    + deptId +"\"]";
        nodeList = getConfigNodeList(xPath);
        if(CollectionUtil.isValid(nodeList))
        {
            Element node = null;
            
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Element)nodeList.get(i);
                List a = node.attributes();
                String value = node.attributeValue("chinesename");
                String key  = node.attributeValue("name");
                map.put(key,value);               
            }
        }
        return map;
    }
    
    
 
    
    
    /**
     * 根据部门编号获取部门所属表
     * @param deptId
     *      部门编号
     * @return
     *      返回部门所属表的vo对象
     */
    public List getShortNameOfDept(String deptId)
    {
        List list = new ArrayList();
        List nodeList = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_PROVIDE_DEPARTMENT + "=\""
                    + deptId +"\"]";
        nodeList = getConfigNodeList(xPath);
        if(CollectionUtil.isValid(nodeList))
        {
            Element node = null;
            
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Element)nodeList.get(i);
                List a = node.attributes();
                String voName = node.attributeValue("valueobject");
                list.add(voName);             
            }
        }
        return list;
    }
    

    
    
    
    /**
     * 根据部门代码获取该部门业务主表,用于获取唯一的业务主表，不适用于多个业务主表的情况
     * @author 王骁
     * @version 0.1
     * @date 2005-11-03 1:23
     * @param deptId
     *      部门代码
     * @return String
     *      返回部门业务主表VO
     */
    public String getBusinessKeyTableNameOfDept(String deptId)
    {
        List nodeList = null;
        String businessKeyTableName = null;
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_PROVIDE_DEPARTMENT + "=\""
                    + deptId +"\"]";
        nodeList = getConfigNodeList(xPath);
        if (CollectionUtil.isValid(nodeList))
        {
        	Element node = null;
            
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Element)nodeList.get(i);
                String isKeyBusinessTable = node.attributeValue("is-key-business-table");
               
                
	                if(StringUtil.isValid(isKeyBusinessTable) && isKeyBusinessTable.equals("Y"))
	                {
	                	businessKeyTableName = node.attributeValue("shortname");
	                }        
            }
        }
        if(businessKeyTableName == null)
        {
        	logger.error("getProvidDepartment(deptId = " + deptId
                + ") - 数据表中没有配置该部门的业务主表，请查看数据表配置文件！");
        }
        return businessKeyTableName;
    }
    
    
    /**
     *  根据表名获取描述字段
     * @param table
     * @return
     */
    public String getDescription(String table)
    {
        String description = null;
        String xPath = prefix + table + suffix + ELEMENT_DESCRIPTION;
        description = getConfig(xPath);
        if(!StringUtil.isValid(description))
        {
            logger.warn("getEnterpriseCodeColumnbyTable(table = " + table
                    + ") - 数据表中的描述字段没有正确配置，请检查配置文件！", null);            
        }        
        return description;
    }
    
    
    
    
    
    /**
     * 根据数据表名获取数据表所有字段名称
     * @param table
     *      数据表名
     * @return
     *      如果存在则返回字段名称集合，否则返回null
     * 
     */

    public List getFieldNamebyTable(String table)
    {
        List fieldNameList = new ArrayList();
        String fileName = null;
        String xPath = prefix + table + suffix + ELEMENT_FIELDINFO 
        + "/" + ELEMENT_FIELNAME; 
        List list = null;
        list = getConfigNodeList(xPath); 
        if(CollectionUtil.isValid(list))
        {
            Iterator iter = list.iterator();
            if(null != iter)
            {
                Node node = null;
                while(iter.hasNext())
                {
                    node  = (Node)iter.next();
                    fileName = node.getStringValue();
                    if(StringUtil.isValid(fileName))
                    {
                        fieldNameList.add(fileName);
                    }
                }
            }
        }
        return fieldNameList;
    }
    
    
    
    /**
     * 获取数据表是否记录日志的标志值
     * @param table
     *      数据表名
     * @return
     *      如果设置为yes,true或y，不论大小写,则返回true，否则返回false
     */
    public boolean getLogFlag(String table)
    {
        boolean logFlag = false;
        String xPath = prefix + table + suffix + ELEMENT_LOGFLAG;
        String log = null;
        log  = getConfig(xPath,"");
        
        if(StringUtil.isValid(log))
        {
            logFlag = isTrue(log);
        }
        return logFlag;
    }
    
    public boolean isTrue(String flag)
    {
        boolean isTrue = false;
        if(flag.equalsIgnoreCase("yes") || flag.equalsIgnoreCase("true")|| flag.equalsIgnoreCase("y"))
        {
            isTrue = true;
        }
        return isTrue;
    }
    /**
     * 根据部门描述获取该部门所属所有数据表名
     * @param deptDesc
     *      部门描述
     * @return
     *      该部门所属所有数据表名
     */
    public List getTableNameOfDeptDesc(String deptDesc)
    {
        List list = new ArrayList();
        List nodeList = null;
        String xPath = ELEMENT_TABLE + "[" + ELEMENT_DESCRIPTION + "=\""
                    + deptDesc +"\"]";
        nodeList = getConfigNodeList(xPath);
        if(CollectionUtil.isValid(nodeList))
        {
            Element node = null;
            
            for(int i=0; i<nodeList.size(); i++)
            {
                node = (Element)nodeList.get(i);
                String tableName = node.attributeValue("name");
                list.add(tableName);             
            }
        }
        return list;
    }
    
    

    
}