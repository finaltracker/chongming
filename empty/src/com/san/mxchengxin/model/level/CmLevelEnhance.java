package com.san.mxchengxin.model.level;

import com.san.mxchengxin.model.target.CmTarget;
import com.san.mxchengxin.utils.util;


/**
 * CmLevel entity. @author MyEclipse Persistence Tools
 */

public class CmLevelEnhance   extends CmLevel{


    // Fields    

	String stringPubData;


    // Constructors

    /** default constructor */
   
    public CmLevelEnhance( CmLevel in )
	{
    	this.id = in.id;
    	this.levelScore = in.levelScore;
        this.levelName = in.levelName;
        this.author = in.author;
        this.pubdate = in.pubdate;
	}
    


    public String getstringPubData() {
    	return util.dateLongToString( this.getPubdate());
    }
    
    public void setstringPubData(String stringPubData) {
        this.stringPubData = stringPubData;
    }
   








}