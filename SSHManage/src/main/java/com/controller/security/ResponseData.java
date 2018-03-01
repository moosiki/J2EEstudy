package com.controller.security;

import java.io.Serializable;

public class ResponseData implements Serializable{
	
	//�����ɹ�
	public static final String SUCCESS_CODE = "0";
	//����ʧ��
	public static final String ERROR_CODE = "-1";
	//״̬�룬Ĭ�ϳɹ�
	private String status = SUCCESS_CODE;
	
	//��������
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
