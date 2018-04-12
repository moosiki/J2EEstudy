package com.qsx.crm.module.user.controller;

import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qsx.crm.model.UserModel;
import com.qsx.crm.module.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "user/hello")
	public ModelAndView helloworld(ModelAndView mov) {
		UserModel userModel = userservice.findByloginName("admin");
		mov.addObject("user",userModel);
		mov.setViewName("helloword");
		return mov;
	}
	
	public ModelAndView list(ModelAndView mov) {
		return null;//TODO
	}
	
	
	@RequestMapping(value = "/list/assign")
	@ResponseBody
	public List<UserModel> getAssign() {
		List<UserModel> list = userservice.queryAll();
		for (UserModel userModel : list) {
			System.out.println("负责人:"+userModel);
		}
		return list;
	}
	
	
}
