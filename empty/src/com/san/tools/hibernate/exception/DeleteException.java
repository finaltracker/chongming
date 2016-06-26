/*
 * DeleteException.java
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
public class DeleteException extends Exception
{
    public DeleteException()
    {
        super();
    }
    
    public DeleteException(String msg)
    {
        super(msg);
    }
    
    public DeleteException(String msg, Throwable root)
    {
        super(msg, root);
    }
    
    public DeleteException(Throwable root)
    {
        super(root);
    }
}
