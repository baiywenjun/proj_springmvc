package com.erdangjia.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.erdangjia.entity.TbAccount;
import com.erdangjia.service.TbAccountService;

public class CustomRealm extends AuthorizingRealm{

	@Autowired
	private TbAccountService tbAccountService;
	
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
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
				
		//执行到这里说明账号存在
		//根据账号从数据库查询正确的密码 
		//模拟正确的密码 
		//String pwd_db = "123";
		String pwd = account.getPassWord();
		
		//SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usercode,pwd,"customRealm");
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account.getUserName(), pwd, "customRealm");
		
		return simpleAuthenticationInfo;
	}

}
