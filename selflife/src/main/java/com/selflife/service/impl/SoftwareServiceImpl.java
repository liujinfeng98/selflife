package com.selflife.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.common.util.MemcacheSingleton;
import com.selflife.dao.SoftwareDao;
import com.selflife.model.Software;
import com.selflife.service.SoftwareService;

@Service
public class SoftwareServiceImpl implements SoftwareService {
	
	@Autowired
	private SoftwareDao sd;
	
	@Override
	public int insertSoftware(Software s) throws Exception {
		// TODO Auto-generated method stub
		int i=sd.insertSoftware(s);
		
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

	@Override
	public Software querySoftware(Software s) throws Exception {
		// TODO Auto-generated method stub
		return sd.querySoftware(s);
	}

	@Override
	public List<Software> queryAllSoftware() throws Exception {
		// TODO Auto-generated method stub
		return sd.queryAllSoftware();
	}

	@Override
	public Software querySoftwareByName(Software s) throws Exception {
		// TODO Auto-generated method stub
		return sd.querySoftwareByName(s);
	}

}
