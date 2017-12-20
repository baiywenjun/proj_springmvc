package com.erdangjia.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.erdangjia.entity.TbAccount;
import com.erdangjia.entity.TbAccountExample;
import com.github.pagehelper.PageInfo;

public interface TbAccountService {
	
	int countByExample(TbAccountExample example);

    int deleteByExample(TbAccountExample example);

    int deleteByPrimaryKey(Long accountId);

    int insert(TbAccount record);

    int insertSelective(TbAccount record);

    List<TbAccount> selectByExample(TbAccountExample example);

    TbAccount selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") TbAccount record, @Param("example") TbAccountExample example);

    int updateByExample(@Param("record") TbAccount record, @Param("example") TbAccountExample example);

    int updateByPrimaryKeySelective(TbAccount record);

    int updateByPrimaryKey(TbAccount record);
	
    PageInfo listPage(int pageNum, int pageSize, Map<String, Object> condition);
}
