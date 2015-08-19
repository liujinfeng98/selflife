package com.selflife.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.common.util.MemcacheSingleton;
import com.selflife.dao.UpdateCatTag;
import com.selflife.model.CatTag;
import com.selflife.service.UpdateCatTagService;

@Service
public class UpdateCatTagServiceImpl implements UpdateCatTagService {

	
	@Autowired
	private UpdateCatTag uct;
	public int updateCatTagService(CatTag ct) throws Exception {
		// TODO Auto-generated method stub
	int i=	uct.updateCatTag(ct);
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
