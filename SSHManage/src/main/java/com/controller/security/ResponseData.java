package com.controller.security;

import java.io.Serializable;

public class ResponseData implements Serializable{
	
	//操作成功
	public static final String SUCCESS_CODE = "0";
	//操作失败
	public static final String ERROR_CODE = "-1";
	//状态码，默认成功
	private String status = SUCCESS_CODE;
	
	//返回数据
	private Object data;
	
	public boolean isSuccess() {
		return this.status.equalsIgnoreCase(SUCCESS_CODE) ? true : false;
	}

	public String getStatu() {
		return status;
	}

	public void setStatu(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setError(Object data) {
		this.status = ERROR_CODE;
		this.data = data;
	}
	
	public void setError(Object data,String status) {
		this.status = status;
		this.data = data;
		
	}
	
	
	
}
