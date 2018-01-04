package com.controller.skip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.manage.BaseController;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.model.Employees;
import com.service.Service;


@Controller
@RequestMapping("startController")
public class StartController extends BaseController<Employees>{
	
	@Autowired
	@Qualifier("employeesServiceImpl")
	@Override
	public void setService(Service<Employees> service) {
		super.service = service;
		
	}
	
	@RequestMapping("loginPage")
	public String loginPage() {
		
		System.out.println("登陆");
		return "start/loginPage";
		
	}
	
	@RequestMapping("registPage")
	public String registPage() {
		
		System.out.println("注册");
		return "start/registPage";
		
	}
	
	@RequestMapping("homePage")
	public String homePage() {
		
		System.out.println("主页");
		return "homePage/homePage";
		
	}
	
	@PostMapping("loginVerify")
	@ResponseBody
	public Map loginVerify(@RequestParam Integer loginName,String password) {
		
		Map<String, String> result = new HashMap<>();
		
		result.put("result", "false");
		result.put("noneUser", "");
		result.put("wrongPassword", "");
		String nullName = StringUtils.isEmpty(loginName)?"用户名不能为空!":"";
		result.put("nullname", nullName);
		String nullPass = StringUtils.isEmpty(password)?"密码不能为空!":"";
		result.put("nullPassword", nullPass);
		
		if (!(StringUtils.isEmpty(loginName)||StringUtils.isEmpty(password))) {
			Employees employee = service.queryObjectById(loginName, Employees.class);
			
			String noneUser = (employee==null)?"无此用户!":"";
			result.put("noneUser", noneUser);
			
			
			if (employee!=null) {
				String birthDate = employee.getBirthDate().toString().replaceAll("-","");

				if (birthDate.equals(password)) {
					
					result.put("wrongPassword", "");
					
					result.replace("result", "success");
				}else {

					result.put("wrongPassword", "密码错误!");
				}
			}
		}
		return result;
		
	}
	
	@RequestMapping("employeeMessage")
	public String EmployeeMessage() {
		
		System.out.println("信息");
		return "message/employeeMessage";
		
	}
}
