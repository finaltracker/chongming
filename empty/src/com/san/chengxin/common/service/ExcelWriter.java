package com.san.chengxin.common.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


/**
 * excel文件生成工具类
 * 
 * @author yangyj
 *
 */
public class ExcelWriter {
	private HSSFWorkbook workbook = new HSSFWorkbook();
	private HSSFSheet sheet;

	private String[] sheetHeader;
	private String[][] sheetData;
	

	public ExcelWriter() {
		//sheet = workbook.createSheet();
	}

	public ExcelWriter(String sheetName) {
		sheet = workbook.createSheet(sheetName);
	}

	/**
	 * 写入excel文件
	 * 
	 * @param fullFilePathName
	 * @throws IOException
	 */
	public void write(String fullFilePathName) throws IOException {
		fillExcelSheet();
		saveToFile(fullFilePathName);
	}

	/**
	 * 填充excell表格
	 */
	public void fillExcelSheet() {
		if (sheetHeader == null && sheetData == null)
			throw new IllegalArgumentException("Hasn't set any Excel data!");

		if (sheetHeader != null) {
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = null;

			for (int i = 0; i < sheetHeader.length; i++) {
				cell = row.createCell((short) i);
//				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell = setDefaultCellStyle(cell);
				cell.setCellValue(sheetHeader[i]);
			}
		}

		if (sheetData != null) {
			HSSFRow row = null;
			HSSFCell cell = null;
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 1; i < sheetData.length; i++) {
				row = sheet.createRow(lastRowNum + i);
				for (int j = 0; j < sheetData[i].length; j++) {
					cell = row.createCell((short) j);
//					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(sheetData[i][j]);
				}
			}
			lastRowNum = sheet.getLastRowNum();
			lastRowNum = 3;
		}
	}
	
	public void fillExcelSheetList(List bodyDate,int listCount,String sheetName) {
		sheet = workbook.createSheet(sheetName);
		if (sheetHeader == null && bodyDate == null)
			throw new IllegalArgumentException("Hasn't set any Excel data!");

		if (sheetHeader != null) {
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = null;

			for (int i = 0; i < sheetHeader.length; i++) {
				cell = row.createCell((short) i);
//				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell = setDefaultCellStyle(cell);
				cell.setCellValue(sheetHeader[i]);
			}
		}

		
		if (bodyDate != null) {
			HSSFRow row = null;
			HSSFCell cell = null;
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 1; i <= listCount; i++) {
				row = sheet.createRow(lastRowNum + i);
				int bodyRow = i - 1;
				Object[] objs = (Object[])bodyDate.get(bodyRow);
				for (int j = 0; j < objs.length; j++) {
					cell = row.createCell((short) j);
//					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					if(objs[j] !=null){
						cell.setCellValue(objs[j].toString());
					}else{
						cell.setCellValue("");
					}
				}
			}
		}
		
	}

	
	/**
	 * 保存excel表格到文件
	 * 
	 * @param fullFilePathName
	 * @throws IOException
	 */
	private void saveToFile(String fullFilePathName) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(fullFilePathName);
		workbook.write(fileOut);
		fileOut.close();
	}

	/**
	 * 设置cell属性
	 * 
	 * @param cell
	 * @return
	 */
	private HSSFCell setDefaultCellStyle(HSSFCell cell) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setFillForegroundColor((short) 46);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeight((short) 200);
		font.setColor(HSSFFont.COLOR_NORMAL);

		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// Style the cell with borders all around.
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);

		cell.setCellStyle(cellStyle);

		return cell;
	}

	/**
	 * @return
	 */
	public String[] getSheetHeader() {
		return sheetHeader;
	}

	/**
	 * @param sheetHeader
	 */
	public void setSheetHeader(String[] sheetHeader) {
		this.sheetHeader = sheetHeader;
	}

	/**
	 * @return Returns the sheetData.
	 */
	public String[][] getSheetData() {
		return sheetData;
	}

	/**
	 * @param sheetData
	 *            The sheetData to set.
	 */
	public void setSheetData(String[][] sheetData) {
		this.sheetData = sheetData;
	}

	/**
	 * @return Returns the workbook.
	 */
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}
	
	
//	public List getBodyDate() {
//		return bodyDate;
//	}

//	public void setBodyDate(List bodyDate) {
//		this.bodyDate = bodyDate;
//	}
	
	/*
	public static void main(String[] args) {
		String result = "姓名,年龄,分数";
		String[] header = result.split("\\,");
		
		String[][] bodyData = new String[][] {{ "xiaoming", "23", "100" },{ "xiaowang", "25", "200" } };
		String fileName = "D:/dd.xls";
		
		ToolKit.printArray(bodyData);
		
		ExcelWriter writer = new ExcelWriter("data sheet");
		writer.setSheetHeader(header);
		writer.setSheetData(bodyData);
		writer.fillExcelSheet();
		
		try {
			writer.getWorkbook().write(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
