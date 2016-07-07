package com.san.mxchengxin.model.log;


/**
 * CmLog entity. @author MyEclipse Persistence Tools
 */

public class CmLog  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String info;
     private Long pubdate;
     private String author;
     private String ip;


    // Constructors

    /** default constructor */
    public CmLog() {
    }

	/** minimal constructor */
    public CmLog(Long pubdate) {
        this.pubdate = pubdate;
    }
    
    /** full constructor */
    public CmLog(String info, Long pubdate, String author, String ip) {
        this.info = info;
        this.pubdate = pubdate;
        this.author = author;
        this.ip = ip;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    public Long getPubdate() {
        return this.pubdate;
    }
    
    public void setPubdate(Long pubdate) {
        this.pubdate = pubdate;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
   








}