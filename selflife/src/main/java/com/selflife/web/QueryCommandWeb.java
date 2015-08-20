package com.selflife.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.selflife.common.util.RegexUtil;
import com.selflife.model.Command;
import com.selflife.service.QueryCommandService;

@Path("/queryCommand")
@Controller
public class QueryCommandWeb {
	
	@Autowired
	private QueryCommandService qcs;
	@Autowired
	private com.selflife.model.LinkHashMap m;
	@Autowired
	private Command c; 
	
	@GET
	@Path("/command/{commandid}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryUser(@PathParam("commandid") String commandid){
		if(!m.isEmpty()){
			m.clear();
		}
		if(!RegexUtil.isDigits(commandid)){
			m.put("_ret", Integer.valueOf("400"));
		}else{
			m.put("_ret", Integer.valueOf("100"));
			c.setEc_command_id(Integer.parseInt(commandid));
			 try {
				c=qcs.queryCommand(c);
				m.put("command", c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.put("_ret", Integer.valueOf("201"));

			}

		}
		return new ModelAndView("command","hashmap",m);

			
	}
}
