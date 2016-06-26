/*
 * DeleteException.java
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