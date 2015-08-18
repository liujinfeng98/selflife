package com.selflife.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selflife.common.util.MemcacheSingleton;
import com.selflife.dao.UpdateCommand;
import com.selflife.model.Command;
import com.selflife.service.UpdateCommandService;

@Service
public class UpdateCommandServiceImpl implements UpdateCommandService {
	
	@Autowired
	private UpdateCommand uc;
	
	public int updateCommand(Command c)  throws Exception{
		// TODO Auto-generated method stub
		int i=uc.updateCommand(c);
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
