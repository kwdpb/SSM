package com.kw.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kw.entity.Blog;
import com.kw.entity.Page;
import com.kw.service.BlogService;
import com.kw.util.getDateutil;




@Controller
public class BlogController {
	@Autowired
	private BlogService bService;
	
	
	@RequestMapping(value="AllBlog")
	public String AllBlog(Model model,HttpServletRequest request){
		String page=request.getParameter("page");
		int pageNum;
		try {
			pageNum=Integer.parseInt(page);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			pageNum=1;
		}
		int pageSize=8;
		Page<Blog> pageList=bService.allBlog(pageNum, pageSize);
		model.addAttribute("essayquery",pageList);
		return "blogmanage";
	}
	
	@RequestMapping(value="tagblog")
	public String tagblog(HttpServletRequest request,Model model){
		String page=request.getParameter("page");
		int pageNum;
		try {
			pageNum=Integer.parseInt(page);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			pageNum=1;
		}
		int pageSize=5;
		String tagid=request.getParameter("categoryid");
		int categoryid=Integer.parseInt(tagid);
		Page page2=bService.pagingBlog(pageNum, pageSize,categoryid);
		List hotblogList=bService.getHotBlog();
		List newblogList=bService.getNewBlog();
		model.addAttribute("tagblog", page2);
		model.addAttribute("categoryid",categoryid);
		model.addAttribute("hotblog", hotblogList);
		model.addAttribute("newblog",newblogList);
		return "tagblog";
	}
	
	@RequestMapping(value="blogcontent")
	public String blogcontent(HttpServletRequest request,Model model){
		String blogid=request.getParameter("id");
		int ID=Integer.parseInt(blogid);
		Blog blog=bService.BlogContent(ID);
		model.addAttribute("blogcontent",blog);
		return "blogcontent";
	}
	
	
	@RequestMapping(value="pageview")
	@ResponseBody
	public void pageview(
			@RequestParam("blogid") int blogid
			)throws IOException{
		bService.pageView(blogid);
	}
	
	@RequestMapping(value="searchblog",method=RequestMethod.GET)
	public String searchblog
		(@RequestParam("keyword") String keyword, //利用GET获取数据，使乱码解决，但如果set时仍会乱码
		 HttpServletRequest request,
		 HttpServletResponse response,
		 Model model){
		String page=request.getParameter("page");
		int pageNum;
		try {
			pageNum=Integer.parseInt(page);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			pageNum=1;
		}
		int pageSize=5;
		Page<Blog> page3=bService.searchBlog(pageNum, pageSize, keyword);
		List<Blog> hotblogList=bService.getHotBlog();
		List<Blog> newblogList=bService.getNewBlog();
		model.addAttribute("serachblog", page3);
		model.addAttribute("keyword",keyword);
		model.addAttribute("hotblog", hotblogList);
		model.addAttribute("newblog",newblogList);
		return "search";
	}
	
	@RequestMapping("insertblog")
	public String insert(
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		@RequestParam("categoryid") int categoryid
		){
		java.sql.Date pubtime=getDateutil.getdate();
		Blog blog=new Blog();
		blog.setTitle(title);
		blog.setContent(content);
		blog.setCategoryid(categoryid);
		blog.setPubtime(pubtime);
		bService.insertBlog(blog);
		return "index";
	}
	
	@RequestMapping(value="delete_blog")
	public String delete_blog(
		@RequestParam("id") int id
		){
		bService.delete_blog(id);
		return "blogmanage";
	}
	
	@RequestMapping(value="type")
	@ResponseBody
	public JSONArray type(){
		List<Blog> list=bService.getcategory();
		JSONArray jArray=new JSONArray();
		for(Blog cate:list)
		{
			JSONObject jo=new JSONObject();  //将List转换为Jsonobject的格式
			jo.put("id", cate.getCategoryid());
			jo.put("name", cate.getCategoryname());
			jArray.add(jo);
		}
		return jArray;
	}
}
