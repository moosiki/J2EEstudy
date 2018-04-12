package com.qsx.crm.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 用户登录密码混淆类
 * @author Mryang
 *
 */
public class UserPasswordSaltSource implements SaltSource{
	public Object getSalt(UserDetails user) {
		return user.getUsername();
	}
	

}
