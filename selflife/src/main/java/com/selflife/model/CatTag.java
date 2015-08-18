package com.selflife.model;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class CatTag implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int code;
	private int id;
	private int status;
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
