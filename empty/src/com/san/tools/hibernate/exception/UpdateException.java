/*
 * UpdateException.java
 * ���ܣ�		
 * �������ڣ� 2005-4-26
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
