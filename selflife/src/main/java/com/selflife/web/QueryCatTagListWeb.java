package com.selflife.web;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.selflife.model.CatTag;
import com.selflife.service.QueryCatTagService;

@Path("/queryCommand")
@Controller
public class QueryCatTagListWeb {
	
	@Autowired
	private QueryCatTagService qcts;
	@Autowired
	private com.selflife.model.LinkHashMap m;
	
	
	@GET
	@Path("/cattagsList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryCatTags(){
		if(!m.isEmpty()){
			m.clear();
		}
			 try {
				List<CatTag> cts= qcts.queryCatTagAll();
				m.put("cattags", cts);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		return new ModelAndView("cattagsList","hashmap",m);

			
	}
}
