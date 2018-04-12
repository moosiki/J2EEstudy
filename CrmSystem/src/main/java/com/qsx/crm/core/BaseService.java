package com.qsx.crm.core;

import org.slf4j.LoggerFactory;

import com.qsx.crm.model.UserModel;
import com.qsx.crm.security.SecurityHelper;

import org.slf4j.Logger;


/**
 * Service 基类
 * @author Mryang
 *
 */
public  abstract class BaseService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 获取当前登录用户信息
	 * @return
	 */
	protected UserModel getCurrentUser() {
		logger.debug("获取当前用户");
		System.out.println("获取当前用户");
		return SecurityHelper.getCurrentUser();
	}
}
