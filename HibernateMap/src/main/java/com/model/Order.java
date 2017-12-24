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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_Order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增
	@Column(name="code")
	private Integer code;
	
	@Column(name="creatDate")
	private Date creatDate;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(targetEntity=Goods.class,fetch=FetchType.EAGER)
	@JoinTable(
			name="tb_temp",//中间表名称
			joinColumns={
					@JoinColumn(name="code")
			},
			inverseJoinColumns={
					@JoinColumn(name="goodsId")
			}
	)
	private Set<Goods> goods = new HashSet<>();
	
	public Order(Integer code, Date creatDate, String description) {
		super();
		this.code = code;
		this.creatDate = creatDate;
		this.description = description;
	}

	public Order(Integer code) {
		super();
		this.code = code;
	}

	public Order(Date creatDate, String description) {
		super();
		this.creatDate = creatDate;
		this.description = description;
	}

	public Order() {
		super();
	}

	
	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Order [code=" + code + ", creatDate=" + creatDate + ", description=" + description + "]";
	}
	public String toStringAndgoods() {
		return "Order [code=" + code + ", creatDate=" + creatDate + ", description=" + description + ", goods=" + goods
				+ "]";
	}
	
}
