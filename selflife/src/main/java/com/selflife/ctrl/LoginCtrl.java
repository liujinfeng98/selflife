package com.selflife.ctrl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Path("/loginPage")
public class LoginCtrl{

	@GET
	@Produces(MediaType.TEXT_HTML)
	public ModelAndView login() throws Exception {
		// TODO Auto-generated method stub
		
		return new ModelAndView("loginPage");
	}


}
