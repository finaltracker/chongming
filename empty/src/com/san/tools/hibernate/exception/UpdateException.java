/*
 * UpdateException.java
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
public class UpdateException extends Exception
{
    public UpdateException()
    {
        super();
    }
    
    public UpdateException(String msg)
    {
        super(msg);
    }
    
    public UpdateException(String msg, Throwable root)
    {
        super(msg, root);
    }
    
    public UpdateException(Throwable root)
    {
        super(root);
    }
}
