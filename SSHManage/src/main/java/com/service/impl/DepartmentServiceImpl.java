package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.Dao;
import com.model.Departments;
import com.service.DepartmentsService;

@Service
public class DepartmentServiceImpl extends ServiceImpl<Departments> implements DepartmentsService{
	
	@Autowired
	@Qualifier("departmentsDaoImpl")
	@Override
	public void setDao(Dao dao) {
		super.dao = dao;
		
	}
	
}
