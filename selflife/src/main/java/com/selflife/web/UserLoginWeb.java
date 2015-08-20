package com.selflife.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.selflife.common.util.RegexUtil;
import com.selflife.model.Command;
import com.selflife.service.QueryCommandAllService;
import com.selflife.service.UserService;

@Path("/loginPage")
@Controller
public class UserLoginWeb {
	
	@Autowired
	private UserService us;

	@Autowired 
	private QueryCommandAllService qcas;
	
	@Autowired
	private com.selflife.model.LinkHashMap m;
	
	@Autowired
	private com.selflife.model.User u;
	
	@POST
	@Path("/userLogin")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView queryUser(@Context HttpServletRequest request,@FormParam("_user") String _user,
			@FormParam("_pwd") String _pwd){
		if(!m.isEmpty()){
			m.clear();
		}
		if(!RegexUtil.isAccount(_user)||!RegexUtil.isPwd(_pwd)){
			m.put("_ret", Integer.valueOf("400"));
		}else{
			m.put("_ret", Integer.valueOf("100"));
		
			u.setEc_username(_user);
			u.setEc_password(_pwd);
			 try {
				u=us.queryUser(u);
				m.put("user", u);
				request.getSession().setAttribute("username", u.getEc_username());
				List<Command> commands=qcas.queryCommandAll();
				m.put("commands", commands);
				return new ModelAndView("index","hashmap",m);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.put("_ret", Integer.valueOf("201"));

			}

		}
		return new ModelAndView("loginPage","hashmap",m);
			
	}
}
