package com.controller.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.security.ResponseData;
import com.model.Departments;
import com.model.DeptEmp;
import com.model.DeptManager;
import com.model.Employees;
import com.model.Role;
import com.model.Salaries;
import com.model.Titles;
import com.service.EmployeesService;
import com.service.Service;


@Controller
@RequestMapping("empControl")
public class EmployeesController extends BaseController<Employees> {

	private static Map<String, String> loginExceptionMap = new HashMap<>();

	static {
		loginExceptionMap.put("403", "errors.login.failed.authorization");
		loginExceptionMap.put("Bad credentials", "errors.login.password.mismatch");
		loginExceptionMap.put("LoginSystemException", "errors.login.system.exception");
		loginExceptionMap.put("AccountNotExist", "errors.login.account.not.exist");
		loginExceptionMap.put("AccountIsDisabled", "errors.login.account.is.disabled");
		loginExceptionMap.put("AccountHasNotAnyAuthorization", "errors.login.hasnot.authorization");
	}
	
	//注入服务
	@Autowired
	@Qualifier("employeesServiceImpl")
	@Override
	public void setService(Service<Employees> service) {
		super.service = service;

	}
	
	@Autowired
	private EmployeesService empService;
	
	/**
	 * 用户登陆处理
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(ModelMap model) {
		
		System.out.println("用户登陆中");
		String error = request.getParameter("error");
		System.out.println(error);
		boolean hasLoginError = false;
		String loginErrorMessage = "LoginSystemException";
		if (!StringUtils.isEmpty(error)) {
			System.out.println(error);
			hasLoginError = true;
			loginErrorMessage = loginExceptionMap.get(error);
		}else {
			 Object exceptionObj = request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			 if (exceptionObj != null) {
	                hasLoginError = true;
	                Exception exception = (Exception) exceptionObj;
	                loginErrorMessage = loginExceptionMap.get(exception.getMessage());
	         }
		}
		
		//登陆出现异常
		if (hasLoginError && StringUtils.isEmpty(loginErrorMessage)) {
            loginErrorMessage = "LoginSystemException";
        }
		
		model.addAttribute("hasLoginError", hasLoginError);
        model.addAttribute("loginErrorMessage", loginErrorMessage);
        return "/start/loginPage";
	}
	
	//进入注册界面
	@RequestMapping("/register")
	public String register(ModelMap model) {
		System.out.println("进入注册界面");
		return "/start/registPage";
	}
	
	//处理用户注册请求
	@RequestMapping(value = "/register/do",method = RequestMethod.POST)
	public String doRegister(Model model,Employees employee) {
		//保存用户信息
		ResponseData responseData = empService.register(employee);
		
		model.addAttribute(responseData);
		
		//注册成功，返回登录页面
		if (responseData.isSuccess()) {
			return "/start/loginPage";
			
		//注册失败，返回注册界面
		}else {
			return "/start/registPage";
		}
	}
	
	//查询员工数量
	@GetMapping("queryAmount")
	@ResponseBody
	public Long queryAmount(Model model) {

		Long dataSize = service.queryAmount(Employees.class);

		System.out.println(dataSize);

		return dataSize;
	}
	
	/**
	 * 分页查询数据
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="queryMessage",method=RequestMethod.POST)
	@ResponseBody
	public List queryMessage(Integer startPage,Integer pageSize) {
		
		//分页查询员工对象，包含安全认证信息
		/*List<Employees> list= empService.queryWithPage(startPage, pageSize, Employees.class);*/
		
		//分页查询员工数据集合，只包含员工基本属性
		List<Employees> list= empService.criteriaPage(startPage, pageSize);
	
		/*for (Employees employees : list) {
			System.out.println(employees);
		}*/
		return list;
	}
	
	/**
	 * 自定义条件分页查询数据
	 * @param values
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="paramPage",method=RequestMethod.POST)
	@ResponseBody
	public List ParamPage(String searchName,String deptName,String title,String gender,
						Integer startPage, Integer pageSize){
		
		System.out.println(searchName+deptName+title+gender+startPage+"---"+pageSize);
		
		Object[] values = {deptName,title,gender,searchName};
		
		List<Employees> list = empService.ParamPage(values, startPage, pageSize);
		
		return list;
	}
	
	/**
	 * 删除一个用户
	 * @param empNo
	 */
	@RequestMapping(value="deleteEmp",method=RequestMethod.POST)
	@ResponseBody
	public String deleteEmp(int empNo) {
		Employees emp = empService.queryObjectById(empNo, Employees.class);
		empService.delete(emp);
		return "message/employeeMessage";		
	}
	
	@RequestMapping(value="queryEmp",method=RequestMethod.POST)
	@ResponseBody
	public Map<Integer,Object> queryEmp( int empNo) {
		Employees emp = empService.queryObjectById(empNo, Employees.class);
		
		Map<Integer,Object> result = new HashMap<>();
		Set<Titles> titles = emp.getTitleses();
		Set<DeptEmp> deptEmps = emp.getDeptEmps();
		Set<DeptManager> deptManagers = emp.getDeptManagers();
		Set<Role> roles = empService.queryRoles(empNo);
		result.put(1,deptEmps);
		result.put(2,deptManagers);
		result.put(3,titles);
		result.put(4,roles);
		
		return result;
	}
}
