package com.erdangjia.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import ch.qos.logback.core.subst.Token;

public class CustomRealm extends AuthorizingRealm{

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
		
		String usercode_db = "zhangsan";
		if(!usercode.equals(usercode)){
			//返回null，认证器接收到null，抛出异常UnknownAccountException
			return null;
		}
				
		//执行到这里说明账号存在
		//根据账号从数据库查询正确的密码 
		//模拟正确的密码 
		String pwd_db = "123";
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usercode_db,pwd_db,"customRealm");
		
		return simpleAuthenticationInfo;
	}

}
