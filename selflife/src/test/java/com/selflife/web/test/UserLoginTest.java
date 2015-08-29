package com.selflife.web.test;

import org.junit.Test;
import com.selflife.common.util.RegexUtil;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked") 
public class UserLoginTest {
	
	//@Test
		public void testDevParam(){
			String _uaccount="ljf1";
			String _pwd="ljf1234";
			org.junit.Assert.assertTrue(RegexUtil.isAccount(_uaccount));
			org.junit.Assert.assertTrue(RegexUtil.isPwd(_pwd));
		}
	@Test
	public void testUserLogin(){
		
		String port="userLogin";
		String url="http://192.168.2.244:9095/loginPage/"+port;
		String _uaccount="ljf1";
		String _pwd="ljf1234";

		Map params=new HashMap();
		params.put("_user", _uaccount);
		params.put(_pwd, _pwd);
	
		try {
			HttpPostMethod.postUrlWithParams(url,params,"UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
