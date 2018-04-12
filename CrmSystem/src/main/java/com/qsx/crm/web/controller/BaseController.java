package com.qsx.crm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.util.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	//注入request
	@Autowired
	protected HttpServletRequest request;
	
	/**
	 * 返回项目位置目录
	 * @return
	 */
	protected String getRealPath() {
		return request.getServletContext().getRealPath("/");
		
	}
	
	/**
	 * 返回项目上下文路径
	 * @return
	 */
	protected String getContextPath(){
		return request.getServletContext().getContextPath();
	}
/*	
	protected String getImageUploadPath() {
		return getRealPath() + ImageUtils.DEFAULT_IMAGE_PATH;
	}*/
}
