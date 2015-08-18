package com.selflife.web.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class ServerTimeTest {

	@Test
	public void testServerTime(){
		//String geturl="http://192.168.2.244:9095/resteasy/ServerTime";
		String geturl="http://192.168.2.244:9095/ServerTime";

		try {
			getUrl(geturl,"UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * get method test
	 * @param url
	 * @param encoding
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
    public void getUrl(String url, String encoding)  
            throws ClientProtocolException, IOException {  
        // 默认的client类。  
        HttpClient client = new DefaultHttpClient();  
        // 设置为get取连接的方式.  
        HttpGet get = new HttpGet(url);  
        // 得到返回的response.  
        HttpResponse response = client.execute(get);  
        // 得到返回的client里面的实体对象信息.  
        HttpEntity entity = response.getEntity();  
        if (entity != null) {  
          //  System.out.println("内容编码是：" + entity.getContentEncoding());  
            System.out.println("内容类型是：" + entity.getContentType());  
            // 得到返回的主体内容.  
            InputStream instream = entity.getContent();  
            try {  
                BufferedReader reader = new BufferedReader(  
                        new InputStreamReader(instream, encoding));  
                System.out.println(reader.readLine());  
            } catch (Exception e) {  
                e.printStackTrace();  
            } finally {  
                instream.close();  
            }  
        }  
  
        // 关闭连接.  
        client.getConnectionManager().shutdown();  
    }  
}
