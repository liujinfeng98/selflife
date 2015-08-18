package com.selflife.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.selflife.common.util.RegexUtil;
import com.selflife.model.CatTag;
import com.selflife.model.Command;
import com.selflife.service.QueryCatTagService;
import com.selflife.service.QueryCommandAllService;
import com.selflife.service.QueryCommandService;
import com.selflife.service.UpdateCommandService;

@Path("/queryCommand")
@Controller
public class UpdateCommandWeb {

	
	@Autowired 
	private QueryCommandAllService qcas;

	@Autowired
	private QueryCommandService qcos;
	@Autowired
	private UpdateCommandService ucs;
	@Autowired
	private QueryCatTagService qcs;
	@Autowired
	private com.selflife.model.LinkHashMap m;

	@Autowired
	private Command c; 
	
	@POST
	@Path("/updateCommand")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView updateCommand(@FormParam("_commandid") String _commandid,@FormParam("_code") String _code,@FormParam("_title") String _title,@FormParam("_shell") String _shell){
			
		if(!m.isEmpty()){
			m.clear();
		}
		if(!RegexUtil.checkScope(_commandid,1,999999999)||!RegexUtil.checkScope(_code,1,999999999)||!RegexUtil.isNotNull(_title)){
			m.put("_ret", Integer.valueOf("400"));
		}else{
			m.put("_ret", Integer.valueOf("100"));
			c.setEc_command_id(Integer.parseInt(_commandid));
			c.setEc_cattag_code(Integer.parseInt(_code));
			c.setEc_command_title(_title);
			c.setEc_command_shell(_shell);	
			List<Command> commands=null;
			try {			ucs.updateCommand(c);
				commands = qcas.queryCommandAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.put("commands", commands);
		}
		
		return  new ModelAndView("index","hashmap",m);
			
	}
	
	@GET
	@Path("/toCommandUpdate/{commandid}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView toCommandUpdate(@PathParam("commandid") String commandid){
		if(!m.isEmpty()){
			m.clear();
		}		
		c.setEc_command_id(Integer.parseInt(commandid));
		try {
			c = qcos.queryCommand(c);
			List<CatTag> cts=qcs.queryCatTagAllSelect();
			m.put("cattags", cts);
			m.put("command",c);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("updatecommand","hashmap",m);
			
	}
}
