package com.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Employees;
import com.service.Service;
import com.service.impl.EmployeesServiceImpl;


public abstract class BaseController<T> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected HttpServletRequest request;
	
	//获取当前登录用户
	protected Employees getCurrentEmp() {
		return EmployeesServiceImpl.getCurrentEmp();
	}
	
	
	/**
	 * 服务模块
	 */
	protected Service<T> service;
	
	/**
	 * 子类决定注入哪个service
	 */
	public abstract void setService(Service<T> service);

	
	
}
