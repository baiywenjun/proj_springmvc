<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ include file="/jsp/common/tag.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>设备统计</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${baseurl }/css/x-admin.css" media="all">
<style type="text/css">
	.inner_c {
		width: 800px;
		margin: 0 auto;
		overflow: hidden;
	}
	h1 {
		font: 24px/40px '微软雅黑';
	}
	.viewdata{
		margin: 20px auto;
		width: 800px;
		height: 60px;
	}
	.viewdata div{
		float: left;
		width: 100px;
		height: 60px;
		color: white;
		background-color: #3D6551;
		border-radius:5px;
	}
	.viewdata div p{
		line-height: 30px;
    	text-align: center;
	}
	.viewdata .first{
		margin-left: 100px;
		margin-right: 100px;
	}
	.viewdata .middle{
		margin-left: 50px;
		margin-right: 50px;
	}
	.viewdata .last{
		margin-left: 100px;
	}
</style>
<script src="${baseurl }/js/jquery.min.js"></script>
<script src="${baseurl }/lib/layui/layui.js"></script>
<script src="${baseurl }/js/echarts.js"></script>
</head>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div class="inner_c">
		<h1>用户数量统计</h1>
		<div class="viewdata">
			<div class="first">
				<p>活跃用户</p>
				<p>10</p>
			</div>
			<div class="middle">
				<p>活跃用户</p>
				<p>10</p>
			</div>
			<div class="last">
				<p>活跃用户</p>
				<p>10</p>
			</div>
		</div>
    	<div id="account_addline" style="width: 800px;height:400px;"></div>
    </div>
    
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var addlineChart = echarts.init(document.getElementById('account_addline'));
       
        // 指定图表的配置项和数据
        option = {
		    title: {
		        text: '折线图堆叠'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ['周一','周二','周三','周四','周五','周六','周日']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		        {
		            name:'邮件营销',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'联盟广告',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'视频广告',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'直接访问',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390, 330, 320]
		        },
		        {
		            name:'搜索引擎',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320]
		        }
		    ]
		};
		
       
        addlineChart.setOption(option);
        
    </script>
</body>
</html>