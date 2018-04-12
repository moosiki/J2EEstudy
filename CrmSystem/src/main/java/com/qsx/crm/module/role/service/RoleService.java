package com.qsx.crm.module.role.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qsx.crm.core.BaseService;
import com.qsx.crm.model.MenuModel;
import com.qsx.crm.model.ResourceModel;
import com.qsx.crm.model.ResourceTree;
import com.qsx.crm.model.RoleModel;
import com.qsx.crm.model.State;
import com.qsx.crm.module.menu.repository.MenuBaseRepository;
import com.qsx.crm.module.menu.repository.MenuRepository;
import com.qsx.crm.module.role.repository.RoleRepository;
import com.qsx.crm.util.DateUtils;

@Service
@Transactional
public class RoleService extends BaseService{
	
	@Autowired
	private RoleRepository repository;
	
	//注入菜单处理
	@Autowired
	@Qualifier(value="menuRepositoryImpl")
	private MenuRepository mRepository;
	
	@Autowired
	private MenuBaseRepository mbRepository;
	/**
	 * 获取所有角色（包含角色角色说关联的菜单)
	 * @return
	 */
	public List<RoleModel> getAllRoles() {
		List<RoleModel> roles = (List<RoleModel>) repository.findAll();
		for (RoleModel roleModel : roles) {
			for (MenuModel menuModel : roleModel.getMenus()) {
				menuModel.getResources().size();
				menuModel.getChildren().size();
			}
		}
		return roles;
	}
	
	/**
	 * 根据id获取角色信息
	 * @param roleId
	 * @return
	 */
	public RoleModel getRole(Long roleId) {
		return repository.findOne(roleId);
	}
	
	/**
	 * 保存角色信息
	 * @param roleModel
	 */
	public void saveRole(RoleModel roleModel) {
		roleModel.setUpdateTime(DateUtils.timeToString(new Date()));
		repository.save(roleModel);
	}
	
	/**
	 * 删除角色信息
	 * @param roleId
	 */
	public void deleteRole(Long roleId) {
		repository.delete(roleId);
	}
	
	/**
	 * 根据角色信息Id获取树形菜单json数据
	 * @param roleId
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getTreeData(Long roleId) throws JsonProcessingException {
		RoleModel rModel = repository.findOne(roleId);
		List<MenuModel> menus = mRepository.getMenuList();
		List<ResourceTree> resourceList = new ArrayList<ResourceTree>();
		//根菜单
		for (MenuModel menu : menus) {
			ResourceTree resource = getTopResource(menu,rModel);
			resourceList.add(resource);
		}
		//将list对象转换为json字符串
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		String data = mapper.writeValueAsString(resourceList);
		return data;
	}
	
	/**
	 *一级菜单
	 * @param menu 跟菜单实体
	 * @param rModel 角色拥有的菜单ids
	 * @return 角色拥有的资源ids
	 */
	private ResourceTree getTopResource(MenuModel menu, RoleModel rModel) {
		ResourceTree resource = new ResourceTree();
		resource.setId(String.valueOf(menu.getId()));
		resource.setText(menu.getName());
		//判断角色是否拥有该菜单权限 如果有则树形的checkbox被勾选上否则不被勾选上
		if (rModel.getMenus().contains(menu)) {
			resource.setState(new State(true));
		}
		//设置二级菜单状态
		resource.setChildren(getSecondResourceList(menu.getChildren(),rModel));
		return resource;
	}
	
	/**
	 * 二级菜单
	 * @param 子菜单实体列表
	 * @param 角色拥有的菜单ids
	 * @return 角色拥有的资源ids
	 */
	private List<ResourceTree> getSecondResourceList(Set<MenuModel> menus, RoleModel rModel) {
		List<ResourceTree> childResoureList = new ArrayList<ResourceTree>();
		if (menus !=null) {
			for (MenuModel menu : menus) {
				ResourceTree childResource = new ResourceTree();
				childResource.setId(String.valueOf(menu.getId()));
				childResource.setText(menu.getName());
				
				//判断角色是否拥有该菜单权限 如果有则树形的checkbox被勾选上否则不被勾选上
				if (rModel.getMenus().contains(menu)) {
					childResource.setState(new State(true));
					
				}
				childResource.setChildren(getThirdResourceList(menu.getId(),rModel));
				childResoureList.add(childResource);
			}
		}
		return childResoureList;
	}
	
	/**
	 * 三级资源菜单
	 * @param menuId 资源的父级菜单id	
	 * @param rModel 资源列表
	 * @return 角色拥有的资源ids
	 */
	private List<ResourceTree> getThirdResourceList(Long menuId, RoleModel rModel) {
		List<ResourceTree> resourceList = new ArrayList<ResourceTree>();
		if (rModel.getResources() != null) {
			for (ResourceModel resource : rModel.getResources()) {
				ResourceTree nodeResource = new ResourceTree();
				//三级资源菜单的ID是由资源的父级菜单ID: 资源ID)拼接而成
				nodeResource.setId(String.valueOf(menuId)+ ":" + String.valueOf(resource.getId()));
				nodeResource.setText(resource.getName());
				//判断角色是否拥有该菜单权限 如果有则树形的checkbox被勾选上否则不被勾选上	
				if (rModel.getResources().contains(resource)) {
					nodeResource.setState(new State(true));
				}
				resourceList.add(nodeResource);
			}
		}
		return resourceList;
	}
	
	public void saveRoleAuthorization(String ids, Long roleId) {
		String[] idArray = ids.split(",");
		RoleModel role = repository.findOne(roleId);
		Set<MenuModel> set = role.getMenus();
		set.clear();
		repository.save(role);
		for (String id : idArray) {
			if (null != id) {
				MenuModel menu = mbRepository.findOne(Long.parseLong(id));
				set.add(menu);
			}
		}
		repository.save(role);
	}

}
	















