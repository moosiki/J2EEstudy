package online.shixun.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import online.shixun.model.Student;
import online.shixun.service.Server;

@Controller("studentAction")
public class StudentAction extends BaseAction<Student>{
	
	@Autowired
	@Qualifier("studentServerImpl")
	@Override
	public void setServer(Server<Student> server) {
		super.server=server;
		
	}

	@Override
	public String list() {
		super.objects = super.server.query(super.object, Student.class);
		return "list";
	}

	@Override
	public String to_edit() {
		super.object = super.server.queryObjectById(super.id, Student.class);
		return "to_edit";
	}

	@Override
	public String do_delete() {
		super.object = new Student(super.id);
		return super.do_delete();
	}
	
	
	
}
