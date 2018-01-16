package com.erdangjia.myutil.excel;

import java.util.List;
import java.util.Map;

/**
 * 测试导入数据接口
 * @author Thinkpad
 *
 */
public class HxlsOptRowsInterfaceImpl implements HxlsOptRowsInterface {

	@Override
	public String saveOptRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {
		//，HxlsRead工具类从excel中读取信息
//		List<String> rowlist存储了一行的信息
		//插入数据库中
		//...
		System.out.println("sheetIndex="+sheetIndex+"curRow="+curRow+rowlist);
		//如果处理成功，要返回"success"字符串，否则 将失败原因返回

		return "success";
	}
	
}
