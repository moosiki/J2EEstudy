package com.qsx.crm.module.dashboard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsx.crm.module.dashboard.repository.DashboardRepository;


@Service
@Transactional
public class DashboardService {
	
	@Autowired
	private DashboardRepository dsRepository; 
	

	/**
	 * 查询折线图和柱状图数据
	 * @return
	 */
	public List<Object[]> getLineDates() {
		return dsRepository.getLineDates();
	}
	
	/**
	 * 查询饼状图数据
	 * @return
	 */
	public List<Object[]> getPieDatas() {
		return dsRepository.getPieDatas();
	}
	
	/**
	 * 查询地图数据
	 * @return
	 */
	public String getChinaMapData() {
		List<Object[]> list = dsRepository.getChinaMapData();
		StringBuffer sb = new StringBuffer("");
		//拼接字符串
		for (Object[] map : list) {
			sb.append("{'hc-key':'").append(map[1]).append("','value':").append(map[0])
			.append("},").append("\n");
		}
		//去除最后的逗号
		String data = sb.deleteCharAt(sb.length() - 1) +"";
		return data;
	}
	
	/**
	 * 查询当月销售数据
	 * @return
	 */
	public List<Object[]> getOrderData() {
		return dsRepository.getOrderData();
		
	}
	
	 /**
     * 查询当天新增客户数量
     * 
     * @param
     * @return
     */
    public List<Object[]> getCustomersOfDay() {
    	return dsRepository.getCustomersOfDay();
    }
    
    /**
     * 查询本月新增客户数量
     * 
     * @param
     * @return
     */
    public List<Object[]> getCustomersOfMonth() {
    	return dsRepository.getCustomersOfMonth();
    }
    
    
    
}
