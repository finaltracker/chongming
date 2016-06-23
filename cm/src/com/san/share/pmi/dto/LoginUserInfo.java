package com.san.share.pmi.dto;

public class LoginUserInfo {

	public String Cn;
	public String Ouid;
	public String Ounname;
	public String Sn;
	
	public LoginUserInfo( String Cn )
	{
		this.Cn = Cn;
		
		if( Cn.equals( "cm") )
		{
			Ouid = "1";
			Ounname = "崇明县";
			Sn = "cm";
		}
		if( Cn.equals( "zhongxin") )
		{
			Ouid = "OrgL20160509094607551";
			Ounname = "";
			Sn = "zhongxin";
		}
		if( Cn.equals( "OrgL20160509094607551") )
		{
			Ouid = "OuLi20160509152916080";
			Ounname = "";
			Sn = "cunming2";
		}
		if( Cn.equals( "sifa") )
		{
			Ouid = "OuLi20160509094607551";
			Ounname = "县司法局";
			Sn = "sifa";
		}
	}
	
	
	public String getCn() //获得用户登录名
	{
		return Cn;
	}
	
	public String getOuid()//获得用户所属部门ID
	{
		return Ouid;
	}
	public String getOuname()//获得用户所属部门名称
	{
		return Ounname;
	}
	public String getSn()//获得用户姓名
	{
		return Sn;
	}
}
