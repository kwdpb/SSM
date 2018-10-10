package com.kw.service;

import java.util.List;

import com.kw.entity.User;

public interface UserService {

	int checkLogin(User user);
	
	List<User> getAllUser();
	
	int insertUser(User user);
}
