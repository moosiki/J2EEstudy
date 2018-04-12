package com.qsx.crm.module.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsx.crm.model.ResourceModel;
import com.qsx.crm.module.resource.repository.ResourceRepository;

/**
 * 资源服务类
 * @author Mryang
 *
 */
@Service
public class ResourceService {
	
	//注入资源处理repository
	@Autowired
	ResourceRepository repository;
	//保存资源
	public  void saveResource(ResourceModel rModel) {
		repository.save(rModel);
		
	}
	
	//根据id获取资源
	public ResourceModel getResource(Long id) {
		return repository.findOne(id);
	}
	
	//删除资源
	public void deleteResource(Long id) {
		repository.delete(id);
	}
}
