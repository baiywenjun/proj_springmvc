package com.test.dao;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erdangjia.dao.TbGatherLogMapper;
import com.erdangjia.myutil.DateUtil;

public class MyUtilTest {

	private ApplicationContext applicationContext;
	private TbGatherLogMapper tbGatherLogMapper;
	
	//@Before
	public void setUp() throws Exception {
		 applicationContext = new ClassPathXmlApplicationContext("springmvc.xml");
		 tbGatherLogMapper = (TbGatherLogMapper) applicationContext.getBean("tbGatherLogMapper");
	}
	
	@Test
	public void intervalTest(){
		Date startday = new Date(2017+1900,1,1);
		Date endday = new Date(2017+1900,2,1);
		int intervalDays = DateUtil.getIntervalDays(startday, endday);
		System.err.println(intervalDays);
	}
	
}
