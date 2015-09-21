package com.selflife.web;

import java.util.Date;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.selflife.common.util.JsonUtil;


@Controller
@Path("/")
public class ServerTime {

	@Autowired
	private com.selflife.model.LinkHashMap m;
	@GET
	@Path("ServerTime")
	@Produces("application/json")
	public String serverTime(){
		if(!m.isEmpty()){
			m.clear();
		}
		m.put("_ret", Integer.valueOf(100));
		m.put("_utc", Long.valueOf(new Date().getTime()/1000-0x53724E00));
		return JsonUtil.mapToJson(m);
	}
	@GET
	@Path("/")
	@Produces("application/json")
	public String serverTime1(){
		if(!m.isEmpty()){
			m.clear();
		}
		m.put("_ret", Integer.valueOf(100));
		m.put("_utc", Long.valueOf(new Date().getTime()/1000-0x53724E00));
		return JsonUtil.mapToJson(m);
	}
	@POST
	@Path("/")
	@Produces("application/json")
	public String serverTime2(){
		if(!m.isEmpty()){
			m.clear();
		}
		m.put("_ret", Integer.valueOf(100));
		m.put("_utc", Long.valueOf(new Date().getTime()/1000-0x53724E00));
		return JsonUtil.mapToJson(m);
	}
	
}
