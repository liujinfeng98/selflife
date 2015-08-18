package com.selflife.dao;

import com.selflife.model.User;

public interface UserDao {
	
	public int insertUser(User u);
	public User queryUser(User u);
	
}
