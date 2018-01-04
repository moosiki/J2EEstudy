package online.shixun.service.impl;

import java.io.Serializable;
import java.util.List;
import online.shixun.dao.Dao;
import online.shixun.service.Server;

public abstract class ServerImpl<T> implements Server<T> {
	
	protected Dao dao;
	
	/**
	 * 子类控制注入哪一个
	 * @param dao
	 */
	public abstract void setDao(Dao dao);
	
	@Override
	public List<T> query(T t, Class className) {
		return dao.query(t, className);
	}

	@Override
	public T queryObjectById(Serializable id, Class className) {
		return (T) dao.queryObjectById(id, className);
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
