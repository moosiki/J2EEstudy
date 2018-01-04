<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Head -->
<head>

<title>登录</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="application/x-javascript">
	 
			addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
			function hideURLbar(){ 
				window.scrollTo(0,1); } 
		
</script>
<!-- //Meta-Tags -->

<link rel="stylesheet" href="/SSHManage/styles/start/login.css"
	type="text/css" media="all">
<link rel="stylesheet" href=".././plugs/bootstrap/bootstrap.css"
	type="text/css" media="all">
<link rel="stylesheet" href=".././plugs/bootstrap-toastr/toastr.css"
	type="text/css" media="all">



</head>
<!-- //Head -->

<!-- Body -->
<body>

	<h1>登录</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<form id="loginForm" action="/SSHManage/login/do" method="post"
				data-validator-option="{timely:2, focusCleanup:true}">
				
				<input type="text" name="loginName" placeholder="用户ID" data-rule="loginName: required; length(5~10)"> 
					<span id="inputName" class="spanTips"></span> 
					
				<input type="password" name="password" placeholder="密码" data-rule="password: required">
					<span id="inputPass" class="spanTips"></span>

				<ul class="tick w3layouts agileits">
					<li><input type="checkbox" id="brand1" value=""> <label
						for="brand1"><span></span>记住我</label></li>
				</ul>
				<div class="send-button w3layouts agileits">

					<input id="loginBtn" type="submit" value="登 录">

				</div>
				<c:if test="${hasLoginError == true }">
					<div class="alert alert-warning fade in">
						<fmt:message key="${loginErrorMessage }" />
					</div>
				</c:if>
			</form>
			<a href="#">忘记密码?</a>
			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
				<ul>
					<li class="qq"><a href="#"> <span
							class="icons w3layouts agileits"></span> <span
							class="text w3layouts agileits">QQ</span></a></li>
					<li class="weixin w3ls"><a href="#"> <span
							class="icons w3layouts"></span> <span
							class="text w3layouts agileits">微信</span></a></li>
					<li class="weibo aits"><a href="#"> <span
							class="icons agileits"></span> <span
							class="text w3layouts agileits">微博</span></a></li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="clear"></div>
		</div>


		<div class="clear"></div>

	</div>

	<div class="footer w3layouts agileits">
		<p>
			Copyright &copy; <a href="https://www.qingshixun.com/"
				target="_blank" title="轻实训">轻实训</a>
		</p>
	</div>

	<script type="text/javascript" src=".././plugs/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src=".././scripts/start/login.js"></script>
	<script type="text/javascript"
		src=".././plugs/bootstrap-toastr/toastr.js"></script>
	<script type="text/javascript"
		src=".././plugs/validator/jquery.validator.js?local=zh_CN"></script>

</body>
<!-- //Body -->

</html>