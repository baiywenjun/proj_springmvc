package com.erdangjia.dao.domain;

import java.util.ArrayList;
import java.util.List;

import com.erdangjia.entity.SysPermission;

public class PermissionPO {

	private Long accountId;
	private String userName;
	
	private List<SysPermission> sysPermissionList = new ArrayList<SysPermission>();

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<SysPermission> getSysPermissionList() {
		return sysPermissionList;
	}

	public void setSysPermissionList(List<SysPermission> sysPermissionList) {
		this.sysPermissionList = sysPermissionList;
	}

	
	
}
