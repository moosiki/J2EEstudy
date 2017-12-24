function button() {
	var button1 = document.getElementById('registerButton');
	button1.style.backgroundColor = "blue";
}
function user(){
	var checkName = new RegExp("[^(A-z|0-9|'_')]");
	var username = document.getElementById('username').value;
	if (checkName.test(username)) {
		document.getElementById('username').style.border ="1px groove red";
		document.getElementById('tip1').innerHTML = "";
		document.getElementById('tip5').innerHTML = "格式错误！包含非法字符！";
		// alert("错误");
	}else{
		document.getElementById('username').style.border ="2px groove green";
		document.getElementById('tip5').innerHTML = "";
		document.getElementById('tip1').innerHTML = "输入正确！";
		// alert（"正确"）;
	}
}
function pass(){
	var checkPass = new RegExp("[^(0-9)]");
	var userPass = document.getElementById('password').value;
	if (checkPass.test(userPass)) {
		document.getElementById('password').style.border ="2px groove green";
		document.getElementById('tip2').innerHTML = "输入正确！";
		document.getElementById('tip6').innerHTML = "";
		// alert("错误");
	}else{
		document.getElementById('password').style.border ="1px groove red";
		document.getElementById('tip2').innerHTML = "";
		document.getElementById('tip6').innerHTML = "格式错误！至少包含一个字母";
		// alert（"正确"）;
	}
}
function repitPass(){
	var userPass2 = document.getElementById('password2').value;
	var userPass = document.getElementById('password').value;
	if (userPass == userPass2) {
		document.getElementById('password2').style.border ="2px groove green";
		document.getElementById('tip3').innerHTML = "输入正确！";
		document.getElementById('tip7').innerHTML = "";
		// alert("错误");
	}else{
		document.getElementById('password2').style.border ="1px groove red";
		document.getElementById('tip3').innerHTML = "";
		document.getElementById('tip7').innerHTML = "输入错误！两次密码不同！";
		// alert（"正确"）;
	}
}
function ema(){
	var checkEmail = new RegExp("[@]");
	var email = document.getElementById('email').value;
	if (checkEmail.test(email)) {
		document.getElementById('email').style.border ="2px groove green";
		document.getElementById('tip4').innerHTML = "输入正确！";
		document.getElementById('tip8').innerHTML = "";
		// alert("错误");
	}else{
		document.getElementById('email').style.border ="1px groove red";
		document.getElementById('tip4').innerHTML = "";
		document.getElementById('tip8').innerHTML = "请输入正确的邮箱地址！";
		// alert（"正确"）;
	}
}
function register(){
	var username = document.getElementById('username').value;
	alert("注册成功！\n"+"用户名："+userna);
}