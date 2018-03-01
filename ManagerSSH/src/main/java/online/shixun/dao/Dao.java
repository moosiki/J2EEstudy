package online.shixun.dao;

import java.util.List;

/**
 * ͨ�����ݷ��ʲ㹤��
 * @author Mryang
 * @Param<T>
 *
 */
public interface Dao<T> {
	
	/**
	 * ͨ�÷�������ѯ�б�
	 * @param t ��ѯ��������
	 * @param classname  ��ѯ��Ŀ������
	 * @return ����
	 */
	List<T> query(T t,Class className);
	
	/**
	 * ͨ�÷��� ��ѯ����
	 * @param id ����id
	 * @param className ��ѯĿ������
	 * @return ����
	 */
	T queryObjectById(java.io.Serializable id,Class className);
	
	/**
	 * ͨ�÷��� ����
	 * @param ����Ķ���
	 */
	void save(T t);
	
	/**
	 * ͨ�÷��� ɾ��
	 * @param t ɾ���Ķ���
	 */
	void delete(T t);
	
	/**
	 * ͨ�÷��� �޸�
	 * @param t �޸ĵĶ���
	 */
	void edit(T t);
	
	
	
}
