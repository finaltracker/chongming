package com.san.common.keytools;

/**
 * 
 * @author wuwh
 * ����������
 *
 */
public class UIDDKeyId {
	
	/**
	 * 
	 * @param num 
	 * @return
	 * num �������ɶ���λ������
	 * @author wuwh
	 * 
	 */
    public static String getUIDDKeyId(int num){
    	String ky=new KyeUtil(num).generateKey(num).toString();
    	return ky;
    }
    public static void main(String[] args) {
    	System.out.println(UIDDKeyId.getUIDDKeyId(16));
    	
	}
   
}
