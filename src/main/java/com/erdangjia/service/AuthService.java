package com.erdangjia.service;

import java.util.List;

public interface AuthService {

	/**
	 * 获取权限标识符
	 * @param accountId
	 * @return
	 */
	List<String> ListPermissionCode(String accountId);

}
