package com.san.chengxin.model.target;

public class CmTargetEnhance extends CmTarget {
	String partName;

	public CmTargetEnhance( CmTarget in )
	{
		this.setId( in.getId() );
		this.setTargetName( in.getTargetName() );
		this.setTargetScore( in.getTargetScore() );
		this.setAuthor( in.getAuthor() );
		this.setPubdate( in.getPubdate() );
		this.setDateline( in.getDateline() );
		this.setPartId( in.getPartId());
	}
	
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	
}
