package com.qsx.crm.module.menu.service;

import static org.mockito.Matchers.endsWith;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qsx.crm.core.BaseRepository;
import com.qsx.crm.core.BaseService;
import com.qsx.crm.model.MenuJSON;
import com.qsx.crm.model.MenuModel;
import com.qsx.crm.model.ResourceModel;
import com.qsx.crm.module.menu.repository.MenuBaseRepository;
import com.qsx.crm.module.menu.repository.MenuRepository;
import com.qsx.crm.module.resource.repository.ResourceRepository;

@Service
@Transactional
public class MenuService extends BaseService{
	
	//注入菜单处理
	@Autowired
	@Qualifier(value="menuRepositoryImpl")
	private MenuRepository mRepository;
	
	@Autowired
	@Qualifier(value="baseRepositoryImpl")
	private BaseRepository<MenuModel> baseRepository;
	
	@Autowired
	private MenuBaseRepository mbRepository;
	
	//注入资源处理
	@Autowired
	private ResourceRepository repository;
	
	/**
	 * 获取所有菜单信息
	 * @return
	 */
	public  List<MenuModel> getMenuList() {
		return mRepository.getMenuList();
	}
	
	/**
	 * 根据菜单Id获取菜单信息
	 * @param id
	 * @return
	 */
	public MenuModel getMenu(Long id) {
		return mbRepository.findOne(id);
	}
	
	/**
	 * 保存菜单信息
	 * @param menu
	 */
	public void saveMenu(MenuModel menu) {
		
		//新增一级菜单，新增二级菜单
		if (null == menu.getId()) {
			//设置默认排序
			menu.setIndexNo(0);
			menu.setParent(getMenu(menu.getParent().getId()));
			mbRepository.save(menu);
		}else {
			MenuModel menuModel = getMenu(menu.getId());
			menuModel.setName(menu.getName());
			menuModel.setUrl(menu.getUrl());;
			mbRepository.save(menuModel);
		}
	}
	
	/**
	 * 根据Id删除菜单信息
	 * @param MenuId
	 */
	public void deleteMenu(Long MenuId) {
		MenuModel menu = mbRepository.findOne(MenuId);
		
		if (null != menu.getParent()) {
			//先设置父级为空，避免连带父级删除
			menu.setParent(null);
			mbRepository.delete(menu);
		}else {
			mbRepository.delete(MenuId);
		}
	}
	
	/**
	 * 保存资源信息
	 * @param resource
	 */
	public void saveResource(ResourceModel resource) {
		//如果资源id是null，表示新增资源
		if (null == resource.getId()) {
			MenuModel menu = mbRepository.findOne(resource.getMenuId());
			menu.getResources().add(resource);
			mbRepository.save(menu);
		}else{
			//如果资源id不是为null，表示修改资源
			repository.save(resource);
		}
	}
	
	/**
	 * 删除资源
	 * @param resourceId
	 * @param menuId
	 */
	public void deleteResource(Long resourceId, Long menuId) {
		MenuModel menu = mbRepository.findOne(menuId);
		
		//因为有外键，删除外键需去掉菜单中的这个资源
		menu.getResources().remove(repository.findOne(resourceId));
		mbRepository.save(menu);
		
	}
	
	public void sort(String sectionSortString) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		//将json数据转换为list对象
		try {
			List<MenuJSON> menuJSONs = mapper.readValue(sectionSortString, mapper.getTypeFactory()
					.constructParametricType(ArrayList.class, MenuJSON.class));
			int parentIndex = 10;
			//设置排序号为四位数，前两位数代表父级菜单的排序 后两位代表子菜单的排序
			for (MenuJSON menuJSON : menuJSONs) {
				MenuModel menu = mbRepository.findOne(Long.valueOf(menuJSON.getId()));
				menu.setParent(null);
				int index = Integer.valueOf(String.valueOf(++parentIndex) +"00");
				menu.setIndexNo(index);
				int childIndex = 10;
				if (menuJSON.getChildren() != null) {
					for(MenuJSON child : menuJSON.getChildren()){
						Integer indexNo = Integer.valueOf(String.valueOf(parentIndex) + String
								.valueOf(childIndex++));
						MenuModel cikdmenu = getMenu(Long.valueOf(child.getId()));
						cikdmenu.setIndexNo(indexNo);
						cikdmenu.setParent(mbRepository.findOne(Long.valueOf(menuJSON.getId())));;
						saveMenu(cikdmenu);
					}
				}
				//保存菜单
				saveMenu(menu);
						
			}
					
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	
	
	
	
	
}
