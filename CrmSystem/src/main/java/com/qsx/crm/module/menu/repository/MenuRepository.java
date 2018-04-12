package com.qsx.crm.module.menu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qsx.crm.core.BaseRepository;
import com.qsx.crm.model.MenuModel;


public interface MenuRepository{
	/**
	 * 查询所有菜单列表
	 * @return
	 */
	List<MenuModel> getMenuList();
}
