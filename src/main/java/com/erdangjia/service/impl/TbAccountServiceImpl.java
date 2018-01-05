package com.erdangjia.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erdangjia.common.CustomeException;
import com.erdangjia.dao.TbAccountMapper;
import com.erdangjia.entity.TbAccount;
import com.erdangjia.entity.TbAccountExample;
import com.erdangjia.entity.TbAccountExample.Criteria;
import com.erdangjia.myutil.DateUtil;
import com.erdangjia.service.TbAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Transactional
@Service("tbAccountService")
public class TbAccountServiceImpl implements TbAccountService {

	@Autowired
	private TbAccountMapper tbAccoutMapper;
	
	@Override
	public int countByExample(TbAccountExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(TbAccountExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TbAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TbAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TbAccount> selectByExample(TbAccountExample example) {
		return tbAccoutMapper.selectByExample(example);
	}

	@Override
	public TbAccount selectByPrimaryKey(Long accountId) {
		if(accountId == -1){
			throw new CustomeException("500", "查询主键不能为-1");
		}
		return tbAccoutMapper.selectByPrimaryKey(accountId);
	}

	@Override
	public int updateByExampleSelective(TbAccount record, TbAccountExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(TbAccount record, TbAccountExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TbAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TbAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * account分页
	 * @param pageNum
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	public PageInfo listPage(int pageNum, int pageSize, Map<String, Object> condition){
		
		TbAccountExample example = new TbAccountExample();
		if(condition!=null && condition.size() > 0){
			Criteria criteria = example.createCriteria();
//		    if(StringUtils.isNotEmpty((String)condition.get("equmentType"))){
//		    	criteria.andEqumentTypeEqualTo((String)condition.get("equmentType"));
//		    }
//			 if(StringUtils.isNotEmpty((String)condition.get("equmentName"))){
//				 criteria.andEqumentNameLike("%"+(String)condition.get("equmentName")+"%");	    	
//		    }
//			 if(StringUtils.isNotEmpty((String)condition.get("equmentNo"))){
//				 criteria.andEqumentNoEqualTo((String)condition.get("equmentNo"));
//			 }
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<TbAccount> list = this.selectByExample(example);
		PageInfo page = new PageInfo(list);
		return page;
	}
	
	
	/**
	 * 根据输入时间查询月、周、天注册人数
	 * @param date
	 * @return
	 */
	public Map<String, Object> selectCountRegister(Date date){
		Date now = date;
		if(date == null){
			now = new Date();
		}
		
		int countDay = tbAccoutMapper.countByDay(now);
		int countWeek = tbAccoutMapper.countByWeek(now);
		int countMonth = tbAccoutMapper.countByMonth(now);
		
		Map<String, Object> map = new HashMap<>();
		map.put("countDay", countDay);
		map.put("countWeek", countWeek);
		map.put("countMonth", countMonth);
		
		return map;
	}
	
	/**
	 * 获取最近一周的注册数
	 * @param end
	 * @return
	 */
	public Map<String, List<Object>> selectTbAccountCountByDays(Date end){
		DateUtil util = new DateUtil();
		Date afterNDay = util.afterNDay(end, -6);
		
		return this.selectTbAccountCountByDays(afterNDay, end);
	}
	
	
	/**
	 * 根据时间获取注册数
	 * @param begin
	 * @param end
	 * @return
	 */
	// FIXME 
	
	public Map<String, List<Object>> selectTbAccountCountByDays(Date begin, Date end){
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> xNameList = new ArrayList<>();
		List<Object> yDataList = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//tbGatherLogMapper.getCountByCreateTime(dateStr);
		int intervalDays = DateUtil.getIntervalDays(begin, end);
		String beginStr = sdf.format(begin);
		xNameList.add(beginStr);
		int chooseCount = tbAccoutMapper.countByDay(begin);
		yDataList.add(chooseCount);
		
		for(int i=0; i<intervalDays; i++){
			long dayMills = 1000*60*60*24 * (i+1);
			long nextDayMills = begin.getTime() + dayMills;
			Date nextDay = new Date(nextDayMills);
			String nextDayStr = sdf.format(nextDay);
			xNameList.add(nextDayStr);
			int count = tbAccoutMapper.countByDay(nextDay);
			yDataList.add(count);
		}
		
		map.put("xNames", xNameList);
		map.put("yData", yDataList);
		
//		int key = tbAccoutMapper.deleteByPrimaryKey(3l);
		
//		String tmp = null;
//		if(tmp.equals("aaaa")){
//			System.err.println("aaa");
//		}
		
//		int i = 1/0;
//		System.err.println(i);
		
		return map;
	}
	
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public TbAccount selectTbAccountByUserName(String userName){
		TbAccountExample example = new TbAccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<TbAccount> list = this.selectByExample(example);
		
		if(list.isEmpty()){
			return null;
		}
		
		return list.get(0);
	}
	
}
