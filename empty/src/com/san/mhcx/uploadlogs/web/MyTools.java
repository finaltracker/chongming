package com.san.mhcx.uploadlogs.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import com.san.mhcx.uploadlogs.model.LogTjByDeptPO;

public class MyTools {

	/**
	 * 上传数量统计图
	 * @param list1
	 * @param title
	 * @return
	 */
	
	public static String aytbblxml(List list1) {
		String xmls = "<?xml version='1.0' encoding='UTF-8'?>";
		xmls += "<anychart>";
		xmls += "<settings>";
		xmls += "<animation enabled=\"True\"/>";
		xmls += "</settings>";
		xmls += "<charts>";
		xmls += "<chart plot_type=\"CategorizedVertical\">";
		xmls += "<data_plot_settings default_series_type='Bar'><bar_series><marker_settings><marker size='8' /> <states><hover><marker size='12' /></hover></states></marker_settings><tooltip_settings enabled='True' > <format> {%Name}:{%YValue}{numDecimals:0,thousandsSeparator:,,useNegativeSign;false,thousandsSeparator:,,useNegativeSign;false}条</format></tooltip_settings> <label_settings enabled='True' mode=\"outside\"> <format>{%YValue}{numDecimals:0,thousandsSeparator:,,useNegativeSign;true,thousandsSeparator:,,useNegativeSign;true}  </format></label_settings> </bar_series></data_plot_settings>";
		xmls += "<chart_settings>";
		xmls += "<title enabled=\"true\">";
		xmls += "<text>上传数量统计图</text>";
		xmls += "</title>";
		xmls += "<axes>";
		xmls += "<y_axis>";
		xmls += "<title>";
		xmls += "<text>数量(条)</text>";
		xmls += "</title>";
		xmls += "<labels align='Inside'>";
		xmls += "<format>{%Value}{numDecimals:0,thousandsSeparator:,,useNegativeSign;false,thousandsSeparator:,,useNegativeSign;false}</format>";
		xmls += "</labels>";
		xmls += "</y_axis>";
		xmls += "<x_axis>";
		if(list1.size()>5){
			xmls += "<labels display_mode=\"Normal\" rotation=\"50\"/>";
			}
		xmls += "<title>";
		xmls += "<text>部门</text>";
		xmls += "</title>";
		xmls += "</x_axis></axes>";
		xmls += "</chart_settings>";
		xmls += "<data>";
		xmls += "<series size='10' name='Series 1'>";
		if(list1.size()>0){
	        for(int i=0;i<list1.size();i++){
	        	LogTjByDeptPO obj=(LogTjByDeptPO)list1.get(i);	         
	            	 
	            	 xmls += "<point  name='"+obj.getDeptName()+"' y='"+obj.getAllUpLoadSize()+"'/>";
	            	 
	             }
        }
		xmls += "</series>"; 
		xmls += "</data>";
		xmls += "</chart>";
		xmls += "</charts>";
		xmls += "</anychart>";
		return xmls;
	}
	
	/**
	 * 最近一个月上传数量统计图
	 * @param list1
	 * @param title
	 * @return
	 */
	
	public static String aytbblxmly(List list1) {
		String xmls = "<?xml version='1.0' encoding='UTF-8'?>";
		xmls += "<anychart>";
		xmls += "<settings>";
		xmls += "<animation enabled=\"True\"/>";
		xmls += "</settings>";
		xmls += "<charts>";
		xmls += "<chart plot_type=\"CategorizedVertical\">";
		xmls += "<data_plot_settings default_series_type='Bar'><bar_series><marker_settings><marker size='8' /> <states><hover><marker size='12' /></hover></states></marker_settings><tooltip_settings enabled='True' > <format>{%YValue}{numDecimals:0,thousandsSeparator:,,useNegativeSign;false,thousandsSeparator:,,useNegativeSign;false}  </format></tooltip_settings> <label_settings enabled='True' mode=\"outside\"> <format>{%YValue}{numDecimals:0,thousandsSeparator:,,useNegativeSign;true,thousandsSeparator:,,useNegativeSign;true}  </format></label_settings> </bar_series></data_plot_settings>";
		xmls += "<chart_settings>";
		xmls += "<title enabled=\"true\">";
		if(list1.size()>0){
	        	LogTjByDeptPO obj=(LogTjByDeptPO)list1.get(1);
	        	String stryear=obj.getStrdate().substring(0,4);
	        	String strdate=obj.getStrdate().substring(5);
	        	xmls += "<text>"+stryear+"年"+strdate+"月上传数量统计图"+"</text>";
	            	 
        }
		
		xmls += "</title>";
		xmls += "<axes>";
		xmls += "<y_axis>";
		xmls += "<title enabled=\"false\"/>";
		xmls += "<labels align='Inside'>";
		xmls += "<format>{%Value}{numDecimals:0,thousandsSeparator:,,useNegativeSign;false,thousandsSeparator:,,useNegativeSign;false}</format>";
		xmls += "</labels>";
		xmls += "</y_axis>";
		xmls += "<x_axis>";
		if(list1.size()>5){
		xmls += "<labels display_mode=\"Normal\" rotation=\"50\"/>";
		}
		xmls += "<title enabled=\"false\"/>";
		xmls += "</x_axis></axes>";
		xmls += "</chart_settings>";
		xmls += "<data>";
		xmls += "<series size='10' name='Series 1'>";
		if(list1.size()>0){
	        for(int i=0;i<list1.size();i++){
	        	LogTjByDeptPO obj=(LogTjByDeptPO)list1.get(i);	         
	            	 xmls += "<point name='"+obj.getDeptName()+"' y='"+obj.getAllUpLoadSize()+"'/>";
	            	 
	             }
        }
		xmls += "</series>"; 
		xmls += "</data>";
		xmls += "</chart>";
		xmls += "</charts>";
		xmls += "</anychart>";
		return xmls;
	}
	
	
	
	public static boolean fileXmlOperation(String filePath, String fileName,
			String fileContent) throws UnsupportedEncodingException,
			FileNotFoundException {
		boolean sign = false;


		System.out.println(fileContent);
		String pathTemp = filePath + "\\" + fileName + ".xml";
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
			// TODO 自动生成 catch 块
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

	public static void write(String path, String content) {
		String s = new String();
		String s1 = new String();
		try {
			File f = new File(path);
			if (f.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在，正在创建...");
				if (f.createNewFile()) {
					System.out.println("文件创建成功！");
				} else {
					System.out.println("文件创建失败！");
				}

			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((s = input.readLine()) != null) {
				s1 += s + "\n";
			}
			System.out.println("文件内容：" + s1);
			input.close();
			s1 += content;

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
