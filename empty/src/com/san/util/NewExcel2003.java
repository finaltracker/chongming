package com.san.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public  class NewExcel2003{
	/**
	 * 生成excel2003  （修订版）
	 * list:第一行为标题，从第二行起为内容
	 * url:生成excel的路径
	 * filename:excel名称
	 */
	public static void initExcel(List list,String url,String filename){
		HSSFWorkbook wb =new HSSFWorkbook();	
		//设置样式
		HSSFCellStyle cellStyle = wb.createCellStyle();//创建样式
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);//居中
		//创建一个新的表\并创建名称
		HSSFSheet s =wb.createSheet();
		for(int i=0; i<list.size(); i++){//遍历数据
			Object[] obj=(Object[])list.get(i);
			//定义行
			HSSFRow row = s.createRow(i);
			for (int j = 0; j < obj.length; j++) {
					//列
					HSSFCell cell = row.createCell((short)j);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					String value ="";
					if(null!=obj[j] && !"".equals(obj[j].toString())){
						value=obj[j].toString();
					}
					cell.setCellValue(value.toString());//以字符串的形式写入
					//设置内容样式
					cell.setCellStyle(cellStyle);
			}
			//自动调整列宽
			//s.autoSizeColumn(i);
			
		}
		scxls(wb, url, File.separator+filename);//生成文件
	}
	
	/**
	  *  写标题
	  */
	public static void xTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] zdnames) {
		for (int i = 0; i < zdnames.length; i++) {
			xContext(workbook, sheet, zdnames[i], 0, i);
		}
	}
	
	/**
	 * 写内容
	 * check:默认为空
	 */
	public static void findResult(List list, int size, HSSFWorkbook workbook,HSSFSheet sheet,String check) {
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
	public static void xContext(HSSFWorkbook workbook, HSSFSheet sheet,String content, int rowindex, int cellindex) {
		HSSFRow row = sheet.createRow(rowindex);
		HSSFCell cell = row.createCell((short) cellindex);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(content);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		cell.setCellStyle(style);
	}
	/**
	 * 生成文件
	 */
	public static void scxls(HSSFWorkbook workbook,String url,String filename){
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
