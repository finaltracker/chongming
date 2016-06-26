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

public class LogConfigure extends ConfigFactory{
    
    private static final Logger logger = Logger.getLogger(TableConfigure.class);
    private static LogConfigure instance = new LogConfigure();
    private static final String defaultConfig = "logConfig.xml";
    private static final String ELEMENT_LOG = "log";
    private static final String ATTRIBUTE_NAME = "@target";
    private static final String ATTRIBUTE_INFO = "@info";
    private static final String ATTRIBUTE_FUNCTION = "@function";
    private static final String ATTRIBUTE_FUNCTIONNAME = "@functionName";
    protected LogConfigure() {
        super(defaultConfig);
    }
    /**
     * ����ģʽ����ȡΨһTableConfigureʵ��
     */
    public static LogConfigure getInstance()
    {
        if (instance == null)
        {
            synchronized (TableConfigure.class)
            {
                instance = new LogConfigure();
            }
        }
        return instance;
    }
    
    public void refreshConfig()
    {
        //        super.
    }

    
    /**
     * �������ݶ���������������ݱ���
     * @param voName
     *      ���ݶ�����
     * @return
     *      ������ھͷ������ݱ��������򷵻�null
     * 
     */
    public String getLogInfobyTarget(String href)
    {
        String logInfo = null;
        String xPath = ELEMENT_LOG + "[" + ATTRIBUTE_NAME + "=\""
                    + href + "\"]/" + ATTRIBUTE_INFO;
        logger.debug("xPath+++++++++++++++++++++++++++++++++"+xPath);
        logInfo = getConfig(xPath);
        logger.debug("tableName++++++++++++++++++++++++++"+logInfo);
        
        if(!StringUtil.isValid(logInfo))
        {
            logger.debug("getTableNamebyVOName(voName = " + href
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
        }

        return logInfo;
    }
    
    /**
     * �������ݶ���������������ݱ���
     * @param voName
     *      ���ݶ�����
     * @return
     *      ������ھͷ������ݱ��������򷵻�null
     * 
     */
    public String getLogInfobyFunction(String href)
    {
        String logInfo = null;
        String xPath = ELEMENT_LOG + "[" + ATTRIBUTE_NAME + "=\""
                    + href + "\"]/" + ATTRIBUTE_FUNCTION;
        logger.debug("xPath+++++++++++++++++++++++++++++++++"+xPath);
        logInfo = getConfig(xPath);
        logger.debug("tableName++++++++++++++++++++++++++"+logInfo);
        
        if(!StringUtil.isValid(logInfo))
        {
            logger.debug("getTableNamebyVOName(voName = " + href
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
        }

        return logInfo;
    }
    
    /**
     * �������ݶ���������������ݱ���
     * @param voName
     *      ���ݶ�����
     * @return
     *      ������ھͷ������ݱ��������򷵻�null
     * 
     */
    public String getLogInfobyFunctionName(String href)
    {
        String logInfo = null;
        String xPath = ELEMENT_LOG + "[" + ATTRIBUTE_NAME + "=\""
                    + href + "\"]/" + ATTRIBUTE_FUNCTIONNAME;
        logger.debug("xPath+++++++++++++++++++++++++++++++++"+xPath);
        logInfo = getConfig(xPath);
        logger.debug("tableName++++++++++++++++++++++++++"+logInfo);
        
        if(!StringUtil.isValid(logInfo))
        {
            logger.debug("getTableNamebyVOName(voName = " + href
                    + ") - �������ݱ����ݶ����Ӧ�����ݱ�û�����ã����������ļ���", null);            
        }

        return logInfo;
    }
}
