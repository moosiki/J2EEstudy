$(function(){
	init();
	function init(){
		//翻译部门名称
		$("#table").find(".dept_name").each(function(){
			$(this).text(translateDept($(this).attr("value")));
		});

		//翻译性别
		$("#table").find(".gender").each(function(){
			$(this).text(translateGender($(this).attr("value")));
		});

		//翻译职称
		$("#table").find(".title").each(function(){
			$(this).text(translateTitle($(this).attr("value")));
		});
	}
	

	//翻译部门名称函数
	function translateDept(deptName) {

		switch (deptName) {

			case "Development":
				
				return "开发部";

			case "Sales":
				return "销售部";

			case "Production":
				return "产品部";

			case "Human Resources":
				return "人力资源部";

			case "Research":
				return "调研部";

			case "Quality Management":
				return "质量管理部";

			case "Customer Service":
				return "客户服务部";

			case "Marketing":
				return "市场部";

			case "Finance":
				return "财政部";
				
		}
	}

	//翻译性别函数
	function translateGender(gender){
		switch (gender) {

			case "F":
				return "女";

			case "M":
				return "男";

		}
	}
	
	//翻译职称函数
	function translateTitle(title){
		switch (title) {

			case "Senior Engineer":
				return "高级工程师";

			case "Staff":
				return "普通员工";

			case "Engineer":
				return "工程师";

			case "Senior Staff":
				return "高级员工";

			case "Assistant Engineer":
				return "助理工程师";

			case "Technique Leader":
				return "技术主管";
		}
	}
		
});