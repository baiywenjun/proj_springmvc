package com.erdangjia.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.erdangjia.entity.TbAccount;
import com.erdangjia.service.AuthService;
import com.erdangjia.service.TbAccountService;

public class CustomRealm extends AuthorizingRealm{

	@Autowired
	private TbAccountService tbAccountService;
	
	@Autowired
	private AuthService authService;
	
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		TbAccount account = (TbAccount) principals.getPrimaryPrincipal();
		
		//给授权器返回用户所拥有的权限
		List<String> permission = authService.ListPermissionCode(Long.toString(account.getAccountId()));
		
		//创建授权信息对象
		SimpleAuthorizationInfo simpleAuthorizationInfo =new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permission);
		return simpleAuthorizationInfo;
		
	}

	// 登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
 		String usercode = (String) token.getPrincipal();
		
		TbAccount account = tbAccountService.selectTbAccountByUserName(usercode);
		if(account == null){
			//返回null，认证器接收到null，抛出异常UnknownAccountException
			return null;
		}
				
		// 执行到这里说明账号存在
		// 根据账号从数据库查询正确的密码 
		String pwd = account.getPassWord();
		// 认证信息对象构造方法的第一个参数：用户身份信息，如果认证通过将第一个参数的值放入session，
		// 第二个参数：正确的密码（md5加密后的），第三个参数：realm的名称，字符串
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, pwd, "customRealm");
		
		return simpleAuthenticationInfo;
	}

}
