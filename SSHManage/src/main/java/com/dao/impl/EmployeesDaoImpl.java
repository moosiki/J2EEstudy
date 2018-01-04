package com.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dao.EmployeesDao;
import com.model.Employees;
import com.model.Role;


@Repository("employeesDaoImpl")
public class EmployeesDaoImpl extends DaoImpl<Employees> implements EmployeesDao{
	
	
	/**
	 * 获取用户权限
	 * @param empNo
	 * @return
	 */
	@Override
	public Set<Role> queryRoles(int empNo) {
		
		String sql = "select * from role r where r.roleId in (select roleId from employee_role e where e.emp_no = "+empNo+")";
	
		Session session = super.baseDao.getSessionFactory().getCurrentSession();
		
		Query query = session.createSQLQuery(sql);
		
		
		return (new HashSet<Role>(query.list()));
	}
	
	
}
