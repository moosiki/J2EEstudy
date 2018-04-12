package com.qsx.crm.security;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qsx.crm.model.MenuModel;
import com.qsx.crm.model.ResourceModel;
import com.qsx.crm.model.RoleModel;
import com.qsx.crm.module.role.service.RoleService;

/**
 * 角色资源仓库类
 * @author Mryang
 *
 */
@Service
@Transactional
public class RoleResourceRepository implements InitializingBean{
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	private Map<String, Set<MenuModel>> roleMenuMap = Maps.newConcurrentMap();
	
	private Map<String, List<ResourceModel>> roleResourceMap = Maps.newConcurrentMap();
	
	@Autowired
	private RoleService roleService;
	
	private String filterChainDefinitions;
	
	/**
	 * 获取角色的所有资源(菜单)
	 * @param roleIds
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MenuModel> getRoleMenus(List<String> roleIds) {
		//菜单列表
		List<MenuModel> roleMenus = Lists.newArrayList();
		
		//获取指定角色的所拥有的所有菜单项
		for (String roleId : roleIds) {
			System.out.println("用户拥有的角色id："+roleId);
			Set<MenuModel> oneRoleMenus = roleService.getRole(Long.parseLong(roleId)).getMenus();
			for (MenuModel menuModel : oneRoleMenus) {
				if (!roleMenus.contains(menuModel)) {
					//如果是顶层菜单
					if (menuModel.getParent() == null) {
						System.out.println("此角色的一级菜单："+menuModel.getName());
						roleMenus.add(menuModel);
					}else {
						int parentIndex = roleMenus.indexOf(menuModel.getParent());
						if (-1 != parentIndex) {
							MenuModel parentMenu = roleMenus.get(parentIndex);
							System.out.println(parentMenu.getName()+"的二级菜单："+menuModel.getName());
							parentMenu.addChildren(menuModel);
						}
					}
				}
			}
		}
/*		System.out.println("菜单排序");
		//菜单排序
		Collections.sort(roleMenus);
		System.out.println("排序完成");*/
		for (MenuModel menuModel : roleMenus) {
			System.out.println("角色拥有的菜单列表"+menuModel.toString());
		}
		
		return roleMenus;
	}
	
	public Map<String, List<ResourceModel>> getRoleResource() {
		return roleResourceMap;
	}
	
	/**
	 * 加载指定角色拥有的功能菜单
	 * @param roles
	 */
	public void loadRoleMenuMap(List<RoleModel> roles) {
		//加载角色对应菜单前，首先清除所有内容
		roleMenuMap.clear();
		//将登陆用户的角色ID，角色对应的菜单列表以key,value的形式put到roleMenuMao中
		for (RoleModel role : roles) {
			roleMenuMap.put(String.valueOf(role.getId()), role.getMenus());
		}
	}
	
	/**
	 * 加载指定角色拥有的资源权限(如：产品查询，产品新增，产品删除等)
	 * @param roles
	 */
	public void loadRoleResourceMap(List<RoleModel> roles) {
		roleResourceMap.clear();
		//将登陆用户的角色ID，角色对应的资源列表以key,value的形式put到roleMenuMap中
		for (RoleModel role : roles) {
			Set<MenuModel> roleMenus = role.getMenus();
			List<ResourceModel> roleResources = Lists.newArrayList();
			for (MenuModel menu : roleMenus) {
				roleResources.addAll(menu.getResources());
			}
			roleResourceMap.put(String.valueOf(role.getId()), roleResources);
		}
	}

	public String getFilterChainDefinitions() {
		return filterChainDefinitions;
	}

	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		//获取系统中所有角色数据
		List<RoleModel> roles = roleService.getAllRoles();
		
		//加载角色与菜单映射
		loadRoleMenuMap(roles);
		
		//加载角色与资源权限映射
		loadRoleResourceMap(roles);
		
		
	}
	
	
}
