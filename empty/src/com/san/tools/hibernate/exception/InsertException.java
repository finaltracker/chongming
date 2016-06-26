/*
 * InsertException.java
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
