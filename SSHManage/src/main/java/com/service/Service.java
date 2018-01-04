package com.service;

import java.util.List;



/**
 * 通用业务逻辑类
 * @author Mryang
 *
 * @param <T>
 */
public interface Service<T> {
	/**
	 * 通用方法，查询列表
	 * @param t 查询对象
	 * @param className 查询目标类型
	 * @return 集合
	 */
	List<T> query(T t,Class className);
	
	/**
	 * 查询总数
	 * @param className
	 * @return
	 */
	Long queryAmount(Class className);
	
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
	 * @param values
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	List<T> ParamPage(Object[] values,
			Integer startPage, Integer pageSize);
	
	/**
	 * 通用方法 通过id查询
	 * @param id 对象编号
	 * @param className 对象类型
	 * @return 对象
	 */
	T queryObjectById(java.io.Serializable id,Class className);
	
	/**
	 * 通用方法 保存
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 通用方法 删除
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 通用方法 修改
	 * @param t
	 */
	void edit(T t);
}
