/*
 * InsertException.java
 * 功能：		
 * 创建日期： 2005-4-26
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
public class InsertException extends Exception
{
    public InsertException()
    {
        super();
    }
    
    public InsertException(String msg)
    {
        super(msg);
    }
    
    public InsertException(String msg, Throwable root)
    {
        super(msg, root);
    }
    
    public InsertException(Throwable root)
    {
        super(root);
    }
}
