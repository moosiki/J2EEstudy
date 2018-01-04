package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.model.Departments;
import com.model.Employees;
import com.model.Role;
import com.model.Salaries;
import com.service.DepartmentsService;
import com.service.EmployeesService;
import com.service.Service;
import com.service.impl.EmployeesServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext aContext = new ClassPathXmlApplicationContext(new String[]{"classpath:AppliactionContext-service.xml","classpath:AppliactionContext-dao.xml"});
		/*EmployeesService service = (EmployeesService) aContext.getBean("employeesServiceImpl");*/
		EmployeesService service = (EmployeesService) aContext.getBean("employeesServiceImpl");
	/*	List<Departments> list = service.query(new Departments(), Departments.class);
		for (Departments departments : list) {
			System.out.println(departments);
		}*/
		
	/*	List list = new ArrayList<>();
		
		list = service.criteriaPage(1, 10);
		
		for (Object object : list) {
			
			System.out.println(object.toString());
		}*/
			
		
		/*EmployeesService eService = (EmployeesService)aContext.getBean("employeesServiceImpl");
		List<Employees> employee = (List<Employees>) eService.queryObjectById(10003, Employees.class);
		for (Employees employees : employee) {
			System.out.println(employees.getFirstName());
		}*/
		
		//综合查询测试方法
		/*String[] values = {"%%","%%","%F%","%%"};
		List<Employees> list = new ArrayList<>();
		list = service.ParamPage(values, 1, 5);
		
		for (Object emp : list) {
			System.out.println(emp.toString());
		}*/
		
	/*	Employees emp = service.queryObjectById(100003, Employees.class);*/
		
		
/*		System.out.println(emp.toString());*/
		System.out.println(service.queryAmount(Employees.class));
		
		
		((ClassPathXmlApplicationContext)aContext).close();
	}

}
