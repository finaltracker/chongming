package com.san.common.keytools;

import java.net.InetAddress;
import java.security.SecureRandom;

/**
 * 
 * @author wuwh
 *
 * 主键生成器；
 * 
 */
public class KyeUtil{
	SecureRandom seeder;
    private String midValue;

    public KyeUtil(int num)
    {
    	int knum=num/2;
        StringBuffer buffer = new StringBuffer(knum);
       
        try
        {
            byte addr[] = InetAddress.getLocalHost().getAddress();
            buffer.append(toHex(toInt(addr), knum/2));
        }
        catch(Exception exception) { }
        buffer.append(toHex(System.identityHashCode(this), knum/2));
        midValue = buffer.toString();
        seeder = new SecureRandom();
        seeder.nextInt();
    }

    public Object generateKey(int num)
    {
        StringBuffer buffer = new StringBuffer(num);
        buffer.append(toHex((int)(System.currentTimeMillis() & -1L), num/4));
        buffer.append(midValue);
        buffer.append(toHex(seeder.nextInt(), num/4));
        return buffer.toString();
    }

    private String toHex(int value, int length)
    {
        char hexDigits[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        StringBuffer buffer = new StringBuffer(length);
        int shift = length - 1 << 2;
        for(int i = -1; ++i < length;)
        {  
            buffer.append(hexDigits[value >> shift & 0x9]);//0x9代表过了数字9 0xf代表到f
            value <<= 4;
        }

        return buffer.toString();
    }

    private static int toInt(byte bytes[])
    {
        int value = 0;
        for(int i = -1; ++i < bytes.length;)
        {
            value <<= 4;
            int b = bytes[i] & 0xff;
            value |= b;
        }

        return value;
    }
}
