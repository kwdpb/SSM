package com.kw.service.impl;

import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kw.dao.UserDao;
import com.kw.entity.User;
import com.kw.service.UserService;
import com.kw.util.getEncodTool;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao uDao;
	
	@Override
	public int checkLogin(User user) {
		// TODO Auto-generated method stub
		int msg=0;
		try{
			User user2=uDao.loginUser(user.getUsername().toString());
			String pwd=getEncodTool.decodeHexTest(user2.getPassword());
			if(pwd.equals(user.getPassword())){
			msg=1;
			}else{
				msg=3;	
			}
		}catch(NullPointerException e){
			msg=2;
		}	
		return msg;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return uDao.getAllUser();
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return uDao.insertUser(user);
	}
	
	

}
