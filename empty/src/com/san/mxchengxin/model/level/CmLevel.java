package com.san.mxchengxin.model.level;


/**
 * CmLevel entity. @author MyEclipse Persistence Tools
 */

public class CmLevel  implements java.io.Serializable {


    // Fields    

     public Short id;
     public String levelScore;
     public String levelName;
     public String author;
     public Long pubdate;


    // Constructors

    /** default constructor */
    public CmLevel() {
    }

    
    /** full constructor */
    public CmLevel(String levelScore, String levelName, String author, Long pubdate) {
        this.levelScore = levelScore;
        this.levelName = levelName;
        this.author = author;
        this.pubdate = pubdate;
    }

   
    // Property accessors

    public Short getId() {
        return this.id;
    }
    
    public void setId(Short id) {
        this.id = id;
    }

    public String getLevelScore() {
        return this.levelScore;
    }
    
    public void setLevelScore(String levelScore) {
        this.levelScore = levelScore;
    }

    public String getLevelName() {
        return this.levelName;
    }
    
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPubdate() {
        return this.pubdate;
    }
    
    public void setPubdate(Long pubdate) {
        this.pubdate = pubdate;
    }
   








}