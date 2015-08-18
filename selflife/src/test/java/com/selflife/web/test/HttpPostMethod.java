package com.selflife.web.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpPostMethod {

    public static void postUrlWithParams(String url, Map params, String encoding)  
            throws Exception {  
        DefaultHttpClient httpclient = new DefaultHttpClient();  
        try {  
  
            HttpPost httpost = new HttpPost(url);  
            // 添加参数  
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
            if (params != null && params.keySet().size() > 0) {  
                Iterator iterator = params.entrySet().iterator();  
                while (iterator.hasNext()) {  
                    Map.Entry entry = (Map.Entry) iterator.next();  
                    nvps.add(new BasicNameValuePair((String) entry.getKey(),  
                            (String) entry.getValue()));  
                }  
            }  
  
            httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));  
  
            HttpResponse response = httpclient.execute(httpost);  
            HttpEntity entity = response.getEntity();  
  
            System.out.println("Login form get: " + response.getStatusLine()  
                    + entity.getContent());  
            dump(entity, encoding);  
            System.out.println("Post logon cookies:");  
            List<Cookie> cookies = httpclient.getCookieStore().getCookies();  
            if (cookies.isEmpty()) {  
                System.out.println("None");  
            } else {  
                for (int i = 0; i < cookies.size(); i++) {  
                    System.out.println("- " + cookies.get(i).toString());  
                }  
            }  
  
        } finally {  
            // 关闭请求  
            httpclient.getConnectionManager().shutdown();  
        }  
    }  
    private static void dump(HttpEntity entity, String encoding)  
            throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(  
                entity.getContent(), encoding));  
        System.out.println(br.readLine());  
    }  
	
}
