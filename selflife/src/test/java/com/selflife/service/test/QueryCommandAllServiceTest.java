package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.selflife.service.QueryCommandAllService;


public class QueryCommandAllServiceTest {
	

	private QueryCommandAllService qcs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        qcs=(QueryCommandAllService)context.getBean("queryCommandAllServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 
	  */
	 @Test
	 public void queryCommandServiceTest() throws Exception{
		
		 System.out.println(qcs.queryCommandAll().size());
		 
	 }
	 
	 @Test
	 public void queryCommandsByTimeServiceTest() throws Exception{
		
		 System.out.println(qcs.queryCommandAllByTime());
		 
	 }
	 
	 @Test
	 public void queryCommandsByCattagServiceTest() throws Exception{
		
		 System.out.println(qcs.queryCommandAllByCattag());
		 
	 }
}
