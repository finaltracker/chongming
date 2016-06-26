package com.logServices.zqs.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;

public class MyUtil {
	
	//分页语句
	public int getFirstSize(int pageNo,int pageSize){
	   int firstSize = 0;
	   firstSize = (pageNo -1) * pageSize;
	   return firstSize;
	}
	
	 //关闭数据连接池
	public void closeSource(Object object){
	        if(null == object) return;
	        if(object instanceof Session)
	        {
	            Session session = (Session)object;
	            session.close();
	        }
	        else if(object instanceof Connection)
	        {
	            Connection conn = (Connection)object;
	            try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else if(object instanceof CallableStatement)
	        {
	            CallableStatement callProc = (CallableStatement)object;
	            try {
					callProc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else if(object instanceof Statement)
	        {
	        	Statement statement = (Statement)object;
	        	try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
}
