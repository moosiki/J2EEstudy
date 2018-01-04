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
            	url:'/SSHManage/empControl/queryAmount',
         /*   	url:'/SSHManage/empControl/queryAmount',*/
            	success:function(data){
            		
            		dataSize = data;
            		for(var i = 1; i < dataSize; i++){
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
          		var dataHtml = "<table class='zebra'>"+
          							"<thead>"+
					        			"<tr>";
				dataHtml += '<th>员工编号</th>';
				dataHtml += '<th>员工名字</th>';
				dataHtml += '<th>员工姓氏</th>';
				dataHtml += '<th>员工性别</th>';
				dataHtml += '<th>员工状态</th>';
				dataHtml += '<th>员工生日</th>';
				dataHtml += "</tr>"+
					        "</thead>"+	
					        "<tbody id='info'>";
                
                $.ajax({
                 	type:"post",
                 	async:false,
                 	url:'/SSHManage/empControl/queryMessage',
                 	/*url:'/SSHManage/empControl/queryMessage',*/
                 	data:{"startPage":pagination.pageNumber,"pageSize":pagination.pageSize},
                 	success:function(data){
                 		dataSize=data.length;
                 		$.each(response, function(index, item){
                 			dataHtml += '<tr>';
                 			for(val in data[index]) {
                 				
                 				dataHtml += '<th>'+data[index][val]+'</th>';
                 			}
                 			dataHtml += '<tr>';
	                    });

                 	}
                });
                dataHtml += "</tbody>"+
                			"</table>";
				
                container.prev().html(dataHtml);
            }
        };
        container.pagination(options);

        return container;
    }
})