package com.selflife.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.dao.QueryCatTag;
import com.selflife.model.CatTag;
import com.selflife.service.QueryCatTagService;

@Service
public class QueryCatTagAllServiceImpl implements QueryCatTagService{

	@Autowired
	private QueryCatTag qct;
	
	public List<CatTag> queryCatTagAllSelect() throws Exception {
		// TODO Auto-generated method stub
		return qct.queryCatTagAllSelect();
	}
	public List<CatTag> queryCatTagAll() throws Exception {
		// TODO Auto-generated method stub
		return qct.queryCatTagAll();
	}

	public CatTag queryCatTag(CatTag ct) throws Exception {
		// TODO Auto-generated method stub
		return qct.queryCatTag(ct);
	}
	@Override
	public CatTag queryCatTagByCode(CatTag ct) throws Exception {
		// TODO Auto-generated method stub
		return qct.queryCatTagByCode(ct);
	}

}
