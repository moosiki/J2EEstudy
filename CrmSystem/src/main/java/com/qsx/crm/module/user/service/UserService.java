package com.qsx.crm.module.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsx.crm.core.BaseService;
import com.qsx.crm.model.MenuModel;
import com.qsx.crm.model.RoleModel;
import com.qsx.crm.model.UserModel;
import com.qsx.crm.model.UserStatus;
import com.qsx.crm.module.menu.repository.MenuRepository;
import com.qsx.crm.module.role.repository.RoleRepository;
import com.qsx.crm.module.user.repository.UserRepository;
import com.qsx.crm.security.RoleResourceRepository;


@Service
@Transactional
public class UserService extends BaseService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private MenuRepository mRepository;
	
	@Autowired
	private RoleResourceRepository rRRepository;
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public UserModel findOne(Long id) {
		UserModel userModel = userRepository.findOne(id);
		/*userModel.getStatus();
		userModel.getRoles();
		userModel.getDepartment();*/
/*		userModel.getAuthorities();*/
		return userModel;
	}
	
	/**
	 *根据登陆名获取用户
	 * @param loginName
	 * @return
	 */
	public UserModel findByloginName(String loginName) {
		UserModel userModel = userRepository.findByloginName(loginName);
		
	/*	userModel.getStatus().getName();
		userModel.getRoles().size();*/
	/*	userModel.getAuthorities();*/
	/*	userModel.getDepartment().getName();*/
	/*	System.out.println(userModel.toStringAll());*/
		System.out.println("查询用户,service层:"+userModel.toStringSimple());
		return userModel;
	}
	
	/**
	 * 获取当前用户的菜单资源
	 * @return
	 */
	public List<MenuModel> getCurrentUserMenus() {
		
		List<String> roleIds = new ArrayList<>();
		
		Set<RoleModel> roles = super.getCurrentUser().getRoles();
		
		for (RoleModel roleModel : roles) {
			roleIds.add(String.valueOf(roleModel.getId()));
		}
		
		return rRRepository.getRoleMenus(roleIds);
		
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserModel> queryAll() {
		Iterable<UserModel> iterable = userRepository.findAll();
		List<UserModel> list = new ArrayList<UserModel>();
		iterable.forEach(user -> {list.add(user);});
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
