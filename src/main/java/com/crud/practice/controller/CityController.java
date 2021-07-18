package com.crud.practice.controller;

import java.util.List;

import com.crud.practice.services.CityServices;
import com.crud.practice.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/city")
public class CityController {
	
	@Autowired
	CityServices cityServices;
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/id/{cityId}")
	public ResponseEntity getCityInfo(@PathVariable("cityId") String cityId) {
		City city= cityServices.getCityById(cityId);
		System.out.println("Entering..");
		
		return ResponseEntity.ok(city);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/cities")
	public ResponseEntity getAllCityInfo() {
		List<City> list = cityServices.getAllCities(); 
		return ResponseEntity.ok(list);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/updateArea/id/{cityId}/area/{area}")
	public ResponseEntity updateAreaByCityId(@PathVariable("cityId") Integer cityId, @PathVariable("area") Double area) {
		return ResponseEntity.ok(cityServices.updateAreaById(cityId,area));
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/citiesByDistrict/districtName/{districtName}")
	public ResponseEntity getAllCityInfoByDistrict(@PathVariable("districtName") String districtName) {
		List<City> list = cityServices.getAllCitiesByDistrict(districtName); 
		return ResponseEntity.ok(list);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/addNewCity")
	public ResponseEntity addCity(@RequestBody City city) {
		return ResponseEntity.ok(cityServices.addCity(city));
	}
}
