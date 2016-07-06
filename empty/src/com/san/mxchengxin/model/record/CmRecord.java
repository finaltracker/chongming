package com.san.mxchengxin.model.record;

import com.san.mxchengxin.model.country.CmPerson;
// default package



/**
 * CmRecord entity. @author MyEclipse Persistence Tools
 */

public class CmRecord  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private CmPerson person;
     private Integer targetId;
     private Short score;
     private String author;
     private Long pubdate;
     private Boolean stat;
     private Long dateline;
     private Long partId;


    // Constructors

    /** default constructor */
    public CmRecord() {
    }

	/** minimal constructor */
    public CmRecord(Integer personId, Integer targetId, Short score, String author, Long pubdate) {
       // this.personId = personId;
        this.targetId = targetId;
        this.score = score;
        this.author = author;
        this.pubdate = pubdate;
    }
    
    /** full constructor */
    public CmRecord(Integer personId, Integer targetId, Short score, String author, Long pubdate, Boolean stat, Long dateline, Long partId) {
        //this.personId = personId;
        this.targetId = targetId;
        this.score = score;
        this.author = author;
        this.pubdate = pubdate;
        this.stat = stat;
        this.dateline = dateline;
        this.partId = partId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public CmPerson getPerson() {
        return this.person;
    }
    
    public void setPerson(CmPerson person) {
        this.person = person;
    }

    public Integer getTargetId() {
        return this.targetId;
    }
    
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Short getScore() {
        return this.score;
    }
    
    public void setScore(Short score) {
        this.score = score;
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

    public Boolean getStat() {
        return this.stat;
    }
    
    public void setStat(Boolean stat) {
        this.stat = stat;
    }

    public Long getDateline() {
        return this.dateline;
    }
    
    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public Long getPartId() {
        return this.partId;
    }
    
    public void setPartId(Long partId) {
        this.partId = partId;
    }
   








}