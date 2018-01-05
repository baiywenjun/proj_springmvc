package com.test.shiro;

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

public class CustomRealmTest extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//给授权器返回用户所拥有的权限
		List<String> permission = new ArrayList<String>();
		permission.add("user:delete");
		permission.add("user:update");
		
		//创建授权信息对象
		SimpleAuthorizationInfo simpleAuthorizationInfo =new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permission);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户的身份，用户在认证的时候输入的是账号，身份是账号
		//getPrincipal()真实类型和token用户输入的身份信息类型一致 new UsernamePasswordToken("zhangsan", "123");
		String usercode = (String) token.getPrincipal();//用户输入的账号
		//根据账号从数据库查询
		//模拟一个账号表示是数据库的账号
		String usercode_db = "zhangsan";//数据库中的账号
		if(!usercode.equals(usercode_db)){//用户 输入的账号在数据库不存在
			//返回null，认证器接收到null，抛出异常UnknownAccountException
			return null;
		}		
		//执行到这里说明账号存在
		//根据账号从数据库查询正确的密码 
		//模拟正确的密码 
		String pwd_db = "123";
		
		//给认证器返回正确的密码 （正确密码包括在认证信息对象中）
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usercode_db, pwd_db, "customRealm");
		
		return simpleAuthenticationInfo;
	}

}
