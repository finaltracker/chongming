// default package



/**
 * CmStatistics entity. @author MyEclipse Persistence Tools
 */

public class CmStatistics  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer personId;
     private Short countryId;
     private Short scoreBase;
     private Short scoreAdd;
     private Short scoreSub;


    // Constructors

    /** default constructor */
    public CmStatistics() {
    }

	/** minimal constructor */
    public CmStatistics(Integer personId) {
        this.personId = personId;
    }
    
    /** full constructor */
    public CmStatistics(Integer personId, Short countryId, Short scoreBase, Short scoreAdd, Short scoreSub) {
        this.personId = personId;
        this.countryId = countryId;
        this.scoreBase = scoreBase;
        this.scoreAdd = scoreAdd;
        this.scoreSub = scoreSub;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Short getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public Short getScoreBase() {
        return this.scoreBase;
    }
    
    public void setScoreBase(Short scoreBase) {
        this.scoreBase = scoreBase;
    }

    public Short getScoreAdd() {
        return this.scoreAdd;
    }
    
    public void setScoreAdd(Short scoreAdd) {
        this.scoreAdd = scoreAdd;
    }

    public Short getScoreSub() {
        return this.scoreSub;
    }
    
    public void setScoreSub(Short scoreSub) {
        this.scoreSub = scoreSub;
    }
   








}