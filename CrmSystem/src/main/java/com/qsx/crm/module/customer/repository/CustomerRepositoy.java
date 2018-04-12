package com.qsx.crm.module.customer.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.qsx.crm.model.CustomerModel;

/**
 * 客户仓库接口
 * @author Mryang
 *
 */
public interface CustomerRepositoy extends PagingAndSortingRepository<CustomerModel, Long>{
	
	//新建一个根据名字模糊查询，并实现数据分页
	public Page<CustomerModel> findBynameLike(String name, Pageable pageable);
	
	
	
}
