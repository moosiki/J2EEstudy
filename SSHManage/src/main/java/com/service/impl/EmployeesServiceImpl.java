package com.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.controller.security.ResponseData;
import com.dao.Dao;
import com.dao.EmployeesDao;
import com.model.Employees;
import com.model.Role;
import com.service.EmployeesService;

@Service
public class EmployeesServiceImpl extends ServiceImpl<Employees> implements EmployeesService{
	
	@Autowired
	private EmployeesDao empDao;	
	
	@Autowired
	@Qualifier("employeesDaoImpl")
	@Override
	public void setDao(Dao dao) {
		super.dao=dao;
	}
	
	@Override
	public Employees getEmployee(Integer loginName) {
		
		return	(Employees) super.dao.queryObjectById(loginName, Employees.class);
		
	}

	@Override
	public ResponseData register(Employees emp) {
		ResponseData rspData = new ResponseData();
		
		if (getEmployee(emp.getEmpNo()) != null) {
			rspData.setError("员工编号:"+emp.getEmpNo()+"已存在!请更换其它编号!");
		}else {
			
			/**
			 * 对密码进行加密 
			 */
			
			/**
			 * 设置权限
			 */
			
			//保存用户
			super.dao.save(emp);
			
			rspData.setData(emp);
		}
		
		return rspData;
		
	}
	
	public static Employees getCurrentEmp() {
		return (Employees) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public Set<Role> queryRoles(int empNo) {
		
		return empDao.queryRoles(empNo);
	}
	
	
}
