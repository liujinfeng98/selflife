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
import com.selflife.service.AddCommandService;
import com.selflife.service.QueryCatTagService;
import com.selflife.service.QueryCommandAllService;

@Path("/queryCommand")
@Controller
public class AddCommandWeb {

	@Autowired
	private AddCommandService acs;
	@Autowired
	private QueryCatTagService qcs;
	@Autowired
	private com.selflife.model.LinkHashMap m;

	@Autowired
	private Command c; 
	@Autowired 
	private QueryCommandAllService qcas;
	@POST
	@Path("/addcommand")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView addCommand(@FormParam("_code") String _code,@FormParam("_title") String _title,@FormParam("_shell") String _shell){
			
		if(!m.isEmpty()){
			m.clear();
		}
		if(!RegexUtil.checkScope(_code,1,999999999)||!RegexUtil.isNotNull(_title)){
			m.put("_ret", Integer.valueOf("400"));
		}else{
			m.put("_ret", Integer.valueOf("100"));
			 
			c.setEc_cattag_code(Integer.parseInt(_code));
			c.setEc_command_title(_title);
			c.setEc_command_shell(_shell);
			List<Command> commands=null;
			try {	
				acs.addCommand(c);
				 commands = qcas.queryCommandAll();
				 m.put("commands", commands);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return  new ModelAndView("index","hashmap",m);
			
	}
	
	@GET
	@Path("/toCommandAdd")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView toCommandAdd(){
		if(!m.isEmpty()){
			m.clear();
		}		
		List<CatTag> cts=null;
		try {
			cts = qcs.queryCatTagAllSelect();
			m.put("cattags",cts);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("addcommand","hashmap",m);
			
	}
}
