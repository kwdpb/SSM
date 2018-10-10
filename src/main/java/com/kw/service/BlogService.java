package com.kw.service;

import java.util.List;
import com.kw.entity.Blog;
import com.kw.entity.Page;

public interface BlogService {

	public Page<Blog> allBlog(int pageNum, int pageSize);
	
	public Page<Blog> pagingBlog(int pageNum, int pageSize,int categoryid);
	
	public List<Blog> getHotBlog();
	
	public List<Blog> getNewBlog();
	
	public Blog BlogContent(int id);
	
	public Page<Blog> searchBlog(int pageNum, int pageSize,String keyword);
	
	public void insertBlog(Blog blog);
	
	//文章访问量统计
	void pageView(int id);
	
	//删除指定博客  @param id 指定博客Id
	void delete_blog(int id);
	
	//获取类别
	List<Blog> getcategory();
}
