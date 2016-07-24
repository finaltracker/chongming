package com.san.mxchengxin.objects;

public class StatisticsChengxinObj {
	String name ;
	long subScore;
	long addScore;
	long baseScore;
	long totalScore;
	String rank;
	
	public long getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(long totalScore) {
		this.totalScore = totalScore;
	}

	
	public StatisticsChengxinObj(String name, long subScore, long addScroe,
			long baseScore , long totalScore , String rank ) {
		super();
		this.name = name;
		this.subScore = subScore;
		this.addScore = addScroe;
		this.baseScore = baseScore;
		this.totalScore = totalScore;
		this.rank = rank;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSubScore() {
		return subScore;
	}
	public void setSubScore(long subScore) {
		this.subScore = subScore;
	}
	
	public long getAddScore() {
		return addScore;
	}

	public void setAddScore(long addScore) {
		this.addScore = addScore;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}

	public long getBaseScore() {
		return baseScore;
	}
	public void setBaseScore(long baseScore) {
		this.baseScore = baseScore;
	}
	
	
	
}
