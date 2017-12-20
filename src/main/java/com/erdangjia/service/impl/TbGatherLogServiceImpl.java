package com.erdangjia.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.dao.TbGatherLogMapper;
import com.erdangjia.entity.TbGatherLog;
import com.erdangjia.entity.TbGatherLogExample;
import com.erdangjia.service.TbGatherLogService;

@Service("tbGatherLogService")
public class TbGatherLogServiceImpl implements TbGatherLogService {

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
	public List<TbGatherLog> selectTbGatherLogCountByDate(Date begin, Date end){
		Calendar calendar = Calendar.getInstance();
		
		
		return null;
	}

}
