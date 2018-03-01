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
 * spring ��ȫ��֤��
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

		System.out.println("ͨ����¼�������û� --> ��¼��:" + loginName);
		
		log.debug("ͨ����¼�������û� --> ��¼��:" + loginName);
		
		Integer empId = Integer.valueOf(loginName);
		Employees emp = empService.getEmployee(empId);
		
		//δ�ҵ��û�
		if (emp == null) {
			throw new BadCredentialsException("AccountNotExist");
		}
		
		//�û�������
		if (emp.isDisabled()) {
			log.warn("User status is disabled --> " + loginName);
			throw new BadCredentialsException("AccountIsDisabled");
		}
		
		//�û�û���κ���Ȩ��������ʹ��ϵͳ
		if (emp.getRoles().size() == 0) {
			log.warn("User has not any role --> " + loginName);
			throw new BadCredentialsException("AccountHasNotAnyAuthorization");
		}
		
		Set<Role> empRoles = emp.getRoles();
		
		//��ȡ�û���Ȩ��Ϣ
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (empRoles != null) {
			for (Role empRole : empRoles) {
				log.debug("User has role --> " + empRole.getName());
				System.out.println("User has role --> " + empRole.getName());
				grantedAuthorities.add(new SimpleGrantedAuthority(empRole.getName().trim()));
			}
		}
		
		//�����û���Ȩ��Ϣ��Spring Security ��Ȩ��֤ʱʹ�ã�
		emp.setGrantedAuthority(grantedAuthorities.toArray(new GrantedAuthority[grantedAuthorities.size()]));
		
		return (UserDetails) emp;
	}		
	
}
