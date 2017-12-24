$(function() {
    $.fn.extend({
        animateCss: function(animationName, callback) {
            var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            this.addClass('animated ' + animationName).one(animationEnd, function() {
                $(this).removeClass('animated ' + animationName);
                if (callback) {
                    callback();
                }
            });
            return this;
        }
    });

    var $list = $("#list");
    //查看订单
    $("#orderBtn").on("click",function(){
 		$("#list").load("/HibernateMap/checkOrder",{
 			user_id:$("#user_id").text()
 		});
    });
    
    //删除订单
    $(".deleteBtn").on("click",function(){
    	var $this = $(this);
    	 if (confirm("确定删除订单吗？") == true) {
    		 $.ajax({
     			cache:true,
     			type:"post",
     			url:'/HibernateMap/deleteOrder',
     			traditional:true,
     			data:{"code":$this.val()},
     			async:true,
     			success:function(){
     				$("#list").load("/HibernateMap/checkOrder",{
     		 			user_id:$("#user_id").text()
     		 		});
     			}
            });
    	 }
    });
    //全选按钮
    $list.find("#selectAllBtn").on("click", function() {

        $list.find("input").prop("checked", "checked");
    });

    //反选按钮
    $list.find("#deselectBtn").on("click", function() {

        $list.find("input").each(function(index, item) {
            $(item).prop("checked", !$(item).prop("checked"));
        });

    });
  //加入购物车
    $list.find("#deleteBtn").on("click", function() {
    	var goodId = new Array();
    	var id = 0;
        if (confirm("确定加入购物车吗？") == true) {

            $list.find("tr").each(function(index, item) {
            	
                if ($(this).find("input").prop('checked')) {
                    goodId[id] = $(this).find(".goodsId").text();
                    id++;
                }
            });
            //异步请求
            $.ajax({
    			cache:true,
    			type:"post",
    			url:'/HibernateMap/creatOrder',
    			traditional:true,
    			data:{"goodId":goodId,
    				  "user_id":$("#user_id").text()},
    			async:true,
    			success:function(){
    				console.log("添加成功");
    				/*$("#Order").load(
    					'/HibernateMap/pages/Order.jsp')*//*,{
    					emp_no:$("#emp_no").attr("value")},
    					function(data){
    						console.log(data.result);
    					});*/
    			}
            });
            alert("已购买");
        }
        
    });

    $list.find(".buyBtn").on("click", function() {

        $this = $(this);
        var goodId = new Array();
        goodId[0] = $this.prop("value");
        if(confirm("您确定购买吗？")){
        	$.ajax({
    			cache:true,
    			type:"post",
    			url:'/HibernateMap/creatOrder',
    			traditional:true,
    			data:{"goodId":goodId,
    				  "user_id":$("#user_id").text()},
    			async:true,
    			success:function(){
    				console.log("添加成功");
    				/*$("#Order").load(
    					'/HibernateMap/pages/Order.jsp')*//*,{
    					emp_no:$("#emp_no").attr("value")},
    					function(data){
    						console.log(data.result);
    					});*/
    			}
            });
        	alert("已购买");
        }else
        	alert("取消");

    });

});