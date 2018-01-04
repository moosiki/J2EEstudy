<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="../styles/animate.css">
<link rel="stylesheet" type="text/css" href="../styles/style.css">
<link rel="stylesheet" type="text/css" href="../styles/employeeMessage.css">

<style type="text/css">
	#table{
		border: 2px;
		border-width: 3px;
		border-style: ridge;
		border-color: red;

	}
</style>

<div id="employeeMessage">
	<div id="search">
		所在部门：
			<select class="box" name="employee.dept_name" id="dept_name">
				<option value="">任意</option>
				<option value="Marketing">市场部</option>
				<option value="Finance">财政部</option>
				<option value="Human Resources">人力资源部</option>
				<option value="Production">产品部</option>
				<option value="Development">开发部</option>
				<option value="Quality Management">质量管理部</option>
				<option value="Sales">销售部</option>
				<option value="Research">调研部</option>
				<option value="Customer Service">客户服务部</option>
				
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
		职　　称：
			<select class="box" name="employee.title" id="title">
				<option value="">任意</option>
				<option value="Senior Engineer">高级工程师</option>
				<option value="Staff">普通员工</option>
				<option value="Engineer">工程师</option>
				<option value="Senior Staff">高级员工</option>
				<option value="Assistant Engineer">助理工程师</option>
				<option value="Technique Leader">技术主管</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
		性　　别：
			<select class="box" id="gender">
				<option value="">任意</option>
				<option value="M">男</option>
				<option value="F">女</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
		查询数量：
			<input class="box" type="number" min="0" maxlength="4" pattern="[0-9]" placeholder="数量范围：0~9999" 
			default=20 id="number">&nbsp;&nbsp;&nbsp;&nbsp;
			<button id="searchBtn">查询</button>
	</div>
	<table id="table" border="1px">
		<thead>
			<tr>
				<th>学生编号</th>
				<th>年　　龄</th>
				<th>姓　　名</th>
				<th>性　　别</th>
				<th>操　　作</th>
			</tr>
	   	</thead>	
	   	<tbody id="info">
	   		<c:forEach items="${objects }" var="ms">
	   			<tr)>
		   			<th>${ms.id}</th>
		   			<th>${ms.age}</th>
		   			<th>${ms.name}</th>
		   			<th class="gender" value="${ms.sex}">${ms.sex}</th>

		   		    <th><button class="details" value="${ms.id}">详　情</button></th>
		   		    <th><button class="delete" value="${ms.id}">删　除</button></th>
		   		    <th><button class="modify" value="${ms.id}">修　改</button></th>
	   			</tr>
	   		</c:forEach> 
	   	</tbody>
	</table>
</div>

	<script type="text/javascript" src="../scripts/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.paginate.js"></script>
	<script type="text/javascript" src="../scripts/MessageBtn.js"></script>
	<script type="text/javascript" src="../scripts/MessageTranslate.js"></script>
