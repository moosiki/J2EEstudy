package com.qsx.crm.usertest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qsx.crm.model.UserModel;
import com.qsx.crm.module.user.service.UserService;

@Service
public class UserTest {
	
	@Autowired
	private UserService uService;
	
	public void queryAllTest() {
		List<UserModel> list =  uService.queryAll();
		list.forEach(user -> {System.out.println(user.toStringSimple());});
	}
	
}
