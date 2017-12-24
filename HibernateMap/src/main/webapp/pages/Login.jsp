<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登陆</title>
    <link rel="stylesheet" type="text/css" href="/HibernateMap/styles/style.css">
</head>

<body id="main">
    <div id="outline">
        <header>
            <img src="/HibernateMap/images/cat.jpg" width="100px" height="73px">
            <h2 id="title">登陆</h2>
        </header>
        <div id="form">
            <form action="/HibernateMap/login" method="post">
                <tr>
                    用户名称：
                    <input class="inputBox" type="text" id="username" name="user.loginName" placeholder="请输入您的登陆名：loginName" required="required" onblur="user()">&nbsp;&nbsp;
                    <span class="correctTip" id="tip1"></span><span class="wrongTip" id="tip5"></span>
                </tr>
                <br>
                <br>
                <tr>
                    登陆密码：
                    <input class="inputBox" type="password" id="password" name="user.password" placeholder="请输入您的登陆密码" minlength="8" required="required" onblur="pass()">&nbsp;
                    <span class="correctTip" id="tip2"></span><span class="wrongTip" id="tip6"></span>
                </tr>
                <br>
                <br>              
                <footer>
                    <button type="submit" class="button" id="registerButton">登陆</button>
                    <button type="button"class="button"><a href="/HibernateMap/pages/Registe.jsp">注册</a></button>
                </footer>
            </form>
        </div>
    </div>
</body>

</html>