package com.san.jingtai.service;

public class XmlUtil {
	/**
	 * 过虑xml的无效字符。
	 * <p/>
	 * <ol>
	 * <li>0x00 - 0x08</li>
	 * <li>0x0b - 0x0c</li>
	 * <li>0x0e - 0x1f</li>
	 * </ol>
	 * @author lvht 2014-8-5
	 */
	public static String filter(String xmlStr) {
		StringBuilder sb = new StringBuilder();
		char[] chs = xmlStr.toCharArray();
		// System.out.println("filter before=" +chs.length);
		for (char ch : chs) {
			if ((ch >= 0x00 && ch <= 0x08) || (ch >= 0x0b && ch <= 0x0c)
					|| (ch >= 0x0e && ch <= 0x1f)) {
				// eat...
			} else {
				sb.append(ch);
			}
		}
		// System.out.println("filter after=" +sb.length());
		return sb.toString();
	}
}
