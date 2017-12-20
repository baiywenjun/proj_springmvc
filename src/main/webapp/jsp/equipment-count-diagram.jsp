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
		width: 1000px;
		margin: 0 auto;
		overflow: hidden;
	}
	h1 {
		font: 32px/32px "微软雅黑";
		margin: 30px 0;
	}
</style>
<script src="${baseurl }/js/jquery.min.js"></script>
<script src="${baseurl }/lib/layui/layui.js"></script>
<script src="${baseurl }/js/echarts.js"></script>
<script type="text/javascript">
	var xAxisNames = new Array();
	var yAxisData = new Array();
	var xyComposite = new Array();
	
	var columnChart;
    var cakeChart;
	
	$(function(){
		
		
		// layui日期空间
    	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  var start = {
		    min: '1970-01-01 00:00:00'
		    ,max: '2099-06-16 23:59:59'
		    ,istoday: false
		    ,choose: function(datas){
		      end.min = datas; //开始日选好后，重置结束日的最小日期
		      end.start = datas //将结束日的初始值设定为开始日
		    }
		  };
		  
		  var end = {
		    min: '1970-01-01 00:00:00'
		    ,max: '2099-06-16 23:59:59'
		    ,istoday: false
		    ,choose: function(datas){
		      start.max = datas; //结束日选好后，重置开始日的最大日期
		    }
		  };
		  
		  document.getElementById('LAY_demorange_s').onclick = function(){
		    start.elem = this;
		    laydate(start);
		  }
		  document.getElementById('LAY_demorange_e').onclick = function(){
		    end.elem = this
		    laydate(end);
		  }
    	});

    
        // 基于准备好的dom，初始化echarts实例
        columnChart = echarts.init(document.getElementById('equipment_column'));
        cakeChart = echarts.init(document.getElementById('equipment_cake'));
        
        // 伪ajax TODO
        xAxisNames.push("2017-12-10");
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
		yAxisData.push(2);
		
		for(var i=0; i<xAxisNames.length; i++){
			var p = new Object();
			p.name = xAxisNames[i];
			p.value = yAxisData[i];
			xyComposite.push(p);
		} 
		//console.log(xyComposite);

        // 指定图表的配置项和数据
        var columnChart_option = {
        	color : ['#3398DB'],
            title: {
                text: '设备活跃数量-柱状图'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: xAxisNames
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: yAxisData
            }]
        };
		
        var cakeChart_option = {
        		title: {
                    text: '设备活跃数量-饼图'
                },
        		tooltip: {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b}: {c} ({d}%)"
        	    },
        	    legend: {
        	        orient: 'vertical',
        	        x: 'right',
        	        y: 'center',
        	        data:xAxisNames
        	    },
        	    series: [
        	        {
        	            name:'访问来源',
        	            type:'pie',
        	            radius: ['50%', '70%'],
        	            avoidLabelOverlap: false,
        	            label: {
        	                normal: {
        	                    show: false,
        	                    position: 'center'
        	                },
        	                emphasis: {
        	                    show: true,
        	                    textStyle: {
        	                        fontSize: '30',
        	                        fontWeight: 'bold'
        	                    }
        	                }
        	            },
        	            labelLine: {
        	                normal: {
        	                    show: false
        	                }
        	            },
        	            data:xyComposite
        	        }
        	    ]
        	}; 
        
        // 使用刚指定的配置项和数据显示图表。
        columnChart.setOption(columnChart_option);
        cakeChart.setOption(cakeChart_option);
	});
	
	
	
	function dateSearch(){
		var startDate = $("#LAY_demorange_s").val();
		var endDate = $("#LAY_demorange_e").val();
		//console.log(startDate);
		//console.log(endDate);
		if(startDate=='' || endDate==''){
			alert("请选择日期区间！");
			return;
		}
		
		 $.ajax({
			url: '${baseurl}/gatherLog/count.do',
			type:'post',
			data:{'beginDate':startDate,'endDate':endDate},
			dataType:'json',
			success:function(data){
				//console.log(data);
				columnChart.setOption({
			        xAxis: {
			            data: data.xNames
			        },
			        series: [{
			            // 根据名字对应到相应的系列
			            name: '数量',
			            data: data.yData
			        }]
			    });
				for(var i=0; i<xAxisNames.length; i++){
					var p = new Object();
					p.name = data.xNames[i];
					p.value = data.yData[i];
					xyComposite.push(p);
				} 
				cakeChart.setOption({
					legend: {
	        	        data: data.xNames
	        	    },
	        	    series: [{
	        	    	name: '访问来源',
	        	    	data:xyComposite
	        	    }]
				})
			}
		});
	}
</script>
</head>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div class="inner_c">
		<h1>GPS设备统计</h1>
		<div class="layui-form-item">
		    <label class="layui-form-label">范围选择</label>
		    <div class="layui-input-inline">
		      <input class="layui-input" placeholder="开始日" id="LAY_demorange_s">
		    </div>
		    <div class="layui-input-inline">
		      <input class="layui-input" placeholder="截止日" id="LAY_demorange_e">
		    </div>
		    <div class="layui-input-inline" style="width:80px">
		      	<button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick="dateSearch();"><i class="layui-icon">&#xe615;</i></button>
		    </div>
		  </div>
		<div id="equipment_column" style="width: 700px;height:400px;"></div>
    </div>
    
    <div class="inner_c">
    	<div id="equipment_cake" style="width: 700px;height:400px;"></div>
    </div>
</body>
</html>