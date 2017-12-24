package com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.model.Goods;
import com.model.Order;
import com.model.User;

public class Connect_DB {
	SessionFactory sf = null;
	Session session = null;
	Transaction transaction = null;
	
	/**
	 * 开启hibernate连接
	 */
	public void init() {
		//加载配置文件
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//注册标准服务
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr = ssrb.applySettings(configuration.getProperties()).build();
		
		//通过标准服务加载配置文件后获得会话工厂
		sf = configuration.buildSessionFactory(ssr); //二级缓存
		
		//开启一个会话
		session = sf.openSession();//一级缓存
		
		//开启事务
		transaction = session.beginTransaction();
		
		//操作
		System.out.println("连接开启成功");
		
	}
	
	/**
	 * 关闭hibernate连接
	 */
	public void destroy() {
		//提交事务
		transaction.commit();
		//关闭
		session.close();
		sf.close();
		System.out.println("连接关闭成功");
			
	}
	public void save(Object object) {
		init();
		session.save(object);
		destroy();
	}
	public void saveOrUpdate(Object object) {
		init();
		session.saveOrUpdate(object);
		destroy();
	}
	public void delete(Object object) {
		init();
		session.delete(object);
		destroy();
	}
	public void merge(Object object) {
		init();
		session.merge(object);
		destroy();
	}
	public Object get(Class clazz,Integer id) {
		init();
		Object object = session.get(clazz, id);
		destroy();
		return object;
		
	}
	public Object getByName(String fromName,String name,String searchName) {
		init();
		String hql = "from "+fromName+" u where u."+name+"="+searchName;
		Query query = session.createQuery(hql);
		Object object = query.uniqueResult();
		destroy();
		return object;
	}
	public Object getMessage(String message,String fromName,String property,String searchName) {
		init();
		String hql = "select u."+message+" from "+fromName+" u where u."+property+"="+searchName;
		Query query = session.createQuery(hql);
		Object object = query.uniqueResult();
		destroy();
		return object;
	}
	public List getAll(Object object,String fromName) {
		init();
		List list = new ArrayList<>();
		String hql = "from "+fromName;
		Query query = session.createQuery(hql);
		list = query.list();
		destroy();
		return list;
	}
	public List<Order> getOrder() {
		init();
		List<Order> list = new ArrayList<>();
		String hql = "from Order";
		Query query = session.createQuery(hql);
		list = query.list();
		destroy();
		return list;
	}
	public void creatOrder(Integer user_id,Integer[] goodsId,String userName) {
		init();
		User user = (User) session.get(User.class, user_id);
		Order order = new Order(new Date(),"用户"+userName+"的订单！");
		for(int i=0;i<goodsId.length;i++){
			order.getGoods().add((Goods) session.get(Goods.class, goodsId[i]));
		}
		System.out.println(order.toStringAndgoods());
/*		session.save(order);*/
		
		System.out.println(user);
		user.getOrders().add(order);
		session.merge(user);
		destroy();
	}
	public List<Order> orderForUser(Integer user_id) {
		init();
		List<Order> list = new ArrayList<>();
		String hql = "from Order where user_id="+user_id;
		Query query = session.createQuery(hql);
		list = query.list();
		destroy();
		System.out.println(list.toString());
		return list;
	}
	public void deleteOrder(Integer code) {
		init();
		Order order = (Order)session.get(Order.class, code);
		session.delete(order);
		destroy();
	}
}
