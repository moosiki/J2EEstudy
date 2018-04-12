package com.qsx.crm.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("baseRepositoryImpl")
public class BaseRepositoryImpl<T> implements BaseRepository<T>{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseRepositoryImpl(){
		this.entityClass = getSuperClassGenricType(getClass());
	}
	
	/**
	 * 获得当前hibernate SessionFactory
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * 获取当前session
	 * @return
	 */
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	/**
	 * 根据sql语句查询
	 * @param sql
	 * @return
	 */
	public List<Object[]> queryBySql(String sql) {
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		return list;
	}
	
	public List<T> find(final Criterion...criterions) {
		return createCriteria(criterions).list();
	}
	
	public List<T> findList(final Criteria criteria) {
		return criteria.list();
	}
	
	public Criteria createCriteria(final Criterion...criterions ) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	public Criterion createCriterion(final String propertyName,final Object value) {
		if (value ==null) {
			return Restrictions.isNull(propertyName);
		} else{
			return Restrictions.gt(propertyName, value);
		}
		
	}
	/**
	 * 通过反射，=获得定义CLass时声明的父类的泛型参数的类型，如如无法找到，则返回Object。class
	 * @param clazz
	 * @return
	 */
	public Class getSuperClassGenricType(final Class clazz) {
		Type genType = clazz.getSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName() +"'s superclass not ParameterizedType");
			return Object.class;	
		}
		
		Type[] param =((ParameterizedType) genType).getActualTypeArguments();
		return (Class) param[0];
		
	}
	
	
}
