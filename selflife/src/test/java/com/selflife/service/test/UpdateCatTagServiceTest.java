package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.CatTag;
import com.selflife.service.AddCatTagService;
import com.selflife.service.UpdateCatTagService;


public class UpdateCatTagServiceTest {

	
	private UpdateCatTagService acs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        acs=(UpdateCatTagService)context.getBean("updateCatTagServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 应用接入码测试
	 * @throws Exception 
	  */
	 @Test
	 public void updateCatTagServiceTest() throws Exception{
		 CatTag c=new CatTag();
		 c.setId(3);
			c.setName("eclipse");
			c.setCode(3);
			c.setStatus(0);
		 System.out.println(acs.updateCatTagService(c));
	 }
}
