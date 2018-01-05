package com.erdangjia.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 权限验证测试
 * @author chenwenjun
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	
	@RequiresPermissions("user:list")
	@RequestMapping(value="/listUser",method=RequestMethod.GET)
	public String listUser(){
		System.err.println("you have this permission");
		return "admin-list";
	}
	
	
	
	
	
	
	
	/**
	 * 把json字符串转为Map
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/table/user")
	@ResponseBody
	public Map<String, String> getJson(String page, String limit){
		System.err.println(page+"=="+limit);
		String json_db = "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[{\"id\":10000,\"username\":\"user-0\",\"sex\":\"女\",\"city\":\"城市-0\",\"sign\":\"签名-0\",\"experience\":255,\"logins\":24,\"wealth\":82830700,\"classify\":\"作家\",\"score\":57}]}";
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("rawtypes")
		Map map = null;
		try {
			map = mapper.readValue(json_db, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
