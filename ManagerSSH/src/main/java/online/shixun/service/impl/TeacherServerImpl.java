package online.shixun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import online.shixun.dao.Dao;
import online.shixun.model.Teather;
import online.shixun.service.TeacherServer;

@Service("teacherServerImpl")
public class TeacherServerImpl extends ServerImpl<Teather> implements TeacherServer{
	
	@Autowired
	@Qualifier("teacherDaoImpl")
	@Override
	public void setDao(Dao dao) {
		super.dao = dao;
		
	}
	
	
}
