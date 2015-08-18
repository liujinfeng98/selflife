package com.selflife.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.dao.QueryCommandAll;
import com.selflife.model.Command;
import com.selflife.model.Statics;
import com.selflife.service.QueryCommandAllService;

@Service
public class QueryCommandAllServiceImpl implements QueryCommandAllService {
	
	@Autowired
	private QueryCommandAll qca;
	
	public List<Command> queryCommandAll()  throws Exception {
		// TODO Auto-generated method stub
		return qca.queryCommandAll();
	}

	public List<Statics> queryCommandAllByTime() throws Exception {
		// TODO Auto-generated method stub
		return qca.queryCommandAllByTime();
	}

	public List<Statics> queryCommandAllByCattag() throws Exception {
		// TODO Auto-generated method stub
		return qca.queryCommandAllByCattag();
	}

}
