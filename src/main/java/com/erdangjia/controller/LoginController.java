package com.erdangjia.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erdangjia.controller.domain.Result;
import com.erdangjia.entity.TbAccount;



@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Result validate(String userName, String password){
		
		System.err.println(userName+"=="+password);
		
		// 获取当前请求线程的用户
		Subject subject = SecurityUtils.getSubject();

		// 对输入的密码进行MD5加密
		//String pwd_md5 = new MD5().getMD5ofStr(pwd);
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			token.clear();
			e.printStackTrace();
			return new Result(203, "用户名或密码错误！");
		}
		
		// 登录成功后，可过去用户session信息
		TbAccount account = (TbAccount) subject.getPrincipal();
		System.err.println(account.getUserName());
		
		return new Result(200,"欢迎你，"+userName+"!");
	}
}
