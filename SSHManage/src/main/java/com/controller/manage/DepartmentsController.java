package com.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Departments;
import com.model.Employees;
import com.service.DepartmentsService;
import com.service.Service;
import com.service.impl.DepartmentServiceImpl;

@Controller
@RequestMapping("deptControl")
public class DepartmentsController extends BaseController<Departments>{
	
	@Autowired
	@Qualifier("departmentServiceImpl")
	@Override
	public void setService(Service<Departments> service) {
		super.service = service;
		
	}
	@Autowired
	private DepartmentsService deptService;
	
	@PostMapping("queryMessage")
	@ResponseBody
	public List<Departments> queryMessage(Integer startPage,Integer pageSize) {
		List<Departments> list= deptService.queryWithPage(startPage, pageSize, Departments.class);
		for (Departments departments : list) {
			System.out.println(departments);
		}
		return list;
	}

	


}
