package com.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_Goods")
public class Goods {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增
	@Column(name="goodsId")
	private Integer goodsId;
	
	@Column(name="goodsName")
	private String goodsName;
	
	@Column(name="price")
	private Double price;
/*
	@ManyToMany(targetEntity=Order.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(
			name="tb_temp",//中间表名称
			joinColumns={
					@JoinColumn(name="goodsId")
			},
			inverseJoinColumns={
					@JoinColumn(name="code")
			}
	)
	private Set<Order> orders = new	HashSet<Order>();
	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
*/
	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Goods(Integer goodsId, String goodsName, Double price) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
	}

	public Goods(String goodsName, Double price) {
		super();
		this.goodsName = goodsName;
		this.price = price;
	}

	public Goods(Integer goodsId) {
		super();
		this.goodsId = goodsId;
	}

	public Goods() {
		super();
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", price=" + price + "]";
	}
	
}
