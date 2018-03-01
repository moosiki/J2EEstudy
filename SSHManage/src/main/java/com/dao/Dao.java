package com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * ͨ�ýӿ� ���ݷ��ʲ�
 * @author Mryang
 *
 * @param <T>
 */
public interface Dao<T> {
	
	/**
	 * ͨ�ò�ѯ��������ѯĳ��ȫ����Ϣ
	 * @param t
	 * @param className
	 * @return
	 */
	List<T> query(T t,Class className);
	
	/**
	 * ��ҳ��ѯ
	 * @param startPage ��ʼҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @param className 
	 * @return
	 */
	List<T> queryWithPage(Integer startPage,Integer pageSize,Class className);
	
	/**
	 * ������ҳ��ѯ
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	List<T> criteriaPage(Integer startPage, Integer pageSize);
	
	/**
	 * �Զ���������ҳ��ѯ
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
	 * ͨ�ò�ѯ���� ��ѯĳ������
	 * @param id
	 * @param className
	 * @return
	 */
	T queryObjectById(Serializable id,Class className);
	
	/**
	 * ��ѯ����
	 * @param className
	 * @return
	 */
	Long queryAmount(Class className);
	
	/**
	 * ͨ�ñ�����󷽷�
	 * @param t
	 */
	void save(T t);
	
	/**
	 * ͨ��ɾ�����󷽷�
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * ͨ���޸Ķ��󷽷�
	 * @param t
	 */
	void edit(T t);

	
}
