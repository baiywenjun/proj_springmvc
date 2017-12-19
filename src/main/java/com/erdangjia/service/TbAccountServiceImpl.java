package com.erdangjia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.common.CustomeException;
import com.erdangjia.dao.TbAccountMapper;
import com.erdangjia.entity.TbAccount;
import com.erdangjia.entity.TbAccountExample;

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
		// TODO Auto-generated method stub
		return null;
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

}
