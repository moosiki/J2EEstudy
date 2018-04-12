package com.qsx.crm.module.dashboard.controller;

import static org.mockito.Matchers.isNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsx.crm.model.RegionModel;
import com.qsx.crm.module.dashboard.service.DashboardService;
import com.qsx.crm.module.region.service.RegionService;
import com.qsx.crm.web.controller.BaseController;

/**
 * 首页处理 Controller 类
 * @author Mryang
 *
 */
@Controller
@RequestMapping(value="/dashboard")
public class DashBoardController extends BaseController{
	
	@Autowired
	private DashboardService dsService;
	
	@Autowired
	private RegionService rgService;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String dashboard(Model model) {
		System.out.println("首页处理");
		List<Object[]> list = dsService.getLineDates();
		
		//折线图数据
		List<Object> lineValues = new ArrayList<Object>();
		
		//柱状图数据
		List<Object> barValues = new ArrayList<Object>();
		
		//遍历所有数据放折线图
		Map<Object, Object> lineMap = new HashMap<Object,Object>();
		for (int j = 0; j < list.size(); j++) {
			lineMap.put(list.get(j)[2], list.get(j)[0]);
		}
		
		//遍历说有数据放柱状图map
		Map<Object, Object> barMap = new HashMap<Object,Object>();
		for (int k = 0; k < list.size(); k++) {
			barMap.put(list.get(k)[2], list.get(k)[1]);
		}
		
		//遍历12个月的数据
		for (int i = 0; i < 12; i++) {
			 if (null != lineMap.get(i)) {
				lineValues.add(lineMap.get(i));
				barValues.add(barMap.get(i));
			}else {
				lineValues.add(0);
				barValues.add(0);
			}
		}														
		
		//饼状图数据
		List<Object[]> pieList = dsService.getPieDatas();
		//饼图数据（统计各个区域客户数量）
		List<Object> pieNames = new ArrayList<Object>();
		List<Object> pieValues = new ArrayList<Object>();
		
		//遍历出所有数据放饼状图mao
		Map<String, Object> pieMap = new HashMap<String, Object>();
		for (int i = 0; i < pieList.size(); i++) {
			pieMap.put(pieList.get(i)[1].toString(), pieList.get(i)[0]);
		}
		
		//获取区域信息列表
		List<RegionModel> regionList = rgService.getRegionList();
		for (int i = 0; i < regionList.size(); i++) {
			if (null != pieMap.get(regionList.get(i).getId().toString())) {
				pieNames.add("'"+regionList.get(i).getName()+"'");
				pieValues.add(pieMap.get(regionList.get(i).getId().toString()));	
			}else {
				pieNames.add("'"+regionList.get(i).getName()+"'");
				pieValues.add(0);
			}
		}
		
		//地图数据
		String data = dsService.getChinaMapData();
		
		//本月销售数据
		List<Object[]> orderList = dsService.getOrderData();
		
		//今天新增客户数量
		List<Object[]> customerList = dsService.getCustomersOfDay();
		
		//本月新增客户数量
		List<Object[]> customersList = dsService.getCustomersOfMonth();
		
		//返回到页面的数据
		model.addAttribute("lineValues",lineValues);
		model.addAttribute("barValues",barValues);
		model.addAttribute("pieNames",pieNames);
		model.addAttribute("pieValues",pieValues);
		model.addAttribute("data",data);
		model.addAttribute("amount",orderList.get(0)[0]);
		model.addAttribute("quantity",orderList.get(0)[1]);
		model.addAttribute("customer",customerList.get(0)[0]);
		model.addAttribute("customers",customerList.get(0)[1]);
		
		
		//转向前端也页面
		return "/dashboard/dashboard";
					
	}
		

}
 