package com.erdangjia.controller.domain;

import java.util.Map;

/**
 * 接口返回实体
 * @author chenwenjun
 *
 */
public class Result {

	private Integer code;
	
	private String msg;
	
	private Map<String, Object> data;

	public Result() {
		super();
	}
	
	public Result(Integer code) {
		super();
		this.code = code;
	}

	public Result(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Result(Integer code, String msg, Map<String, Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	
	
}
