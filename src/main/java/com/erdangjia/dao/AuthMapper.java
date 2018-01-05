package com.erdangjia.dao;

import org.apache.ibatis.annotations.Param;

import com.erdangjia.dao.domain.PermissionPO;

public interface AuthMapper {

	// 根据用户id获取权限列表
	PermissionPO selectPermissionListById(@Param("accountId") String accountId);
}
