package com.selflife.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.selflife.model.Command;
import com.selflife.service.UpdateCommandService;


public class UpdateCommandServiceTest {

	

	private UpdateCommandService ucs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        ucs=(UpdateCommandService)context.getBean("updateCommandServiceImpl");
	 }
	 /**
	  * yyyyy 
	  * 应用接入码测试
	  */
	 //@Test
	    public void updateCommandServiceTest() throws Exception{
		 Command c=new Command();
		 c.setEc_command_id(1);
		 c.setEc_cattag_code(1);
		 c.setEc_command_shell("编译的时候出现了\n\n"+

"error， error C2143: syntax error : missing ';' before 'type'\n"+
"感觉很奇怪,细细看来所有的语法都似乎都是对的，更奇怪的是把文件改成cpp或者cc能正常编译，把int a;和if调换下也能正常编译。这样的错误可能发生在当变量的声明放在可执行代码之后。而这个是在K&R C中规定的，但在ANSI C中废除。\n"+ 
"In Microsoft C, compiler errors C2143 and C2144 are defined as follows: \n"+
"C2143: syntax error : missing 'token1' before 'token2'\n"+
"C2144: syntax error : missing 'token' before type 'type' \n"+
"You may receive this error message if your program places executable code before a data declaration, an acceptable practice in Kernighan-and-Ritchie C. This practice has been outlawed in later versions of the ANSI drafts.\n"+ 
"This error message will normally occur if a required closing curly brace (}), right parenthesis [)], or semicolon (;) is missing.\n "+
"注: The C Programming Language的作者简称K&R，也是C语言之父, 经常用K&R C来和ANSI C做对比。这本书的第二版已经用ANSI.\n"+
"我用的编译器是VS2008, 看来微软向来无视标准。\n"+
"总结：\n"+
"在 ANSI C或者C++中，在可执行代码中随时定义变量是允许的，但是在K&R C中是不允许的，VS2008实现的C竟然是K&R C。注意这样的错误也体现在VS中要是用for (int i = 0; i++; i<10)同时你的文件名是.c的也会出现这样的错误。\n"+
"Code complete中讨论过变量名的最迟绑定有利于增加代码的可读性等。所以在VS中写c要注意了\n");
		 c.setEc_command_title("jni用vc ++6写C时，编译无法通过。原来是标准问题，汗呀。愁坏吾也！");
		 System.out.println(ucs.updateCommand(c));
	 }
}
