package com.san.mxchengxin.utils;
/**
 * 
 */

import java.util.Comparator;

import com.san.mxchengxin.model.level.CmLevel;

/**
 * @author tmac
 */
public class ComparatorCmLevel implements Comparator<CmLevel>{

	/**
	 * lhs.compareTo(rhs);
	 * 返回正数(1)，代表当前对象（调用compareTo方法的对象lhs）要排在比较对象（compareTo传参对象rhs）后面，
	 * 返回负数(-1)，代表放在前面
	 */
	@Override
	public int compare(CmLevel lhs, CmLevel rhs) {
		// TODO Auto-generated method stub
		int m1 = Integer.valueOf(lhs.getLevelScore());
		int m2 = Integer.valueOf(rhs.getLevelScore());
		if(m1 > m2){
			return -1;
		}else if(m1 < m2){
			return 1;
		}
		return 0;
	}

}
