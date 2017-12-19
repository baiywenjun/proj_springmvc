package com.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroTest {
	
	@Test
	public void testLoginAndLogout(){
		// 文档文件当作数据库
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-token.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken  token = new UsernamePasswordToken("zhangsan", "323");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean authenticated = subject.isAuthenticated();
		System.err.println(authenticated);
		
		subject.logout();
		authenticated = subject.isAuthenticated();
		System.err.println(authenticated);
	}
	
	@Test
	public void testLoginAndLogoutByRealm(){
		// 文档文件当作数据库
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken  token = new UsernamePasswordToken("zhangsan", "123");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean authenticated = subject.isAuthenticated();
		System.err.println(authenticated);
		
		subject.logout();
		authenticated = subject.isAuthenticated();
		System.err.println(authenticated);
	}
}
