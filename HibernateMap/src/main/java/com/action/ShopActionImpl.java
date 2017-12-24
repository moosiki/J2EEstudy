package com.action;

import java.util.Date;
import java.util.List;

import com.model.Goods;
import com.model.Order;
import com.model.User;
import com.service.ShopServiceImpl;

public class ShopActionImpl {
	ShopServiceImpl sImpl = new	ShopServiceImpl();
	private User user;
	private String loginName;
	private Integer user_id;
	private List goodsList;
	private String result;
	private Integer[] goodId;
	private List<Order> ordersList;
	private Integer code;
	
	
	
	/*private Object[] goodId;
	
	public Object[] getGoodId() {
		return goodId;
	}
	public void setGoodId(Object[] goodId) {
		this.goodId = goodId;
	}*/
	
	
	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<Order> getOrdersList() {
		return ordersList;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer[] getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer[] goodId) {
		this.goodId = goodId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public List getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List goodsList) {
		this.goodsList = goodsList;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 用户登陆
	 */
	public String login() {
		String inputName ="'"+user.getLoginName()+"'";
		String inputPass = user.getPassword();
		if(inputPass.equals((String) sImpl.getMessage("password","User", "loginName",inputName))){
			user.setUser_id((Integer) sImpl.getMessage("user_id","User", "loginName",inputName));
			System.out.println(user_id);
			result = "密码正确！";
			return "success";
		}
		else {
			result = "密码错误！";
			return "false";
		}
		}
	
	/**
	 * 注册用户信息
	 */
	public String registe() {
		user.setCreatDate(new Date());
		sImpl.save(user);
		user_id = user.getUser_id();		
		return "success";
	}
	/**
	 * 查看用户信息
	 */
	
	/**
	 * 商品界面
	 */
	public String shopping() {
		goodsList = sImpl.getAll(new Order(), "Goods");
		System.out.println(goodsList);
		user_id = user.getUser_id();
		loginName = user.getLoginName();
		return "success";
	}
	
	/**
	 * 创建订单
	 */
	public String creatOrder() {
		for(int i=0;i<goodId.length;i++)
		System.out.println(goodId[i]);
		System.out.println(user_id);
		String userName = (String) sImpl.getMessage("loginName", "User", "user_id",user_id+"");
		System.out.println(userName);
		sImpl.creatOrder(user_id,goodId,userName);
		return "success";
	}
	/**
	 * 查看订单
	 */
	public String checkOrder() {
		System.out.println(user_id);
		ordersList = sImpl.orderForUser(user_id);
		for (Order order : ordersList) {
			System.out.println(order.toStringAndgoods());
		}	
		return "success";
	}
	/**
	 * 删除订单
	 */
	public String deleteOrder() {
		sImpl.deleteOrder(code);
		return "success";
	}
}
