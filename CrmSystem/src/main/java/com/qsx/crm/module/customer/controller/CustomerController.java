package com.qsx.crm.module.customer.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsx.crm.core.PageContainer;
import com.qsx.crm.model.CustomerModel;
import com.qsx.crm.module.customer.service.CustomerService;
import com.qsx.crm.web.ResponseData;
import com.qsx.crm.web.controller.BaseController;

/**
 * 客户信息控制类
 * @author Mryang
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController{
	
	@Autowired
	private CustomerService cstService;
	
	/**
	 * 加载客户信息界面
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list() {
		
		return "/customer/list";
	}
	
	/**
	 * 获取客户信息
	 * @return
	 */
	@RequestMapping(value = "/list/data")
	@ResponseBody
	public PageContainer getCustomerData(Model model,@RequestParam Map<String,String> params) {
		return cstService.findPage(params);
	}
	
	/**
	 * 进入客户编辑页面
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping(value = "/form/{customerId}")
	public String customerForm(Model model,@PathVariable Long customerId) {
		CustomerModel customer = null;
		//新增客户时Id为0
		if (customerId.equals(0L)) {
			customer = new CustomerModel();
		}else {
			customer = cstService.getCustomerById(customerId);
		}
		model.addAttribute(customer);
		return "/customer/form";
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData saveCustomer(Model model,@Valid @ModelAttribute("customer") CustomerModel customer) {
		ResponseData responseData = new ResponseData();
		try {
			cstService.saveCustomer(customer);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			responseData.setError(e.getMessage());
		}
		return responseData;
	}
}
