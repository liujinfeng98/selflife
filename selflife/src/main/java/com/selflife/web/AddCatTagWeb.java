package com.selflife.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.selflife.common.util.RegexUtil;
import com.selflife.model.CatTag;
import com.selflife.model.Command;
import com.selflife.service.AddCatTagService;
import com.selflife.service.QueryCatTagService;
import com.selflife.service.QueryCommandAllService;

@Path("/queryCommand")
@Controller
public class AddCatTagWeb {

	@Autowired
	private AddCatTagService ats;
	@Autowired
	private QueryCatTagService qts;
	@Autowired
	private com.selflife.model.LinkHashMap m;
	@Autowired
	private CatTag c;

	@Autowired 
	private QueryCommandAllService qcas;
	@POST
	@Path("/addCatTag")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView addCatTag(@FormParam("_code") String _code,@FormParam("_name") String name){
		//String _ret="";
		if(!m.isEmpty()){
			m.clear();
		}
		if(!RegexUtil.checkScope(_code,1,999999999)||!RegexUtil.isNotNull(name)){
			m.put("_ret", Integer.valueOf("400"));
			//_ret= JsonUtil.MapToJson(m);
		}else{
			m.put("_ret", Integer.valueOf("100"));
			c.setCode(Integer.parseInt(_code));
			c.setName(name);
			List<Command> commands=null;
			try {
				CatTag c1=qts.queryCatTagByCode(c);
				if(c1==null){
				ats.addCatTagService(c);
				commands = qcas.queryCommandAll();
				}else{
					 m.put("_ret", Integer.valueOf("202"));
					return  new ModelAndView("addcattag","hashmap",m);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

			m.put("commands", commands);
		}
		
		return  new ModelAndView("index","hashmap",m);
			
	}
	
	@GET
	@Path("/toAddCatTag")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView toAddCatTag(){
		if(!m.isEmpty()){
			m.clear();
		}
		return new ModelAndView("addcattag");
			
	}
}
