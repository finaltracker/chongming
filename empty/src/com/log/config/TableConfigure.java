/*
 * �ļ�����	TableConfigure.java
 * ���ܣ�		
 * �������ڣ�	2005-7-28
 * ���ߣ�		ʢ����     
 * �汾��		0.1
 * �޶���ʷ��	2005-11-02 ���� ��ӷ��� getBusinessKeyTableNameOfDept
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
     * ����ģʽ����ȡΨһTableConfigureʵ��
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
     * ���ݱ�����ȡ�ñ�������Ҫ�Ƚϵ��ֶ����б�
     * @param table
     *      ���ݱ���
     * @return
     * ��������򷵻���Ҫ�Ƚϵ��ֶ����б����򷵻ؿ��ַ���
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
                    + ") - ���ݱ��е���ҵ��������û����ȷ���ã����������ļ���", null);            
        }
        return enterpriseName;
    }  
    
    
    /**
     * ���ݱ�����ȡ�ñ����������ݶ����ж�Ӧ��������
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻�������Ӧ�������������򷵻ؿ��ַ���
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
                    + ") - ���ݱ��Ӧ��������û����ȷ���ã���鿴�����ļ���", null);
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
                    + ") - ���ݱ��Ӧ��������û����ȷ���ã���鿴�����ļ���", null);            
        }
        
        return pkField;
    }
    /**
     * �������ݱ�����ȡ���ݱ��ʱ���ֶ�
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻�ʱ���ֶ��������򷵻ؿ��ַ���
     */
    public String getTimeFieldbyTable(String table)
    {
        String timeField = null;
        String xPath = prefix + table +  suffix + ELEMENT_TIME_KEY;
        timeField = getConfig(xPath);
        
        if(!StringUtil.isValid(timeField))
        {
            logger.warn("getTimeFieldbyTable(table = " + table
                    + ") - ���ݱ��ʱ���ֶβ����ڻ�û����ȷ���ã����������ļ�����ȷ�ϣ�", null);            
        }
        return timeField;
    }

    /**
     * �������ݱ�����ȡʱ���ֶεĸ�ʽ����yyyy��yyyyMM
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻�ʱ���ʽ�����򷵻ؿ��ַ���
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
                    + ") - ���ݱ��ʱ���ֶβ����ڻ���ʱ���ʽû����ȷ���ã����������ļ�����ȷ�ϣ�", null);
            
        }
        
        return timeFormat;
    }

    /**
     * �������ݱ�����ȡ���ݱ��е�ʱ���ֶε���������
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻�ʱ���ֶε��������ͣ����򷵻ؿ��ַ���
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
                    + ") - ���ݱ��ʱ���ֶβ����ڻ���ʱ���ֶ�����û����ȷ���ã����������ļ�����ȷ�ϣ�", null);            
        }
        
        return timeDataType;
    }
    

    

    /**
     * �������ݱ�����ȡ���ݱ�����ҵ���������ֶ���
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻���ҵ���������ֶ��������򷵻�null
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
                    + ") - ���ݱ��е���ҵ���������ֶ�û����ȷ���ã����������ļ���", null);            
        }
        return enterpriseCodeColumn;
    }
    
    /**
     * �������ݱ�����ȡ���ݱ���ҵΨһ��ʶ��
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻���ҵΨһ��ʶ�ţ����򷵻�null
     * 
     */
    public String getEnterpriseIDbyTable(String table){
    	String enterpriseId = "";
        String xPath = prefix + table + suffix + ELEMENT_CODE_ENTERID;
        enterpriseId = getConfig(xPath);
        if(!StringUtil.isValid(enterpriseId))
        {
            logger.warn("getEnterpriseIDbyTable(table = " + table
                    + ") - ���ݱ��е���ҵΨһ�����ֶ�û����ȷ���ã����������ļ���", null);            
        }
    	return enterpriseId;
    }
    /**
     * �������ݶ���������������ݱ���
     * @param voName
     *      ���ݶ�����
     * @return
     *      ������ھͷ������ݱ��������򷵻�null
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
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
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
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
        }
    	return isOrno;
    }
    /**
     * �������ݱ�����ȡ���ݱ����������URL
     * @param table
     *      ���ݱ���
     * @return
     *      ���Խ������������URL
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
                    + ") - ���ݱ��Ӧ�������ַû�����ã���鿴�����ļ���", null);
        }

        return url;
    }

    /**
     * ��ȡ���ݱ�����뷽ʽ
     * @param table
     *      ���ݱ���
     * @return
     *      ������ô��ڣ���������÷�����Ӧ��ֵ�����򷵻�Ĭ��ֵ
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
                    + ") - ���ݱ�����뷽ʽû�����ã���鿴�����ļ���", null);
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
     * ��ȡ���ݱ����������
     * @param table
     *      ���ݱ���
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
                    + ") - ���ݱ����������û����ȷ���ã���鿴���ã�", null);
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
    
    //�����������VoName
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
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
        }

        return tableName;
    }
    //����������ñ�״̬
    public String getIsbusniessKeyByVOClass(String voClassName){
    	String isOrno = "";
    	
        String xPath = ELEMENT_TABLE + "[" + ATTRIBUTE_VALUE_OBJECT_CLASS + "=\""
        + voClassName + "\"]/" + ATTRIBUTE_IS_BUSINESS_TABLE;
        isOrno = getConfig(xPath);
        if(!StringUtil.isValid(isOrno))
        {
            logger.debug("getTableNamebyVOName(voName = " + voClassName
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
        }
    	return isOrno;
    }


    /**
     * ���ݱ�����ȡ���ݶ������������com.san.xhzx.data.object.logic.GS_202
     * @param table
     *      ���ݱ���
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
                    + ") - ���ݱ��Ӧ�����ݶ�����û����ȷ���ã���鿴�����ļ���", null);
        }

        return voName;
    }
    
    
    /**
     * ���ݱ�����ȡ�ñ�ı���
     * @param table
     *      ���ݱ���
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
                    + ") - ���ݱ��Ӧ�����ݶ�����û����ȷ���ã���鿴�����ļ���", null);
        }

        return voName;
    }
    
    

    /**
     * �������ݱ�����ȡ���ݶ�����
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻����ݶ����������򷵻ؿ��ַ���
     */
    public String getVONamebyTable(String table)
    {
        String voName = null;
        String xPath = prefix + table.toUpperCase()+ suffix + ATTRIBUTE_SHORT_NAME;
        voName = getConfig(xPath);
        if(!StringUtil.isValid(voName))
        {
            logger.warn("getVONamebyTable(table = " + table
                    + ") - ���ݱ��Ӧ�����ݶ�����û����ȷ���ã���鿴�����ļ���", null);            
        }
        return voName;
    }
    
    
    /**
     * ��ȡ���ݱ������Ĳ��ű��
     * @param table
     *      ���ݱ���
     * @return
     *      ���ű��
     */
    public String getProvidDepartment(String table)
    {
        String departId = null;
        String xPath = prefix + table + suffix + ATTRIBUTE_PROVIDE_DEPARTMENT;
        departId = getConfig(xPath);
        
        if(!StringUtil.isValid(departId))
        {
            logger.warn("getProvidDepartment(table = " + table
                    + ") - ���ݱ���������ű��û�����ã���鿴�����ļ���", null);
        }
        
        return departId;
    }

    /**
     * ��ȡ���ݱ����������
     * @param table
     *      ���ݱ�����Ӣ������
     * @return
     *      ���ݱ���������
     */
    public String getChineseName(String table)
    {
        String chineseName = null;
        String xPath = prefix + table + suffix + ATTRIBUTE_CHINESENAME;
        chineseName = getConfig(xPath);
        
        if(!StringUtil.isValid(chineseName))
        {
            logger.warn("getProvidDepartment(table = " + table
                    + ") - ���ݱ����������û�����ã���鿴�����ļ���", null);
            
        }
        return chineseName;
    }
    
    /**
     * ��ȡ���ݱ������
     * @param table
     *      ���ݱ�����Ӣ������
     * @return
     *      ���ݱ���������
     */
    public String getTableType(String table)
    {
        String tableType = null;
        String xPath = prefix + table + suffix + TABLE_TYPE;
        tableType = getConfig(xPath);
        
        if(!StringUtil.isValid(tableType))
        {
            logger.warn("getProvidDepartment(table = " + table
                    + ") - ���ݱ����������û�����ã���鿴�����ļ���", null);
            
        }
        return tableType;
    }
    
    
    /**
     * ���ݲ��ű�Ż�ȡ������������б�
     * @param deptId
     *      ���ű��
     * @return
     *      �������ݱ����������б�
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
     * ��ȡ����ҵ�����
     * @return
     *      �������ݱ���
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
     * ���ݲ��ű�Ż�ȡ������������б�
     * @param deptId
     *      ���ű��
     * @return
     *      �������ݱ���
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
     * ���ݲ��ű�Ż�ȡ����������
     * @param deptId
     *      ���ű��
     * @return
     *      ���ز�����������б��б���Ԫ���ǳ���Ϊ2�����飬����Ϊ��������Ӣ����
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
     * ���ݲ��ű�Ż�ȡ����������
     * @param deptId
     *      ���ű��
     * @return
     *      ���ز����������vo����
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
     * ���ݲ��Ŵ����ȡ�ò���ҵ������,���ڻ�ȡΨһ��ҵ�������������ڶ��ҵ����������
     * @author ����
     * @version 0.1
     * @date 2005-11-03 1:23
     * @param deptId
     *      ���Ŵ���
     * @return String
     *      ���ز���ҵ������VO
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
                + ") - ���ݱ���û�����øò��ŵ�ҵ��������鿴���ݱ������ļ���");
        }
        return businessKeyTableName;
    }
    
    
    /**
     *  ���ݱ�����ȡ�����ֶ�
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
                    + ") - ���ݱ��е������ֶ�û����ȷ���ã����������ļ���", null);            
        }        
        return description;
    }
    
    
    
    
    
    /**
     * �������ݱ�����ȡ���ݱ������ֶ�����
     * @param table
     *      ���ݱ���
     * @return
     *      ��������򷵻��ֶ����Ƽ��ϣ����򷵻�null
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
     * ��ȡ���ݱ��Ƿ��¼��־�ı�־ֵ
     * @param table
     *      ���ݱ���
     * @return
     *      �������Ϊyes,true��y�����۴�Сд,�򷵻�true�����򷵻�false
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
     * ���ݲ���������ȡ�ò��������������ݱ���
     * @param deptDesc
     *      ��������
     * @return
     *      �ò��������������ݱ���
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