package com.selflife.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Path("/loginPage")
public class CancelQuitCtrl{

	@GET
	@Path("/cancelQuit")
	@Produces(MediaType.TEXT_HTML)
	public ModelAndView cancelQuit(@Context HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("username");
		return new ModelAndView("loginPage");
	}


}
