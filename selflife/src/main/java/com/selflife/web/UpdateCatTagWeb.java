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
import com.selflife.service.QueryCatTagService;
import com.selflife.service.UpdateCatTagService;

@Path("/queryCommand")
@Controller
public class UpdateCatTagWeb {

	@Autowired
	private UpdateCatTagService ats;
	@Autowired
	private QueryCatTagService qts;
	@Autowired
	private com.selflife.model.LinkHashMap m;
	@Autowired
	private CatTag c;

	
	@POST
	@Path("/updateCatTag")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView updateCatTag(@FormParam("_id") Integer id,@FormParam("_code") String _code,@FormParam("_name") String name,@FormParam("_status") String _status){
		if(!m.isEmpty()){
			m.clear();
		}
		if(!RegexUtil.checkScope(id,1,999999999)||!RegexUtil.checkScope(_code,1,999999999)||!RegexUtil.isNotNull(name)||!RegexUtil.checkScope(_status,0,9)){
			m.put("_ret", Integer.valueOf("400"));
		}else{
			c.setId(id);
			c.setCode(Integer.parseInt(_code));
			c.setName(name);
			c.setStatus(Integer.parseInt(_status));
			List<CatTag> cts;
			try {			
				ats.updateCatTagService(c);
				cts = qts.queryCatTagAll();
				m.put("cattags", cts);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return new ModelAndView("cattagsList","hashmap",m);
			
	}
	
	
	@GET
	@Path("/toUpdateCatTag/{_id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json")
	public ModelAndView toUpdateCatTag(@PathParam("_id") String _id){
		if(!m.isEmpty()){
			m.clear();
		}
		try {
			c.setId(Integer.parseInt(_id));
			c=qts.queryCatTag(c);
			m.put("cattag", c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("updatecattag","hashmap",m);
			
	}
}
