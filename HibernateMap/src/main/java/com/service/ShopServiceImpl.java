package com.service;

import java.util.List;

import com.dao.Connect_DB;
import com.model.Order;

public class ShopServiceImpl {
	
	Connect_DB connect_DB = new	Connect_DB();
	
	public void save(Object object) {
		connect_DB.save(object);
	}
	public void saveOrUpdate(Object object){
		connect_DB.saveOrUpdate(object);
	}
	public void merge(Object object) {
		connect_DB.merge(object);
	}
	public Object get(Class clazz,Integer id) {
		return connect_DB.get(clazz,id);
	}
	public void delete(Object object){
		connect_DB.delete(object);
	}
	public List getAll(Object object,String fromName) {
		return connect_DB.getAll(object,fromName);
	}
	public List<Order> getOrder() {
		return connect_DB.getOrder();
	}
	public Object getByName(String fromName,String name,String searchName) {
		return connect_DB.getByName(fromName, name, searchName);
	}
	public Object getMessage(String message,String fromName,String property,String searchName) {
		return connect_DB.getMessage(message, fromName, property, searchName);
	}
	public void creatOrder(Integer user_id,Integer[] goodsId,String userName) {
		connect_DB.creatOrder(user_id, goodsId, userName);
	}
	public List<Order> orderForUser(Integer user_id) {
		return connect_DB.orderForUser(user_id);
	}
	public void deleteOrder(Integer code) {
		connect_DB.deleteOrder(code);  
	}
}
