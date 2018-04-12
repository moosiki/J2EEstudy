package com.qsx.crm.module.customer.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qsx.crm.core.BaseService;
import com.qsx.crm.core.PageContainer;
import com.qsx.crm.model.CustomerModel;
import com.qsx.crm.model.UserStatus;
import com.qsx.crm.module.customer.repository.CustomerRepositoy;
import com.qsx.crm.util.DateUtils;

@Service
public class CustomerService extends BaseService{
	
	@Autowired
	private CustomerRepositoy cusRepository;
	
	public Page<CustomerModel> findAllPage(Pageable pageable) {

		Page<CustomerModel> customers = cusRepository.findAll(pageable);
		return customers;
	}
	
	/**
	 * 获取分页数据
	 * @param params 参数map,包含了name参数，回调的页码start和每页数据量length
	 * @return
	 */
	public PageContainer findPage( Map<String,String> params) {
		
		//初始化一个分页参数对象
		Pageable pageable = new PageRequest(Integer.valueOf(params.get("start")),Integer.valueOf(params.get("length").toString()));		
		String name = "%" + params.get("name") +"%";
		
		//返回一个page对象(spring jpa)
		Page<CustomerModel> page = cusRepository.findBynameLike(name, pageable);
		
		//新建一个PageContainer对象，并将page对象的数据迁移到PageContainer
		PageContainer pgContain = new PageContainer();
		
		pgContain.setiTotalRecords(page.getTotalElements());
		
		pgContain.setiTotalDisplayRecords(page.getNumberOfElements());
		
		pgContain.setData(page.getContent());
		
		return pgContain;
				
	}
	
	/**
	 * 根据id查询一个
	 * @param id
	 * @return
	 */
	public CustomerModel getCustomerById(Long id) {
		return cusRepository.findOne(id);
	}
	
	/**
	 * 保存用户
	 * @param customer
	 */
	public void saveCustomer(CustomerModel customer) {
		 // 如果状态是禁用的，修改客户状态为启用；如果状态是启用的，修改客户状态为禁用
        if (customer.getStatus().equals(UserStatus.disabledStatus)) {
            customer.setStatus(UserStatus.activeStatus);
        } else {
            customer.setStatus(UserStatus.disabledStatus);
        }
        // 设置编码
        if ("".equals(customer.getAccount()) || null == customer.getAccount()) {
            customer.setAccount("CUS" + System.currentTimeMillis());
        }
        // 设置最后更新时间
        customer.setUpdateTime(DateUtils.timeToString(new Date()));
		cusRepository.save(customer);
	}
}
