package com.erdangjia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.dao.TbEqumentMapper;
import com.erdangjia.entity.TbEqumentExample;

@Service("tbEqument")
public class TbEqumentImpl implements TbEqument{

	@Autowired
	private TbEqumentMapper tbEqument;
	
	
	@Override
	public int countByExample(TbEqumentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(TbEqumentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TbEqument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TbEqument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TbEqument> selectByExample(TbEqumentExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbEqument selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(TbEqument record, TbEqumentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(TbEqument record, TbEqumentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TbEqument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TbEqument record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
