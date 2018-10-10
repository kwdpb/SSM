package com.kw.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.util.NameTransformer.Chained;
import com.kw.entity.User;
import com.kw.service.UserService;
import com.kw.service.impl.UserServiceImpl;
import com.kw.util.getEncodTool;



public class loginFilter implements Filter {

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		/*System.out.println("过滤器销毁");*/
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		String uri=request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
/*		System.out.println("过滤器启动"+"---处理地址为:"+path);*/
		String url=request.getContextPath();
/*		System.out.println("真实地址:"+url);*/
		if(request.getSession().getAttribute("username")==null)
		{
			Cookie cookie[]=request.getCookies();
			if(cookie!=null)
			{
				for(Cookie c:cookie) //循环搜寻cookie
				{
					if(c.getName().equals("autologin"))
					{
						String str=c.getValue();
						String vals[]=str.split("!#!");
						String name=URLDecoder.decode(vals[0],"UTF-8");
						String psw=URLDecoder.decode(getEncodTool.decodeHexTest(vals[1]),"UTF-8");
						User user=new User();
						user.setUsername(name);
						user.setPassword(psw);
					/*	System.out.println(user.getUsername()+"   "+user.getPassword());*/
						UserService userService=new UserServiceImpl();
						int flag=userService.checkLogin(user);
						if(flag==1)
						{	
							request.getSession().setAttribute("username", name);
							break;
						}
						else {
							break;     
						}
					}
						
				}
			}
		}
		else{
			if(path.equals("login")){
				response.sendRedirect("blogmanage.jsp");
			}
		}
/*		System.out.println("过滤器通过中...");*/
		chain.doFilter(arg0, arg1);
/*		System.out.println("过滤器已通过");*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	/*	System.out.println("过滤器启用");*/
	}

}
