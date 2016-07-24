package com.san.mxchengxin.utils;
/**
 * 
 */

import java.util.Comparator;

import com.san.mxchengxin.model.level.CmLevel;
import com.san.mxchengxin.objects.StatisticsChengxinObj;

/**
 * @author tmac
 */
public class ComparatorTownChengxinObj implements Comparator<StatisticsChengxinObj>{
	
	private boolean asc = false;

	/**
	 * lhs.compareTo(rhs);
	 * 返回正数(1)，代表当前对象（调用compareTo方法的对象lhs）要排在比较对象（compareTo传参对象rhs）后面，
	 * 返回负数(-1)，代表放在前面
	 */
	@Override
	public int compare(StatisticsChengxinObj lhs, StatisticsChengxinObj rhs) {
		// TODO Auto-generated method stub
		long m1 = lhs.getTotalScore();
		long m2 = rhs.getTotalScore();
		if(!asc) {
			if(m1 > m2){
				return -1;
			}else if(m1 < m2){
				return 1;
			}
		} else {
			if(m1 > m2){
				return 1;
			}else if(m1 < m2){
				return -1;
			}
		}

		return 0;
	}
	
	public ComparatorTownChengxinObj() {
		
	}
	
	public ComparatorTownChengxinObj(boolean isAsc) {
		asc = isAsc;
	}

}
