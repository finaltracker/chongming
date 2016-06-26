package com.san.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public  class NewExcel2007{
	
	/**
	 * 生成excel2007  （修订版）
	 * list:第一行为标题，从第二行起为内容
	 * url:生成excel的路径
	 * filename:excel名称
	 */
	public static void initExcel(List list,String url,String filename){
		XSSFWorkbook wb =new XSSFWorkbook();	
		//设置样式
		XSSFCellStyle cellStyle = wb.createCellStyle();//创建样式
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//居中
		//创建一个新的表\并创建名称
		XSSFSheet s =wb.createSheet();
		for(int i=0; i<list.size(); i++){//遍历数据
			Object[] obj=(Object[])list.get(i);
			//定义行
			XSSFRow row = s.createRow(i);
			for (int j = 0; j < obj.length; j++) {
					//列
					XSSFCell cell = row.createCell(j);
					String value ="";
					if(null!=obj[j] && !"".equals(obj[j].toString())){
						value=obj[j].toString();
					}
					cell.setCellValue(value.toString());//以字符串的形式写入
					//设置内容样式
					cell.setCellStyle(cellStyle);
			}
			//自动调整列宽
			s.autoSizeColumn(i);
			
		}
		scxls(wb, url, File.separator+filename);//生成文件
	}
	
	/**
	  *  写标题
	  */
	public static void xTitle(XSSFWorkbook workbook, XSSFSheet sheet, String[] zdnames) {
		for (int i = 0; i < zdnames.length; i++) {
			xContext(workbook, sheet, zdnames[i], 0, i);
		}
	}
	
	/**
	 * 写内容
	 * check:默认为空
	 */
	public static void findResult(List list, int size, XSSFWorkbook workbook,XSSFSheet sheet,String check) {
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				if(!Util.isNull(check)){
					if(null!=obj[3] && obj[3].toString().equals("成")){
						obj[3]="成功";
					}else if(null!=obj[3] && obj[3].toString().equals("失")){
						obj[3]="失败";
					}
				}
				for (int j = 0; j < size; j++) {
					xContext(workbook, sheet, null == obj[j] ? "" : obj[j].toString(), (i + 1), j);
				}
			}
		}
	}
	
	/**
	 * 写内容
	 */
	public static void xContext(XSSFWorkbook workbook, XSSFSheet sheet,String content, int rowindex, int cellindex) {
		XSSFRow row = sheet.createRow(rowindex);
		XSSFCell cell = row.createCell(cellindex);
		cell.setCellType(XSSFCell.CELL_TYPE_STRING);
		//cell.setEncoding(XSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new XSSFRichTextString(content));
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 上下居中
		cell.setCellStyle(style);
		sheet.autoSizeColumn(cellindex);//宽度自适应
		
	}
	/**
	 * 生成文件
	 */
	public static void scxls(XSSFWorkbook workbook,String url,String filename){
		try {
		    File file = new File(url+filename);
		    File file2 = new File(url);
		    file2.mkdirs();
			if (!file.exists()) {
				NewJsplUtileTools.createFile(url+filename);// 创建文件
			} else {
				NewJsplUtileTools.deleteFile(url+filename);// 删除文件
				NewJsplUtileTools.createFile(url+filename);// 创建文件
			}
			OutputStream os = new FileOutputStream(url+filename);
			try {
				workbook.write(os);
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 生成文件
	 */
	public static void scxls(Workbook workbook,String url,String filename){
		try {
		    File file = new File(url+filename);
		    File file2 = new File(url);
		    file2.mkdirs();
			if (!file.exists()) {
				NewJsplUtileTools.createFile(url+filename);// 创建文件
			} else {
				NewJsplUtileTools.deleteFile(url+filename);// 删除文件
				NewJsplUtileTools.createFile(url+filename);// 创建文件
			}
			OutputStream os = new FileOutputStream(url+filename);
			try {
				workbook.write(os);
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
