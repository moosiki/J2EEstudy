package com.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.model.Employees;
import com.model.Role;
import com.service.EmployeesService;


/**
 * spring 安全认证类
 * 
 * @author Mryang
 *
 * @version 1.0
 */
public class SimpleEmpDetailsService implements UserDetailsService{
	private static Log log = LogFactory.getLog(SimpleEmpDetailsService.class);
	
	@Autowired
	private EmployeesService empService;

	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {

		System.out.println("通过登录名查找用户 --> 登录名:" + loginName);
		
		log.debug("通过登录名查找用户 --> 登录名:" + loginName);
		
		Integer empId = Integer.valueOf(loginName);
		Employees emp = empService.getEmployee(empId);
		
		//未找到用户
		if (emp == null) {
			throw new BadCredentialsException("AccountNotExist");
		}
		
		//用户被禁用
		if (emp.isDisabled()) {
			log.warn("User status is disabled --> " + loginName);
			throw new BadCredentialsException("AccountIsDisabled");
		}
		
		//用户没有任何授权，不允许使用系统
		if (emp.getRoles().size() == 0) {
			log.warn("User has not any role --> " + loginName);
			throw new BadCredentialsException("AccountHasNotAnyAuthorization");
		}
		
		Set<Role> empRoles = emp.getRoles();
		
		//获取用户授权信息
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (empRoles != null) {
			for (Role empRole : empRoles) {
				log.debug("User has role --> " + empRole.getName());
				System.out.println("User has role --> " + empRole.getName());
				grantedAuthorities.add(new SimpleGrantedAuthority(empRole.getName().trim()));
			}
		}
		
		//设置用户授权信息（Spring Security 授权认证时使用）
		emp.setGrantedAuthority(grantedAuthorities.toArray(new GrantedAuthority[grantedAuthorities.size()]));
		
		return (UserDetails) emp;
	}		
	
}
