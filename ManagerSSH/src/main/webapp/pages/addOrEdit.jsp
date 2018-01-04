<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="../styles/addOrEdit.css">
<div id="employeeAdd">
	<div id="titleText">
		添加员工&修改信息
	</div>
	<form action="#" method="post" id="addForm">
		<div>
			编　　号：
			<input class="box" type="number" name="object.id" value=12 readonly="readonly" id="emp_no"><br>
			年　　龄：
			<input class="box" type="number" name="object.age"><br>
			姓　　名：
			<input class="box" type="text" name="object.name">
			<span id="name_sp"></span><br>
			性　　别：
			<input type="radio" name="object.sex" value="男">&nbsp;&nbsp;男
			<input type="radio" name="object.sex" value="女">&nbsp;&nbsp;女
			<br>
			
			职　　务：
			<select class="box" name="object.title" id="title">
				<option value="teacher">老师</option>
				<option value="student">学生</option>
			</select><br>
		</div>
		<div style="margin: 30px 0 10px 50px;">
			<button type="button" id="saveBtn">保存</button>
			<button type="reset" id="resetBtn">重置</button>
			<button type="button" id="cancerBtn">取消</button>
		</div>
	</form>	
</div>
<script type="text/javascript" src="../scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../scripts/addOrEdit.js"></script>