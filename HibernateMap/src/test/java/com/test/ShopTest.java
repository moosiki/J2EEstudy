package com.test;

import java.util.Date;
import java.util.List;

import com.model.Goods;
import com.model.Order;
import com.model.User;
import com.service.ShopServiceImpl;

public class ShopTest {

	public static void main(String[] args) {
		ShopServiceImpl serviceImpl = new ShopServiceImpl();
		
	/*	User user01 = new User(new Date(),"�����","123345");
		
		Order order01 = new Order(new Date(),"������һ���ϰѣ����888Ԫ");*/
		
		/*Order order02 = new Order(new Date(),"������һ�����°壬���220Ԫ");
		
		User user = (User) serviceImpl.get(User.class, 1);
		
		user.getOrders().add(order02);
		
		serviceImpl.merge(user);
		
		User user2 = (User)serviceImpl.get(User.class,1);*/
		/*
		List list2 = serviceImpl.getAll(new Order(),"Goods");
		
		System.out.println(list2.toString());
		*/
		/*List<Order> list = serviceImpl.getOrder();
		
		System.out.println(list.toString());*/

		Goods goods1 = new Goods("����",(double) 18888);
		Goods goods2 = new Goods("΢��¯",(double) 595);
		Goods goods3 = new Goods("���ӻ�",(double) 6666);
		serviceImpl.save(goods1);
		serviceImpl.save(goods2);
		serviceImpl.save(goods3);
		
/*		serviceImpl.creatOrder();*/

	/*	List<Order> list = serviceImpl.orderForUser(1);
		System.out.println(list.toString());
*/
/*		serviceImpl.delete(1);*/
	}

}
