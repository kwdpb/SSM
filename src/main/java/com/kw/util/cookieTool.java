package com.kw.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kw.entity.User;

public class cookieTool {
	
	public static void autologin(HttpServletRequest request,HttpServletResponse response,User user){
		String username;
		try {
			username = URLEncoder.encode(user.getUsername(),"UTF-8");
			String password=URLEncoder.encode(getEncodTool.encodeHexTest(user.getPassword()),"UTF-8");
			Cookie cookie=new Cookie("autologin",username+"!#!"+password);
			cookie.setPath(request.getContextPath());
			cookie.setMaxAge(60*60*24*10);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
