package com.erdangjia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdangjia.dao.AuthMapper;
import com.erdangjia.dao.domain.PermissionPO;
import com.erdangjia.entity.SysPermission;
import com.erdangjia.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthMapper authMapper;
	
	/**
	 * 获取权限标识符
	 * @param accountId
	 * @return
	 */
	@Override
	public List<String> ListPermissionCode(String accountId){
		
		PermissionPO permissionPO = authMapper.selectPermissionListById(accountId);
		
		List<String> codeList = new ArrayList<>();
		
		List<SysPermission> sysPermissionList = permissionPO.getSysPermissionList();
		for (SysPermission sysPermission : sysPermissionList) {
			String pcode = sysPermission.getPcode();
			if(StringUtils.isNotEmpty(pcode)){
				codeList.add(pcode);
			}
		}
		
		return codeList;
	}
	
}
