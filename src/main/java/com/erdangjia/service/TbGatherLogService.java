package com.erdangjia.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erdangjia.entity.TbGatherLog;
import com.erdangjia.entity.TbGatherLogExample;

public interface TbGatherLogService {
	int countByExample(TbGatherLogExample example);

    int deleteByExample(TbGatherLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbGatherLog record);

    int insertSelective(TbGatherLog record);

    List<TbGatherLog> selectByExample(TbGatherLogExample example);

    TbGatherLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGatherLog record, @Param("example") TbGatherLogExample example);

    int updateByExample(@Param("record") TbGatherLog record, @Param("example") TbGatherLogExample example);

    int updateByPrimaryKeySelective(TbGatherLog record);

    int updateByPrimaryKey(TbGatherLog record);
}