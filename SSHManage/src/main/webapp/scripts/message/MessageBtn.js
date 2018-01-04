
$(function(){

	var $table = $("#table");
	
	//删除按钮点击事件
	$("#wrapper").on("click",".delete",function(){
		/*e = e || window.event;
		var target = e.target || e.srcElement;
		if(target.tagName.toLowerCase() == 'button'){*/
			var $this = $(this);
			alert($this.parent().attr("value"));
			var empNo = $this.parent().attr("value");
			$.ajax({
				url:'/SSHManage/empControl/deleteEmp',
				type:'post',
				data:{"empNo":empNo},
				success:function(){
					/*$("#messagePage").find("#form").load(
							'/SSHManage/startController/employeeMessage'
							);*/
					$this.parent().parent().remove();
				},
				});	
	});
	
	//按钮点击效果
	$("#searchBtn").on({
		"mouseover mouseleave mousedown mouseup":function(){
			$(this).toggleClass("buttonEvent");
		}
	});
	
	//查询按钮点击事件
	$("#searchBtn").on("click",function(){
		
		console.log("搜索");
		
		var name = 'demo1';
	    var sizeUrl = '/SSHManage/empControl/paramPage';
	    var sourceUrl = '/SSHManage/empControl/paramPage';
	    
	    var searchName ="%"+$("#nameWord").prop("value")+"%";

		var deptName = "%"+$("#dept_name").prop("value")+"%";

		var title = "%"+$("#title").prop("value")+"%";

		var gender = "%"+$("#gender").prop("value")+"%";
		
		var number;
		var startPa = null;
		var pageSi = null;
		
		if ($("#number").prop("value")!='') {
			number = $("#number").prop("value");
		}else
			number = 15;
		
	    createDemo(name,sizeUrl,sourceUrl);
		function createDemo(name,sizeUrl,sourceUrl){
	        var container = $('#pagination-' + name);	
	        var dataSize;
	        var sources = function(){
	        	var result = [];
	            
	            //异步获取数据总数
	            $.ajax({
	            	type:"post",
	            	async:false,
	            	dataType:'json',
/*	            	contentType:'application/json',*/
	            	url:sizeUrl,
	            	data:{
	            		"deptName":deptName,
						"title":title,
						"gender":gender,
						"searchName":searchName,
						"startPage":startPa,
						"pageSize":pageSi},
	         /*   	url:'/SSHManage/empControl/queryAmount',*/
	            	success:function(data){
	            		console.log(data.length);
	            		console.log(data[0][0]);
	            		console.log(data[1]);
	            		dataSize = data.length;
	            		for(var i = 0; i < dataSize; i++){
		                    result.push(i);
		                }
	            		
	            	}
	            }); 
				
	            return result;
	        }();

	        var options = {
	            dataSource: sources,
	            pageSize:15,
	            showNavigator:true,
	            showGoInput:true,
	            showGoButton:true,
	            activeClassName:'systemPagerActive',
	            preText:'上一页',
	            nextText:'下一页',
	            className: 'paginationjs-theme-red paginationjs-small',
	            callback: function(response, pagination){	                	
	             
	          		var dataHtml = "<table class='zebra' id='table2'>"+
	          							"<thead>"+
						        			"<tr>";
					dataHtml += '<th>员工编号</th>';
					dataHtml += '<th>员工名字</th>';
					dataHtml += '<th>员工姓氏</th>';
					dataHtml += '<th>员工性别</th>';
					dataHtml += '<th>员工状态</th>';
					dataHtml += '<th>员工生日</th>';
					dataHtml += '<th>操  作</th>';
					dataHtml += "</tr>"+
						        "</thead>"+	
						        "<tbody id='info'>";
	                
	                $.ajax({
	                 	type:"post",
	                 	async:false,
	                 	url:sourceUrl,
	                 	/*url:'/SSHManage/empControl/queryMessage',*/
	                 	data:{
		            		"deptName":deptName,
							"title":title,
							"gender":gender,
							"searchName":searchName,
							"startPage":pagination.pageNumber,
							"pageSize":pagination.pageSize},
	                 	success:function(data){
	                 		dataSize=data.length;
	                 		$.each(response, function(index, item){
	                 			dataHtml += '<tr>';
	                 			
	                 			for(val in data[index]) {
	                 				
	                 				dataHtml += '<th>'+data[index][val]+'</th>';
	                 				/*console.log(data[index][val]);*/
	                 			}
	                 			dataHtml += "<th value='"+data[index][0]+"'><button class='delete'>删除</button><button class='edit'>修改</button><button class='details'>详情</button></th>";
	                 			dataHtml += '<tr>';
		                    });

	                 	}
	                });
	                dataHtml += "</tbody>"+
	                			"</table>";
					dataHtml += "<div id='pageNumber'>当前是第:&nbsp;&nbsp;"+"<span id='pageNumber'>"+pagination.pageNumber+"</span>&nbsp;&nbsp;页</div>";
					
					container.prev().html(dataHtml);
	            }
	        };
	        container.pagination(options);

	        return container;
	    }
	});

	//详情按钮点击事件
	$("#wrapper").on("click",".details",function(){
		var $this = $(this);
		var empNo = $this.parent().attr("value");
		console.log(empNo);
		$.ajax({
			type:"post",
         	async:true,
         	url:'/SSHManage/empControl/queryEmp',
         	data:{
        		"empNo":empNo},
         	success:function(data){
         		console.log(data);
         		console.log(data.length);
         	}
		});
	});
	
	//修改按钮点击事件
	$("#wrapper").on("click",".edit",function(){
		console.log("修改");
		var $this = $(this);
		var empNo = $this.parent().attr("value");
		console.log(empNo);
		var message;
		$.ajax({
			type:"post",
         	async:false,
         	url:'/SSHManage/empControl/queryEmp',
         	data:{
        		"empNo":empNo},
         	success:function(data){
         		console.log(data);
         		console.log(data[1].length);
         		message = data;
         	}
		});
		
		
		var html = "<th colspan='7'>";
		html += "<form action='#' method='post' id='addForm'>" +
				"<div>" +
				"员工编号：" +
				"<input class='box' type='number' name='employee.emp_no' value='${emp_no }' readonly='readonly' id='emp_no'><br>" +
				"出生日期：" +
				"<input class='box' type='Date' name='employee.birth_date'><br>" +
				"姓　　氏：" +
				"<input class='box' type='text' name='employee.first_name'>" +
				"<span id='name_sp'></span><br>" +
				"名　　字：" +
				"<input class='box' type='text' name='employee.last_name'><br>" +
				"性　　别：" +
				"<input type='radio' name='employee.gender' value='M'>&nbsp;&nbsp;男" +
				"<input type='radio' name='employee.gender' value='F'>&nbsp;&nbsp;女" +
				"<br>" +
				"雇佣日期：" +
				"<input class='box' type='Date' name='employee.hire_date'><br>" +
				"合同期限：" +
				"<input class='box' type='Date' name='employee.to_date'><br>" +
				"部门编号：" +
				"<input class='box' type='text' name='employee.dept_no' id='dept_no'>&nbsp;&nbsp;" +
				"所在部门：" +
				"<select class='box' name='employee.dept_name' id='dept_name'>" +
				"<option value='Marketing'>市场部</option>" +
				"<option value='Finance'>财政部</option>" +
				"<option value='Human Resources'>人力资源部</option>" +
				"<option value='Production'>产品部</option>" +
				"<option value='Development'>开发部</option>" +
				"<option value='Quality Management'>质量管理部</option>" +
				"<option value='Sales'>销售部</option>" +
				"<option value='Research'>调研部</option>" +
				"<option value='Customer Service'>客户服务部</option>" +
				"</select><br>" +
				"职　　称：" +
				"<select class='box' name='employee.title' id='title'>" +
				"<option value='Senior Engineer'>高级工程师</option>" +
				"<option value='Staff'>普通员工</option>" +
				"<option value='Engineer'>工程师</option>" +
				"<option value='Senior Staff'>高级员工</option>" +
				"<option value='Assistant Engineer'>助理工程师</option>" +
				"<option value='Technique Leader'>技术主管</option>" +
				"<option value='Manager'>部门经理</option>"+
				"</select><br>" +
				"</div>" +
				"<div style='margin: 30px 0 10px 50px;'>" +
				"<button type='button' id='saveBtn'>保存</button>" +
				"<button type='reset' id='resetBtn'>重置</button>" +
				"<button type='button' id='cancerBtn'>取消</button>" +
				"</div>" +
				"</form>"+
				"</th>";
		
		$this.parent().parent().next().html(html);
	})
	
	
});
