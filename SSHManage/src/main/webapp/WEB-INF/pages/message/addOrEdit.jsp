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
			员工编号：
			<input class="box" type="number" name="employee.emp_no" value="${emp_no }" readonly="readonly" id="emp_no"><br>
			出生日期：
			<input class="box" type="Date" name="employee.birth_date"><br>
			姓　　氏：
			<input class="box" type="text" name="employee.first_name">
			<span id="name_sp"></span><br>
			名　　字：
			<input class="box" type="text" name="employee.last_name"><br>
			性　　别：
			<input type="radio" name="employee.gender" value="M">&nbsp;&nbsp;男
			<input type="radio" name="employee.gender" value="F">&nbsp;&nbsp;女
			<br>
			雇佣日期：
			<input class="box" type="Date" name="employee.hire_date"><br>
			合同期限：
			<input class="box" type="Date" name="employee.to_date"><br>
			部门编号：
			<input class="box" type="text" name="employee.dept_no" id="dept_no">&nbsp;&nbsp;
			所在部门：
			<select class="box" name="employee.dept_name" id="dept_name">

				<option value="Marketing">市场部</option>
				<option value="Finance">财政部</option>
				<option value="Human Resources">人力资源部</option>
				<option value="Production">产品部</option>
				<option value="Development">开发部</option>
				<option value="Quality Management">质量管理部</option>
				<option value="Sales">销售部</option>
				<option value="Research">调研部</option>
				<option value="Customer Service">客户服务部</option>
				
			</select><br>
			职　　称：
			<select class="box" name="employee.title" id="title">
				<option value="Senior Engineer">高级工程师</option>
				<option value="Staff">普通员工</option>
				<option value="Engineer">工程师</option>
				<option value="Senior Staff">高级员工</option>
				<option value="Assistant Engineer">助理工程师</option>
				<option value="Technique Leader">技术主管</option>
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