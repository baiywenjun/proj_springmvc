package com.erdangjia.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * @author chenwenjun
 *
 */
public class CustomHandlerExceptionResovler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		CustomeException customeException;
		if(ex instanceof CustomeException){
			customeException = (CustomeException) ex;
		}else if(ex instanceof UnauthorizedException) {
			customeException = new CustomeException("800", "您没有此功能的访问权限");	
		}else{
			customeException = new CustomeException("500", "未知错误");
			// TODO 要打log进日志文件
			System.err.println(ex.getMessage());
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error",customeException.getMessage());
		modelAndView.setViewName("/common/error");
		return modelAndView;
	}

}
