package com.qsx.crm.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.qsx.crm.model.Constants;
import com.qsx.crm.model.RoleModel;
import com.qsx.crm.model.UserModel;
import com.qsx.crm.model.UserStatus;
import com.qsx.crm.module.user.service.UserService;

@Transactional
@Component
public class SimpleUserDetailsService implements UserDetailsService{
	
	private static Log log = LogFactory.getLog(SimpleUserDetailsService.class);
	
	//注入用户service
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("loadUserByUsername --> LoginName:" +username);
		
		//用户名转换成小写比较
		String loginName = username.toLowerCase().trim();
		
		UserModel userModel = userService.findByloginName(loginName);
		
		System.out.println("查询到的用户:"+userModel.toStringSimple());
		
		log.debug("查询到的用户debug输出:"+userModel.toStringSimple());
		
		//用户不存在
		if (userModel == null) {
			
			System.out.println("用户不存在");
			
			throw new BadCredentialsException("errors.user.not.exist");
		}
		
		//用户被禁用
		if (userModel.isDisabled()) {
			
			System.out.println("用户被禁用");
			
			log.warn("User status id disabled -->" +loginName);
			throw new BadCredentialsException("erros.user.id.disabled");
		}
		
		// 用户没有任何授权，不允许使用系统
		if (userModel.getRoles() == null) {
			
			System.out.println("用户没有授权");
			
			log.warn("User has not any role -->" + loginName);
			throw new BadCredentialsException("erros.user.hasnot.anyrole");
		}
		
		log.debug("用户可用");
		
		System.out.println("用户可用");
		
		//用户拥有的角色信息
		Set<RoleModel> userRoles = userModel.getRoles();
		
		for (RoleModel roleModel : userRoles) {
			System.out.println("用户角色:"+roleModel.getName());
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (RoleModel role : userRoles) {
            	System.out.println("用户拥有的角色:"+role.getName().trim());
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().trim()));
            }
        }

        // 所有用户共有的角色
        grantedAuthorities.add(new SimpleGrantedAuthority(Constants.ROLE_EVERY_ONE));

        userModel.setGrantedAuthority(grantedAuthorities.toArray(new GrantedAuthority[grantedAuthorities.size()]));
        return userModel; 
	}
	
}
