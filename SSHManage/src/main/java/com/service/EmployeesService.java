package com.service;

import java.util.Set;

import com.controller.security.ResponseData;
import com.model.Departments;
import com.model.Employees;
import com.model.Role;

public interface EmployeesService extends Service<Employees>{
	
	/**
	 * 登陆服务方法，根据登录名查询
	 * @param loginName  员工编号
	 * @return
	 */
	public Employees getEmployee(Integer loginName);
	
	/**
	 * 注册服务方法，检查注册信息正确性
	 * @param emp
	 * @return
	 */
	public  ResponseData register(Employees emp);
	
	/**
	 * 获取用户权限
	 * @param empNo
	 * @return
	 */
	Set<Role> queryRoles(int empNo);
}
