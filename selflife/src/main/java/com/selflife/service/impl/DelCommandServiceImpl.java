package com.selflife.service.impl;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.selflife.common.util.MemcacheSingleton;
import com.selflife.dao.DelCommand;
import com.selflife.model.Command;
import com.selflife.service.DelCommandService;

@Service
public class DelCommandServiceImpl implements DelCommandService {
	
	@Autowired
	private DelCommand uc;
	
	public int delCommand(Command c)  {
		// TODO Auto-generated method stub
		int i=uc.delCommand(c);
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
