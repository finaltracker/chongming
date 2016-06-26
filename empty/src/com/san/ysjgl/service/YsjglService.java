package com.san.ysjgl.service;

import java.util.List;

import com.san.util.Vo;

public interface YsjglService {
	public Vo getSQL(int page,int rows,String sql);
	public Vo getSQL_2(int page, int rows, String sql);
	public Vo getHQL(int page,int rows,String hql);
	public Vo getSQL(String sql);
	public Vo getHQL(String hql);
	public boolean add(Object obj);
	public boolean update(Object obj);
	public boolean exedeleteSQL(String sql);
}
