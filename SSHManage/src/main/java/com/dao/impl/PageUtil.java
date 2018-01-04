package com.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageUtil{
	
	
	public List<?> queryForPage(final String hql,final Integer offset,final Integer length,BaseDao baseDao) {
		
		Session session = baseDao.getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery(hql);
		
		query.setFirstResult(offset);
		
		query.setMaxResults(length);
		
		List<?> list = query.list();
		
		return list;
		
		
	}
}
