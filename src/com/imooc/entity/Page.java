package com.imooc.entity;

public class Page {
	private int totalNumber;//总条数
	private int currentPage;//当前页码
	private int totalPage;//总页数
	private int pageNumber=5;//每页条数
	private int dbIndex;//limit开始索引
	private int dbNumber;//limit位移
	
	/**
	 * 计算出总页码，当前页码（请求值不合法时，重置），索引开始位置，索引位移。
	 * 注意：得到总条数就可以开始这个算法了
	 */
	public void count(){
		//临时总页数
		int totalPageTemp = this.totalNumber/this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber)==0 ? 0 :1;
		totalPageTemp = totalPageTemp + plus;
		if(totalPageTemp == 0){
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;//总页数
		
		if(this.totalPage < this.currentPage){
			this.currentPage = this.totalPage;
		}
		if(this.currentPage < 1){
			this.currentPage = 1;
		}
		this.dbIndex = (this.currentPage-1)*this.pageNumber;
		this.dbNumber = this.pageNumber;
	}
	
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public int getDbNumber() {
		return dbNumber;
	}
	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
	
}
