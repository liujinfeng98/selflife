package com.selflife.common.util;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class MemcacheSingleton {

	private MemcachedClient cache;
	private static MemcacheSingleton ms;
	private MemcacheSingleton(){
		
	}
	public  MemcachedClient getMemcachedClient() throws IOException{
		if(cache==null)
		 cache = new MemcachedClient(new InetSocketAddress("127.0.0.1", 9096));  
		 return cache;
	}
	
	public  void flush() throws IOException{
		this.getMemcachedClient();
		cache.flush();
		//cache.shutdown();
	}
	
	public static MemcacheSingleton getMemcacheSingleton(){
		if(ms==null)
			ms=new MemcacheSingleton();
		return ms;
	}
}
