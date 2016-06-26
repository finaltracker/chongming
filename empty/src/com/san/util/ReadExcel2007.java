package com.san.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
* 解析excel2007
*/
public  class ReadExcel2007{

	private Logger logger= Logger.getLogger(ReadExcel2007.class);

	private List thiscoslist;//要查询的多列
	private List thisrows;//要跳过的行
	private XSSFWorkbook workbook ;
	public ReadExcel2007(File excelFile,List thiscoslist,List list) throws FileNotFoundException, IOException{
		this.thiscoslist=thiscoslist;
		this.thisrows=list;
	   workbook = new XSSFWorkbook(new FileInputStream(excelFile));
	}
	 
	/**
	*读表 返回多条多列
	*/
	public List getDatasInSheetarr(int sheetNumber) throws FileNotFoundException, IOException{
	   List result = new ArrayList();
	  
	   //获得指定的表
	   XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
	   //获得数据总行数
	   int rowCount = sheet.getLastRowNum();
	   logger.info("found excel rows count: " + rowCount);
	   if (rowCount < 1) {
	    return result;
	   }
	   //逐行读取数据
	   for (int rowIndex = 0; rowIndex <= rowCount; rowIndex++) {
		if(tiaogrows(rowIndex)){continue;}//跳过指定的行
	    //获得行对象
	    XSSFRow row = sheet.getRow(rowIndex);
	    if (row != null) {
	    List list=new ArrayList();	
		 //读取指定的列	
	    for (int i = 0; i < thiscoslist.size(); i++) {
	    	 //获得本行中单元格的个数
	        int columnCount = row.getLastCellNum();
	        //获得本行中各单元格中的数据
	        XSSFCell cell = row.getCell(Short.parseShort(thiscoslist.get(i).toString()));
	        //获得指定单元格中数据
	        Object cellStr = this.getCellString(cell);
	        if(null!=cellStr){
	        	list.add(cellStr.toString());
	         }else{
	        	 list.add("");
	         }
		}	
	    result.add(list);
	    }
	   }
	   return result;
	}
	/**
	*读取所有列
	*/
	public List<List> getDatasInSheetarrall(int sheetNumber) throws FileNotFoundException, IOException{
	   List result = new ArrayList();
	  
	   //获得指定的表
	   XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
	   //获得数据总行数
	   int rowCount = sheet.getLastRowNum();
	   logger.info("found excel rows count: " + rowCount);
	   if (rowCount < 1) {
	    return result;
	   }
	   //逐行读取数据
	   for (int rowIndex = 0; rowIndex <= rowCount; rowIndex++) {
		if(tiaogrows(rowIndex)){continue;}//跳过指定的行
	    //获得行对象
	    XSSFRow row = sheet.getRow(rowIndex);
	    if (row != null) {
	    List list=new ArrayList();	
	    int columnCount = row.getLastCellNum();
		 //读取所有的列	
	    for (int i = 0; i <columnCount; i++) {
	    	 //获得本行中单元格的个数
	        //获得本行中各单元格中的数据
	        XSSFCell cell = row.getCell(Short.parseShort(i+""));
	        //获得指定单元格中数据
	        Object cellStr = this.getCellString(cell);
	        if(null!=cellStr){
	        	list.add(cellStr.toString());
	         }else{
	        	 list.add("");
	         }
		}	
	    result.add(list);
	    }
	   }
	   return result;
	}
	/**
	*多行一列
	*/
	public List<String> getDatasInSheet(int sheetNumber) throws FileNotFoundException, IOException{
	   List<String> result = new ArrayList<String>();
	  
	   //获得指定的表
	   XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
	   //获得数据总行数
	   int rowCount = sheet.getLastRowNum();
	   logger.info("found excel rows count: " + rowCount);
	   if (rowCount < 1) {
	    return result;
	   }
	   //逐行读取数据
	   for (int rowIndex = 0; rowIndex <= rowCount; rowIndex++) {
		if(tiaogrows(rowIndex)){continue;}//跳过指定的行
	    //获得行对象
	    XSSFRow row = sheet.getRow(rowIndex);
	    if (row != null) {
		 //读取指定的列	
	    for (int i = 0; i < thiscoslist.size(); i++) {
	    	 //获得本行中单元格的个数
	        int columnCount = row.getLastCellNum();
	        //获得本行中各单元格中的数据
	        XSSFCell cell = row.getCell(Short.parseShort(thiscoslist.get(i).toString()));
	        //获得指定单元格中数据
	        Object cellStr = this.getCellString(cell);
	        if(null!=cellStr){
	            result.add(cellStr.toString());
	         }else{
	             result.add("0");
	         }
		}	
	    
	    }
	   }
	   return result;
	}
	//跳过指定的行
	public boolean tiaogrows(int rowIndex){
		boolean b=true;
		   if(null!=this.thisrows && this.thisrows.size()>0){
			   boolean rowsbool=false;
			   for (int i = 0; i < thisrows.size(); i++) {
				   int temprows=Integer.parseInt(thisrows.get(i).toString());
				   if(rowIndex==temprows){
					   rowsbool=true;
					   break;
				   }else{
					   rowsbool=false;
				   }
			   }
			   if(rowsbool){
				   return true;
			   }
		   }
		return false;
	}

	/**
	* 获得单元格中的内容
	* @param cell
	* @return
	*/
	protected Object getCellString(XSSFCell cell){
	   Object result = null;
	   if (cell != null) {
	    int cellType = cell.getCellType();
	    switch(cellType){
	    case XSSFCell.CELL_TYPE_STRING :
	     result = cell.getStringCellValue();
	     break;
	    case XSSFCell.CELL_TYPE_NUMERIC:
	     result=cell.getNumericCellValue();
	     break;
	    case XSSFCell.CELL_TYPE_FORMULA:
	     result = cell.getNumericCellValue();
	     break;
	    case XSSFCell.CELL_TYPE_ERROR:
	     break;
	    case XSSFCell.CELL_TYPE_BOOLEAN:
	     result=cell.getBooleanCellValue();
	     break;
	    case XSSFCell.CELL_TYPE_BLANK:
	     result=null;
	     break;
	    }
	   }
	   return result;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\Administrator\\Desktop\\test_07.xlsx");
		 List list2=new ArrayList();
		   List list=new ArrayList();list.add(0);//要跳过的行
		   ReadExcel2007 parser3 = new ReadExcel2007(file,null,list);
		   List<List> datas=parser3.getDatasInSheetarrall(0);
		   for (int i = 0; i <datas.size(); i++) {
			   List listinfo=(List) datas.get(i);
			   for (int j = 0; j < listinfo.size(); j++) {
				System.out.print(listinfo.get(j)+"				");
			   }
			System.out.println("");
		   }
		   
	}

	public void setThisrows(List thisrows) {
		this.thisrows = thisrows;
	}


	public List getThisrows() {
		return thisrows;
	}
	public List getThiscoslist() {
		return thiscoslist;
	}
	public void setThiscoslist(List thiscoslist) {
		this.thiscoslist = thiscoslist;
	}
}
