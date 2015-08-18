package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.CatTag;
import com.selflife.service.AddCatTagService;


public class AddCatTagServiceTest {

	
	private AddCatTagService acs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        acs=(AddCatTagService)context.getBean("addCatTagServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 应用接入码测试
	 * @throws Exception 
	  */
	// @Test
	 public void addCatTagServiceTest() throws Exception{
		 CatTag c=new CatTag();
			c.setName("eclipse");
			c.setCode(3);
		 System.out.println(acs.addCatTagService(c));
	 }
}
