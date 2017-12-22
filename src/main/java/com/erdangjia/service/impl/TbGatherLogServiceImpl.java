package com.erdangjia.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.dao.TbGatherLogMapper;
import com.erdangjia.entity.TbAccountExample;
import com.erdangjia.entity.TbAccountExample.Criteria;
import com.erdangjia.entity.TbGatherLog;
import com.erdangjia.entity.TbGatherLogExample;
import com.erdangjia.myutil.DateUtil;
import com.erdangjia.service.TbGatherLogService;

import sun.tools.tree.ThisExpression;

@Service("tbGatherLogService")
public class TbGatherLogServiceImpl implements TbGatherLogService {

	// private static Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private TbGatherLogMapper tbGatherLogMapper;
	
	@Override
	public int countByExample(TbGatherLogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(TbGatherLogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TbGatherLog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TbGatherLog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TbGatherLog> selectByExample(TbGatherLogExample example) {
		return tbGatherLogMapper.selectByExample(example);
	}

	@Override
	public TbGatherLog selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(TbGatherLog record, TbGatherLogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(TbGatherLog record, TbGatherLogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TbGatherLog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TbGatherLog record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 根据时间获取设备数量
	 * @param begin
	 * @param end
	 * @return
	 */
	public Map<String, List<Object>> selectTbGatherLogCountByDate(Date begin, Date end){
		
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> xNameList = new ArrayList<>();
		List<Object> yDataList = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//tbGatherLogMapper.getCountByCreateTime(dateStr);
		int intervalDays = DateUtil.getIntervalDays(begin, end);
		String beginStr = sdf.format(begin);
		xNameList.add(beginStr);
		int chooseCount = tbGatherLogMapper.getCountByCreateTime2(begin);
		yDataList.add(chooseCount);
		
		for(int i=0; i<intervalDays; i++){
			long dayMills = 1000*60*60*24 * (i+1);
			long nextDayMills = begin.getTime() + dayMills;
			Date nextDay = new Date(nextDayMills);
			String nextDayStr = sdf.format(nextDay);
			xNameList.add(nextDayStr);
			int count = tbGatherLogMapper.getCountByCreateTime2(nextDay);
			yDataList.add(count);
		}
		
		map.put("xNames", xNameList);
		map.put("yData", yDataList);
		
		return map;
	}

}
