package com.crud.practice.dao;

import java.util.List;

import com.crud.practice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

public interface CityRepository extends JpaRepository<City, Integer> {
	
	@Query("SELECT c FROM City c WHERE c.district = :districtName")
	List<City> findAllByDistrictName(String districtName);
	
}
