package com.san.mxchengxin.model.log;

import com.san.mxchengxin.utils.util;

public class CmLogEnhance extends CmLog {
	public String pubdateStr ;

	public CmLogEnhance( Long id , String info ,Long pubdate ,String author ,String ip )
	{
		this.setId(id);
		this.setInfo(info);
		this.setPubdate(pubdate);
		this.setAuthor(author);
		
		setPubdateStr(util.dateLongToString( this.getPubdate()));
	}
	
	public CmLogEnhance( CmLog cl )
	{
		this.setId(cl.getId());
		this.setInfo(cl.getInfo());
		this.setPubdate(cl.getPubdate());
		this.setAuthor(cl.getAuthor());
		this.setIp( cl.getIp() );
		
		setPubdateStr(util.dateLongToString( this.getPubdate()));
	}
	
	public String getPubdateStr() {
		return pubdateStr ;
		
	}

	public void setPubdateStr(String pubdateStr) {
		this.pubdateStr = pubdateStr;
	}
	
	
}
