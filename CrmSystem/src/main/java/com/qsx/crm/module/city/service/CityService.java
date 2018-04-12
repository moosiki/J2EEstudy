package com.qsx.crm.module.city.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsx.crm.core.BaseService;
import com.qsx.crm.model.CityModel;
import com.qsx.crm.module.city.repository.CityRepository;

@Service
public class CityService extends BaseService{
	
	@Autowired
	private CityRepository cityRep;
	
	public List<CityModel> getAllCity() {
		List<CityModel> list = new ArrayList<>();
		Iterable<CityModel> iterable = cityRep.findAll();
		for (CityModel cityModel : iterable) {
			list.add(cityModel);
		}
		return list;
	}

	public List<CityModel> searchCity(String proCode) {
		return cityRep.searchCity(proCode);
	}
}
