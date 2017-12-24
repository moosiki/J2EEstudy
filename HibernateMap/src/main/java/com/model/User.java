package com.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="tb_User")
public class User {
	
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(name="creatDate")
	private Date creatDate;
	
	@Column(name="loginName")
	private String loginName;
	
	@Column(name="password")
	private String password;
	
	//特殊属性
	//1：N
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Set<Order> orders = new	HashSet<Order>();
	
	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer user_id, Date creatDate, String loginName, String password) {
		super();
		this.user_id = user_id;
		this.creatDate = creatDate;
		this.loginName = loginName;
		this.password = password;
	}

	public User() {
		super();
	}

	public User(Integer user_id) {
		super();
		this.user_id = user_id;
	}

	public User(Date creatDate, String loginName, String password) {
		super();
		this.creatDate = creatDate;
		this.loginName = loginName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", creatDate=" + creatDate + ", loginName=" + loginName + ", password="
				+ password + "]";
	}
	
}
