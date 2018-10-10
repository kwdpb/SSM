package com.kw.entity;


import java.util.List;


public class Page<T> {
   private int pageNum; 
   private int pageSize;  
   private int totalRecord; 
   
   private int totalPage; 
   private List<T> list;  
   private int StartIndex; 
   private int EndIndex;
   public Page(int pageNum,int pageSize,int totalRecord)
   {
	  this.pageNum=pageNum;
	  this.pageSize=pageSize;
	  this.totalRecord=totalRecord;
	  
	  if(totalRecord%pageSize==0)
	  {
		 this.totalPage=totalRecord/pageSize;
	  }else{
		 this.totalPage=totalRecord/pageSize+1;
	  }
	  this.StartIndex=(pageNum-1)*pageSize;
	  this.EndIndex=this.StartIndex+pageSize;
	  if(EndIndex>totalRecord)
	  {
		  this.EndIndex=totalRecord;
	  }
   }

public int getPageNum() {
	return pageNum;
}

public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getTotalRecord() {
	return totalRecord;
}

public void setTotalRecord(int totalRecord) {
	this.totalRecord = totalRecord;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public List<T> getList() {
	return list;
}

public void setList(List<T> list) {
	this.list = list;
}

public int getStartIndex() {
	return StartIndex;
}

public void setStartIndex(int startIndex) {
	StartIndex = startIndex;
}

public int getEndIndex() {
	return EndIndex;
}

public void setEndIndex(int endIndex) {
	EndIndex = endIndex;
}

}
