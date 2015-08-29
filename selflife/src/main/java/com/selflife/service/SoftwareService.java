package com.selflife.service;

import java.util.List;
import com.selflife.model.Software;

public interface SoftwareService {
	
	public int insertSoftware(Software s) throws Exception;
	public Software querySoftware(Software s) throws Exception;
	public Software querySoftwareByName(Software s) throws Exception;
	public List<Software> queryAllSoftware() throws Exception;

}
