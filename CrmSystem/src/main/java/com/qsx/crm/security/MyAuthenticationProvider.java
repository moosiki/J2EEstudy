package com.qsx.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.qsx.crm.model.UserModel;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private SimpleUserDetailsService userdetailsService;
	
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName(); //从表单获取的用户名
		String password = (String) authentication.getCredentials(); //从表单获取的密码
		
		UserModel userModel = (UserModel) userdetailsService.loadUserByUsername(userName);
		System.out.println("用户验证:/n输入用户名:"+userName+"输入密码:"+password+"查询到的用户"+userModel.getName());
		if (userModel == null) {
			throw new BadCredentialsException("errors.user.not.exist");
		}
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		/*String encoderPsw = (new ShaPasswordEncoder()).encodePassword(password, userName);*/
		String encoderPsw = encoder.encodePassword(password, userName);
		
		if (!userModel.getPassword().equals(encoderPsw)) {
			throw new BadCredentialsException("errors.BadCredentials");
		}
		
		return new UsernamePasswordAuthenticationToken(userModel, password,userModel.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
