package com.kw.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kw.entity.Blog;

public interface BlogDao {
	
	
	public void insertBlog(Blog blog);
	
	
	public void deleteBlog(int  id);
	
	
	public void updateBlog(Blog blog);
	
	public List<Blog> getAllBlog(Map<String, Object> map); 
	
	//根据标签id获取博客总数
	public List<Blog> getPageBlog(Map<String, Object> map);
	
	//根据博客id获取博客
	public List<Blog> findBlogById(Map<String, Integer> map);
	
	//根据标签id获取博客总数
	public int getBlogCount(Map<String,Object> map);
	
	//获取数据库点击量前五博客
	public List<Blog> getHotBlog(); 
	
	//获取数据库最新博客
	public List<Blog> getNewBlog(); 
	
	//获取博客内容
	public Blog getBlogContent(int id);
	
	
	public List<Blog> getSearchBlog(Map<String, Object> map);
	
	//文章访问量
	void pageView(int id);
	
	//获取分类
	List<Blog> getType(); 
	
	int getSearchCount(String keyword);
}
