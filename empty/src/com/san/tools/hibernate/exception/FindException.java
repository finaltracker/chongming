/*
 * FindException.java
 * ���ܣ�		
 * �������ڣ� 2005-4-29
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
