package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.dao.DepartmentsDao;
import com.model.Departments;

@Repository("departmentsDaoImpl")
public class DepartmentsDaoImpl extends DaoImpl<Departments> implements DepartmentsDao{

}
