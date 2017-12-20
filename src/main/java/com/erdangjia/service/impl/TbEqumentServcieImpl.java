package com.erdangjia.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.dao.TbEqumentMapper;
import com.erdangjia.entity.TbEqument;
import com.erdangjia.entity.TbEqumentExample;
import com.erdangjia.entity.TbEqumentExample.Criteria;
import com.erdangjia.service.TbEqumentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("tbEqumentServcie")
public class TbEqumentServcieImpl implements TbEqumentService{

	@Autowired
	private TbEqumentMapper tbEqumentMapper;
	
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
		return tbEqumentMapper.selectByExample(example);
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

	/**
	 * 分页list
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo listPage(int pageNum, int pageSize, Map<String, Object> condition){
		
		TbEqumentExample example = new TbEqumentExample();
		if(condition!=null && condition.size() > 0){
			Criteria criteria = example.createCriteria();
		    if(StringUtils.isNotEmpty((String)condition.get("equmentType"))){
		    	criteria.andEqumentTypeEqualTo((String)condition.get("equmentType"));
		    }
			 if(StringUtils.isNotEmpty((String)condition.get("equmentName"))){
				 criteria.andEqumentNameLike("%"+(String)condition.get("equmentName")+"%");	    	
		    }
			 if(StringUtils.isNotEmpty((String)condition.get("equmentNo"))){
				 criteria.andEqumentNoEqualTo((String)condition.get("equmentNo"));
			 }
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<TbEqument> list = this.selectByExample(example);
		PageInfo page = new PageInfo(list);
		return page;
	}
	
}
