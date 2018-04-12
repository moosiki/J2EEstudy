package com.qsx.crm;


import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qsx.crm.customertest.CustomerTest;
import com.qsx.crm.model.RegionModel;
import com.qsx.crm.model.UserModel;
import com.qsx.crm.module.customer.service.CustomerService;
import com.qsx.crm.module.dashboard.service.DashboardService;
import com.qsx.crm.module.region.service.RegionService;
import com.qsx.crm.usertest.UserTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CrmSystemApplicationTests {
	
	
	@Autowired
	private UserTest utest;
	
	@Autowired
	private CustomerTest cstTest;
	
	@Test
	public void contextLoads() {
		
		//查询说有用户测试
	/*	utest.queryAllTest();*/
		
		//分页查询客户测试
/*		cstTest.findAllPageTest();*/
		
		//条件分页查询测试
	/*	cstTest.findPageTest();*/
		
	/*	cstTest.findPageTest2();
*/
	/*	cstTest.getCustomerTest();*/
		
		cstTest.findByproCodeTest();
		
	}
	


}
