package com.selflife.service;

import com.selflife.model.User;

public interface UserService {
	
	public int insertUser(User u) throws Exception;
	public User queryUser(User u) throws Exception;

}
