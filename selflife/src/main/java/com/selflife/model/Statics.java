package com.selflife.model;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class Statics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count;
	private String name;
	private int code;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
