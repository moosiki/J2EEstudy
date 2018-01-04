$(function(){

	$.fn.extend({
	    animateCss: function (animationName, callback) {
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

	//设置菜单页节点
	var $menuPage = $("#menuPage");

	//设置信息页节点
	var $msgP = $("#messagePage");

	//查询按钮点击事件
	$menuPage.find("#searchMenu").on("click",function(){
		$this = $(this);
		$this.addClass("menuDivBeChoised").siblings().removeClass("menuDivBeChoised");
		//为信息页面添加动画
		$msgP.animateCss('zoomInDowm');
		//局部加载信息页面
		$msgP.find("#form").load(
			'/ManagerSSH/studentAction!list');
	});
	
	//添加按钮点击事件
	$menuPage.find("#addMenu").on("click",function(){
		$this = $(this);
		$this.addClass("menuDivBeChoised").siblings().removeClass("menuDivBeChoised");

		//局部加载添加页面
		$msgP.find("#form").load(
			'/ManagerSSH/studentAction!to_save');
	});
	/*
		var ctx = $("#myChart");
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		        datasets: [{
		            label: '# of Votes',
		            data: [12, 19, 3, 5, 2, 3],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)',
		                'rgba(153, 102, 255, 0.2)',
		                'rgba(255, 159, 64, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }*/
	/*
	//搜索框内容变化时进行搜索
	$("input[name=keyword]").on("input", function() {

        var keyword = $("input[name=keyword]").val();
            //Ajax Load请求
        	$msgP.find("#form").load(
                //请求路径
                '/ManageSystem/search', {
                    keyword: "'%" + keyword + "%';",
                },
                // 成功的回调函数
                function(data) {
                    console.log(data.result);

                });
	});
	
	 //按关键字搜索并局部加载
    $msgP.find("#searchBtn").on("click", function() {
        var keyword = $("input[name=keyword]").val();

        if (keyword != '') {
            //Ajax Load请求
        	$msgP.find("#form").load(
                //请求路径
                '/ManageSystem/search', {
                    keyword: "'%" + keyword + "%';",
                },
                // 成功的回调函数
                function(data) {
                    console.log(data.result);
                }
            );
        }else
        alert("请输入关键字");
	*/
});