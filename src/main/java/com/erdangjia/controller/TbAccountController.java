package com.erdangjia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erdangjia.entity.TbEqument;
import com.erdangjia.service.TbAccountService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/account")
public class TbAccountController {

	@Autowired
	private TbAccountService  tbAccountService;
	
	@RequestMapping("/list")
	public String listAccount(@RequestParam(defaultValue="1") String pageNum, @RequestParam(defaultValue="5") String pageSize, Model model){
		PageInfo pageInfo = tbAccountService.listPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), null);
		Object[] array = pageInfo.getList().toArray();
		
		model.addAttribute("pageInfo", pageInfo);
		return "account-list";
	}
	
	@RequestMapping("/list/page")
	@ResponseBody
	public List<TbEqument> listPageAccount(@RequestParam(defaultValue="1") String pageNum,
			@RequestParam(defaultValue="5") String pageSize, String equmentType, String equmentName, String equmentNo){
		Map<String, Object> map = new HashMap<>();
//		map.put("equmentType", equmentType);
//		map.put("equmentName", equmentName);
//		map.put("equmentNo", equmentNo);
		
		PageInfo pageInfo = tbAccountService.listPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), map);
		List list = pageInfo.getList();
	
		return list;
	}
	
	
}
