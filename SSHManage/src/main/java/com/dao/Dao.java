package com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 通用接口 数据访问层
 * @author Mryang
 *
 * @param <T>
 */
public interface Dao<T> {
	
	/**
	 * 通用查询方法，查询某类全部信息
	 * @param t
	 * @param className
	 * @return
	 */
	List<T> query(T t,Class className);
	
	/**
	 * 分页查询
	 * @param startPage 起始页
	 * @param pageSize  每页显示数量
	 * @param className 
	 * @return
	 */
	List<T> queryWithPage(Integer startPage,Integer pageSize,Class className);
	
	/**
	 * 条件分页查询
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	List<T> criteriaPage(Integer startPage, Integer pageSize);
	
	/**
	 * 自定义条件分页查询
	 * @param queryString
	 * @param paramNames
	 * @param values
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	List<T> ParamPage(Object[] values,
			Integer startPage, Integer pageSize);
	
	/**
	 * 通用查询方法 查询某个对象
	 * @param id
	 * @param className
	 * @return
	 */
	T queryObjectById(Serializable id,Class className);
	
	/**
	 * 查询总数
	 * @param className
	 * @return
	 */
	Long queryAmount(Class className);
	
	/**
	 * 通用保存对象方法
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 通用删除对象方法
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 通用修改对象方法
	 * @param t
	 */
	void edit(T t);

	
}
