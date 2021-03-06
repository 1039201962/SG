<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户中心--layui后台管理模板 2.0</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form">
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" class="layui-input searchVal" placeholder="请输入搜索的内容" />
				</div>
				<a class="layui-btn search_btn" data-type="reload">搜索</a>
			</div>
			
		</form>
	</blockquote>
	<table id="userList" lay-filter="userList"></table>

	<!--操作-->
	<script type="text/html" id="userListBar">
		<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="usable">已启用</a>	
	</script>
</form>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','layer','table','laytpl'],function(){
	    var form = layui.form,
	        layer = parent.layer === undefined ? layui.layer : top.layer,
	        $ = layui.jquery,
	        laytpl = layui.laytpl,
	        table = layui.table;
	
	    //用户列表
	  var tableIns = table.render({
	        elem: '#userList',
	        url : '/user/findAll',
	        cellMinWidth : 95,
	        page : true,
	        height : "full-125",
	        limits : [10,15,20,25],
	        limit : 10,
	        id : "userListTable",
	        cols : [[
	            {type: "checkbox", fixed:"left", width:50},
	            {field: 'username', title: '用户名', minWidth:100, align:"center"},
	            {field: 'email', title: '用户邮箱', minWidth:200, align:"center"},
	            {field: 'phone', title: '电话号码', align:'center'},
	            {field: 'updated', title: '最后登录时间', align:'center',minWidth:150},
	            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
	        ]]
	    });
	
	    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	    $(".search_btn").on("click",function(){
	        if($(".searchVal").val() != ''){
	            table.reload("userListTable",{
	                page: {
	                    curr: 1 //重新从第 1 页开始
	                },
	                where: {
	                    key: $(".searchVal").val()  //搜索的关键字
	                }
	            })
	        }else{
	            layer.msg("请输入搜索的内容");
	        }
	    });
	
	
	    //列表操作
	    table.on('tool(userList)', function(obj){
	        var layEvent = obj.event,
	            data = obj.data;
	
	        if(layEvent === 'edit'){ //编辑
	            addUser(data);
	        }else if(layEvent === 'usable'){ //启用禁用
	            var _this = $(this),
	                usableText = "是否确定禁用此用户？",
	                btnText = "已禁用";
	            if(_this.text()=="已禁用"){
	                usableText = "是否确定启用此用户？",
	                btnText = "已启用";
	            }
	            layer.confirm(usableText,{
	                icon: 3,
	                title:'系统提示',
	                cancel : function(index){
	                    layer.close(index);
	                }
	            },function(index){
	                _this.text(btnText);
	                layer.close(index);
	            },function(index){
	                layer.close(index);
	            });
	        }else if(layEvent === 'del'){ //删除
	            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
	                // $.get("删除文章接口",{
	                //     newsId : data.newsId  //将需要删除的newsId作为参数传入
	                // },function(data){
	                    tableIns.reload();
	                    layer.close(index);
	                // })
	            });
	        }
	    });
	
	})
	
</script>
</body>
</html>