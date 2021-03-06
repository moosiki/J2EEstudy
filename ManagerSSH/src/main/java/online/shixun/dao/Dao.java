package online.shixun.dao;

import java.util.List;

/**
 * 通用数据访问层工具
 * @author Mryang
 * @Param<T>
 *
 */
public interface Dao<T> {
	
	/**
	 * 通用方法，查询列表
	 * @param t 查询条件对象
	 * @param classname  查询的目标类型
	 * @return 集合
	 */
	List<T> query(T t,Class className);
	
	/**
	 * 通用方法 查询对象
	 * @param id 对象id
	 * @param className 查询目标类型
	 * @return 对象
	 */
	T queryObjectById(java.io.Serializable id,Class className);
	
	/**
	 * 通用方法 保存
	 * @param 保存的对象
	 */
	void save(T t);
	
	/**
	 * 通用方法 删除
	 * @param t 删除的对象
	 */
	void delete(T t);
	
	/**
	 * 通用方法 修改
	 * @param t 修改的对象
	 */
	void edit(T t);
	
	
	
}
