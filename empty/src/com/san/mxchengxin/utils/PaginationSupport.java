package com.san.mxchengxin.utils;


import java.util.List;

public class PaginationSupport {

	public final static int PAGESIZE = 30;

	private int pageSize = PAGESIZE;

	private List items;

	private int totalCount;

	private int[] indexes = new int[0];

	private int startIndex = 0;

	public PaginationSupport(List items, int totalCount) {
		setPageSize(PAGESIZE);
                setTotalCount(totalCount);
		setItems(items);		
		setStartIndex(0);
	}

	public PaginationSupport(List items, int totalCount, int startIndex) {
                setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);		
		setStartIndex(startIndex);
	}

	public PaginationSupport(List items, int totalCount, int pageSize, int startIndex) {
                setPageSize(pageSize);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		
	}

	public int[] getIndexes() {
		return indexes;
	}

	public void setIndexes(int[] indexes) {
		this.indexes = indexes;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		
	}

	public int getNextIndex() {
		return 0;
	}

	public int getPreviousIndex() {
		
		return 0;
		
	}

}