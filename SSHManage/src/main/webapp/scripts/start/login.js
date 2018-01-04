$(function(){
	$("#loginBtn").on('click',function(){
		console.log("登陆");
		var userName = $("#loginForm").find("input[name='loginName']").prop("value");
		var password = $("#loginForm").find("input[name='password']").prop("value");
		console.log(userName);
		console.log(password);
		
		var ajaxVal ={
			async:false,
			
         	type:"post",
         	url:'/SSHManage/startController/loginVerify',
         	data:{
         		userName:userName,
         		password:password
         	},
         	success:function(data){
         		console.log(data);
         		if(data['result']==="success"){
         			Storage["userName"] = 
         			window.location.href='/SSHManage/startController/homePage';
         		}
         			
         		else{
         			console.log(data['result']);
         			$("#inputName").text(data['nullname']+data['noneUser']);
         			$("#inputPass").text(data['nullPassword']+data['wrongPassword']);
         		}
         	}
         };
		if(userName.length<11)
			$.ajax(ajaxVal);
		else
			toastr.warning('用户名长度小于 11 位 ！');
		
		
	})
})