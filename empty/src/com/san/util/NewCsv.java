package com.san.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public  class NewCsv{
	/**
	 * 生成Csv
	 * list:第一行为标题，从第二行起为内容
	 * url:生成Csv的路径
	 * filename:Csv名称
	 */
	public static void initExcel(List list,String url,String filename){
		 try {   
			 	 File file2 = new File(url);
		    	 file2.mkdirs();
		    
	            FileWriter fw = new FileWriter(url+"\\"+filename);  
	            for(int i=0; i<list.size(); i++){
	    			Object[] obj=(Object[])list.get(i);
					String value ="";
	    			for (int j = 0; j < obj.length; j++) {
    					if(null!=obj[j] && !"".equals(obj[j].toString())){
    						value+=obj[j].toString().replaceAll(",","，");
    						if(j<obj.length-1){
    							value+=",";
    						}
    					}
	    			}
		            fw.write(value+"\r\n");
	    		}
	            fw.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
	}
}
