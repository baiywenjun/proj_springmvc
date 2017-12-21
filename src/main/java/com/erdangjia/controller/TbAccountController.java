package com.erdangjia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erdangjia.controller.domain.Result;
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
	
	@SuppressWarnings("rawtypes")
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
	
	/**
	 * equipment-count-diagram.jsp 请求接口
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value="/count",method=RequestMethod.POST)
	@ResponseBody
	public Result getCountData(String beginDate, String endDate){
		
		if(StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate)){
			return new Result(400, "结束日期不能为空");
		}
		
		Date begin = null;
		Date end = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(beginDate!=null){
				begin = sdf.parse(beginDate);
			}
			end = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Result result = new Result();
		if(begin == null){
			Map<String, Object> countDUM = tbAccountService.selectCountRegister(end);
			Map<String, List<Object>> diagram = tbAccountService.selectTbAccountCountByDays(end);
			Map<String, Object> data = new HashMap<>();
			data.put("countDUM", countDUM);
			data.put("diagram", diagram);
			
			result.setCode(200);
			result.setData(data);
		}else{
			// XXX 指定时间段的统计（暂无需求）
		}
		
		
		return result;
	}
	
}
