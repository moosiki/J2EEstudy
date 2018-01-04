$(function(){
	
	//按钮点击效果
	$("button").on({
		"mouseover mouseleave mousedown mouseup":function(){
			$(this).toggleClass("buttonEvent");
		}
	});
	
	//保存按钮点击事件
	$("#saveBtn").on("click",function(){
		var action;
		var title = $("#title").find("option:selected").attr("value");
		if(title=='student')
			action='/ManagerSSH/studentAction!do_save';
		else
			action='/ManagerSSH/teacherAction!do_save';
		alert(action);
		/*alert("保存");*/
		$.ajax({
			cache:true,
			type:"post",
			url:action,
			data:$("#addForm").serialize(),
			async:true,
		/*	success:function(){
				console.log("添加成功");
				$("#form").load(
					'/ManageSystem/findBy_no',{
					emp_no:$("#emp_no").attr("value")},
					function(data){
						console.log(data.result);
					});
			}
		*/
		});

		/*$("#form").load(
			'/ManageSystem/addEmployee');*/
	});
/*	ajax({
		cache:true;
		type :"post";
		url:'/ManageSystem/'
		
	})*/
	
	
/*
	//表单提交事件
	$("#employeeAdd").find("#addForm").submit(function(){
		alert("跳入信息页面");
	 		$("#messagePage").find("#form").load(
				'/ManageSystem/addEmployee');
	 });
*/
	
	
//将部门编号与下拉框绑定
	$("#dept_no").on("change",function(){
		var dept_no = $(this).val();
		switch	(dept_no) {
			case "d001":
				$("#dept_name").find("option[value='Marketing']").attr("selected",true);
				break;

			case "d002":
				$("#dept_name").find("option[value='Finance']").attr("selected",true);
				break;

			case "d003":
				$("#dept_name").find("option[value='Human Resources']").attr("selected",true);
				break;

			case "d004":
				$("#dept_name").find("option[value='Production']").attr("selected",true);
				break;

			case "d005":
				$("#dept_name").find("option[value='Development']").attr("selected",true);
				break;

			case "d006":
				$("#dept_name").find("option[value='Quality Management']").attr("selected",true);
				break;

			case "d007":
				$("#dept_name").find("option[value='Sales']").attr("selected",true);
				break;

			case "d008":
				$("#dept_name").find("option[value='Research']").attr("selected",true);
				break;

			case "d009":
				$("#dept_name").find("option[value='Customer Service']").attr("selected",true);
		}
	});
	$("#dept_name").on("change",function () {
		var dept_name = $(this).val();
		switch(dept_name) {
			case "Marketing":
				$("#dept_no").attr("value","d001");
				break;

			case "Finance":
				$("#dept_no").attr("value","d002");
				break;

			case "Human Resources":
				$("#dept_no").attr("value","d003");
				break;

			case "Production":
				$("#dept_no").attr("value","d004");
				break;

			case "Development":
				$("#dept_no").attr("value","d005");
				break;

			case "Quality Management":
				$("#dept_no").attr("value","d006");
				break;

			case "Sales":
				$("#dept_no").attr("value","d007");
				break;

			case "Research":
				$("#dept_no").attr("value","d008");
				break;

			case "Customer Service":
				$("#dept_no").attr("value","d009");
				break;

		}
		
	});

});