/*
 * FindException.java
 * 功能：		
 * 创建日期： 2005-4-29
 * 作者： 	盛海军
 * 版本：		0.1
 * 修订历史：
 * 			
 * 
 * 最后版本： 
 **/
package com.san.tools.hibernate.exception;


/**
 * 
 */
public class FindException extends Exception
{
    public FindException()
    {
        super();
    }
    
    public FindException(String msg)
    {
        super(msg);
    }
    
    public FindException(String msg, Throwable root)
    {
        super(msg, root);
    }
    
    public FindException(Throwable root)
    {
        super(root);
    }

}
