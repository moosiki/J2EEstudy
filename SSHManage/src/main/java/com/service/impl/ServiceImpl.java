package com.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.Dao;
import com.service.Service;


public abstract class ServiceImpl<T> implements Service<T>{
	
	protected Dao dao;
	
	public abstract void setDao(Dao dao);
	
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	

	@Override
	public List<T> query(T t, Class className) {
		return dao.query(t, className);
	}

	@Override
	public T queryObjectById(Serializable id, Class className) {
		return (T) dao.queryObjectById(id, className);
	}
	
	

	@Override
	public List<T> queryWithPage(Integer startPage, Integer pageSize, Class className) {
		return dao.queryWithPage(startPage, pageSize, className);
	}

	
	
	@Override
	public List<T> criteriaPage(Integer startPage, Integer pageSize) {
		
		return dao.criteriaPage(startPage, pageSize);
	}
	
	
	
	@Override
	public List<T> ParamPage( Object[] values, Integer startPage, Integer pageSize) {
		
		return dao.ParamPage(values, startPage, pageSize);
	}

	@Override
	public Long queryAmount(Class className) {
		
		return dao.queryAmount(className);
	}

	@Override
	public void save(T t) {
		dao.save(t);
		
	}

	@Override
	public void delete(T t) {
		dao.delete(t);
		
	}

	@Override
	public void edit(T t) {
		dao.edit(t);
		
	}
	
	
	
	
}
