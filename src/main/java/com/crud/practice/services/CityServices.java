package com.crud.practice.services;

import java.util.List;

import com.crud.practice.dao.CityRepository;
import com.crud.practice.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CityServices {
	
	@Autowired
	CityRepository cityRepository;
	
	public City getCityById(String cityId) {
		City cityModel = cityRepository.findById(Integer.valueOf(cityId)).get();
		return cityModel;
	}
	
	public List<City> getAllCities() {
		List<City> listOfCities = cityRepository.findAll();
		return listOfCities;
	}

	public City updateAreaById(Integer cityId, Double area) {
		// TODO Auto-generated method stub
		City cityModel = getCityById(cityId.toString());
		cityModel.setArea(area);
		return cityRepository.save(cityModel);
	}

	public List<City> getAllCitiesByDistrict(String districtName) {
		// TODO Auto-generated method stub
		List<City> cities = cityRepository.findAllByDistrictName(districtName);
		return cities;
	}

	public City addCity(City city) {		// TODO Auto-generated method stub
		City cityModel =  cityRepository.save(city);
		return cityModel;
		
	}

}
