package com.erdangjia.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erdangjia.entity.TbAccount;
import com.erdangjia.entity.TbAccountExample;

public interface TbAccountMapper {
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
    
    int countByDay(Date date);
    
    int countByWeek(Date date);
    
    int countByMonth(Date date);
    
    
}