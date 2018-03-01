package com.service;

import java.util.Set;

import com.controller.security.ResponseData;
import com.model.Departments;
import com.model.Employees;
import com.model.Role;

public interface EmployeesService extends Service<Employees>{
	
	/**
	 * ��½���񷽷������ݵ�¼����ѯ
	 * @param loginName  Ա�����
	 * @return
	 */
	public Employees getEmployee(Integer loginName);
	
	/**
	 * ע����񷽷������ע����Ϣ��ȷ��
	 * @param emp
	 * @return
	 */
	public  ResponseData register(Employees emp);
	
	/**
	 * ��ȡ�û�Ȩ��
	 * @param empNo
	 * @return
	 */
	Set<Role> queryRoles(int empNo);
}
