package com.qsx.crm.module.menu.repository.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.qsx.crm.core.BaseRepositoryImpl;
import com.qsx.crm.core.BaseRepository;
import com.qsx.crm.model.MenuModel;
import com.qsx.crm.module.menu.repository.MenuBaseRepository;
import com.qsx.crm.module.menu.repository.MenuRepository;

@Repository("menuRepositoryImpl")
public class MenuRepositoryImpl implements MenuRepository{
	
	@Autowired
	@Qualifier("baseRepositoryImpl")
	private BaseRepository baseRepository;
	
	/**
	 * 查询所有菜单列表
	 * @return
	 */
	public List<MenuModel> getMenuList() {
		//初始化的查询条件是父级ID是null
		Criterion parentId = baseRepository.createCriterion("parent.id", null);
		
		//初始查询条件是根据indexNo升序
		Criteria criteria = baseRepository.createCriteria(parentId).addOrder(Order.asc("indexNo"));
		
		return baseRepository.findList(criteria);

	}
	
}
