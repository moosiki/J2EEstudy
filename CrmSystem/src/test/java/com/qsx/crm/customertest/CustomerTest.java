package com.qsx.crm.customertest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qsx.crm.core.PageContainer;
import com.qsx.crm.model.CityModel;
import com.qsx.crm.model.CustomerModel;
import com.qsx.crm.module.city.service.CityService;
import com.qsx.crm.module.customer.service.CustomerService;

/**
 * 客户测试类
 * @author Mryang
 *
 */
@Service
public class CustomerTest {
	
	@Autowired
	private CustomerService cstService;
	
	@Autowired
	private CityService cityService;
	
	public void findAllPageTest() {
		
		Pageable pageable = new PageRequest(2, 3);
		
		Page<CustomerModel> customers = cstService.findAllPage(pageable);
		
		customers.forEach(customer -> {System.out.println(customer.toStringSimple());});

		System.out.println("页码："+customers.getNumber()+"--总数据量"+customers.getTotalElements()+"---每页数据量"+customers.getSize()+
				"--排序方式:"+customers.getSort());
	}
	
	public void findPageTest() {
		Pageable pageable = new PageRequest(0, 1);
		
		Map<String, String> params = new HashMap<>();
 		
		params.put("start", "0");
		params.put("length", "2");
		params.put("name", "李");
		
		String m =  "<button type='button' title='修改' class='btn btn-primary btn-xs edit'>" + "<i class='fa fa-pencil'></i>" + "</button>" + "&nbsp;&nbsp;" + "<button type='button' title='删除' class='btn btn-danger btn-xs delete'>" + "<i class='fa fa-trash-o'></i>" + "</button>" + "&nbsp;&nbsp;" + "<button type='button' title='更改状态' class='btn btn-xs status'>"
                + "<i class='fa fa-arrow-circle-up checkStatus'></i>" + "</button>";
		PageContainer customers = cstService.findPage(params);
		
		for (CustomerModel customer : (List<CustomerModel>)customers.getData()) {
			System.out.println(customer.toString());
		}

		System.out.println(customers.getData());
		System.out.println("当前页数据量："+customers.getiTotalDisplayRecords()+"--总数据量"+customers.getiTotalRecords());
	}
	
	public void getCustomerTest() {
		CustomerModel customer = cstService.getCustomerById(24l);
		System.out.println(customer.toString());
	}
	
	public void findByproCodeTest(){
		List<CityModel> list = cityService.searchCity("四川");
		
		for (CityModel cityModel : list) {
			System.out.println(cityModel.toString());
		}
	}
	
	/**
	 * 鸡兔同笼
	 * @param head
	 * @param foot
	 */
	public void jitu(int 头, int 脚) {
		
		if (脚%2==0 && 脚<=4*头 && 脚>=头*2) {
			System.out.println("鸡有"+(2*头-脚/2)+"只");
			System.out.println("兔有"+(脚/2-头)+"只");
		}else  System.out.println("无解");
		
		
		return;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
