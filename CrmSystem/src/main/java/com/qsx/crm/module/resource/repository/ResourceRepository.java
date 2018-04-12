package com.qsx.crm.module.resource.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qsx.crm.model.ResourceModel;

public interface ResourceRepository extends CrudRepository<ResourceModel, Long>{
	

}
