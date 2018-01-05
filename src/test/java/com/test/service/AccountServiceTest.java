package com.test.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erdangjia.service.AuthService;
import com.erdangjia.service.TbAccountService;

public class AccountServiceTest {

	private static Logger log = LoggerFactory.getLogger(AccountServiceTest.class);
	
	private ApplicationContext applicationContext;
	private TbAccountService tbAccountService;
	private AuthService authService;
	
	@Before
	public void setUp() throws Exception {
		
		 applicationContext = new ClassPathXmlApplicationContext("config/applicationContext-*.xml");
		 tbAccountService = (TbAccountService) applicationContext.getBean("tbAccountService");
		 authService = (AuthService) applicationContext.getBean("authService");
	}
	
	@Test
	public void countDaysTest(){
		Date date = new Date();
		Map<String, Object> count = tbAccountService.selectCountRegister(date);
		log.info(count + "");
		log.error(count + "") ;
		System.err.println(count);
	}
	
	@Test
	public void listPcode(){
		String accountId = "6";
		List<String> listPermissionCode = authService.ListPermissionCode(accountId);
		for (String string : listPermissionCode) {
			System.err.println(string);
		}
	}
	
}
