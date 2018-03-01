package com.dao;

import java.util.Set;

import com.model.Employees;
import com.model.Role;

public interface EmployeesDao extends Dao<Employees>{
	
	/**
	 * ��ȡ�û�Ȩ��
	 * @param empNo
	 * @return
	 */
	Set<Role> queryRoles(int empNo);
}
