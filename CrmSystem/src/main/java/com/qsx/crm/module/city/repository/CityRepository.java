package com.qsx.crm.module.city.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsx.crm.model.CityModel;


public interface CityRepository extends JpaRepository<CityModel,Long>{
	
	
	@Query(value = "select c from CityModel c where c.province.code= ?1")
	List<CityModel> searchCity(String code);
}
