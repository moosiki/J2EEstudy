<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href=".././styles/default.css">
<link rel="stylesheet" type="text/css" href=".././plugs/pagination/pagination.css">
<link rel="stylesheet" type="text/css" href=".././styles/tableStyle/messageTabel.css">
<link rel="stylesheet" type="text/css" href=".././styles/message/employeeMessage.css">


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
				<option value="Manager">部门经理</option>
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
	<%-- <table class="zebra">
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
	   
	 --%>
		<article class="htmleaf-container">
				
			<div id="wrapper">
				<section>
					<div class="data-container"></div>
					<div id="pagination-demo1"></div>
					<div id="pagination-demo2"></div>
				</section>
			</div>
		</article>
</div>
	
	<script type="text/javascript" src=".././plugs/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src=".././plugs/pagination/pagination.min.js"></script>
	<script type="text/javascript" src=".././scripts/message/MessageTranslate.js"></script>
<!-- 	<script type="text/javascript" src=".././scripts/customPagination.js"></script> -->	
	<script type="text/javascript">
		$(function(){
			var name = 'demo1';
		    var sizeUrl = '/SSHManage/empControl/queryAmount';
		    var sourceUrl = '/SSHManage/empControl/queryMessage';
		    createDemo(name,sizeUrl,sourceUrl);
			function createDemo(name,sizeUrl,sourceUrl){
		        var container = $('#pagination-' + name);	
		        var dataSize;
		        var sources = function(){
		            var result = [];
		            $.ajax({
		            	type:"get",
		            	async:false,
		            	dataType:'json',
		            	contentType:'application/json',
		            	url:sizeUrl,
		         /*   	url:'/SSHManage/empControl/queryAmount',*/
		            	success:function(data){
		            		
		            		dataSize = data;
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
		             
		          		/* window.console && console.log(response, pagination); */
		          		var dataHtml = "<table class='zebra' id='table'>"+
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
		                 	data:{"startPage":pagination.pageNumber,"pageSize":pagination.pageSize},
		                 	success:function(data){
		                 		dataSize=data.length;
		                 		$.each(response, function(index, item){
		                 			dataHtml += '<tr>';
		                 			for(val in data[index]) {
		                 				
		                 				dataHtml += '<th>'+data[index][val]+'</th>';
		                 				
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
	</script>

<!--

//-->
	<script type="text/javascript" src=".././scripts/message/MessageBtn.js"></script>