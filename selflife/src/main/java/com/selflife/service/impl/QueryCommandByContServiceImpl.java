package com.selflife.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.dao.QueryCommandAllByCont;
import com.selflife.model.Command;
import com.selflife.model.Statics;
import com.selflife.service.QueryCommandByContService;

@Service
public class QueryCommandByContServiceImpl implements QueryCommandByContService {

	@Autowired
	private QueryCommandAllByCont qcabc;
	public List<Command> queryCommandAllByTimeCont(Statics s) throws Exception {
		// TODO Auto-generated method stub
		return qcabc.queryCommandAllByTimeCont(s);
	}

	public List<Command> queryCommandAllByCattagCont(Statics s) throws Exception {
		// TODO Auto-generated method stub
		return qcabc.queryCommandAllByCattagCont(s);
	}

}
