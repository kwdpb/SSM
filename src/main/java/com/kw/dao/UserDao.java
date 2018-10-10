package com.kw.dao;

import java.util.List;

import com.kw.entity.User;

public interface UserDao {
	
    //登录用户判断
	User loginUser(String username);
	
	
	List<User> getAllUser(); 
	
	//添加用户
	int insertUser(User user);
}
