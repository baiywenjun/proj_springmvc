package com.test.excel;

import java.util.ArrayList;
import java.util.List;

import com.erdangjia.myutil.excel.ExcelExportSXXSSF;

public class UtilTest {

	public static void main(String[] args) throws Exception {
		/**            导出文件存放物理路径
		 * @param fileWebPath
		 *            导出文件web下载路径
		 * @param filePrefix
		 *            导出文件名的前缀          
		 * @param flushRows
		 *            存放在内存的数据量
		 * @param fieldNames
		 *            导出文件列标题
		 * @param fieldCodes
		 * 			  导出数据对象的字段名称     
		 * @param flushRows*/
		//导出文件存放的路径，并且是虚拟目录指向的路径，在web服务器
		String filePath = "e:/upload/";
		//导出文件的前缀，为了避免文件名称重复
		String filePrefix="test";
		//使用XSSF，构造方法参数-1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
		int flushRows=100;
		
		//指导导出数据的title
		List<String> fieldNames=new ArrayList<String>();
		fieldNames.add("用户名");
		fieldNames.add("用户年龄");
		fieldNames.add("用户电话");
		
		//告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
		List<String> fieldCodes=new ArrayList<String>();
		fieldCodes.add("userName");
		fieldCodes.add("userAge");
		fieldCodes.add("userPhone");
		
		//准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
		List<UserInfoTest> list = new ArrayList<UserInfoTest>();
		UserInfoTest test1 = new UserInfoTest("张三", "24", "185232312");
		UserInfoTest test2 = new UserInfoTest("lisi", "24", "185232312");
		UserInfoTest test3 = new UserInfoTest("王武", "24", "185232312");
		list.add(test1);
		list.add(test2);
		list.add(test3);
		
		//注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应
		
		
		//开始导出，执行一些workbook及sheet等对象的初始创建
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes, flushRows);
				
		
		//执行导出
		excelExportSXXSSF.writeDatasByObject(list);
		//输出文件，返回下载文件的http地址
		String webpath = excelExportSXXSSF.exportFile();
		
		System.out.println(webpath);
		
		
	}
}
