package com.erdangjia.dao;

import com.erdangjia.entity.TbLoginLog;
import com.erdangjia.entity.TbLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbLoginLogMapper {
    int countByExample(TbLoginLogExample example);

    int deleteByExample(TbLoginLogExample example);

    int deleteByPrimaryKey(Long loginId);

    int insert(TbLoginLog record);

    int insertSelective(TbLoginLog record);

    List<TbLoginLog> selectByExample(TbLoginLogExample example);

    TbLoginLog selectByPrimaryKey(Long loginId);

    int updateByExampleSelective(@Param("record") TbLoginLog record, @Param("example") TbLoginLogExample example);

    int updateByExample(@Param("record") TbLoginLog record, @Param("example") TbLoginLogExample example);

    int updateByPrimaryKeySelective(TbLoginLog record);

    int updateByPrimaryKey(TbLoginLog record);
}