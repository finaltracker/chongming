package com.san.chengxin.common.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import com.thoughtworks.xstream.XStream;

/**
 * VO抽象基类
 * @author shmilyLT
 *
 */
public abstract class BaseVo implements Serializable{
	//protected final Log log = LogFactory.getLog(getClass());
	//返回消息
	protected String msg;
	
	protected int pageCount =0;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String toXml(Map map) {
		if(map == null) {
			map = new HashMap();
		}
    	String xml = new String();
//		XStream xstream = new XStream(); 
		
//		Iterator keys = map.keySet().iterator();
//		while(keys.hasNext()) {
//			String key = (String) keys.next();
//			xstream.alias(key, (Class)map.get(key)); 
//		}
//		xml = xstream.toXML(this);
//    	System.out.println("");
    	return xml;
    }
    public String toXml() {
    	String xml = new String();
//		XStream xstream = new XStream(); 
//		
//		xml = xstream.toXML(this);
    	
    	return xml;
    }
    
}
