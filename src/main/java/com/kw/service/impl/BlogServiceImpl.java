package com.kw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kw.dao.BlogDao;
import com.kw.entity.Blog;
import com.kw.entity.Page;
import com.kw.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	private BlogDao blDao;
	
	@Override
	public Page<Blog> allBlog(int pageNum, int pageSize){
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		int totalRecord=blDao.getBlogCount(map);
		Page<Blog> page=new Page<Blog>(pageNum, pageSize, totalRecord);
		int start=page.getStartIndex();
		int end=page.getEndIndex();
		map.put("startindex", start);
		map.put("endindex", end);
		page.setList(blDao.getAllBlog(map));
		return page;
	}

	@Override
	public Page<Blog> pagingBlog(int pageNum, int pageSize,int categoryid) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("categoryid", categoryid);
/*		System.out.println("标签id:"+map.get("categoryid"));*/
		int totalRecord=blDao.getBlogCount(map);
/*		System.out.println("标签博客总数："+totalRecord);*/
		
		Page<Blog> page=new Page<Blog>(pageNum, pageSize, totalRecord);
		int start=page.getStartIndex();
		int end=page.getEndIndex();
		map.put("startindex", start);
		map.put("endindex", end);
		page.setList(blDao.getPageBlog(map));
		return page;
	}

	@Override
	public List<Blog> getHotBlog() {
		// TODO Auto-generated method stub
		return blDao.getHotBlog();
	}

	@Override
	public List<Blog> getNewBlog() {
		// TODO Auto-generated method stub
		return blDao.getNewBlog();
	}

	@Override
	public Blog BlogContent(int id) {
		// TODO Auto-generated method stub
		return blDao.getBlogContent(id);
	}

	@Override
	public Page<Blog> searchBlog(int pageNum, int pageSize, String keyword) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		int totalRecord=blDao.getSearchCount(keyword);
		Page<Blog> page=new Page<Blog>(pageNum, pageSize, totalRecord);
		int start=page.getStartIndex();
		int end=page.getEndIndex();
		map.put("startindex", start);
		map.put("endindex", end);
		map.put("keyword", keyword);
		page.setList(blDao.getSearchBlog(map));
		return page;
	}

	@Override
	public void insertBlog(Blog blog) {
		// TODO Auto-generated method stub
		blDao.insertBlog(blog);
	}

	@Override
	public void pageView(int id) {
		// TODO Auto-generated method stub
		blDao.pageView(id);
	}

	@Override
	public void delete_blog(int id) {
		// TODO Auto-generated method stub
		blDao.deleteBlog(id);
	}

	@Override
	public List<Blog> getcategory() {
		// TODO Auto-generated method stub
		return blDao.getType();
	}
	
	
	
	

}
