package com.selflife.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.dao.UserDao;
import com.selflife.model.User;
import com.selflife.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao ud;

	public int insertUser(User u) throws Exception {
		// TODO Auto-generated method stub
		return ud.insertUser(u);
	}

	public User queryUser(User u) throws Exception {
		// TODO Auto-generated method stub
		return ud.queryUser(u);
	}

}
