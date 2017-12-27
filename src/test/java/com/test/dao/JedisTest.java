package com.test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {

	private Jedis jedis;
	
	@Before
	 public void setUp(){
		 jedis = new Jedis("127.0.0.1", 6379);
		 System.err.println(jedis.ping());
	 }
	
	@Test
	public void addList(){
		jedis.lpush("sanguo", "张飞","关羽","刘备","赵云");
		List<String> list = jedis.lrange("sanguo", 0, 20);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	@Test
	public void setExpire(){
		jedis.set("temp", "10s");
		System.out.println(jedis.get("temp"));
		jedis.expire("temp", 10);
		
		//System.out.println(jedis.get("temp"));
	}
	
}
