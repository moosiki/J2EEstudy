package com.qsx.crm.module.province.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsx.crm.model.ProvinceModel;
import com.qsx.crm.module.province.service.ProvinceService;
import com.qsx.crm.web.controller.BaseController;

@Controller
@RequestMapping(value = "/province")
public class ProvinceController extends BaseController{
	
	@Autowired
	private ProvinceService pService;
	
	@RequestMapping(value = "/list/data")
	@ResponseBody
	private List<ProvinceModel> list() {
		return pService.getAllProvince();
	}
}
