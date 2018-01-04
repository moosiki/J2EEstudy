$(function(){
	var $table = $("#table");

	//按钮点击效果
	$("#searchBtn").on({
		"mouseover mouseleave mousedown mouseup":function(){
			$(this).toggleClass("buttonEvent");
		}
	});
	
	//查询按钮点击事件
	$("#searchBtn").on("click",function(){

		var nameWord ="%"+$("#nameWord").prop("value")+"%";

		var dept_name = "%"+$("#dept_name").prop("value")+"%";

		var title = "%"+$("#title").prop("value")+"%";

		var gender = "%"+$("#gender").prop("value")+"%";
		
		var number;
		if ($("#number").prop("value")!='') {
			number = $("#number").prop("value");
		}else
			number = 15;

		$("#form").load(
				'/ManageSystem/search',{
					dept_name:dept_name,
					title:title,
					gender:gender,
					first_name:nameWord,
					last_name:nameWord,
					num:number
				},function(data){
					console.log(data.result);
				});

	});

	//详情按钮点击事件
	$table.find(".details").on("click",function(){
		var $this = $(this);
		$("#messagePage").find("#form").load(
			'/ManagerSSH/studentAction!to_edit',{
				id:$this.attr("value")
			}
		);
	});
	
	//删除按钮点击事件
	$table.find(".delete").on("click",function(){
		var $this = $(this);
		alert($this.attr("value"));
		var id = $this.attr("value");
		$("#messagePage").find("#form").load(
			'/ManagerSSH/studentAction!do_delete',{
				id:id
			});
	});
});
