package com.qsx.crm.module.province.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsx.crm.core.BaseService;
import com.qsx.crm.model.ProvinceModel;
import com.qsx.crm.module.province.repository.ProvinceRepositero;

@Service
public class ProvinceService extends BaseService{
	
	@Autowired
	private ProvinceRepositero proRep;
	
	public List<ProvinceModel> getAllProvince() {
		List<ProvinceModel> list = new ArrayList<>();
		Iterable<ProvinceModel> iterable = proRep.findAll();
		for (ProvinceModel provinceModel : iterable) {
			list.add(provinceModel);
		}
		return list;
	}
}	
