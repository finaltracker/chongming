package com.san.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
* 解析excel2003
*/
public  class ReadExcel2003{
 
private Logger logger= Logger.getLogger(ReadExcel2003.class);

private List thiscoslist;//要查询的多列
private List thisrows;//要跳过的行
private HSSFWorkbook workbook ;
public ReadExcel2003(File excelFile,List thiscoslist,List list) throws FileNotFoundException, IOException{
	this.thiscoslist=thiscoslist;
	this.thisrows=list;
   workbook = new HSSFWorkbook(new FileInputStream(excelFile));
}
 
/**
*读表 返回多条多列
*/
public List getDatasInSheetarr(int sheetNumber) throws FileNotFoundException, IOException{
   List result = new ArrayList();
  
   //获得指定的表
   HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
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
    HSSFRow row = sheet.getRow(rowIndex);
    if (row != null) {
    List list=new ArrayList();	
	 //读取指定的列	
    for (int i = 0; i < thiscoslist.size(); i++) {
    	 //获得本行中单元格的个数
        int columnCount = row.getLastCellNum();
        //获得本行中各单元格中的数据
        HSSFCell cell = row.getCell(Short.parseShort(thiscoslist.get(i).toString()));
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
   HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
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
    HSSFRow row = sheet.getRow(rowIndex);
    if (row != null) {
    List list=new ArrayList();	
    int columnCount = row.getLastCellNum();
	 //读取所有的列	
    for (int i = 0; i <columnCount; i++) {
    	 //获得本行中单元格的个数
        //获得本行中各单元格中的数据
        HSSFCell cell = row.getCell(Short.parseShort(i+""));
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
   HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
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
    HSSFRow row = sheet.getRow(rowIndex);
    if (row != null) {
	 //读取指定的列	
    for (int i = 0; i < thiscoslist.size(); i++) {
    	 //获得本行中单元格的个数
        int columnCount = row.getLastCellNum();
        //获得本行中各单元格中的数据
        HSSFCell cell = row.getCell(Short.parseShort(thiscoslist.get(i).toString()));
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
protected Object getCellString(HSSFCell cell){
   Object result = null;
   if (cell != null) {
    int cellType = cell.getCellType();
    switch(cellType){
    case HSSFCell.CELL_TYPE_STRING :
     result = cell.getStringCellValue();
     break;
    case HSSFCell.CELL_TYPE_NUMERIC:
     result=cell.getNumericCellValue();
     break;
    case HSSFCell.CELL_TYPE_FORMULA:
     result = cell.getNumericCellValue();
     break;
    case HSSFCell.CELL_TYPE_ERROR:
     break;
    case HSSFCell.CELL_TYPE_BOOLEAN:
     result=cell.getBooleanCellValue();
     break;
    case HSSFCell.CELL_TYPE_BLANK:
     result=null;
     break;
    }
   }
   return result;
}

public static void main(String[] args) throws Exception {
	File file = new File("C:\\Users\\Administrator\\Desktop\\Book1.xls");
	/* //年初
	  List list=new ArrayList();list.add(0);list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(18);//要跳过的行
	  List list2=new ArrayList();list2.add(2);//要查询的列
	  ExcelSheetParser parser = new ExcelSheetParser(file,list2,list);
	  List<String> datas = parser.getDatasInSheet(0);
	 //资产负债信息
	   //年初
	   List list3=new ArrayList();list3.add(0);list3.add(1);list3.add(2);list3.add(3);list3.add(4);list3.add(5);list3.add(19);list3.add(29);//要跳过的行
	   List list6=new ArrayList();list6.add(6);//要查询的列
	   ExcelSheetParser parser2 = new ExcelSheetParser(file,list6,list3);
	   List<String> datas2 = parser2.getDatasInSheet(0);

	   //合并数据并进行封装
	   datas.addAll(datas2);
	   Collections.sort(datas);
	   System.out.println(datas);
	   
	   List list2=new ArrayList();
	   List list=new ArrayList();list.add(0);//要跳过的行
	   ExcelSheetParser parser3 = new ExcelSheetParser(file,null,list);
	   List<List> datas=parser3.getDatasInSheetarrall(0);
	   for (int i = 0; i <datas.size(); i++) {
		   List listinfo=(List) datas.get(i);
		   for (int j = 0; j < listinfo.size(); j++) {
			System.out.print(listinfo.get(j)+"				");
		   }
		System.out.println("");
	   }*/

	 List list2=new ArrayList();
	   List list=new ArrayList();list.add(0);//要跳过的行
	   ReadExcel2003 parser3 = new ReadExcel2003(file,null,list);
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
