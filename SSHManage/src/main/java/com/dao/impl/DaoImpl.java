package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.Dao;

@Component
public class DaoImpl<T> implements Dao<T>{
	
	@Autowired
	protected BaseDao baseDao;
	
	//查询目标总数
	@Override
	public Long queryAmount(Class className) {
		String hql = "select count(*) from "+className.getSimpleName();
		Session session = baseDao.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		Long dataSize = (Long) query.uniqueResult();
		session.close();
		return dataSize;

	}
	
	//根据类名分页查询
	@Override
	public List<T> queryWithPage(Integer startPage, Integer pageSize, Class className) {
		String hql = "from " + className.getSimpleName();
		
		return (List<T>) (new PageUtil()).queryForPage(hql, (startPage-1)*pageSize, pageSize,baseDao);
		
	}
	
	//自定义分页查询
	@SuppressWarnings("unchecked")
	@Override
	public List<T> criteriaPage(Integer startPage, Integer pageSize) {
		String hql = "select empNo,firstName,lastName,gender,status,birthDate from Employees";

		return (List<T>) (new PageUtil()).queryForPage(hql, (startPage - 1) * pageSize, pageSize, baseDao);

	}

	//自定义条件分页查询
	@Override
	public List<T> ParamPage(Object[] values,
			Integer startPage, Integer pageSize) {
			String sql = "select u.empNo,u.firstName,u.lastName,u.gender,u.status,u.birthDate from Employees AS u "
						+ "INNER JOIN u.deptEmps AS o INNER JOIN o.id AS r INNER JOIN o.departments AS p INNER JOIN u.titleses AS "
						+"q INNER JOIN q.id AS s ON u.empNo=o.empNo AND r.deptNo=p.deptNo AND u.empNo=s.empNo "
						+"where p.deptName like :deptName "
						+ "AND s.title like :title "
						+ "AND gender like :gender "
						+ "AND (u.firstName like :searchName "
						+ "or u.lastName like :searchName) ";
			String[] paramNames = {"deptName","title","gender","searchName"};
			
			Session session = baseDao.getSessionFactory().getCurrentSession();
			
			Query query = session.createQuery(sql);
			
			for (int i = 0; i < paramNames.length; i++) {
				query.setParameter(paramNames[i], values[i]);
			}
			
			if (startPage!=null&&pageSize!=null) {
				query.setFirstResult((startPage-1)*pageSize);
				
				query.setMaxResults(pageSize);
			}
			
			
			return (List<T>) query.list();
	}
	
	
	//根据类名查询所有
	@Override
	public List<T> query(T t, Class className) {
		return (List<T>) baseDao.getHibernateTemplate().find("from "+className.getSimpleName());
		
	}
	
	//根据ID查询
	@Override
	public T queryObjectById(Serializable id, Class className) {
		return (T) baseDao.getHibernateTemplate().get(className, id);
		
	}
	
	//保存对象
	@Override
	public void save(T t) {
		baseDao.getHibernateTemplate().save(t);
		
	}
	//删除对象
	@Override
	public void delete(T t) {
		baseDao.getHibernateTemplate().delete(t);
		
	}

	 //修改对象
	@Override
	public void edit(T t) {
		baseDao.getHibernateTemplate().update(t);
		
	}

	
	
	
	
}
