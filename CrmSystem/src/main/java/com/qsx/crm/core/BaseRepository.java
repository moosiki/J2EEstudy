package com.qsx.crm.core;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;


public interface BaseRepository<T> {
	SessionFactory getSessionFactory();
	Session getSession();
	List<Object[]> queryBySql(String sql);
	List<T> find(final Criterion...criterions);
	List<T> findList(final Criteria criteria);
	Criteria createCriteria(final Criterion...criterions );
	Criterion createCriterion(final String propertyName,final Object value);
	Class getSuperClassGenricType(final Class clazz);
}
