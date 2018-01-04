package online.shixun.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import online.shixun.dao.StudentDao;
import online.shixun.model.Student;
import online.shixun.service.StudentServer;
import online.shixun.service.impl.StudentServerImpl;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(value = {"classpath:appliactionContext-dao.xml", "classpath:appliactionContext-service.xml"})*/
public class SSHTest {
	/*
	@Autowired 
	private static StudentServerImpl ssi;*/
	
	public static void main(String[] args) {
		ApplicationContext apContext = new ClassPathXmlApplicationContext(new String[]{"classpath:appliactionContext-dao.xml", "classpath:appliactionContext-service.xml"});
		StudentServer ssi =  (StudentServer) apContext.getBean("studentServerImpl");
		/*
		Student stu = ssi.queryObjectById(1, Student.class);
		System.out.println(stu.toString());*/
		ssi.delete(new Student(1));
		((ClassPathXmlApplicationContext)apContext).close();
		
	}
	
	
}
