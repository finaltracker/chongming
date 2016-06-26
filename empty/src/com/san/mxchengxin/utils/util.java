package com.san.mxchengxin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class util {

	static public String dateLongToString( long DataLong )
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date= new Date(DataLong * 1000); //ms
        return sdf.format(date);
	}
}
