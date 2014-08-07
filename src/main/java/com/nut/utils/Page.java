package com.nut.utils;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private static int DEFAULT_PAGE_SIZE = 20;
	private int pageSize = DEFAULT_PAGE_SIZE;
	private List<?> currentPageList;
	private int currentPageNo;
	private long totalCount;

	public Page(int pageSize, int currentPageNo, long totalCount,
			List<?> currentPageList) {
		this.pageSize = pageSize;
		this.currentPageNo = currentPageNo;
		this.totalCount = totalCount;
		this.currentPageList = currentPageList;
	}

	public Page(int currentPageNo, long totalCount, List<?> currentPageList) {
		this(DEFAULT_PAGE_SIZE, currentPageNo, totalCount, currentPageList);
	}

	public Page(int currentPageNo, long totalCount) {
		this(DEFAULT_PAGE_SIZE, currentPageNo, totalCount, new ArrayList<Object>());
	}

	public Page() {
		this(DEFAULT_PAGE_SIZE, 1, 0, new ArrayList<Object>());
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getCurrentPageList() {
		return currentPageList;
	}

	public void setCurrentPageList(List<?> currentPageList) {
		this.currentPageList = currentPageList;
	}

	public long getTotalPageCount() {
		return (totalCount % pageSize == 0) ? (totalCount / pageSize)
				: (totalCount / pageSize + 1);
	}

	public boolean hasNextPage() {
		if (currentPageNo < getTotalPageCount()) {
			return true;
		}
		return false;
	}

	public boolean hasPreviousPage() {
		if (currentPageNo == 1) {
			return true;
		}
		return false;
	}

	public int getFirstResultIndex() {
		return (currentPageNo - 1) * pageSize;
	}
}
