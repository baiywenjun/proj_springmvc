package com.erdangjia.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.erdangjia.entity.TbEqument;
import com.erdangjia.entity.TbEqumentExample;
import com.github.pagehelper.PageInfo;

public interface TbEqumentService {

	int countByExample(TbEqumentExample example);

    int deleteByExample(TbEqumentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbEqument record);

    int insertSelective(TbEqument record);

    List<TbEqument> selectByExample(TbEqumentExample example);

    TbEqument selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbEqument record, @Param("example") TbEqumentExample example);

    int updateByExample(@Param("record") TbEqument record, @Param("example") TbEqumentExample example);

    int updateByPrimaryKeySelective(TbEqument record);

    int updateByPrimaryKey(TbEqument record);
    
    PageInfo listPage(int pageNum, int pageSize, Map<String, Object> condition);
}
