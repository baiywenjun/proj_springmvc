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
		font: 32px/32px "微软雅黑";
		margin: 30px 0;
	}
</style>
<script src="${baseurl }/js/jquery.min.js"></script>
<script src="${baseurl }/lib/layui/layui.js"></script>
<script src="${baseurl }/js/echarts.js"></script>
<script type="text/javascript">
	function dateSearch(){
		var startDate = $("#LAY_demorange_s").val();
		var endDate = $("#LAY_demorange_e").val();
		//console.log(startDate);
		//console.log(endDate);
		if(startDate=='' || endDate==''){
			alert("请选择日期区间！");
		}
		
		$.ajax({
			url:'xxx.do',
			type:'post',
			data:{'param':'中文实验','userName':userName,'userAddr':userAddr, 'userBirthday':userBirthday},
			dataType:'json',
			success:function(data){
				console.log(data);
				
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
		<div id="equipment_column" style="width: 600px;height:400px;"></div>
    </div>
    
    <div class="inner_c">
    	<h1>监控设备统计</h1>
    	<div id="equipment_cake" style="width: 600px;height:400px;"></div>
    </div>
    <script type="text/javascript">
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
    	/* $.ajax({
			url:'/integration/getUserInfo.do',
			type:'post',
			data:{'param':'中文实验','userName':userName,'userAddr':userAddr, 'userBirthday':userBirthday},
			dataType:'json',
			success:function(data){
				console.log(data);
				$("#span1").text(data.userName);
				var tmp0 = new Date(data.userBirthday);
				var tmp1 = tmp0.toLocaleString();
				$("#span2").text(tmp1);
			}
		}); */
    
        // 基于准备好的dom，初始化echarts实例
        var columnChart = echarts.init(document.getElementById('equipment_column'));
        var cakeChart = echarts.init(document.getElementById('equipment_cake'));
        
        // 指定图表的配置项和数据
        var columnChart_option = {
        	color : ['#3398DB'],
            title: {
                text: '设备活跃数量'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 80]
            }]
        };
		
        var cakeChart_option = {
        	    title : {
        	        text: '某站点用户访问来源',
        	        subtext: '纯属虚构',
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },
        	    legend: {
        	        orient: 'vertical',
        	        left: 'left',
        	        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        	    },
        	    series : [
        	        {
        	            name: '访问来源',
        	            type: 'pie',
        	            radius : '55%',
        	            center: ['50%', '60%'],
        	            data:[
        	                {value:335, name:'直接访问'},
        	                {value:310, name:'邮件营销'},
        	                {value:234, name:'联盟广告'},
        	                {value:135, name:'视频广告'},
        	                {value:1548, name:'搜索引擎'}
        	            ],
        	            itemStyle: {
        	                emphasis: {
        	                    shadowBlur: 10,
        	                    shadowOffsetX: 0,
        	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
        	                }
        	            }
        	        }
        	    ]
        	}; 
        
        // 使用刚指定的配置项和数据显示图表。
        columnChart.setOption(columnChart_option);
        cakeChart.setOption(cakeChart_option);
        
    </script>
</body>
</html>