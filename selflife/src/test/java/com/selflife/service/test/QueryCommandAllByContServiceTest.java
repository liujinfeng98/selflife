package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.Statics;
import com.selflife.service.QueryCommandAllService;
import com.selflife.service.QueryCommandByContService;


public class QueryCommandAllByContServiceTest {
	

	private QueryCommandByContService qcs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        qcs=(QueryCommandByContService)context.getBean("queryCommandByContServiceImpl");
	 	}

	 
	 @Test
	 public void queryCommandsByCattagcontServiceTest() throws Exception{
		Statics s=new Statics();
		s.setCode(1);
		System.out.println(qcs.queryCommandAllByCattagCont(s));
	 }
	 
	 @Test
	 public void queryCommandsByTimecontServiceTest() throws Exception{
			Statics s=new Statics();
			s.setName("2015-08");
			System.out.println(qcs.queryCommandAllByTimeCont(s));
	 }
}
