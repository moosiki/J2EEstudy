<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册界面</title>
    <link rel="stylesheet" type="text/css" href="./styles/Detail.css">
</head>

<body id="main">
    <div id="outline">
        <header>
            <h2 id="title">注册成功!</h2>
        </header>
        <div id="form">
            <form action="/HibernateMap/shopping" method="post">
            
                <tr>
                    用户名称：
                   	<div name=user.loginName>${user.loginName}</div>
                   	<input class="inputBox" type="text" id="username" name="user.loginName" value="${user.loginName}" readonly="readonly">
                </tr>
                <br>
                <br>
                <tr>
                    用户Id：
                   <div name=user.user_id>${user.user_id}</div>
                   <input class="inputBox" type="text" id="username" name="user.user_id" value="${user.user_id}" readonly="readonly">
                   
                </tr>
                <br>
                <br>
                <tr>
                   注册时间：
                    <div name=user.creatDate>${user.creatDate}</div>
                    <input class="inputBox" type="text" id="username" name="user.creatDate" value="${user.creatDate}" readonly="readonly">
                </tr>
                <br>
                <br>
                <tr>
                   
                <footer>
                    <button type="submit" class="button" id="registerButton" onclick="register()">shopping!</button>
                    <button type="reset" class="button" style="background-color: red;">scanner</button>
                </footer>
            </form>
        </div>
    </div>
</body>

</html>
	