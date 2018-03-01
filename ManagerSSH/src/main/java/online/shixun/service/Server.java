package online.shixun.service;

import java.util.List;

/**
 * ͨ��ҵ���߼�����
 * @author Mryang
 *
 * @param <T>
 */
public interface Server<T> {
	/**
	 * ͨ�÷�������ѯ�б�
	 * @param t ��ѯ����
	 * @param className ��ѯĿ������
	 * @return ����
	 */
	List<T> query(T t,Class className);
	
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
