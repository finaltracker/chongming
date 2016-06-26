package com.san.common.keytools;

/**
 * 
 * @author wuwh
 * 主键生成器
 *
 */
public class UIDDKeyId {
	
	/**
	 * 
	 * @param num 
	 * @return
	 * num 代表生成多少位主键；
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
