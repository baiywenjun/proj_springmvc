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
            <form class="layui-form x-center" action="" style="width:800px">
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
                      <input type="text" name="username"  placeholder="设备类型" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                      <input type="text" name="username"  placeholder="设备名称" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                      <input type="text" name="username"  placeholder="设备编号" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                    </div>
                  </div>
                </div> 
            </form>
            <xblock><button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button><button class="layui-btn" onclick="member_add('添加用户','member-add.html','600','500')"><i class="layui-icon">&#xe608;</i>添加</button><span class="x-right" style="line-height:40px">共有数据：88 条</span></xblock>
            
			<table id="demo" lay-filter="test"></table>
            <div id="page"></div>
        </div>
    <script src="${baseurl}/lib/layui/layui.js"></script>
    <script src="${baseurl }/js/x-layui.js"></script>
	<script>
	layui.use('table', function(){
		  var table = layui.table;
		  
		  //第一个实例
		  table.render({
		    elem: '#demo'
		    ,height: 315
		    ,url: '${baseurl}/test/table/user.do' //数据接口
		    ,request: {}
		    ,page: true //开启分页
		    ,cols: [[ //表头
		      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
		      ,{field: 'username', title: '用户名', width:80}
		      ,{field: 'sex', title: '性别', width:80, sort: true}
		      ,{field: 'city', title: '城市', width:80} 
		      ,{field: 'sign', title: '签名', width: 177}
		      ,{field: 'experience', title: '积分', width: 80, sort: true}
		      ,{field: 'score', title: '评分', width: 80, sort: true}
		      ,{field: 'classify', title: '职业', width: 80}
		      ,{field: 'wealth', title: '财富', width: 135, sort: true}
		    ]]
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