package online.shixun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import online.shixun.dao.Dao;
import online.shixun.model.Student;
import online.shixun.service.StudentServer;

@Service("studentServerImpl")
public class StudentServerImpl extends ServerImpl<Student> implements StudentServer{
	
	@Autowired
	@Qualifier("studentDaoImpl")
	@Override
	public void setDao(Dao dao) {
		super.dao=dao;
	}

}
