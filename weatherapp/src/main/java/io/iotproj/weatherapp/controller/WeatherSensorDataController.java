package io.iotproj.weatherapp.controller;
import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.service.WeatherSensorDataService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value="/sensordata")
public class WeatherSensorDataController {
	
	WeatherSensorDataService weatherSensorDataService;  
	
	public WeatherSensorDataController(WeatherSensorDataService weatherSensorDataService){
		this.weatherSensorDataService=weatherSensorDataService;
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<WeatherSensorDataEntity> findAll(){
		return weatherSensorDataService.findAll();
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/{id}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WeatherSensorDataEntity findOne(@PathVariable("id") String wSensorID){
		return weatherSensorDataService.findOne(wSensorID);
	}
	
	@RequestMapping(
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WeatherSensorDataEntity create( @RequestBody WeatherSensorDataEntity WeatherSensorDataObject){
		return weatherSensorDataService.create(WeatherSensorDataObject);
	}
	
	
	@RequestMapping(
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WeatherSensorDataEntity update( @RequestBody WeatherSensorDataEntity WeatherSensorDataObject){
		return weatherSensorDataService.update(WeatherSensorDataObject);
	}
	
	@RequestMapping(
			method=RequestMethod.DELETE,
			value="/{id}")
	public void delete(@PathVariable("id") String wSensorID){
		weatherSensorDataService.delete(wSensorID);
	}
}
