package com.qsx.crm.module.region.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsx.crm.model.RegionModel;
import com.qsx.crm.module.region.repository.RegionRepository;

/**
 * 区域处理服务类
 * @author Mryang
 *
 */
@Service
public class RegionService {
	
	@Autowired
	private RegionRepository rgRepository;
	
	public List<RegionModel> getRegionList() {
		List<RegionModel> list = new ArrayList<>();
		Iterable<RegionModel> iterable = rgRepository.findAll();
		for (RegionModel regionModel : iterable) {
			list.add(regionModel);
		}
		return list;
	}
}
