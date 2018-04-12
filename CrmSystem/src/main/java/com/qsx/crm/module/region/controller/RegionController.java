package com.qsx.crm.module.region.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsx.crm.model.RegionModel;
import com.qsx.crm.module.region.service.RegionService;
import com.qsx.crm.web.ResponseData;

/**
 * 区域处理控制类
 * @author Mryang
 *
 */
@Controller
@RequestMapping(value="/region")
public class RegionController {
	
	@Autowired
	private RegionService rgService;
	
	/**
	 * 获取区域信息列表
	 * @return
	 */
	public ResponseData name() {
		ResponseData responseData = new ResponseData();
		List<RegionModel> region = rgService.getRegionList();
		responseData.setData(region);
		return responseData;
	}
	
	@RequestMapping(value = "/list/data")
	@ResponseBody
	public List<RegionModel> regionList() {
		List<RegionModel> list = rgService.getRegionList();
		return list;
	}
}
