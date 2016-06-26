/*
 * Copyright (c)  2006, 中国太平洋保险（集团）股份有限公司
 * All rights reserved.
 *
 * $Id: StringUtil.java 14698 2008-04-16 02:19:33Z c_dufei $
 */
package com.san.chengxin.common.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * This class provides a number of supporting String methods which are otherwise
 * not found in the java.util package. They are implemented as static methods
 * which take a String as argument and/or provide a String as return value. This
 * class can be divided into the following sections:
 * <ul>
 * <li>General String and String manipulation methods.
 * <ul>
 * <li>getSpaces() returns an empty String
 * <li>getZeros() returns a zero-filled String
 * <li>padLeft() left-pads a String to a given width
 * <li>padRight() right-pads a String to a given width
 * <li>padZero() left-pads a String with zeros
 * </ul>
 * <li>Formatted output of primitive data types (like printf in C/C++).
 * <ul>
 * <li>getFormatted() takes a String and a value argument and returns a
 * composed String according to the printf formatting rules. This method is
 * available for values of type int, double, char and String.
 * </ul>
 * </ul>
 * <p>
 * getFormatted mostly follows the conventions used in C/C++ printf formatting,
 * thoufg there are some slight differences. If you're not familar with printf,
 * you may consider to take a look in any good C reference. Here are the rules
 * for out format String:
 * <ul>
 * <li>There may be an arbibtrary number of format specifiers. Only the first
 * one is used to obtain the format information.
 * <li>The format specifier must have the form:
 * 
 * <pre>
 *               %[-][+][0-9][.0-9][lL][dxXuofeEgGcs]
 *               ||  |  |    |     |   |
 *               ||  |  |    |     |   +- format char, see below
 *               ||  |  |    |     +----- long modifier, ignored
 *               ||  |  |    +----------- decimals
 *               ||  |  +---------------- field length
 *               ||  +------------------- plus sign
 *               |+---------------------- leftalign
 *               +----------------------- percent sign, starts format specifier
 * </pre>
 * 
 * <ul>
 * <li>The percent sign always starts the format specifiert. Two consecutive
 * %'s could be used to literally generate a single %
 * <li>A "-" aligns output left (usually, it's right-aligned).
 * <li>A "+" outputs a plus sign for positive numbers (usually, it is
 * supressed.
 * <li>The field length specifies the overall field length. If the formatted
 * value is shorter, it will be padded with blanks, if it longer, it will remain
 * unchanged.
 * <li>The number of decimals specifies the length of the fractional part for
 * floating point numbers. If ommitted, the default is 6.
 * </ul>
 * The format char determines the base type for the formatted value and has a
 * big impact on how the result appears:
 * <ul>
 * <li>"d": integer value in decimal format.
 * <li>"x": integer value in hexadecimal format (letters in lowercase).
 * <li>"X": integer value in hexadecimal format (letters in uppercase).
 * <li>"u": absolute integer value in decimal format. Result will always be
 * positive.
 * <li>"o": integer value in octal format.
 * <li>"f": floating point value in fixed format (xxx.yyyyyy).
 * <li>"e": floating point value in scientific format (0.yyyyyye+zzz).
 * <li>"E": floating point value in scientific format (0.yyyyyyE+zzz).
 * <li>"g": same as "f" for absolute values not smaller than 0.001 and not
 * greater or equal than 1000. Otherwise, same as "e".
 * <li>"G": same as "f" for absolute values not smaller than 0.001 and not
 * greater or equal than 1000. Otherwise, same as "E".
 * <li>"c": single character.
 * <li>"s": String.
 * </ul>
 * Here are some additional hints:
 * <ul>
 * <li>For the "e" and "E" format chars the following is true:
 * <ul>
 * <li>The mantissa is normalized to its canonical form, i.e. it's always
 * smaller than 1.0 and greater than or equal to 0.1
 * <li>The exponent has always three digits.
 * <li>The exponent always shows a sign, even for positive values.
 * <li>The length of the frational part is subject to the number of decimals
 * specified in the format string. If omitted, it defaults to 6.
 * </ul>
 * <li>The fractional part is subject to rounding for the last visible digit.
 * Overflows could be propagated into the integer part or even into the
 * exponent.
 * <li>The "u" format char behaves different as in C/C++. Here, it always
 * displays the absolute value of the argument in decimal format.
 * <li>The "l" and "L" modfiers are completely ignored.
 * <li>The number of decimals is applied to all format chars except "c" and
 * "s". For integer values, the fractional part is always 0.
 * </ul>
 * </ul>
 */
public class StringUtil {
	/**
	 * 日志对象
	 */
	private static Logger log = Logger.getLogger(StringUtil.class);

	// ---Constants-------------------------------------------------------
	static final int MAXSPACES = 2560;

	static final int MAXZEROS = 2560;

	static final int DEFAULTDECIMALS = 6;

	static final int EXPONENTLEN = 3;

	// ---Pseudo Constants------------------------------------------------
	static String SPACES = "                                        ";

	static int SPACESLEN = 40;

	static String ZEROS = "0000000000000000000000000000000000000000";

	static int ZEROSLEN = 40;

	static Object lock = new Object();

	// ---Public general String handling methods--------------------------

	public static String processPrint(String string, int length) {
		String[] ss = StringUtil.split(string, "\r\n");
		String ss4 = "";
		for (int i = 0; i < ss.length; i++) {
			int len = length;
			if (ss[i] == null) {
				return ss4;
			}
			int len1 = ss[i].length();
			if (len1 < len) {
				ss[i] += "\r\n";
			} else {
				if (len1 / len == 1) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len) + "\r\n";
				} else if (len1 / len == 2) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len) + "\r\n";
				} else if (len1 / len == 3) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len, 3 * len) + "\r\n"
							+ ss[i].substring(3 * len) + "\r\n";
				} else if (len1 / len == 4) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len, 3 * len) + "\r\n"
							+ ss[i].substring(3 * len, 4 * len) + "\r\n"
							+ ss[i].substring(4 * len) + "\r\n";

				} else if (len1 / len == 5) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len, 3 * len) + "\r\n"
							+ ss[i].substring(3 * len, 4 * len) + "\r\n"
							+ ss[i].substring(4 * len, 5 * len) + "\r\n"
							+ ss[i].substring(5 * len) + "\r\n";
				} else if (len1 / len == 6) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len, 3 * len) + "\r\n"
							+ ss[i].substring(3 * len, 4 * len) + "\r\n"
							+ ss[i].substring(4 * len, 5 * len) + "\r\n"
							+ ss[i].substring(5 * len, 6 * len) + "\r\n"
							+ ss[i].substring(6 * len) + "\r\n";

				} else if (len1 / len == 7) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len, 3 * len) + "\r\n"
							+ ss[i].substring(3 * len, 4 * len) + "\r\n"
							+ ss[i].substring(4 * len, 5 * len) + "\r\n"
							+ ss[i].substring(5 * len, 6 * len) + "\r\n"
							+ ss[i].substring(6 * len, 7 * len) + "\r\n"
							+ ss[i].substring(7 * len) + "\r\n";

				} else if (len1 / len >= 8) {
					ss[i] = ss[i].substring(0, len) + "\r\n"
							+ ss[i].substring(len, 2 * len) + "\r\n"
							+ ss[i].substring(2 * len, 3 * len) + "\r\n"
							+ ss[i].substring(3 * len, 4 * len) + "\r\n"
							+ ss[i].substring(4 * len, 5 * len) + "\r\n"
							+ ss[i].substring(5 * len, 6 * len) + "\r\n"
							+ ss[i].substring(6 * len, 7 * len) + "\r\n"
							+ ss[i].substring(7 * len, 8 * len) + "\r\n"
							+ ss[i].substring(8 * len) + "\r\n";

				}
			}
			ss4 += ss[i];
		}

		return ss4;
	}

	/**
	 * 四舍五入
	 * 
	 * @param v
	 * @param scale
	 * @return double
	 */

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * Returns an empty String (i.e. a String which consists of only blanks) of
	 * the specified length.
	 * 
	 * @param len
	 *            length of String to return.
	 * @return Blank String of the given length.
	 * @exception StringIndexOutOfBoundsException
	 *                if len is larger than MAXSPACES (currently 2560).
	 */
	static public String getSpaces(int len) {
		if (len > SPACESLEN && SPACESLEN < MAXSPACES) {
			// aquire lock only when neccessary
			synchronized (lock) {
				while (len > SPACESLEN && SPACESLEN < MAXSPACES) {
					SPACES += SPACES;
					SPACESLEN += SPACESLEN;
				}
			}
		}
		return SPACES.substring(0, len);
	}

	// 这个方法就是生成单号最后一位算法，其中传入的为保单号截去最后一位的其余字符串：

	public static char Adjust_Char(String l_str) {

		char chars[];
		int asciis[];
		chars = new char[63];
		asciis = new int[63];

		char l_char;
		int i, j, l_length;
		long k;
		int l_before0 = 1;
		int l_before1 = 1;
		long l_sum = 0;
		long l_sum2 = 1;
		long l_sum3 = 1;
		char ascii_ini = 0;
		String l_str2 = "";

		l_str2 = l_str;
		l_length = l_str.length();

		if (ascii_ini == 0) {
			i = 0;
			for (l_char = 'A'; l_char <= 'Z'; l_char++) {
				chars[i] = l_char;
				asciis[i] = (i + 1) * 2 - 1;
				++i;
			}

			for (l_char = 'a'; l_char <= 'z'; l_char++) {
				chars[i] = l_char;
				asciis[i] = (i + 1) * 2 - 1;
				++i;
			}

			for (l_char = '0'; l_char <= '9'; l_char++) {
				chars[i] = l_char;
				asciis[i] = (i + 1) * 2 - 1;
				++i;
			}

			chars[i] = '*';
			asciis[i] = (i + 1) * 2 - 1;

			ascii_ini = 1;
		}

		for (i = 0; i < l_length; ++i) {
			l_char = l_str2.charAt(i);
			for (j = 0; j < 63 - 1; ++j) {
				if (l_char == chars[j]) {
					l_before0 = asciis[j];
					break;
				}
			}

			l_sum = l_sum * 2 + asciis[j] * (i + 1) + asciis[j] + (i + 1); /* 差异算法 */
			l_sum = l_sum % 26; /* 防止l_sum溢出 */
			l_sum2 = l_sum2 * asciis[j] % 26; /* 避免末尾重复 */
			l_sum3 = l_sum3 * asciis[j] * l_before1 / (i + 1); /* 避免末尾重复 */
			l_sum3 = l_sum3 % 137371; /* 防止l_sum3溢出 */
			l_before1 = l_before0;
		}

		l_sum = l_sum + l_sum2 + l_sum3;
		k = Math.abs(l_sum) % 26;

		return chars[(int) k];

	}

	/**
	 * 对转入的对象进行base64转码
	 * 
	 * @param ob
	 *            Object 待转码信息
	 * @param srcFormat
	 *            String 原编码字符集
	 * @param dstFormat
	 *            String 编码结果字符集
	 * @return String 编码结果
	 * @throws Exception
	 */
	public static synchronized String base64EnCode(Object ob, String srcFormat,
			String dstFormat) throws Exception {
		Base64 bs = new Base64();
		String result = "";
		if (ob != null)
			result = new String(bs.encode(ob.toString().getBytes(srcFormat)),
					dstFormat);
		else
			;

		return result;
	}

	/**
	 * 对转入的对象进行base64解码
	 * 
	 * @param ob
	 * @param srcFormat
	 * @param dstForma
	 * @return String
	 * @throws Exception
	 */
	public static synchronized String base64DeCode(Object ob, String srcFormat,
			String dstForma) throws Exception {
		Base64 bs = new Base64();
		String result = "";
		if (ob != null)
			result = new String(bs.decode(ob.toString().getBytes(srcFormat)));
		else
			;

		return result;
	}

	/**
	 * 对转入的对象进行base64转码
	 * 
	 */
	public static synchronized String base64EnCode(Object ob) throws Exception {
		Base64 bs = new Base64();
		String result = "";
		if (ob != null)
			result = new String(bs.encode(ob.toString().getBytes("GBK")),
					"UTF-8");
		else
			;

		return result;
	}

	/**
	 * 对转入的对象进行base64解码
	 * 
	 */
	public static synchronized String base64DeCode(Object ob) throws Exception {
		Base64 bs = new Base64();
		String result = "";
		if (ob != null)
			result = new String(bs.decode(ob.toString().getBytes("UTF-8")));
		else
			;

		return result;
	}

	/**
	 * 对转入的对象进行base64解码
	 * 
	 */
	public static synchronized String base64DeCodeGBK(Object ob)
			throws Exception {
		Base64 bs = new Base64();
		String result = "";
		if (ob != null)
			result = new String(bs.decode(ob.toString().getBytes()), "GBK");
		else
			;

		return result;
	}

	/**
	 * 对转入的对象进行base64解码
	 * 
	 */
	public static synchronized String base64DeCode2(Object ob) throws Exception {
		Base64 bs = new Base64();
		String result = "";
		if (ob != null)
			result = new String(bs.decode(ob.toString().getBytes()));
		else
			;

		return result;
	}

	public static void main(String args[]) throws Exception {
		// System.out.println("11==="+base64DeCode("QVNISEoxMDk5ODA3RDEwMjIzNEo="+"------"+"MzAxMDEwMA=="+"------"+"QlNISEoxMDk5ODA3RDEwNTUwMEo="));
		// System.out.println("22==="+base64DeCode("W0JAMWY3NjcwZA=="));??????????
		// System.out.println("55==="+padRight("sru6z7jx",4));

		// <P_PUBLIC_POLICY__STARTDATE>MjAwNzA4MDY=</P_PUBLIC_POLICY__STARTDATE>
		// <P_PUBLIC_POLICY__ENDDATE>MjAwNzExMDQ=</P_PUBLIC_POLICY__ENDDATE>
		// String ss="0123456789a";
		// System.out.println(ss.substring(10,11));
		// System.out.println("33==="+base64EnCode("ASHH27004107D284899A"));

	}

	/**
	 * Returns a String of the specified length which consists of only Zeros
	 * (ASCII 48).
	 * 
	 * @param len
	 *            length of String to return.
	 * @return Zero-filled String of the given length.
	 * @exception StringIndexOutOfBoundsException
	 *                if len is larger than MAXZEROS (currently 2560).
	 */
	static public String getZeros(int len) {
		if (len > ZEROSLEN && ZEROSLEN < MAXZEROS) {
			// aquire lock only when neccessary
			synchronized (lock) {
				while (len > ZEROSLEN && ZEROSLEN < MAXZEROS) {
					ZEROS += ZEROS;
					ZEROSLEN += ZEROSLEN;
				}
			}
		}
		return ZEROS.substring(0, len);
	}

	/**
	 * 对转入的百分制的数字字符除以100并转为DOUBLE返回
	 * 
	 */
	public static Double getPercentValue(String str) throws Exception {
		Double result = null;
		if (str != null && !"".equals(str)) {
			result = new Double(Double.valueOf(str).doubleValue() / 100);
		}
		return result;
	}

	public static String replaceEnsureWordForHtml(String str) {
		StringBuffer ss = new StringBuffer(str);
		while (str.indexOf('\n') != -1) {
			int num = str.indexOf('\n');
			ss.deleteCharAt(num);
			char[] ch = new char[] { '<', 'b', 'r', '>', '&', 'n', 'b', 's',
					'p', '&', 'n', 'b', 's', 'p', '&', 'n', 'b', 's', 'p', '&',
					'n', 'b', 's', 'p', '&', 'n', 'b', 's', 'p' };
			str = ss.insert(num, ch).toString();
		}
		return str;
	}

	public static String replaceEnsureWordForPrint(String str) {
		StringBuffer ss = new StringBuffer(str);
		while (str.indexOf('\t') != -1) {
			int num = str.indexOf('\t');
			ss.deleteCharAt(num);
			str = ss.toString();
		}
		String returnValue="";
		String aa[]=StringUtil.split(str,"\n");
        if(aa!=null && aa.length>0){
        	returnValue+=aa[0];
        	for(int i=1;i<aa.length;i++){
        		returnValue+="\n\t"+aa[i];
        	}
        }
		return returnValue;
	}

	/**
	 * 对转入的DOUBLE型数字乘以以100转为百分制的String返回
	 * 
	 */
	public static String toPercentString(Double dou) throws Exception {
		String result = null;
		if (dou != null && !"".equals(dou)) {
			result = String.valueOf(dou.doubleValue() * 100);
		}
		return result;
	}

	/**
	 * Pads the String s to the given length by inserting blanks at the left
	 * side. If s is longer than len, the String remains unchanged.
	 * 
	 * @param s
	 *            String to pad
	 * @param len
	 *            length of resulting String
	 * @return The padded String.
	 */
	static public String padLeft(String s, int len) {
		return padLeft(s, len, false);
	}

	/**
	 * Pads the String s to the given length by inserting blanks at the left
	 * side. If s is longer than len and trim is set to true, the result is
	 * truncated to the given length.
	 * 
	 * @param s
	 *            String to pad
	 * @param len
	 *            length of resulting String
	 * @param trim
	 *            truncates s if longer then len
	 * @return The padded String.
	 */
	static public String padLeft(String s, int len, boolean trim) {
		int slen = s.length();
		String ret;
		if (slen < len) {
			ret = getSpaces(len - slen) + s;
		} else if (slen > len && trim) {
			ret = s.substring(0, len);
		} else {
			ret = s;
		}
		return ret;
	}

	/**
	 * Pads the String s to the given length by inserting blanks at the right
	 * end. If s is longer than len, the String remains unchanged.
	 * 
	 * @param s
	 *            String to pad
	 * @param len
	 *            length of resulting String
	 * @return The padded String.
	 */
	static public String padRight(String s, int len) {
		return padRight(s, len, false);
	}

	/**
	 * Pads the String s to the given length by inserting blanks at the right
	 * end. If s is longer than len and trim is true, the result is truncated to
	 * the given length.
	 * 
	 * @param s
	 *            String to pad
	 * @param len
	 *            length of resulting String
	 * @param trim
	 *            truncates s if longer then len
	 * @return The padded String.
	 */
	static public String padRight(String s, int len, boolean trim) {
		int slen = s.length();
		String ret;
		if (slen < len) {
			ret = s + getSpaces(len - slen);
		} else if (slen > len && trim) {
			ret = s.substring(0, len);
		} else {
			ret = s;
		}
		return ret;
	}

	/**
	 * Left-pads the String with zeros to the given length.
	 * 
	 * @param s
	 *            String to pad
	 * @param len
	 *            length of resulting String
	 * @return The padded value as a String.
	 */
	static public String padZero(String s, int len) {
		int slen = s.length();
		String ret;
		if (slen < len) {
			ret = getZeros(len - slen) + s;
		} else {
			ret = s;
		}
		return ret;
	}

	/**
	 * Converts the integer value into a String which is left-padded with zeros
	 * to the given length.
	 * 
	 * @param value
	 *            integer value to pad
	 * @param len
	 *            length of resulting String
	 * @return The padded value as a String.
	 */
	static public String padZero(int value, int len) {
		String s = "" + value;
		int slen = s.length();
		String ret;
		if (slen < len) {
			ret = getZeros(len - slen) + s;
		} else {
			ret = s;
		}
		return ret;
	}

	// ---Public String formatting methods--------------------------------

	/**
	 * Formats the value according to the given format specifier. The format
	 * char may be any character out of "dxXoufeEgGc". If the format char is in
	 * "feEgG", the value is casted to a double, if it is "c", it is casted to a
	 * char, before actually calling the corresponding formatting method.
	 * 
	 * @param format
	 *            format specifier according to the rules mentioned above
	 * @param value
	 *            integer value which should be formatted as specified in the
	 *            format argument
	 * @return The formatted value as a String. If the format char is "s", the
	 *         return value is the error message "<***cannot convert
	 *         value***>".
	 */
	public static String getFormatted(String format, int value) {
		String ret;
		FormatParas fp = new FormatParas();
		parseFormatString(format, fp);
		ret = fp.prefix.toString();
		if (fp.specfound) {
			String valstring;
			if (fp.basetype == 'i') {
				valstring = toString(value, fp);
			} else if (fp.basetype == 'f') {
				valstring = toString((double) value, fp);
			} else if (fp.basetype == 'c') {
				valstring = toString((char) value, fp);
			} else {
				valstring = "<***cannot convert value***>";
			}
			ret += valstring + fp.suffix.toString();
		}
		return ret;
	}

	/**
	 * Formats the value according to the given format specifier. The format
	 * char may be any character out of "dxXoufeEgG". If the format char is in
	 * "dxXou", the value is casted to an int before actually calling the
	 * corresponding formatting method.
	 * 
	 * @param format
	 *            format specifier according to the rules mentioned above
	 * @param value
	 *            double value which should be formatted as specified in the
	 *            format argument
	 * @return The formatted value as a String. If the format char is "c" or
	 *         "s", the return value is the error message "<***cannot convert
	 *         value***>".
	 */
	public static String getFormatted(String format, double value) {
		String ret;
		FormatParas fp = new FormatParas();
		parseFormatString(format, fp);
		ret = fp.prefix.toString();
		if (fp.specfound) {
			String valstring;
			if (fp.basetype == 'f') {
				valstring = toString(value, fp);
			} else if (fp.basetype == 'i') {
				valstring = toString((int) value, fp);
			} else {
				valstring = "<***cannot convert value***>";
			}
			ret += valstring + fp.suffix.toString();
		}
		return ret;
	}

	/**
	 * Formats the value according to the given format specifier. The format
	 * char may be any character out of "csdxXou". If the format char is "s",
	 * the value is considered a String of length 1. If it is in "dxXou", the
	 * value is casted to an int before actually calling the corresponding
	 * formatting method.
	 * 
	 * @param format
	 *            format specifier according to the rules mentioned above
	 * @param value
	 *            character which should be formatted as specified in the format
	 *            argument
	 * @return The formatted value as a String. If the format char is in
	 *         "feEgG", the return value is the error message "<***cannot
	 *         convert value***>".
	 */
	public static String getFormatted(String format, char value) {
		String ret;
		FormatParas fp = new FormatParas();
		parseFormatString(format, fp);
		ret = fp.prefix.toString();
		if (fp.specfound) {
			String valstring;
			if (fp.basetype == 'c') {
				valstring = toString(value, fp);
			} else if (fp.basetype == 's') {
				valstring = toString("" + value, fp);
			} else if (fp.basetype == 'i') {
				valstring = toString((int) value, fp);
			} else {
				valstring = "<***cannot convert value***>";
			}
			ret += valstring + fp.suffix.toString();
		}
		return ret;
	}

	/**
	 * Formats the value according to the given format specifier. The format
	 * char has to be the character "s".
	 * 
	 * @param format
	 *            format specifier according to the rules mentioned above
	 * @param value
	 *            String value which should be formatted as specified in the
	 *            format argument
	 * @return The formatted value as a String. If the format char is different
	 *         from "s", the return value is the error message "<***cannot
	 *         convert value***>".
	 */
	public static String getFormatted(String format, String value) {
		String ret;
		FormatParas fp = new FormatParas();
		parseFormatString(format, fp);
		ret = fp.prefix.toString();
		if (fp.specfound) {
			String valstring;
			if (fp.basetype == 's') {
				valstring = toString(value, fp);
			} else {
				valstring = "<***cannot convert value***>";
			}
			ret += valstring + fp.suffix.toString();
		}
		return ret;
	}

	/**
	 * Double 到 double 类型转换
	 * 
	 * @param doubleValue
	 * @return double
	 */
	public static double DoubleTodouble(Double doubleValue) {
		double returnValue = 0;
		if (doubleValue != null && !"".equals(doubleValue)) {
			returnValue = doubleValue.doubleValue();
		}
		return returnValue;
	}

	/**
	 * Double 到 String 类型转换
	 * 
	 * @param doubleValue
	 * @return String
	 */
	public static String DoubleToString(Double doubleValue) {
		String returnValue = "";
		if (doubleValue != null && !"".equals(doubleValue)) {
			returnValue = doubleValue.toString();
		}
		return returnValue;
	}

	/**
	 * Double 到 String 类型转换
	 * 
	 * @param str
	 * @return double
	 */
	public static double StringTodouble(String str) {
		double returnValue = 0;
		if (str != null && !"".equals(str)) {
			returnValue = Double.valueOf(str).doubleValue();
		}
		return returnValue;
	}

	/**
	 * Double 到 String 类型转换
	 * 
	 * @param doubleValue
	 * @return String
	 */

	public static String doubleToString(double doubleValue) {
		String returnValue = String.valueOf(Math.round(doubleValue));
		return returnValue;
	}

	/**
	 * This method could be used to run the format parser on the first argument
	 * and then return the format specification as a String. It is thought for
	 * debugging purposes and need not be called under normal circumstances.
	 * It's declared public because the test engine is in a different package
	 * and thus can not call package level methods.
	 * 
	 * @param format
	 *            format specifier according to the rules mentioned above
	 * @return The parsed format String in a human-readable format.
	 */
	public static String testFormatParser(String format) {
		FormatParas fp = new FormatParas();
		parseFormatString(format, fp);
		return "\nFormat String....: " + format + "\n" + fp.toString();
	}

	// ---Private methods-------------------------------------------------
	/**
	 * Converts the integer value into a String according to the format encoded
	 * in fp. This method supports the format specifiers "d", "u", "x" and "o".
	 * It interprets the modifiers "alignleft", "plussign", "fieldlen",
	 * "padzero" and "decimals".
	 */
	private static String toString(int value, FormatParas fp) {
		String ret = "";
		int signlen = 0;
		char sign = ' ';
		// Value conversion
		if (fp.convchar == 'd' || fp.convchar == 'u') {
			if (fp.convchar == 'u') {
				value = Math.abs(value);
			}
			if (value < 0) {
				ret = "" + (-value);
				signlen = 1;
				sign = '-';
			} else {
				ret = "" + value;
				if (fp.plussign) {
					signlen = 1;
					sign = '+';
				}
			}
			if (fp.decimals > 0) {
				ret += "." + getZeros(fp.decimals);
			}
		} else if (fp.convchar == 'x') {
			ret = Integer.toHexString(value);
		} else if (fp.convchar == 'X') {
			ret = Integer.toHexString(value).toUpperCase();
		} else if (fp.convchar == 'o') {
			ret = Integer.toOctalString(value);
		}
		// Padding
		if (fp.fieldlen > 0) {
			if (fp.padzero) {
				ret = padZero(ret, fp.fieldlen - signlen);
				if (signlen > 0) {
					ret = sign + ret;
				}
			} else {
				if (signlen > 0) {
					ret = sign + ret;
				}
				if (fp.alignleft) {
					ret = padRight(ret, fp.fieldlen);
				} else {
					ret = padLeft(ret, fp.fieldlen);
				}
			}
		} else if (signlen > 0) {
			ret = sign + ret;
		}
		return ret;
	}

	/**
	 * Converts the double value into a String according to the format encoded
	 * in fp. This method supports the format specifiers "f", "e", "E", "g" nd
	 * "G". It interprets the modifiers "alignleft", "plussign", "fieldlen",
	 * "padzero" and "decimals".
	 * 
	 * The floating point formatter always transforms the value into the
	 * normalized canonical form "0.xy" where the whole part is 0 and the first
	 * digit x of the fractional part is not 0. The implementation relies on the
	 * fact that the implicit Java String conversion for normalized values
	 * always returns a String in the format mentioned above.
	 */
	private static String toString(double value, FormatParas fp) {
		String ret = "";
		char convchar = fp.convchar;
		// Sign
		int signlen = 0;
		char sign = ' ';
		if (value < 0) {
			signlen = 1;
			sign = '-';
			value = -value;
		} else {
			if (fp.plussign) {
				signlen = 1;
				sign = '+';
			}
		}
		// Modify convchar
		if (fp.convchar == 'g' || fp.convchar == 'G') {
			if (value >= 1000.0 || value < 0.001) {
				convchar = (fp.convchar == 'g') ? 'e' : 'E';
			} else {
				convchar = 'f';
			}
		}
		// Compute exponent and canonical form
		int exp;
		String canonical;
		if (value == 0.0) {
			exp = 0;
			canonical = "0.0";
		} else {
			exp = (int) (Math.floor(Math.log(value) / Math.log(10)) + 1);
			// Checking for possible floating value representation errors
			// Occure if value is a multiple of 1000
			double normalized = value / Math.pow(10.0, exp);
			if (normalized >= 1.0) {
				// exp too small, multiplied by 10
				exp += 1.0;
				normalized = value / Math.pow(10.0, exp);
			}
			if (normalized < 0.1) {
				// exp too big, divided by 10
				exp -= 1.0;
				normalized = value / Math.pow(10.0, exp);
			}
			// Creating canonical form
			canonical = "" + normalized;
		}
		if (!canonical.startsWith("0.")) {
			ret = "***unexpected canonical form: " + ret;
		} else {
			// Value conversion
			canonical = canonical.substring(2);
			String s1, s2, s3;
			if (convchar == 'f') {
				if (exp > 0) {
					s1 = (canonical + getZeros(exp)).substring(0, exp);
					s2 = (canonical + getZeros(exp)).substring(exp);
				} else if (exp < 0) {
					s1 = "0";
					s2 = getZeros(-exp) + canonical;
				} else {
					s1 = "0";
					s2 = canonical;
				}
				s3 = "";
			} else { // convchar is 'e' or 'E'
				s1 = "0";
				s2 = canonical;
				if (exp >= 0) {
					s3 = "" + convchar + "+" + padZero(exp, EXPONENTLEN);
				} else {
					s3 = "" + convchar + "-" + padZero(-exp, EXPONENTLEN);
				}
			}
			// Correcting number of decimals and rounding
			int decimals = (fp.decimals == -1) ? DEFAULTDECIMALS : fp.decimals;
			if (decimals == 0) {
				if (s2.charAt(0) >= '5') {
					s1 = incrementString(s1);
				}
				s2 = "";
			} else {
				s2 += getZeros(decimals + 1);
				if (s2.charAt(decimals) >= '5') {
					s2 = incrementString(s2.substring(0, decimals));
					if (s2.length() > decimals) { // overflow in fractional
						// part
						if (convchar == 'f') {
							// set frac part to zero and propagate overflow to
							// integer part
							s2 = s2.substring(1);
							s1 = incrementString(s1);
						} else {
							// normalize frac part and propagate overflow to
							// exponent
							s2 = "1" + s2.substring(2);
							int newexp = exp + 1;
							if (newexp >= 0) {
								s3 = "" + convchar + "+"
										+ padZero(newexp, EXPONENTLEN);
							} else {
								s3 = "" + convchar + "-"
										+ padZero(-newexp, EXPONENTLEN);
							}
						}
					}
				} else {
					s2 = s2.substring(0, decimals);
				}
			}
			// Building raw version
			ret = s1 + (decimals > 0 ? ("." + s2) : "") + s3;
			// Padding
			if (fp.fieldlen > 0) {
				if (fp.padzero) {
					ret = padZero(ret, fp.fieldlen - signlen);
					if (signlen > 0) {
						ret = sign + ret;
					}
				} else {
					if (signlen > 0) {
						ret = sign + ret;
					}
					if (fp.alignleft) {
						ret = padRight(ret, fp.fieldlen);
					} else {
						ret = padLeft(ret, fp.fieldlen);
					}
				}
			} else if (signlen > 0) {
				ret = sign + ret;
			}
		}
		return ret;
	}

	/**
	 * Converts the char value into a String according to the format encoded in
	 * fp. This method supports the format specifier "c" with the "fieldlen" and
	 * "alignleft" modifiers.
	 */
	private static String toString(char value, FormatParas fp) {
		String ret = "" + value;
		if (fp.fieldlen > 0) {
			if (fp.alignleft) {
				ret = padRight(ret, fp.fieldlen);
			} else {
				ret = padLeft(ret, fp.fieldlen);
			}
		}
		return ret;
	}

	/**
	 * Formats the String value according to the format encoded in fp. This
	 * method supports the format specifier "s" with the "fieldlen" and
	 * "alignleft" modifiers.
	 */
	private static String toString(String value, FormatParas fp) {
		if (fp.fieldlen > 0) {
			if (fp.alignleft) {
				value = padRight(value, fp.fieldlen);
			} else {
				value = padLeft(value, fp.fieldlen);
			}
		}
		return value;
	}

	/**
	 * This method is used to parse the format String and to split it up into
	 * three parts:
	 * <ol>
	 * <li>All characters which occur before the first format specifier will be
	 * stored in the "prefix" component.
	 * <li>All characters which occur after the end of the first format
	 * specifier will be stored in the "suffix" component.
	 * <li>All charactcers which comprise the first format specifiert are
	 * scanned and stored in a structured way.
	 * </ol>
	 * All three parts are returned in the fp argument which is described in
	 * more detail below.
	 */
	private static void parseFormatString(String format, FormatParas fp) {
		int specpos = 0;
		int formatlen = format.length();
		while (formatlen > 0) {
			specpos = format.indexOf("%");
			if (specpos == -1 || specpos >= formatlen - 1) {
				// % not found or last char in format
				if (!fp.specfound) {
					fp.prefix.append(format);
				} else {
					fp.suffix.append(format);
				}
				format = "";
				formatlen = 0;
			} else if (format.charAt(specpos + 1) == '%') {
				// found two consecutive %'s
				if (!fp.specfound) {
					fp.prefix.append(format.substring(0, specpos + 1));
				} else {
					fp.suffix.append(format.substring(0, specpos + 1));
				}
				format = format.substring(specpos + 2);
				formatlen -= (specpos + 2);
			} else if (fp.specfound) {
				// found single % in suffix
				fp.suffix.append(format.substring(0, specpos + 1));
				format = format.substring(specpos + 1);
				formatlen -= (specpos + 1);
			} else {
				// found first single %
				fp.prefix.append(format.substring(0, specpos));
				format = format.substring(specpos + 1);
				formatlen -= (specpos + 1);
				fp.specfound = true;
				// now scanning format specifier for -+lL0123456789.dxXoufeEgGcs
				// chars
				int i = 0, numpos = 0;
				int num[] = { -1, -1 };
				boolean firstdigit = true;
				while (i < formatlen) {
					char c = format.charAt(i);
					if (c == '-') {
						fp.alignleft = true;
					} else if (c == '+') {
						fp.plussign = true;
					} else if (c == 'l' || c == 'L') {
						fp.aslong = true;
					} else if (c >= '0' && c <= '9') {
						if (num[numpos] == -1) {
							num[numpos] = 0;
						}
						num[numpos] = 10 * num[numpos] + c - '0';
						if (c == '0' && firstdigit) {
							fp.padzero = true;
						}
						firstdigit = false;
					} else if (c == '.') {
						numpos = 1;
					} else if ("dxXou".indexOf(c) != -1) {
						fp.convchar = c;
						fp.basetype = 'i';
						++i;
						break;
					} else if ("feEgG".indexOf(c) != -1) {
						fp.convchar = c;
						fp.basetype = 'f';
						++i;
						break;
					} else if (c == 'c') {
						fp.convchar = c;
						fp.basetype = 'c';
						++i;
						break;
					} else if (c == 's') {
						fp.convchar = c;
						fp.basetype = 's';
						++i;
						break;
					} else {
						++i;
						break;
					}
					++i;
				}
				fp.fieldlen = num[0];
				fp.decimals = num[1];
				// specifier completely scanned
				format = format.substring(i);
				formatlen -= i;
			}
		}
	}

	/**
	 * Treats the String as character-encoded positive integer value and
	 * increments it by 1. The return value is larger than s if and only if s
	 * completely consisted of "9" digits. This case could be considered an
	 * overflow.
	 */
	private static String incrementString(String s) {
		int i;
		StringBuffer sb = new StringBuffer(s);
		for (i = sb.length() - 1; i >= 0; --i) {
			char c = sb.charAt(i);
			if (c < '9') {
				sb.setCharAt(i, (char) (c + 1));
				break;
			} else {
				sb.setCharAt(i, '0');
			}
		}
		return ((i == -1) ? "1" : "") + sb.toString();
	}

	public static String format(String sFormat, String[] obj) {
		int len = obj.length;
		String sResult = sFormat;

		for (int i = 0; i < len; i++) {
			sResult = getFormatted(sResult, obj[i]);
		}
		return sResult;
	}

	/*
	 * public static void main(String sArgv[]) { String format="%d %c%s %s";
	 * String[] sArgs= new String[4]; sArgs[0] = "20"; sArgs[1] = "A"; sArgs[2] =
	 * "GE"; sArgs[3] = " is not good"; String sStr = Str.format(format,sArgs);
	 * cat.debug("STR IS:" + sStr); }
	 */

	// private static final char cKanJiSpace = '\u4E02';
	/**
	 * replace sub string
	 */
	public static String replaceStr(String src, String sFnd, String sRep) {
		String sTemp = "";
		int endIndex = 0;
		int beginIndex = 0;
		if (src == null || sFnd == null) {
			return src;
		}
		do {
			endIndex = src.indexOf(sFnd, beginIndex);
			// log.debug(endIndex + ":" + beginIndex);
			if (endIndex >= 0) { // mean found it.
				// log.debug( src.substring(beginIndex,endIndex));
				sTemp += src.substring(beginIndex, endIndex) + sRep;
				beginIndex = endIndex + sFnd.length();
			} else if (beginIndex >= 0) {
				sTemp += src.substring(beginIndex);
				break;
			}
		} while (endIndex >= 0);

		// log.debug(sTemp);
		return sTemp;
	}

	public static String chgCRLFTAB2SPC(String str) {

		String tmp;
		tmp = str;

		tmp = replaceStr(tmp, "\r\n", " ");
		tmp = replaceStr(tmp, "\r", " ");
		tmp = replaceStr(tmp, "\n", " ");
		tmp = replaceStr(tmp, "\b", " ");

		return tmp;

	}

	public static String GBToISO88591(String org) {
		log.debug("enter GBToISO88591 String1");

		if (org == null || org.equals("")) {
			return org;
		}

		try {
			log.debug("before convert=" + org);
			byte[] buf = org.getBytes("GBK");
			log.debug("after convert=" + new String(buf, "ISO8859_1"));
			return new String(buf, "ISO8859_1");
		} catch (Exception ex) {
			log.error("", ex);
			return null;
		}

	}

	public static String GBToUTF8(String org) {
		log.debug("enter GBToUTF8 String1");

		if (org == null || org.equals("")) {
			return org;
		}

		try {
			String str = new String(org.getBytes(), "UTF-8");
			// log.debug("before convert=" + org);
			// byte[] buf = org.getBytes("GBK");
			log.error("after convert=" + new String(str.getBytes("UTF-8")));
			return str;
		} catch (Exception ex) {
			log.error("", ex);
			return null;
		}

	}

	public static String GBToGB2312(String org) {
		log.debug("enter GBToUTF8 String1");

		if (org == null || org.equals("")) {
			return org;
		}

		try {
			String str = new String(org.getBytes(), "GB2312");
			// log.debug("before convert=" + org);
			// byte[] buf = org.getBytes("GBK");
			log.error("after convert=" + new String(str.getBytes("GB2312")));
			return str;
		} catch (Exception ex) {
			log.error("", ex);
			return null;
		}

	}

	public static String ISO88591ToGB(String org) {
		log.debug("enter ISO88591ToGBK String1");

		if (org == null || org.equals("")) {
			return org;
		}

		// ISO88591 -> GBK
		try {
			log.debug("before convert=" + org);
			byte[] buf = org.getBytes("ISO8859_1");
			log.debug("after convert=" + new String(buf, "GBK"));
			return new String(buf, "GBK");
		} catch (Exception ex) {
			log.error("", ex);
			return null;
		}

	}

	public static String[] ISO88591ToGB(String sOrgs[]) {
		if (sOrgs == null) {
			log.debug("sOrgs == null");
			return null;
		}

		for (int i = 0; i < sOrgs.length; i++) {
			log.debug("before convert.." + sOrgs[i]);
			sOrgs[i] = ISO88591ToGB(sOrgs[i]);
			log.debug("after  convert.." + sOrgs[i]);
		}

		return sOrgs;
	}

	public static boolean isNumber(String str) {
		int i;
		for (i = 0; i < str.length(); i++) {
			if (!java.lang.Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * 判断转入的字符串是不是数字
	 */
	public static boolean isNum(String str) {
		String number = "0123456789.";
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (number.indexOf(str.charAt(i)) == -1) {
				return false;
			}
			if (str.charAt(i) == '.') {
				j++;
			}
		}
		if (j > 1)
			return false;
		return true;

	}

	public static String nvl(String sIn) {
		return (sIn == null) ? "" : sIn;
	}

	public static String nvl(String sIn, String sDef) {
		return (sIn == null) ? sDef : sIn;
	}

	public static String fmtDate(String sYear, String sMonth, String sDay,
			String sSplit) {
		if (sMonth.length() == 1)
			sMonth = "0" + sMonth;
		if (sDay.length() == 1)
			sDay = "0" + sDay;
		return sYear + sSplit + sMonth + sSplit + sDay;
	}

	public static String convDate(String sDate, String sSep) {
		int pos = 0;
		String str = sDate;
		int len = str.length();
		if ((len < 8) || (len > 10)) {
			return str;
		} else if (str.indexOf(sSep) == 4) {
			pos = str.indexOf(sSep, 5);
			if (pos == 6) {
				if (len == 8) {
					return str.substring(0, 4) + "0" + str.substring(5, 6)
							+ "0" + str.substring(7, 8);
				} else {
					return str.substring(0, 4) + "0" + str.substring(5, 6)
							+ str.substring(7, 9);
				}
			} else if (pos == 7) {
				if (len == 9) {
					return str.substring(0, 4) + str.substring(5, 7) + "0"
							+ str.substring(8, 9);
				} else {
					return str.substring(0, 4) + str.substring(5, 7)
							+ str.substring(8, 10);
				}
			} else {
				return str;
			}
		} else {
			return str;
		}
	}

	public static boolean chkDate(String date) {
		int[] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int[] leapdays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int year, month, day;
		int i;

		if (date == null)
			return false;
		try {
			if (date.length() == 10) {
				date = formatDate(date);
			}

			if (date.length() != 8 && date.length() != 6)
				return false;
			if (date.length() == 8) {
				year = java.lang.Integer.parseInt(date.substring(0, 4));
				month = java.lang.Integer.parseInt(date.substring(4, 6));
				day = java.lang.Integer.parseInt(date.substring(6, 8));
				if (month < 1 || month > 12 || day < 1)
					return false;

				if (isLeapYear(year)) {
					for (i = 0; i < months.length; i++) {
						if (months[i] == month && day > leapdays[i])
							return false;
					}
				} else {
					for (i = 0; i < months.length; i++) {
						if (months[i] == month && day > days[i])
							return false;
					}
				}
			} else if (date.length() == 6) {
				year = java.lang.Integer.parseInt(date.substring(0, 4));
				month = java.lang.Integer.parseInt(date.substring(4, 6));
				if (month < 0 || month > 12)
					return false;
			}
		} catch (Exception e) {
			log.error("", e);
			return false;
		}

		return true;
	}

	public static boolean isLeapYear(int year) {
		if (year % 100 != 0 && year % 4 == 0)
			return true;
		else if (year % 400 == 0)
			return true;
		return false;
	}

	public static boolean chkMail(String mail) {
		int i;
		int len = mail.length();
		int aPos = mail.indexOf("@");
		int dPos = mail.indexOf(".");
		int aaPos = mail.indexOf("@@");
		int adPos = mail.indexOf("@.");
		int ddPos = mail.indexOf("..");
		int daPos = mail.indexOf(".@");
		String lastChar = mail.substring(len - 1, len);
		String chkStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_@.";
		if ((aPos <= 0) || (aPos == len - 1) || (dPos <= 0)
				|| (dPos == len - 1) || (adPos > 0) || (daPos > 0)
				|| (lastChar.equals("@")) || (lastChar.equals("."))
				|| (aaPos > 0) || (ddPos > 0)) {
			return false;
		}
		if (mail.indexOf("@", aPos + 1) > 0) {
			return false;
		}
		while (aPos > dPos) {
			dPos = mail.indexOf(".", dPos + 1);
			if (dPos < 0) {
				return false;
			}
		}
		for (i = 0; i < len; i++) {
			if (chkStr.indexOf(mail.charAt(i)) < 0) {
				return false;
			}
		}
		return true;
	}

	public static String removeChar(String str, String rc) {
		if (str == null) {
			return null;
		}

		int i = str.indexOf(rc);
		while (i >= 0) {
			str = str.substring(0, i) + str.substring(i + 1, str.length());
			i = str.indexOf(rc);
		}
		return str;
	}

	/**
	 * divide the source String into several String array, the numbers of the
	 * array is the separator numbers+1
	 */
	public static String[] divideStr(String src, String separator) {
		if (src == null)
			return null;
		if (separator == null || separator == "") {
			String[] result = { src };
			return result;
		}

		int part = 0;
		int end = src.indexOf(separator);
		int begin = end + separator.length();
		while (end >= 0 && begin <= src.length()) {
			part++;
			end = src.indexOf(separator, begin);
			begin = end + separator.length();
		}

		// the src is divided into n+1 parts by the n separators.
		String[] result = new String[part + 1];
		part = 0;
		begin = 0;
		end = src.indexOf(separator);
		while ((end >= 0) && (end + separator.length()) <= src.length()) {
			result[part++] = src.substring(begin, end);
			begin = end - 1;
			src = src.substring(0, end)
					+ src.substring(end + separator.length(), src.length());
			end = src.indexOf(separator, ++begin);
		}
		result[part] = src.substring(begin, src.length());
		return result;
	}

	public static boolean chkPhone(String phone) {
		int i = phone.indexOf("--");
		int len = phone.length();
		if (i >= 0) {
			return false;
		}
		i = phone.indexOf("-");
		if ((i == 0) || (i == len - 1)) {
			return false;
		} else if (i > 0) {
			i = phone.lastIndexOf("-");
			if (i == len - 1) {
				return false;
			}
			phone = removeChar(phone, "-");
		}
		if (!isNumber(phone)) {
			return false;
		}
		return true;
	}

	public static String formatDate(String sDate) {
		return formatDate(sDate, null, null);
	}

	public static String formatDate(String sDate, String sFmtTo) {
		return formatDate(sDate, null, sFmtTo);
	}

	public static String formatDate(String sDate, String sFmtFrom, String sFmtTo) {
		SimpleDateFormat sdfFrom = null;
		SimpleDateFormat sdfTo = null;
		java.util.Date dt = null;
		int nLen = 0;

		if (sDate == null) {
			return sDate;
		}

		try {
			nLen = sDate.length();

			if (sFmtFrom == null) {
				if (nLen == 8) {
					sFmtFrom = "yyyyMMdd";
				} else if (nLen == 10) {
					sFmtFrom = "yyyy-MM-dd";
				}
			}

			if (sFmtTo == null) {
				if (nLen == 8) {
					sFmtTo = "yyyy-MM-dd";
				} else if (nLen == 10) {
					sFmtTo = "yyyyMMdd";
				}
			}

			sdfFrom = new SimpleDateFormat(sFmtFrom);
			dt = sdfFrom.parse(sDate);

			sdfTo = new SimpleDateFormat(sFmtTo);

			return sdfTo.format(dt);

		} catch (Exception e) {
			log.error("", e);
			return sDate;
		}

	}

	public static int compareDate(String sDate1, java.util.Date dt2) {
		SimpleDateFormat sdf = null;
		SimpleDateFormat sdfNormalized = new SimpleDateFormat("yyyyMMdd");

		String sFmt = "";
		java.util.Date dt1 = null;
		int nLen = 0;

		if (sDate1 == null || dt2 == null) {
			return 0;
		}

		try {
			if (sDate1.length() == 6) {
				sDate1 = sDate1 + "01";
			}

			nLen = sDate1.length();

			if (nLen == 8) {
				sFmt = "yyyyMMdd";
			} else if (nLen == 10) {
				sFmt = "yyyy/MM/dd";
			}

			sdf = new SimpleDateFormat(sFmt);
			dt1 = sdf.parse(sDate1);

			String sDt1 = sdfNormalized.format(dt1);
			String sDt2 = sdfNormalized.format(dt2);

			return sDt1.compareTo(sDt2);

		} catch (Exception e) {
			log.error("", e);
			return 0;
		}

	}

	public static int compareDate(String sDate1, String sDate2) {
		SimpleDateFormat sdf = null;
		String sFmt = "";
		java.util.Date dt2 = null;
		int nLen = 0;

		if (sDate1 == null || sDate2 == null) {
			return 0;
		}

		try {

			if (sDate2.length() == 6) {
				sDate2 = sDate2 + "01";
			}

			nLen = sDate2.length();

			if (nLen == 8) {
				sFmt = "yyyyMMdd";
			} else if (nLen == 10) {
				sFmt = "yyyy/MM/dd";
			}

			sdf = new SimpleDateFormat(sFmt);
			dt2 = sdf.parse(sDate2);

			return compareDate(sDate1, dt2);

		} catch (Exception e) {
			log.error("", e);
			return 0;
		}

	}

	public static boolean isToday(String sDate) {
		return (compareDate(sDate, new java.util.Date()) == 0);
	}

	public static boolean beforeToday(String sDate) {
		return (compareDate(sDate, new java.util.Date()) < 0);
	}

	public static boolean afterToday(String sDate) {
		return (compareDate(sDate, new java.util.Date()) > 0);
	}

	public static String toDBSelStr(String sIn) {
		if (sIn == null) {
			return sIn;
		}

		String sOut = sIn;

		sOut = replaceStr(sOut, "~", "~~");
		sOut = replaceStr(sOut, "%", "~%");
		sOut = replaceStr(sOut, "_", "~_");

		sOut = replaceStr(sOut, "'", "''");

		return sOut;
	}

	public static String toDBInsStr(String sIn) {
		return toDBInsStr(sIn, -1);
	}

	public static String toDBInsStr(String sIn, int nMaxLen) {
		if (sIn == null) {
			return sIn;
		}

		String sOut = sIn;

		sOut = replaceStr(sOut, "\"", "\uFFFDh");

		if (nMaxLen != -1) {
			byte[] bs = sOut.getBytes();
			if (bs.length > nMaxLen) {
				sOut = new String(bs, 0, nMaxLen);
			}
		}

		sOut = replaceStr(sOut, "'", "''");

		return sOut;
	}

	public static String toHTMLOutStr(String sIn) {
		if (sIn == null) {
			return sIn;
		}
		String sOut = sIn;

		sOut = replaceStr(sOut, "<", "&lt;");
		sOut = replaceStr(sOut, ">", "&gt;");

		return sOut;
	}

	public static boolean isSpace(char c) {
		return (c == ' ' || c == '\t' || c == '\n');
	}

	public static boolean isSpace(String s) {
		if (s == null)
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (!isSpace(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String filter(String value) {

		if (value == null)
			return (null);

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (ch == '<')
				result.append("&lt;");
			else if (ch == '>')
				result.append("&gt;");
			else if (ch == '&')
				result.append("&amp;");
			else if (ch == '"')
				result.append("&quot;");
			else if (ch == '\r')
				result.append("<BR>");
			else if (ch == '\n') {
				if (i > 0 && value.charAt(i - 1) == '\r') {

				} else {
					result.append("<BR>");
				}
			} else if (ch == '\t')
				result.append("&nbsp;&nbsp;&nbsp;&nbsp");
			else if (ch == ' ')
				result.append("&nbsp;");
			else
				result.append(ch);
		}
		return (result.toString());
	}

	public static String filter2(String value) {

		if (value == null)
			return (null);

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (ch == '<')
				result.append("&lt;");
			else if (ch == '>')
				result.append("&gt;");
			else if (ch == '&')
				result.append("&amp;");
			else if (ch == '"')
				result.append("&quot;");
			else if (ch == '\r')
				result.append("<BR>");
			else if (ch == '\t')
				result.append("&nbsp;&nbsp;&nbsp;&nbsp");
			else
				result.append(ch);
		}
		return (result.toString());
	}

	public static String trim(String s) {
		if (s == null)
			return null;
		int begin, end;
		for (begin = 0; (begin < s.length()) && isSpace(s.charAt(begin)); begin++)
			;
		for (end = s.length() - 1; (end >= 0) && isSpace(s.charAt(end)); end--)
			;
		if (end < begin) {
			return "";
		}
		return s.substring(begin, end + 1);
	}

	/**
	 * Convert a string like "243,434,343" to long like 243434343
	 */
	public static long unFormatNum(String input) {
		if (input == null || input.equals("")) {
			return 0;
		}
		String tmp = removeChar(input, ",");
		if (isNumber(tmp)) {
			long output;
			try {
				output = java.lang.Long.parseLong(tmp);
			} catch (Exception e) {
				log.error("", e);
				return -1;
			}
			return output;
		} else {
			return -1;
		}
	}

	/**
	 * Convert a long number like 123456789 to a format String "123,456,789"
	 */
	public static String formatNum(int input) {
		if (input < 0) {
			return "";
		}
		String tmp = java.lang.String.valueOf(input);
		String output = "";
		int len = tmp.length();
		int i = len;
		while (i > 0) {
			if (i < 3) {
				output = tmp.substring(0, i) + output;
				break;
			} else {
				i = i - 3;
				output = tmp.substring(i, i + 3) + output;
				if (i > 0) {
					output = "," + output;
				}
			}
		}
		return output;
	}

	public static String formatNum(long input) {
		if (input < 0) {
			return "";
		}
		String tmp = java.lang.String.valueOf(input);
		String output = "";
		int len = tmp.length();
		int i = len;
		while (i > 0) {
			if (i < 3) {
				output = tmp.substring(0, i) + output;
				break;
			} else {
				i = i - 3;
				output = tmp.substring(i, i + 3) + output;
				if (i > 0) {
					output = "," + output;
				}
			}
		}
		return output;
	}

	public static String formatNum(String input) {
		if (input == null)
			return null;
		if (input.trim().length() == 0)
			return null;
		// String tmp = java.lang.String.valueOf(input);
		String tmp = input;
		String output = "";
		int len = tmp.length();
		int i = len;
		while (i > 0) {
			if (i < 3) {
				output = tmp.substring(0, i) + output;
				break;
			} else {
				i = i - 3;
				output = tmp.substring(i, i + 3) + output;
				if (i > 0) {
					output = "," + output;
				}
			}
		}
		return output;
	}

	public static int length(String str) {
		if (str == null) {
			return 0;
		} else {
			return str.getBytes().length;
		}
	}

	/**
	 * 把null变成空字符串 如果不是null，则不做任何处理
	 * 
	 * @param strTemp
	 *            String
	 * @return String
	 */
	public static String changeNullToSpace(String strTemp) {
		if (strTemp == null) {
			strTemp = "";
		}
		return strTemp;
	}

	/**
	 * 把null变成空字符串 如果不是null，则不做任何处理
	 * 
	 * @param strObject
	 * @return String
	 */
	public static String checkNullToSpace(Object strObject) {
		String strTemp = "";
		if (strObject == null) {
			strTemp = "";
		} else
			strTemp = strObject.toString();
		return strTemp;
	}

	/**
	 * 把null变成空数字字符串 如果不是null，则不做任何处理
	 * 
	 * @param strObject
	 * @return String
	 */
	public static String checkNullToNumber(Object strObject) {
		String strTemp = "";
		if (strObject == null) {
			strTemp = "0";
		} else {
			strTemp = strObject.toString();
			if ("".equals(strTemp)) {
				strTemp = "0";
			}
		}
		return strTemp;
	}

	/**
	 * 把格式化为############.##格式的数据
	 * 
	 * @param str
	 * @return String
	 */
	public static String formatNumber(String str) {
		NumberFormat nf = DecimalFormat.getInstance();
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("############.##");
		return df.format(str);
	}

	/**
	 * 把格式化为###0.00格式的数据
	 * 
	 * @param doubleValue
	 *            
	 * @return String
	 */
	public static String formatdouble(double doubleValue) {
		DecimalFormat dFormat = new DecimalFormat("###0.00");
		String cString = dFormat.format(doubleValue);
		return cString;
	}

	/**
	 * 取出用分隔符分隔的字符串中的每一段字符
	 * 
	 * @param pStrSrc
	 * @param pStrReg
	 * @return String[]
	 */
	public static String[] split(String pStrSrc, String pStrReg) {
		String[] splitRes = null;
		int regLeng = pStrReg.length();
		if (pStrSrc == null || pStrReg == null) {
			;
		} else {
			int begin = 0, pos = 0, l = pStrSrc.length();
			int counter = 0;
			while (begin < l) {
				pos = pStrSrc.indexOf(pStrReg, begin);
				if (pos >= 0) {
					counter++;
				} else {
					counter++;
					break;
				}
				begin = pos + 1;
			}
			splitRes = new String[counter];
			begin = pos = counter = 0;
			while (begin < l) {
				pos = pStrSrc.indexOf(pStrReg, begin);
				if (pos >= 0) {
					splitRes[counter] = pStrSrc.substring(begin, pos);
				} else {
					splitRes[counter] = pStrSrc.substring(begin, l);
					break;
				}
				counter++;
				begin = pos + regLeng;
			}
		}

		return splitRes;
	}
}

/**
 * This class is used to hold the properties of a single format specifier. It is
 * filled by the parseFormatString method and is used by several other methods.
 * 
 * @version 1.0, 97/12/21
 * @author Guido Krueger
 */
class FormatParas {
	boolean specfound; // A valid format specifier was found

	int fieldlen; // Length of field (-1 if not specified)

	int decimals; // Number of decimals (-1 if not specified)

	boolean alignleft; // Left align inside output field

	boolean padzero; // Pad with leading zeros

	boolean plussign; // Output plus sign for positive numbers

	boolean aslong; // "long" modifier found

	char convchar; // Conversion character

	char basetype; // i=integer f=floatingpoint s=String c=char

	StringBuffer prefix; // Substring on the left of the specifier

	StringBuffer suffix; // Substring on the right of the specifier

	/**
	 * Initializes all members to their default values.
	 */
	public FormatParas() {
		specfound = false;
		fieldlen = -1;
		decimals = -1;
		alignleft = false;
		padzero = false;
		plussign = false;
		aslong = false;
		convchar = ' ';
		prefix = new StringBuffer("");
		suffix = new StringBuffer("");
	}

	/**
	 * Returns a String representation of the object's state.
	 */
	public String toString() {
		String ret = "";
		ret += "specfound........: " + specfound + "\n";
		ret += "fieldlen.........: " + fieldlen + "\n";
		ret += "decimals.........: " + decimals + "\n";
		ret += "alignleft........: " + alignleft + "\n";
		ret += "padzero..........: " + padzero + "\n";
		ret += "plussign.........: " + plussign + "\n";
		ret += "aslong...........: " + aslong + "\n";
		ret += "convchar.........: " + convchar + "\n";
		ret += "prefix...........: " + prefix + "\n";
		ret += "suffix...........: " + suffix + "\n";
		return ret;
	}

	public static boolean chkSpecialCharacter(String str) {
		return false;
	}

	public static String hankaku2Zenkaku(String str) {
		return str;
	}

	public static String zenkaku2Hankaku(String str) {
		return str;
	}

	public static String stringToNumber(String ss) {
		String string = "";
		if (ss == null || ss.equals("")) {
			string = "0";
		} else {
			string = ss;
		}
		return string;
	}

}