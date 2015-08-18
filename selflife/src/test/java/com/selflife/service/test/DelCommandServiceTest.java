package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.Command;
import com.selflife.service.DelCommandService;
import com.selflife.service.UpdateCommandService;


public class DelCommandServiceTest {

	

	private DelCommandService ucs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        ucs=(DelCommandService)context.getBean("delCommandServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 应用接入码测试
	  */
	 //@Test
	    public void updateCommandServiceTest(){
		
		 Command c1=new Command();
		 c1.setEc_command_id(221);
		 Command c2=new Command();
		 c2.setEc_command_id(201);
		 Command c3=new Command();
		 c3.setEc_command_id(181);
		
		 System.out.println(ucs.delCommand(c2));

		 System.out.println(ucs.delCommand(c3));
		 System.out.println(ucs.delCommand(c1));


	 }
}
