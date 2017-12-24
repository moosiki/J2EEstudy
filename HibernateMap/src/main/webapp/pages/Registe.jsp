<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册界面</title>
    <link rel="stylesheet" type="text/css" href="/HibernateMap/styles/style.css">
</head>

<body id="main">
    <div id="outline">
        <header>
            <img src="../images/cat.jpg" width="100px" height="73px">
            <h2 id="title">网上商城用户注册</h2>
        </header>
        <div id="form">
            <form action="/HibernateMap/registe" method="post">
                <tr>
                    用户名称：
                    <input class="inputBox" type="text" id="username" name="user.loginName" placeholder="15字符以内，可由字母，数字，下划线组成" required="required" onblur="user()">&nbsp;&nbsp;
                    <span class="correctTip" id="tip1"></span><span class="wrongTip" id="tip5"></span>
                </tr>
                <br>
                <br>
                <tr>
                    登陆密码：
                    <input class="inputBox" type="password" id="password" name="user.password" placeholder="8-20字符，不能由纯数字组成" minlength="8" required="required" onblur="pass()">&nbsp;
                    <span class="correctTip" id="tip2"></span><span class="wrongTip" id="tip6"></span>
                </tr>
                <br>
                <br>
                <tr>
                     重复密码：
                    <input class="inputBox" type="password" id="password2" name="password2" placeholder="请再次输入密码" required="required" onchange="repitPass()">&nbsp;
                    <span class="correctTip" id="tip3"></span><span class="wrongTip" id="tip7"></span>
                </tr>
                <br>
                <br>
                <tr>
                    电子邮箱：
                    <input class="inputBox" type="email" id="email" name="email" placeholder="输入您的常用邮箱" required="required" onblur="ema()">&nbsp;&nbsp;
                    <span class="correctTip" id="tip4"></span><span class="wrongTip" id="tip8"></span>
                </tr>
                <br>
                <br>
                <tr>
                    性　　别：
                    <input type="radio" name="gender" value="male">男
                    <input type="radio" name="gender" value="female">女
                </tr>
                <br>
                <br>
                <footer>
                    <button type="submit" class="button" id="registerButton" onclick="register()">注册</button>
                    <button type="reset" class="button" style="background-color: red;">重置</button>
                </footer>
            </form>
            <a href="../pages/Login.jsp">已有账户？点击登陆</a>
        </div>
    </div>
    <script type="text/javascript" src="/HibernateMap/scripts/register.js">
    </script>
</body>

</html>