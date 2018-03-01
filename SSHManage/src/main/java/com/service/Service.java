package com.service;

import java.util.List;



/**
 * ͨ��ҵ���߼���
 * @author Mryang
 *
 * @param <T>
 */
public interface Service<T> {
	/**
	 * ͨ�÷�������ѯ�б�
	 * @param t ��ѯ����
	 * @param className ��ѯĿ������
	 * @return ����
	 */
	List<T> query(T t,Class className);
	
	/**
	 * ��ѯ����
	 * @param className
	 * @return
	 */
	Long queryAmount(Class className);
	
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
	 * @param values
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	List<T> ParamPage(Object[] values,
			Integer startPage, Integer pageSize);
	
	/**
	 * ͨ�÷��� ͨ��id��ѯ
	 * @param id ������
	 * @param className ��������
	 * @return ����
	 */
	T queryObjectById(java.io.Serializable id,Class className);
	
	/**
	 * ͨ�÷��� ����
	 * @param t
	 */
	void save(T t);
	
	/**
	 * ͨ�÷��� ɾ��
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * ͨ�÷��� �޸�
	 * @param t
	 */
	void edit(T t);
}
