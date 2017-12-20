<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ include file="/jsp/common/tag.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            二当家的Lay1.0
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${baseurl }/css/x-admin.css" media="all">
        <script src="${baseurl }/lib/layui/layui.js"></script>
    	<script src="${baseurl }/js/x-layui.js"></script>
    	<script src="${baseurl }/js/jquery.min.js"></script>
        <script type="text/javascript">
        $(function(){
        })
        function equmentSearch(){
        	//alert("aaaa");
        	var equmentType =  $("#equmentType").val();
        	var equmentName =  $("#equmentName").val();
        	var equmentNo =  $("#equmentNo").val();
        	
        	$.ajax({
				url : '${baseurl}/equipment/list/page.do',
				type : "get",
				data : {'pageNum':1,
						'pageSize':5,
						'equmentType':equmentType,
						'equmentName':equmentName,
						'equmentNo':equmentNo
						},
				dataType : 'json',
				success : function(result) {
					$(".tbody").empty();
					// TODO
					var equip = result;
					var html = "";
					$.each(equip,function(i, a) {
								html += '<td>' + this.id + '</td>';
								html += '<td>' + this.equmentName+ '</td>';
								html += '<td>' + this.equmentNo+ '</td>';
								html += '<td>' + this.equmentType+ '</td>';
								html += '<td>' + this.createTime+ '</td>';
								$("<tr>").html(html).appendTo(".tbody");
								html = "";
							});
				},
				error : function() {
					alert("error!");
				}
			});
        	
        }
        
        </script>
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>设备管理</cite></a>
              <a><cite>设备列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
            <form class="layui-form x-center" action="javascript:;" style="width:800px">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item">
                   <!--  <label class="layui-form-label">日期范围</label>
                    <div class="layui-input-inline">
                      <input class="layui-input" placeholder="开始日" id="LAY_demorange_s">
                    </div>
                    <div class="layui-input-inline">
                      <input class="layui-input" placeholder="截止日" id="LAY_demorange_e">
                    </div> -->
                    <div class="layui-input-inline">
                      <input type="text" id="equmentType" name="equmentType"  placeholder="设备类型" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                      <input type="text" id="equmentName" name="equmentName"  placeholder="设备名称" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                      <input type="text" id="equmentNo" name="equmentNo"  placeholder="设备编号" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick="equmentSearch();"><i class="layui-icon">&#xe615;</i></button>
                    </div>
                  </div>
                </div> 
            </form>
            
			<table class="layui-table">
			<thead>
				<tr>
					<!-- <th><input type="checkbox" name="" value=""></th> -->
					<th>序号</th>
					<th>帐号</th>
					<th>姓名</th>
					<th>注册时间</th>
					<th>电话</th>
					<!-- <th>操作</th> -->
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${pageInfo.list}" var="item" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${item.accountId }</td>
						<td>${item.userName }</td>
						<td>${item.createTime }</td>
						<td>${item.phone }</td>
					</tr>
				</c:forEach>
				<c:if test="${!empty message }">
					<tr>
						<td colspan='5' align="center">${message }</td>
					<tr>
				</c:if>
			</tbody>
		</table>

		<div id="pageDemo"></div>
        </div>
		<script>
		layui.use(['layer', 'laypage', 'element'], function(){
		  var layer = layui.layer
		  ,laypage = layui.laypage
		  ,element = layui.element();
		  
		  //向世界问个好
		 // layer.msg('Hello World');
		 
		  //监听Tab切换
		  element.on('tab(demo)', function(data){
		    layer.msg('切换了：'+ this.innerHTML);
		    console.log(data);
		  });
		  
		  //分页
		  laypage({
		    cont: 'pageDemo' //分页容器的id
		    ,pages: 100 //总页数
		    ,skin: '#5FB878' //自定义选中色值
		    //,skip: true //开启跳页
		    ,jump: function(obj, first){
		      if(!first){
		        layer.msg('第'+ obj.curr +'页');
		        var pageNum = obj.cur;
		        $.ajax({
					url : '${baseurl}/equipment/list/page.do',
					type : "get",
					data : {'pageNum':obj.curr,'pageSize':5},
					dataType : 'json',
					success : function(result) {
						$(".tbody").empty();
						// TODO
						var equip = result;
						var html = "";
						$.each(equip,function(i, a) {
									html += '<td>' + this.id + '</td>';
									html += '<td>' + this.equmentName+ '</td>';
									html += '<td>' + this.equmentNo+ '</td>';
									html += '<td>' + this.equmentType+ '</td>';
									html += '<td>' + this.createTime+ '</td>';
									$("<tr>").html(html).appendTo(".tbody");
									html = "";
								});
					},
					error : function() {
						alert("error!");
					}
				});
		      }
		    }
		  });
		});
		</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>