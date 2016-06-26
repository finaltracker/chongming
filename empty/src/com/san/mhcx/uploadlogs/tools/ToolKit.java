package com.san.mhcx.uploadlogs.tools;

import java.io.UnsupportedEncodingException;


/**
 * 为这个包服务的小工具
 * 
 * @author yangyj
 * 
 */
public class ToolKit {
	

	/**
	 * 检查一个对象是否为空
	 * 
	 * @param obj
	 *            对象
	 * @return 结果
	 */
	public static boolean isNull(Object obj) {

		if (obj == null)
			return true;
		else
			return false;
	}

	/**
	 * 检查一个字符串是否为空白字符串
	 * 
	 * @param s
	 *            字符串
	 * @return 结果
	 */
	public static boolean isBlank(String s) {

		if (s.trim().equals(""))
			return true;
		else
			return false;
	}

	/**
	 * 检查一个字符串是否为空或者是否为空白字符串
	 * 
	 * @param s
	 *            字符串对象
	 * @return 结果
	 */
	public static boolean isNullOrBlank(String s) {

		if (isNull(s))
			return true;
		if (isBlank(s))
			return true;

		return false;
	}

	/**
	 * 转换编码
	 * 
	 * @param str
	 * @return
	 */
	public static String convertEncoding(String str) {

		if (str == null)
			return null;

		try {
			return new String(str.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return str;
		}
	}

	/**
	 * 打印二维字符串数组的内容
	 * 
	 * @param arr
	 */
	public static void printArray(String[][] arr) {

		if (arr == null)
			return;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println("");
		}
	}

}
