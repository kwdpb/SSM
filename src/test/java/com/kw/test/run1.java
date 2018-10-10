package com.kw.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.kw.dao.BlogDao;
import com.kw.entity.Blog;
import com.kw.entity.User;
import com.kw.service.BlogService;
import com.kw.service.impl.BlogServiceImpl;
import com.kw.util.getEncodTool;

public class run1 {

	public static void main(String[] args){
/*		Integer i=new Integer(2);
		System.out.println(i);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startindex", 1);
		map.put("endindex", 2);
		map.put("categoryid", 1);
		List<Blog> list=bDao.findBlog(map);
		for(int a=0;a<list.size();a++)
		System.out.println(list.get(a).getTitle());*/
		
/*		Map<String,Object> map=new HashMap<String,Object>();
		map.put("count", 0);
		map.put("categoryid",1);
		int i=bDao.getBlogCount(map);
		System.out.println("总数:"+i);*/
		
/*		ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=(User)apc.getBean("user");
		System.out.println(""+user.getPassword());*/
		
/*		Map<String,Object> map=new HashMap<String, Object>();
		map.put("keyword", "泛型");
		map.put("startindex", 0);
		map.put("endindex", 5);
		List<Blog> list=bDao.getSearchBlog(map);
		System.out.println("map的tag:"+map.get("keyword"));
		System.out.println(list.get(0).getTitle());*/
		
/*		String pwd="123456";
		String str=getEncodTool.encodeHexTest(pwd);
		String dstr=getEncodTool.decodeHexTest(str);
		System.out.println("原密码:"+pwd+"，加密的密码:"+str+"解码后:"+dstr);*/
		
		
		
		
	}
	}
	