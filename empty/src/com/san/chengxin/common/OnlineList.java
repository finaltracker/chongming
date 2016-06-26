package com.san.chengxin.common;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import com.san.share.pmi.dto.LoginUserInfo;

import java.util.Map;
import java.util.HashMap;

/**
 * session����
 * @author shmilyLT
 */
public class OnlineList implements HttpSessionAttributeListener{
	public final static String LOGINUSERINFOBEAN_NAME = "loginUserInfoBean";
	/** ���������б� */
	private static Map map = new HashMap();
	
	/**
	 * session�����Ϣ
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
				System.out.println("����id:" + cn + " ��" + map.size());
			}
		}
	}

	/**
	 * �û�ע����ʱ
	 * @param session
	 */
	public void attributeRemoved(HttpSessionBindingEvent session) {
		String sessionName = session.getName();
		if(LOGINUSERINFOBEAN_NAME.equals(sessionName)) {
			if(session.getValue() instanceof LoginUserInfo) {
				LoginUserInfo loginUserInfo = (LoginUserInfo)session.getValue();
				String cn = loginUserInfo.getCn();
				map.remove(cn);
				System.out.println("�Ƴ�id:" + cn + " ��" + map.size());
			}
		}
	}

	/**
	 * sessionֵ�ı�
	 * @param session
	 */
	public void attributeReplaced(HttpSessionBindingEvent session) {
		
	}
	/**
	 * �����б�list
	 * @return 
	 */
	public static Map getMap() {
		if(map == null) {
			map = new HashMap();
		}
		return map;
	}
}