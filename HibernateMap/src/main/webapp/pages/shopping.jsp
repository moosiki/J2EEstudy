<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物界面</title>
    <link rel="stylesheet" type="text/css" href="/HibernateMap/styles/shopping.css">
    <link rel="stylesheet" href="/HibernateMap/styles/animate.css">
</head>

<body class="mainPage">
    <div>当前登陆用户：${loginName}</div>
    <span>用户id：</span><span id="user_id">${user_id}</span>
    <div id="list">
    	<button id="orderBtn">查看订单</button>
        <table id="movieTable" cellspacing="0" style="border-collapse: collapse;">
            <thead>
            	<th>选择</th>
            	<th>商品Id</th>
                <th>商品名称</th>
                <th>商品价格</th>
               
             
                <th>操作</th>
            </thead>
            <tbody>
                <c:forEach items="${goodsList}" var="goods">
                    <label for="deleteBox">
                        <tr>
                    <td>
                        <input type="checkbox" name="delete" id="deleteBox">
                    </td>
                    <td class="goodsId">${goods.goodsId }</td>
                    <td>${goods.goodsName }</td>
                    <td>${goods.price }</td>
                    <td><button class="buyBtn" value="${goods.goodsId }">购买</button> </td>                         
                </tr>
                    </label>
                
                </c:forEach>
            </tbody>
        </table>
        <div style="width: 500px;margin: auto;">
            <button  class="selectBtn" id="selectAllBtn">全选</button>
            <button  class="selectBtn" id="deselectBtn">反选</button>
            <button  class="selectBtn" id="deleteBtn">加入购物车</button>
        </div>
    </div>
    <div id="Order"></div>
    <script type="text/javascript" src="/HibernateMap/scripts/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/HibernateMap/scripts/shopping.js"></script>
	</body>

</html>