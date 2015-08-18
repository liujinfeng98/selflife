package com.selflife.service;

import java.util.List;

import com.selflife.model.Command;
import com.selflife.model.Statics;

public interface QueryCommandAllService {

	public List<Command> queryCommandAll() throws Exception;
	public List<Statics> queryCommandAllByTime() throws Exception;
	public List<Statics> queryCommandAllByCattag() throws Exception;

}
