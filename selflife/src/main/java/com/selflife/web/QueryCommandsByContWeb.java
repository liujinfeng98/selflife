package com.selflife.web;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.selflife.model.Command;
import com.selflife.model.Statics;
import com.selflife.service.QueryCommandAllService;
import com.selflife.service.QueryCommandByContService;


@Path("/queryCommand")
@Controller
public class QueryCommandsByContWeb {
	

	@Autowired 
	private QueryCommandAllService qcas;
	
	@Autowired
	private QueryCommandByContService qcbcs;
	@Autowired
	private com.selflife.model.LinkHashMap m;
	
	@Autowired
	private com.selflife.model.Statics s;
	
	@GET
	@Path("/queryStaticsesByTime")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryStaticsByTime(){
		if(!m.isEmpty()){
			m.clear();
		}
		
			 try {
				List<Statics> staticses=qcas.queryCommandAllByTime();
				m.put("staticses", staticses);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return new ModelAndView("cattags","hashmap",m);
			
	}
	
	@GET
	@Path("/queryStaticsesByCatTag")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryStaticsesByCatTag(){
			if(!m.isEmpty()){
				m.clear();
			}
		
			 try {
				List<Statics> staticses=qcas.queryCommandAllByCattag();
				m.put("staticses", staticses);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return new ModelAndView("statics","hashmap",m);
			
	}
	
	
	@GET
	@Path("/cattag/{code}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryCommandsByCatTag(@PathParam("code") String code){
		if(!m.isEmpty()){
			m.clear();
		}
		
		try {s.setCode(Integer.parseInt(code));
				List<Command> commands=qcbcs.queryCommandAllByCattagCont(s);
				m.put("commands", commands);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return new ModelAndView("index","hashmap",m);
			
	}
	@GET
	@Path("/time/{name}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryCommandsByTime(@PathParam("name") String name){
		if(!m.isEmpty()){
			m.clear();
		}
		
		try {s.setName(name);
				List<Command> commands=qcbcs.queryCommandAllByTimeCont(s);
				m.put("commands", commands);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return new ModelAndView("index","hashmap",m);
			
	}
}
