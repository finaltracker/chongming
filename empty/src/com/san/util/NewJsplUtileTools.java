package com.san.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class NewJsplUtileTools {
	
	/**
	 * 生成jsp文件
	 * @param filePath
	 * @param fileName
	 * @param fileContent
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public static boolean fileJspOperation(String filePath, String fileName,String fileContent,String jspTitle,String sjlx){
		//加载默认内容
		fileContent=addjsp_init(fileContent,jspTitle,sjlx);
		
		boolean sign = false;
		String pathTemp = filePath + "\\" + fileName + ".jsp";
		File file = new File(pathTemp);
		try {
			// 文件不存在
			if (!file.exists()) {

				sign = createFile(pathTemp);// 创建文件
				if (sign) {// 文件创建成功
					writeFile(pathTemp, fileContent);// 写入内容
				}
			} else {
				sign = deleteFile(pathTemp);// 删除文件
				sign = createFile(pathTemp);// 创建文件
				if (sign) {// 文件创建成功
					writeFile(pathTemp, fileContent);// 写入内容
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sign;
	}
	
	/**
	 * 生成html
	 */
	public static boolean NewFileHtml(String filePath, String fileName,String fileContent,String weburl,String savetype){
		//加载默认内容
		fileContent=addHtml_init(fileContent,weburl,savetype);
		
		boolean sign = false;
		String pathTemp = filePath + "\\" + fileName + ".html";
		File file = new File(pathTemp);
		try {
			// 文件不存在
			if (!file.exists()) {
				sign = createFile(pathTemp);// 创建文件
				if (sign) {// 文件创建成功
					writeFile(pathTemp, fileContent);// 写入内容
				}
			} else {
				sign = deleteFile(pathTemp);// 删除文件
				sign = createFile(pathTemp);// 创建文件
				if (sign) {// 文件创建成功
					writeFile(pathTemp, fileContent);// 写入内容
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sign;
		
	}
	/**
	 * 创建文件
	 * 
	 * @throws IOException
	 */
	public static boolean createFile(String name) throws IOException {
		boolean flag = false;
		File filename = new File(name);
		if (!filename.exists()) {
			filename.createNewFile();
			flag = true;
		}
		return flag;
	}

	/**
	 * 写文件
	 * 
	 * @param newStr
	 *            新内容
	 * @throws IOException
	 */
	public static boolean writeFile(String filePath, String newStr)
			throws IOException {
		// 先读取原有文件内容，然后进行写入操作
		boolean flag = false;
		String filein = newStr + "\r\n";
		// String str = new String(filein.getBytes("UTF-8"),"UTF-8");
		String temp = "";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		// PrintWriter pw = null;
		Writer pw = null;
		try {
			File file = new File(filePath);
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			StringBuffer buf = new StringBuffer();
			// // 文件路径
			// File file = new File(filePath);
			// // 将文件读入输入流
			//		  
			// isr = new InputStreamReader(new FileInputStream(file),"utf-8");
			// br = new BufferedReader(isr);
			// StringBuffer buf = new StringBuffer();
			/**
			 * File f=new File(rawfilename); if(f.exists()) { BufferedReader
			 * br=null; try { String line; InputStreamReader read = new
			 * InputStreamReader(new FileInputStream(f),"utf-8"); br=new
			 * BufferedReader(read);
			 */
			// 保存该文件原有的内容
			for (int i = 1; (temp = br.readLine()) != null; i++) {
				buf = buf.append(temp);
				buf = buf.append(System.getProperty("line.separator"));
			}
			buf.append(filein);
			fos = new FileOutputStream(file);
			pw = new OutputStreamWriter(fos, "utf-8");
			pw.write(buf.toString());
			pw.flush();
			flag = true;
		} catch (IOException e1) {
			throw e1;
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return flag;
	}
	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		boolean isSuccess = false;
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			isSuccess = true;
		}
		return isSuccess;
	}
	
	
	/**
	 * 加载jsp的默认内容
	 */
	public static String addjsp_init(String str,String jspTitle,String type){
		String temp="<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"UTF-8\"%>\r\n"+
		"<%\r\n"+
		"String path = request.getContextPath();\r\n"+
		"String basePath = request.getScheme()+\"://\"+request.getServerName()+\":\"+request.getServerPort()+path+\"/\";\r\n"+
		"%>"+
		"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"+
		"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n"+
		"<head>\r\n"+
		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n"+
		" <title>"+jspTitle+"</title>\r\n"+
		" <link href=\"<%=path %>/css/css.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n"+
		" <script type=\"text/javascript\" src=\"<%=path%>/js/jquery-1.4.4.min.js\"></script>\r\n"+
		"<script type=\"text/javascript\">\r\n"+
		"			var http_request = false;\r\n"+
		"			function send_request(url) {\r\n"+
		"			  http_request = false;\r\n"+
		"			  if(window.XMLHttpRequest) {\r\n"+
		"				　　http_request = new XMLHttpRequest();\r\n"+
		"				　　if (http_request.overrideMimeType) {\r\n"+
		"				　　http_request.overrideMimeType('text/xml');\r\n"+
		"			　　 }\r\n"+
		"			  }else if (window.ActiveXObject) {\r\n"+
		"			　　try {\r\n"+
		"			　　    http_request = new ActiveXObject(\"Msxml2.XMLHTTP\");\r\n"+
		"			　　} catch (e) {\r\n"+
		"			　　    try {\r\n"+
		"			　      　 http_request = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n"+
		"			　　    } catch (e) {}\r\n"+
		"			　　}\r\n"+
		"			  }\r\n"+
		"			if (!http_request) {\r\n"+
		"			　　window.alert(\"不能创建XMLHttpRequest对象实例.\");\r\n"+
		"			　　return false;\r\n"+
		"			}\r\n"+
		"			http_request.onreadystatechange = processRequest;\r\n"+
		"			http_request.open(\"GET\", url, true);\r\n"+
		"			http_request.send(null);\r\n"+
		"			}\r\n"+
		"		　　function processRequest() {\r\n"+
		"			　　if (http_request.readyState == 4) {\r\n"+
		"				　　if (http_request.status == 200) {\r\n"+
		"						var str=http_request.responseText;\r\n"+
		"						var strs=str.split(\"&\");\r\n"+
		"						var indexId=strs[0];\r\n"+
		"						var inHtml=strs[1];\r\n"+
		"				      	document.getElementById(indexId).innerHTML=\"&nbsp;&nbsp;\"+inHtml;\r\n"+
		"				      	showVal();\r\n"+
		"				　　} else {\r\n"+
		"				　　    alert(\"您所请求的页面有异常。\");\r\n"+
		"				　　}\r\n"+
		"			　　}\r\n"+
		"		　　}\r\n"+
		"			function jiazai(){\r\n"+
		"				var spanEl = document.getElementsByTagName(\"span\");\r\n"+
		"				for (var i = 0; i < spanEl.length; i++) {\r\n"+
		"					if(spanEl[i].id!=\"\"){\r\n"+
		"						spanEl[i].innerHTML=\"&nbsp;&nbsp;加载中...\";\r\n"+
		"					}\r\n"+
		"				}\r\n"+
		"				showVal();\r\n"+
		"			}\r\n"+
		"			function showVal(){\r\n"+
		"				var spanEl = document.getElementsByTagName(\"span\");\r\n"+
		"				for (var i = 0; i < spanEl.length; i++) {\r\n"+
		"					if(spanEl[i].id!=\"\"){\r\n"+
		"						if(spanEl[i].innerHTML==\"&nbsp;&nbsp;加载中...\"){\r\n"+
		"							send_request(\"/web/jingtaiAction.do?dispatch=qyXyda&enterpriseId=<%=request.getAttribute(\"enterpriseId\").toString() %>&indexId=\"+spanEl[i].id+\"&tim\"+new Date().getTime());\r\n"+
		"							break;\r\n"+
		"						}\r\n"+
		"					}\r\n"+
		"				}\r\n"+
		"			}\r\n"+
		"			function showMx(tableId){\r\n"+
		"				var url=\"/web/selectAction.do?dispatch=damx&tableId=\"+tableId+\"&sysId=<%=request.getAttribute(\"enterpriseId\").toString() %>&type="+type+"\";\r\n"+
		"				var styleStr = \"toolbar=0,location=0,status=0,men?ubar=0,scrollbars=1,resizable=1,top=120,left=280,width=600,height=350\";\r\n"+
		"				window.open(url,\"damx\",styleStr);\r\n"+
		"			}\r\n"+
		"		</script>\r\n"+
		"</head>\r\n"+
		"<body onload=\"jiazai();\">"+str+"</body></html>";
		return temp;
	}
	
	/**
	 * 加载html默认内容
	 */
	public static String  addHtml_init(String info,String webUrl,String savetype){
		if(savetype.equals("0")){//无水印
			savetype="";
		}else{//有水印
			savetype=" style=\"background-image: url(\'"+webUrl+"/img/sy_bg.png\')\" ";
		}
		String strhtml="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"+
			"		<html>"+
			"		 <head>"+
			"		  <title>信用档案模板</title>"+
			"		  <style>"+
			"				body {margin:auto;padding: 0px;width: 1024px;overflow-y:auto;overflow-x:hidden;font-size:12px;line-height:150%;}"+
			"				div{overflow-x:hidden;overflow-y:hidden;}"+
			"				p{margin: 0px;}"+
			"				.hr_1{background-image: url('"+webUrl+"/img/text_bgimg.png');background-position: center;background-repeat: repeat-x;text-align:center;height: 30px; line-height: 30px;}"+
			"				.hr_2{background-image: url('"+webUrl+"/img/1_lin_hr.png');background-position: center;background-repeat: repeat-x;text-align:center;height:30px; line-height: 30px;}"+
			"				.hr_1 span{background-color: white;padding: 5px;font-size: 18px;font-weight: bold;height: 30px; line-height: 30px;}"+
			"				.hr_2 span{background-color: white;padding: 5px;font-size: 14px;height:30px; line-height: 30px;}"+
			"				.dqzf{font-weight: normal;font-size: 14px;}"+
			"				#countText_div div{margin-top:5px;}"+
			"			    table{width: 100%;border:1px solid #ADADAD;border-collapse: collapse;}"+
			"				table tr td{border:1px solid #A0A0A0;text-align: left;padding-left: 10px;font-size: 12px;}"+
			"				table tr th{border:1px solid #A0A0A0;background-color: #F6F6F6;text-align: left;padding-left: 10px;font-weight:normal;font-size: 12px;}"+
			"				table  tr{height: 35px;line-height: 35px;}"+
			"				.tbody_td_class{padding:1px;}"+
			"				.tbody_td_class tr th{text-align: center;font-weight: bold;}"+
			"				.tbody_td_class tr td{text-align: center;}"+
			"			 </style>"+
			"		 </head>"+
			"		 <body "+savetype+">"+info+
			"		 <div style=\"font-family:宋体;text-align: left;\">"+
			"		 	<p>（1）本报告所载信息为截至查询时间，本市行政机关、司法机关、公用事业单位、社会组织向信用平台提供的与被查询人相关的全部信息。</p>"+
			"			<p>（2）法人或自然人伪造、变造本报告信息的，应当承担相应法律责任，该行为将作为其信用。</p>"+
				"		<p>（3）本报告所载信息仅供参考。</p>"+
					"	<p>（4）本报告版式为试用版式。</p>"+
					 "</div><br/><br/><br/>"+	
					" </body>"+
					"</html>";
		return strhtml;
	}
}
