package com.kw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kw.entity.User;
import com.kw.service.UserService;
import com.kw.util.cookieTool;
import com.kw.util.getEncodTool;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//登录功能
	@RequestMapping(value="checklogin")
	public void checklogin(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session
		){
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		int msg=userService.checkLogin(user);
		String data=null;
		if(msg==1){
			session.setAttribute("username", user.getUsername());
			if(request.getParameterValues("autologin")!=null){
				cookieTool.autologin(request, response, user);
			}
			data="登录成功";
		}else if(msg==2){
			data="用户名不存在";
		}else if(msg==3){
			data="密码错误";
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="allUser")
	public String allUser(){
		List<User> list=userService.getAllUser();
		for(int i=0;i<list.size();i++)
			System.out.println(" "+list.get(i).getUsername());
		return "result";
	}
	
	//注册功能
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(
			@RequestParam("username")String username,
			@RequestParam("password")String password
	){
		String pwd=getEncodTool.encodeHexTest(password);
		User user=new User();
		user.setUsername(username);
		user.setPassword(pwd);
		int i=userService.insertUser(user);
		System.out.println("是否插入成功"+i);
		return "redirect:login.html";
	}
	
	@RequestMapping(value="cancel")
	public String cancel(
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			){
		session.removeAttribute("username");
		Cookie cookie=new Cookie("autologin","");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:login.html";
	}
}
