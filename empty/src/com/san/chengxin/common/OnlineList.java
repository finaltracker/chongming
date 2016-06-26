package com.san.chengxin.common;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import com.san.share.pmi.dto.LoginUserInfo;

import java.util.Map;
import java.util.HashMap;

/**
 * session监听
 * @author shmilyLT
 */
public class OnlineList implements HttpSessionAttributeListener{
	public final static String LOGINUSERINFOBEAN_NAME = "loginUserInfoBean";
	/** 监听对象列表 */
	private static Map map = new HashMap();
	
	/**
	 * session添加信息
	 * @param session
	 */
	public void attributeAdded(HttpSessionBindingEvent session) {
		String sessionName = session.getName();
		System.out.println("sessionName:" + sessionName);
		if(LOGINUSERINFOBEAN_NAME.equals(sessionName)) {
			if(session.getValue() instanceof LoginUserInfo) {
				LoginUserInfo loginUserInfo = (LoginUserInfo)session.getValue();
				String cn = loginUserInfo.getCn();
				map.put(cn,cn);
				System.out.println("新增id:" + cn + " 共" + map.size());
			}
		}
	}

	/**
	 * 用户注销或超时
	 * @param session
	 */
	public void attributeRemoved(HttpSessionBindingEvent session) {
		String sessionName = session.getName();
		if(LOGINUSERINFOBEAN_NAME.equals(sessionName)) {
			if(session.getValue() instanceof LoginUserInfo) {
				LoginUserInfo loginUserInfo = (LoginUserInfo)session.getValue();
				String cn = loginUserInfo.getCn();
				map.remove(cn);
				System.out.println("移除id:" + cn + " 共" + map.size());
			}
		}
	}

	/**
	 * session值改变
	 * @param session
	 */
	public void attributeReplaced(HttpSessionBindingEvent session) {
		
	}
	/**
	 * 返回列表list
	 * @return 
	 */
	public static Map getMap() {
		if(map == null) {
			map = new HashMap();
		}
		return map;
	}
}