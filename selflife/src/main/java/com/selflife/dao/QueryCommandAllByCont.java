package com.selflife.dao;

import java.util.List;

import com.selflife.model.Command;
import com.selflife.model.Statics;

public interface QueryCommandAllByCont {

	public List<Command> queryCommandAllByTimeCont(Statics s) throws Exception;
	public List<Command> queryCommandAllByCattagCont(Statics s) throws Exception;

}
