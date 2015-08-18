package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.Command;
import com.selflife.service.QueryCommandService;


public class QueryCommandServiceTest {

	

	private QueryCommandService qcs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        qcs=(QueryCommandService)context.getBean("queryCommandServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 应用接入码测试
	  */
	 @Test
	    public void queryCommandServiceTest(){
		 Command c=new Command();
		 c.setEc_command_id(1);
		 System.out.println(qcs.queryCommand(c).getEc_command_shell()+qcs.queryCommand(c).getEc_command_title());
	 }
}
