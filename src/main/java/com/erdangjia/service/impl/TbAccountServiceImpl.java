package com.erdangjia.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.common.CustomeException;
import com.erdangjia.dao.TbAccountMapper;
import com.erdangjia.entity.TbAccount;
import com.erdangjia.entity.TbAccountExample;
import com.erdangjia.entity.TbEqument;
import com.erdangjia.entity.TbAccountExample;
import com.erdangjia.entity.TbAccountExample.Criteria;
import com.erdangjia.service.TbAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
}
