package com.selflife.model;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ec_username;
	private String ec_password;
	private int ec_userlevel;
	
	public String getEc_username() {
		return ec_username;
	}
	public void setEc_username(String ec_username) {
		this.ec_username = ec_username;
	}
	public String getEc_password() {
		return ec_password;
	}
	public void setEc_password(String ec_password) {
		this.ec_password = ec_password;
	}
	public int getEc_userlevel() {
		return ec_userlevel;
	}
	public void setEc_userlevel(int ec_userlevel) {
		this.ec_userlevel = ec_userlevel;
	}
	
	
}
