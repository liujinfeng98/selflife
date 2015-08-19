package com.selflife.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.CatTag;
import com.selflife.service.QueryCatTagService;
import com.selflife.service.QueryCommandAllService;


public class QueryCatTagAllServiceTest {
	

	private QueryCatTagService qcs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        qcs=(QueryCatTagService)context.getBean("queryCatTagAllServiceImpl");
	 }
	 /**
	  * yyyyy 
	 * @throws Exception 
	  * 
	  */
	 @Test
	 public void queryCommandServiceTest() throws Exception{
		
		 List<CatTag> cts=qcs.queryCatTagAll();
		 System.out.println(cts.size());
		 
	 }
}
