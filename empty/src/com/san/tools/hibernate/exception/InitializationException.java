/*
 * InitializationException.java
 * ���ܣ�		
 * �������ڣ� 2005-5-16
 * ���ߣ� 	ʢ����
 * �汾��		0.1
 * �޶���ʷ��
 * 			
 * 
 * ���汾�� 
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
