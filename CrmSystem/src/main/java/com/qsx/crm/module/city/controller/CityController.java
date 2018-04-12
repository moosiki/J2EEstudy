package com.qsx.crm.module.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsx.crm.model.CityModel;
import com.qsx.crm.module.city.service.CityService;
import com.qsx.crm.web.controller.BaseController;

@Controller
@RequestMapping(value ="/city")
public class CityController extends BaseController{
	
	@Autowired
	private CityService cityservice;
	
	@RequestMapping("/list/data")
	@ResponseBody
	public List<CityModel> getCity(String proCode) {
		return cityservice.searchCity(proCode);
	}
}
