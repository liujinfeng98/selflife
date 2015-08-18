package com.selflife.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.selflife.dao.QueryCommand;
import com.selflife.model.Command;
import com.selflife.service.QueryCommandService;

@Service
public class QueryCommandServiceImpl implements QueryCommandService {
	
	@Autowired
	private QueryCommand qc;
	
	public Command queryCommand(Command c) {
		// TODO Auto-generated method stub
		return qc.queryCommand(c);
	}

}
