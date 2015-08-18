package com.selflife.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.common.util.MemcacheSingleton;
import com.selflife.dao.AddCatTag;
import com.selflife.model.CatTag;
import com.selflife.service.AddCatTagService;

@Service
public class AddCatTagServiceImpl implements AddCatTagService {
	
	@Autowired
	private AddCatTag act;

	public int addCatTagService(CatTag ct) throws Exception{
		// TODO Auto-generated method stub
		int i=act.addCatTag(ct);
		if(i>0){
			try {
				MemcacheSingleton.getMemcacheSingleton().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return i;
	}

}
