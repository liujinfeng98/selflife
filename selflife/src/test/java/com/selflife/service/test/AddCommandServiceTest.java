package com.selflife.service.test;

import javax.ws.rs.Consumes;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.selflife.model.Command;
import com.selflife.service.AddCommandService;

public class AddCommandServiceTest {

	private AddCommandService acs;
	 @Before
	    public void before(){                                                                   
	        @SuppressWarnings("resource")
	        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
	                ,"classpath:conf/spring-mybatis.xml"});
	        acs=(AddCommandService)context.getBean("addCommandServiceImpl");
	 }
	 /**
	  * yyyyy 
	   * 应用接入码测试
	   */
	 //@Test
	    public void addCommandServiceTest(){
		 Command c=new Command();
		 c.setEc_cattag_code(2);
		 c.setEc_command_title("An I/O error occurred while sending to the backend.");
		 c.setEc_command_shell("问题描述:\n"+
				 "### Error querying database.  Cause: org.postgresql.util.PSQLException: An I/O error occurred while sending to the backend.\n"+
				 "### The error may exist in file [/home/ljf/program/resteasy_web/target/test-classes/mapper/UserInfoMapper.xml]\n"+
				 "### The error may involve com.boyi.etdomi.dao.Et_base_userinfo.queryByidAccountExist-Inline\n"+
				 "### The error occurred while setting parameters\n"+
				 "### SQL: select                             ec_user_account as _account,              ec_user_pwd     as _spwd,              ec_user_nick    as _nick,              ec_user_email   as _email,              ec_user_mobile  as _mobile,              ec_user_typeid  as _typeid,              ec_user_push    as _push,              ec_user_id    as _id                from et_base_userinfo where ec_user_id =?\n"+
				 "### Cause: org.postgresql.util.PSQLException: An I/O error occurred while sending to the backend.\n"+
				 "; SQL []; An I/O error occurred while sending to the backend.; nested exception is org.postgresql.util.PSQLException: An I/O error occurred while sending to the backend.\n"+
				 	"at org.springframework.jdbc.support.SQLStateSQLExceptionTranslator.doTranslate(SQLStateSQLExceptionTranslator.java:105)\n"+
				 	"at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)\n"+
				 	"at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)\n"+
				 	"at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)\n"+
				 	"at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)\n"+
				 	"at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:371)\n"+
				 	"at com.sun.proxy.$Proxy14.selectOne(Unknown Source)\n"+
				 	"at org.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:163)\n"+
				 	"at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:68)\n"+
				 	"at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:52)\n"+
				 	"at com.sun.proxy.$Proxy16.queryByidAccountExist(Unknown Source)\n"+
				 	"at com.boyi.etdomi.services.impl.UserInfoServiceImpl.queryByidAccountExist(UserInfoServiceImpl.java:44)\n"+
				 	"at com.boyi.etdomi.web.test.UserEditTest.testUserEdit(UserEditTest.java:63)\n"+
				 	"at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"+
				 	"at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n"+
				 	"at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"+
				 	"at java.lang.reflect.Method.invoke(Method.java:497)\n"+
				 	"at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)\n"+
				 	"at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\n"+
				 	"at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)\n"+
				 	"at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\n"+
				 	"at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\n"+
				 	"at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)\n"+
				 	"at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)\n"+
				 	"at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)\n"+
				 	"at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n"+
				 	"at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n"+
				 	"at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n"+
				 	"at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n"+
				 	"at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n"+
				 	"at org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n"+
				 	"at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)\n"+
				 	"at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n"+
				 	"at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\n"+
				 	"at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)\n"+
				 	"at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\n"+
				 	"at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\n"+
				   "Caused by: org.postgresql.util.PSQLException: An I/O error occurred while sending to the backend.\n"+
				 	"at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:281)\n"+
				 	"at org.postgresql.jdbc2.AbstractJdbc2Statement.execute(AbstractJdbc2Statement.java:561)\n"+
				 	"at org.postgresql.jdbc2.AbstractJdbc2Statement.executeWithFlags(AbstractJdbc2Statement.java:419)\n"+
				 	"at org.postgresql.jdbc2.AbstractJdbc2Statement.execute(AbstractJdbc2Statement.java:412)\n"+
				 	"at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)\n"+
				 	"at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"+
				 	"at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n"+
				 	"at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"+
				 	"at java.lang.reflect.Method.invoke(Method.java:497)\n"+
				 	"at org.apache.ibatis.logging.jdbc.PreparedStatementLogger.invoke(PreparedStatementLogger.java:62)\n"+
				 	"at com.sun.proxy.$Proxy34.execute(Unknown Source)\n"+
				 	"at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:59)\n"+
				 	"at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:73)\n"+
				 	"at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:60)\n"+
				 	"at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:267)\n"+
				 	"at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:137)\n"+
				 	"at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:96)\n"+
				 	"at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:77)\n"+
				 	"at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:108)\n"+
				 	"at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:102)\n"+
				 	"at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:66)\n"+
				 	"at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"+
				 	"at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n"+
				 	"at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"+
				 	"at java.lang.reflect.Method.invoke(Method.java:497)\n"+
				 	"at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:358)\n"+
				 	"... 31 more\n"+
				   "Caused by: java.net.SocketException: Connection reset\n"+
				 	"at java.net.SocketInputStream.read(SocketInputStream.java:209)\n"+
				 	"at java.net.SocketInputStream.read(SocketInputStream.java:141)\n"+
				 	"at org.postgresql.core.VisibleBufferedInputStream.readMore(VisibleBufferedInputStream.java:143)\n"+
				 	"at org.postgresql.core.VisibleBufferedInputStream.ensureBytes(VisibleBufferedInputStream.java:112)\n"+
				 	"at org.postgresql.core.VisibleBufferedInputStream.read(VisibleBufferedInputStream.java:71)\n"+
				 	"at org.postgresql.core.PGStream.ReceiveChar(PGStream.java:282)\n"+
				 	"at org.postgresql.core.v3.QueryExecutorImpl.processResults(QueryExecutorImpl.java:1741)\n"+
				 	"at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:255)\n"+
				 	"在两个节点间发送消息时，IP网络可能会任意地删除、延迟、重新排序或复制消息，因此许多分布式系统都使用TCP以防止消息的重新排序与复制。但TCP/IP在本质上仍然是异步的：网络会任意地延迟消息，连接可能会被随时切断。\n"+
				 	"此外，对故障的诊断也并不可靠：要判断某个节点是否出现故障、网络连接是否被切断、或者操作是否比预计中运行得慢也许是不可能实现的。\n"+
				 	"消息被任意地延迟或切断的这种故障叫做网络分区。分区可能出于多种原因发生在生产环境的网络中：垃圾回收（GC）的压力、网卡（NIC）故障、交换 机故障、配置出错、网络拥塞等等。由于分区的发生，使CAP定理限制了分布式系统能够达到的最大担保能力。\n"+
				 	"当消息被切断时，一致的”（CP）系统会拒绝 某些节点的请求，以保持线性一致性。\n"+
				 	"“可用的”（AP）系统虽然能够处理所有节点上的请求，但必须牺牲线性一致性，因为不同的节点对于操作的顺序可能会产 生不同意见。\n"+
				 	"当网络情况良好时，系统可以保证一致性与可用性，但由于真实的网络中总会产生分区，因此不存在能够完全做到“一致且可用”（CA）的系统\n"+
				 	"问题解决方法:\n"+
				 	"test "+
				 	"or jiqun\n");
		 try {
			System.out.println(acs.addCommand(c));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
