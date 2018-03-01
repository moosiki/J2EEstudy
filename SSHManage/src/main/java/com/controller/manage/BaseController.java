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
	
	//��ȡ��ǰ��¼�û�
	protected Employees getCurrentEmp() {
		return EmployeesServiceImpl.getCurrentEmp();
	}
	
	
	/**
	 * ����ģ��
	 */
	protected Service<T> service;
	
	/**
	 * �������ע���ĸ�service
	 */
	public abstract void setService(Service<T> service);

	
	
}
