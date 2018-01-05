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
<script type="text/javascript">
	var xAxisNames = new Array();
	var yAxisData = new Array();
	
	$(function(){
		
		// TODO 伪ajax
		/* xAxisNames.push("2017-12-10");
		xAxisNames.push("2017-12-11");
		xAxisNames.push("2017-12-12");
		xAxisNames.push("2017-12-13");
		xAxisNames.push("2017-12-14");
		xAxisNames.push("2017-12-15");
        
		yAxisData.push(5);
		yAxisData.push(2);
		yAxisData.push(10);
		yAxisData.push(12);
		yAxisData.push(1);
		yAxisData.push(2); */
		
		var endDate = new Date();
		var endDateStr = endDate.toLocaleString();
		//var endDateStr = null;
		//alert(endDateStr);
		
		$.ajax({
			async: false,
			url: '${baseurl}/account/count.do',
			type:'post',
			data:{'endDate':endDateStr},
			dataType:'json',
			success:function(result){
				if(result.code == 200){
					/* console.log(result.data.countDUM);
					console.log(result.data.diagram.xNames)
					console.log(result.data.diagram.yData) */
					var dum = result.data.countDUM;
					$("#day_reg").text(dum.countDay);
					$("#week_reg").text(dum.countWeek);
					$("#month_reg").text(dum.countMonth);
					xAxisNames = result.data.diagram.xNames;
					yAxisData = result.data.diagram.yData;
				}else{
					alert(result.msg);
				}
			}	
		});
		
		// 基于准备好的dom，初始化echarts实例
        var addlineChart = echarts.init(document.getElementById('account_addline'));
       
        // 指定图表的配置项和数据
        option = {
		    title: {
		        text: '用户数量'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['用户数量']
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
		        data: xAxisNames
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		        {
		            name:'用户数量',
		            type:'line',
		            stack: '总量',
		            data: yAxisData
		        }
		    ]
		};
		
       
        addlineChart.setOption(option);
	});
	
	Date.prototype.toLocaleString = function(){
		return this.getFullYear() + "-" +(this.getMonth()+1) + "-" + this.getDate() + " " + this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds();
	}
</script>
</head>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div class="inner_c">
		<h1>用户数量统计</h1>
		<div class="viewdata">
			<div class="first">
				<p>今日注册</p>
				<p id="day_reg">null</p>
			</div>
			<div class="middle">
				<p>本周</p>
				<p id="week_reg">null</p>
			</div>
			<div class="last">
				<p>本月</p>
				<p id="month_reg">null</p>
			</div>
		</div>
		<shiro:hasPermission name="user:list">aasdf</shiro:hasPermission>
    	<div id="account_addline" style="width: 800px;height:400px;"></div>
    </div>
    
</body>
</html>