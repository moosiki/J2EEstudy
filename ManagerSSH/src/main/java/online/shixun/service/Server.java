package online.shixun.service;

import java.util.List;

/**
 * 通用业务逻辑工具
 * @author Mryang
 *
 * @param <T>
 */
public interface Server<T> {
	/**
	 * 通用方法，查询列表
	 * @param t 查询对象
	 * @param className 查询目标类型
	 * @return 集合
	 */
	List<T> query(T t,Class className);
	
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
