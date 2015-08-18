package com.selflife.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.common.util.MemcacheSingleton;
import com.selflife.dao.AddCommand;
import com.selflife.model.Command;
import com.selflife.service.AddCommandService;

@Service
public class AddCommandServiceImpl implements AddCommandService {
	
	@Autowired
	private AddCommand ac;
	
	public int addCommand(Command c) throws Exception{
		// TODO Auto-generated method stub
		int i=ac.addCommand(c);
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
