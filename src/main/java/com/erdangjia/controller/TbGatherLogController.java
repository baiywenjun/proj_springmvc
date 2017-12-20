package com.erdangjia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erdangjia.service.TbGatherLogService;

@Controller
@RequestMapping("/gatherLog")
public class TbGatherLogController {

	@Autowired
	private TbGatherLogService tbGatherLogService;
	
	
	@RequestMapping(value="/count",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, List<Object>> getCountData(String beginDate, String endDate){
		Date begin = null;
		Date end = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			begin = sdf.parse(beginDate);
			end = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Map<String, List<Object>> data = tbGatherLogService.selectTbGatherLogCountByDate(begin, end);
		
		return data;
	}
}
