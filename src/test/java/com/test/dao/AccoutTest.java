package com.test.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.erdangjia.dao.TbAccountMapper;
import com.erdangjia.dao.TbGatherLogMapper;
import com.erdangjia.entity.TbAccount;
import com.erdangjia.entity.TbAccountExample;
import com.erdangjia.entity.TbAccountExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class AccoutTest {

	private static Logger log = LoggerFactory.getLogger(AccoutTest.class);
	
	private ApplicationContext applicationContext;
	private TbAccountMapper tbAccountMapper;
	private TbGatherLogMapper tbGatherLogMapper;
	
	@Before
	public void setUp() throws Exception {
		
		 applicationContext = new ClassPathXmlApplicationContext("springmvc.xml");
		 tbAccountMapper = (TbAccountMapper) applicationContext.getBean("tbAccountMapper");
		 tbGatherLogMapper = (TbGatherLogMapper) applicationContext.getBean("tbGatherLogMapper");
	}
	
	@Test
	public void getCount(){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse("2017-12-01 12:12:12");
			//int num = tbGatherLogMapper.getCountByCreateTime("2017-12-01");
			int num = tbGatherLogMapper.getCountByCreateTime2(date);
			System.err.println(num);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAccountById(){
		TbAccount account = tbAccountMapper.selectByPrimaryKey(1l);
		//System.err.println(account.getUserName());
		log.debug("====>"+account.getUserName());
	}
	
	@Test
	public void insertAccount(){
		TbAccount account = new TbAccount();
		account.setUserName("李四");
		account.setPassWord("123");
		account.setCreateTime(new Date());
		
		int insert = tbAccountMapper.insert(account);
		System.err.println(insert);
	}
	
	@Test
	public void selectExample(){
		TbAccountExample example = new TbAccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameLike("张%");
		
		List<TbAccount> selectByExample = tbAccountMapper.selectByExample(example);
		for (TbAccount tbAccount : selectByExample) {
			System.err.println(tbAccount.getUserName());
		}
	}
	
	@Test
	public void selectPage(){
		PageHelper.startPage(2, 2);
		List<TbAccount> list = tbAccountMapper.selectByExample(new TbAccountExample());
		
		PageInfo<TbAccount> page = new PageInfo<TbAccount>(list);
		List<TbAccount> list2 = page.getList();
		
		for (TbAccount tbAccount : list2) {
			System.err.println(tbAccount.getUserName());
		}
	}
}
