package com.selflife.service;

import java.util.List;

import com.selflife.model.CatTag;

public interface QueryCatTagService {

	public List<CatTag> queryCatTagAll() throws Exception;
	public List<CatTag> queryCatTagAllSelect() throws Exception ;
	public CatTag queryCatTag(CatTag ct) throws Exception;
	public CatTag queryCatTagByCode(CatTag ct) throws Exception;

}
