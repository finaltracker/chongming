package com.san.mxchengxin.utils;

public class Utils {
	private static String[] specifyPartmentList = {
		"系统管理部",
		"崇明县"	
	};
	
	public static boolean isAdmin(String ouName) {
		for( int i = 0 ; i < specifyPartmentList.length ; i++ )
		{
			if( specifyPartmentList[i].equals( ouName ) )
			{
				return true;
			}
		}
		
		return false;
	}
}
