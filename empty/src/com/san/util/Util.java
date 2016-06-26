package com.san.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * 辅助类
 */
public class Util {
	
	/**
	 * 判断Vo是否为空 
	 * true：为空
	 * false:不为空
	 */
	public static boolean isVoNull(Vo v){
		boolean b=true;
		if(null!=v && v.getPageCount()>0 && null!=v.getList() && v.getList().size()>0){
			return false;
		}
		return b;
	}
	/**
	 * 判断字符串是否为空
	 * true:为空
	 * false:不为空
	 */
	public static boolean isNull(String str){
		boolean b=true;
		if(null!=str && str.length()>0 && !"".equals(str)){
			return false;
		}
		return b;
	}
	
	 /**
	    * 判断字符串是否是数字
	    * true:非数字
	    * false:数字
	    */
	   public static boolean isNumber(String str){
		   if(null!=str && !"".equals(str) && str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")){
				return false;
			}else{
				return true;
			}
	   }
	/**
	 * 字符串转换为json
	 */
	 public static String ObjecttoJsonString(Object javaObj)
	  {
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.registerJsonValueProcessor(java.sql.Date.class , new JsonDateValueProcessor());
	     JSONObject json = JSONObject.fromObject(javaObj,jsonConfig);
	     return json.toString();
	  }
		/**
		 * 将java.util.Date日期转化为java.sql.Date
		 * @param udate
		 * @return
		 */
		public static java.sql.Date converUtilToSql(java.util.Date udate) {
			return new java.sql.Date(udate.getTime());
		}

		/**
		 * 将java.sql.Date日期转化为java.util.Date
		 * @param udate
		 * @return
		 */
		public static java.util.Date converSqlToUtil(java.sql.Date udate) {
			return new java.util.Date(udate.getTime());
		}
		/**
		 * json传输
		 */
	  public static void responseResult4Json(HttpServletResponse response, String jsonResult)
	  {
	    response.setCharacterEncoding("UTF-8");
	    try {
	      PrintWriter out = response.getWriter();
	      out.println(jsonResult);
	      out.flush();
	      out.close();
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	  public static SetJsonObject return_JSON(String[] thistablesx,Vo v){
			JSONArray json=new JSONArray();
			SetJsonObject jsonObj=new SetJsonObject();
			try {
				for (int i = 0; i < v.getList().size(); i++) {
					Object[] obj=(Object[])v.getList().get(i);
					JSONObject jobj=new JSONObject();
					for (int j = 0; j < thistablesx.length; j++) {
						String strarr = null==obj[j] ? "":obj[j].toString();
						String str =thistablesx[j];
						jobj.put(str,strarr);
					}
					json.add(jobj);
				}
				jsonObj.setRows(json);
				jsonObj.setTotal(v.getPageCount());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jsonObj;
		}
	  
	  /**
	   * 根据当前时间生成随机数 参数：随机数位数
	   */
	  public static String returnid(int f)
	  {
	    SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
	    String id = tempDate.format(new Date()) + validateCode(f);
	    return id;
	  }

	  public static String validateCode(int code_len)
	  {
	    int count = 0;
	    char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	    StringBuffer pwd = new StringBuffer("");
	    Random r = new Random();
	    while (count < code_len) {
	      int i = Math.abs(r.nextInt(10));
	      if ((i >= 0) && (i < str.length)) {
	        pwd.append(str[i]);
	        count++;
	      }
	    }
	    return pwd.toString();
	  }
	  /**
	   * 得到当前时间
	   * 格式自定义 不填 默认为"yyyy-MM-dd"
	   */
	  public static String getDate(String type)
	  {
		if(isNull(type)){type="yyyy-MM-dd";}  
	    SimpleDateFormat tempDate = new SimpleDateFormat(type);
	    return tempDate.format(new Date());
	  } 
	  /**
	   * 得到推迟N年的时间 
	   */
	  public static String tcNyearTime(int number){
			Calendar curr = Calendar.getInstance();
			curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-number);
			Date date=curr.getTime();
		    SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		    return tempDate.format(date);
		} 
	  public static String tcNyearTime(int number,String type){
			Calendar curr = Calendar.getInstance();
			curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-number);
			Date date=curr.getTime();
		    SimpleDateFormat tempDate = new SimpleDateFormat(type);
		    return tempDate.format(date);
		}
	  
	  /**
	    * 把字符串的数据转换为日期格式
	    * @param strDate
	    * @return
	    */
	  public static Date strToDate(String strDate){
	       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       Date date = null;
	       try{
	     if(!Util.isNull(strDate)){
	    	 date = dateFormat.parse(strDate);
	     }
	    }catch(ParseException e){
	       System.out.println(e.getMessage());
	    }
	    return date;
	   }public static Date strToDate(String strDate,String type){
	       SimpleDateFormat dateFormat = new SimpleDateFormat(type);
	       Date date = null;
	       try{
	     if(!Util.isNull(strDate)){
	    	 date = dateFormat.parse(strDate);
	     }
	    }catch(ParseException e){
	       System.out.println(e.getMessage());
	    }
	    return date;
	   }
	   /**
	    * 把数组转换成字符串 以","分割
	    */
	   public static String arrToStr(String[] obj){
		   String str="";
		   if(null==obj || obj.length<=0){
			   return str;
		   }
		   for (int i = 0; i < obj.length; i++) {
			   str+=obj[i]+",";
		   }
		   str=str.substring(0,str.length()-1);
		   return str;
	   }
	   /**
	    * 文件上传
	    * 支持单文件，多文件， 返回hashMap， hashMap的键对应文本框的名字， 值对应保存的路径
	    * @throws Exception 
	    * 
	    */
	   public static HashMap<String, String> upfile(ActionForm form, HttpServletRequest request, HttpServletResponse response, String firstfilename) throws Exception{
	 	  HashMap<String, String> hashMapFile=new HashMap<String, String>();//保存上传的结果   键对应文本框的名字， 值对应保存的路径
	 	  Hashtable files=form.getMultipartRequestHandler().getFileElements();//得到所有的input file
	 	  for (Enumeration e = files.keys(); e.hasMoreElements();) {//循环每一个input file    files.keys();//得到其中一项
	 		//文本框名字
	 	    String filekey=e.nextElement().toString();
	 	    //得到这个文件
	 	    FormFile file = (FormFile)files.get(filekey);
	 	    if ((file == null) || (file.getFileSize() <= 0)) {//判断这个文件是否存在
	 	    	continue;
	 	    }
	 	    //得到文件名
	 	    String fileName = file.getFileName();
	 	    //文件大小
	 	    int fileSize = file.getFileSize();
	 	    //准备上传的路径
	 	    String rootPath = request.getRealPath("file/" + firstfilename);
	 	    //判断上传的路径是否存在
	 	    File f = new File(rootPath);
	 	      if (!f.exists()) {
	 	        f.mkdirs();
	 	      }  
	 		 
	 	      InputStream is = file.getInputStream();
	 	      FileOutputStream fos = null;
	 	      //上传
	 	      try {
	 	          fos = new FileOutputStream(new File(f, fileName));
	 	          byte[] b = new byte[1024];
	 	          int real = 0;
	 	          real = is.read(b);
	 	          while (real > 0) {
	 	            fos.write(b, 0, real);
	 	            real = is.read(b);
	 	          }
	 	        } catch (RuntimeException e1) {
	 	      	  e1.printStackTrace();
	 	          System.out.println("-----------utileupdown上传文件出错-----------");
	 	        }
	 	       //当前上传的文件保存的目录
	 	       String webName=request.getContextPath().substring(1,request.getContextPath().length());
	 	       String path="\\"+webName+"\\file\\" + firstfilename + "\\" + fileName;
	 	       //保存到结果集
	 	       hashMapFile.put(filekey, path);
	 	       fos.close();
	 	       is.close();
	 	       System.out.println("文件信息:");
	 	       System.out.println("\t文本框名字:" + filekey);
	 	       System.out.println("\t文件名:" + fileName);
	 	       System.out.println("\t文件路径:" + path);
	 	       file.destroy();
	 	  }
	 	  return hashMapFile;
	   }
	 
	   /**
	 * 下载
	 */
	public static boolean downFile(HttpServletResponse response, String path) {
		boolean flag = false;
		File file = null;
		try {
			file = new File(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != file) {
			if (file.exists()) {
				try {
					//弹出下载对话框
					response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(file.getName(), "utf-8"));
					OutputStream os = os = response.getOutputStream();
					InputStream is = is = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(is);
					BufferedOutputStream bos = new BufferedOutputStream(os);
					//用输入流进行先读，然后用输出流去写
					int bytesRead = 0;
					byte[] buffer = new byte[8192];
					while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
						bos.write(buffer, 0, bytesRead);
					}
					bos.flush();
					bos.close();
					bis.close();
					os.flush();
					os.close();
					is.close();
					flag = true;
				} catch (IOException e) {
					flag = false;
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}
