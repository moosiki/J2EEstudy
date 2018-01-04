<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href=".././styles/home/manage.css">
	<link rel="stylesheet" href=".././plugs/animate.css">
	
	
<title>用户管理界面</title>
</head>
<body id="mainPage" style="margin: 0">
	<div id="headPage">
		<img src=".././images/home/logo.png" style="width: 55px;height: 55px;margin-left: 20px;margin-top: 3px
		;float: left;">
		<p style="width:200px; margin-left: 50px;line-height:65px;float: left">用户管理系统</p>
		<div style="float: right; margin-top: 20px;margin-right: 50px">
			当前登陆用户:
			<a href="http://www.baidu.com" style="text-decoration: none; color: white">
				<security:authentication property="principal.username"/>
			</a>
			<a href="" style="text-decoration: none; color: white">帮助</a>
			&nbsp;&nbsp;
				<a href="${ctx }/logout" style="text-decoration: none;color: white" data-toggle="dropdown"> 
					<i class="dropdown-icon fa fa-power-off"></i> 
					<span>退出</span>
				</a>

		</div>
	</div>
	<div id="menuPage">
		<div class="menuDiv" id="searchMenu">用户查询</div>
		<div class="menuDiv" id="addMenu">用户新增</div>
		
	</div>	
	<div id="messagePage">
		<div style="margin:30px 0 0 30px;border-bottom: 2px solid black;padding-bottom: 20px;min-width: 1200px">
			用户名称 : &nbsp;&nbsp;
			<input type="text" name="keyword" style="height: 25px" placeholder="请输入关键字查询" id="nameWord">
			<button class="button" id="mainSearchBtn">查 询</button>
		</div>
		<div id="form" style="margin-top: 20px;margin-left: 50px;min-width: 1200px">
			
		</div>
	</div>
	<canvas id="myChart"></canvas>
	
	<script type="text/javascript" src=".././plugs/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src=".././scripts/home/manage.js"></script>
	<script type="text/javascript" src=".././plugs/Chart.min.js"></script>
</body>
</html>