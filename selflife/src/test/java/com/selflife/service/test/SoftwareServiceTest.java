package com.selflife.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.selflife.model.Software;
import com.selflife.service.SoftwareService;

public class SoftwareServiceTest {
	Logger log=LoggerFactory.getLogger(SoftwareServiceTest.class);
	
	private SoftwareService acs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        acs=(SoftwareService)context.getBean("softwareServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 应用接入码测试
	 * @throws Exception 
	  */
	 @Test
	 public void insertSoftwareTest() throws Exception{
		 Software s=new Software();
		 s.setId(1);
		 s.setName("tomcat8.zip");
		 s.setPath("/software/");
		 s.setUseful("application server");
		 s.setCode(3);
		 if(acs.querySoftwareByName(s)==null)
		 log.info(""+acs.insertSoftware(s));
	 }
	 @Test
	 public void querySoftware() throws Exception{
		 Software s=new Software();
		 s.setId(1);
		 s=acs.querySoftware(s);
		 log.info("========"+s);
	 }
	 @Test
	 public void queryAllSoftware() throws Exception{
		
		List<Software> ss=acs.queryAllSoftware();
		log.info("----------"+ss.size());
	 }
}
