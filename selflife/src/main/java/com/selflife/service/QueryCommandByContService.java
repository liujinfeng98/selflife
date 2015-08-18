package com.selflife.service;

import java.util.List;
import com.selflife.model.Command;
import com.selflife.model.Statics;

public interface QueryCommandByContService {

	public List<Command> queryCommandAllByTimeCont(Statics s) throws Exception;
	public List<Command> queryCommandAllByCattagCont(Statics s) throws Exception;

}
