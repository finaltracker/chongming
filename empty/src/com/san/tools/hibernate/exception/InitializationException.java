/*
 * InitializationException.java
 * 功能：		
 * 创建日期： 2005-5-16
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
public class InitializationException extends Exception
{
    public InitializationException()
    {
        super();
    }
    
    public InitializationException(String msg)
    {
        super(msg);
    }
    
    public InitializationException(String msg, Throwable root)
    {
        super(msg, root);
    }
    
    public InitializationException(Throwable root)
    {
        super(root);
    }

}
