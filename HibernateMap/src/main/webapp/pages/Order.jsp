<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <link rel="stylesheet" type="text/css" href="/HibernateMap/styles/shopping.css">

    
    <div >
    	<div>我的订单</div>
        <table id=movieTable cellspacing="0" style="border-collapse: collapse;">
            <thead>
            	<th>订单编号</th>
            	<th>创建日期</th>
                <th>订单描述</th>
                <th>操作</th>
                <th>订单详情</th>
            </thead>
            <tbody>
                <c:forEach items="${ordersList}" var="order">
                <tr>
                    <td class="code" rowspan="2">${order.code }</td>
                    <td rowspan="2">${order.creatDate }</td>
                    <td rowspan="2">${order.description }</td>
                    <td rowspan="2"><button class="deleteBtn" value="${order.code }">删除</button> </td>     
                    <td>商品id</td>
               		<td>商品名字</td>
               		<td>商品价格</td>                   
                </tr>
               		
               	<tr>
                    <c:forEach items="${order.goods }" var="goods">
                    	<td>${goods.goodsId }</td>
                    	<td>${goods.goodsName }</td>
                    	<td>${goods.price }</td>
                    </c:forEach>
                </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>
    <script type="text/javascript" src="/HibernateMap/scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/HibernateMap/scripts/shopping.js"></script>

