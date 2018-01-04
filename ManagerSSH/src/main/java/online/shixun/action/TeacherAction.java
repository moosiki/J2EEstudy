package online.shixun.action;

import org.springframework.stereotype.Controller;

import online.shixun.model.Teather;
import online.shixun.service.Server;

@Controller("teacherAction")
public class TeacherAction extends BaseAction<Teather>{

	@Override
	public void setServer(Server<Teather> server) {
		super.server=server;
		
	}

	@Override
	public String list() {
		super.objects = super.server.query(super.object, Teather.class);
		return "list";
	}

	@Override
	public String to_edit() {
		super.object = super.server.queryObjectById(object.getId(), Teather.class);
		return "to_edit";
	}
	
}
