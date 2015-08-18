package com.selflife.dao;

import java.util.List;

import com.selflife.model.Command;
import com.selflife.model.Statics;

public interface QueryCommandAll {

	
	public List<Command> queryCommandAll() throws Exception;
	public List<Statics> queryCommandAllByTime() throws Exception;
	public List<Statics> queryCommandAllByCattag() throws Exception;
	
}
