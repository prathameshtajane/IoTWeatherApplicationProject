package io.iotproj.weatherapp.service;

import java.util.List;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;

public interface WeatherSensorDataService {
	
	public List<WeatherSensorDataEntity> findAll();
	
	
	public Long count();
	public WeatherSensorDataEntity findOne(String wSensorID);
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject);
	public WeatherSensorDataEntity update( WeatherSensorDataEntity WeatherSensorDataObject);
	public List<WeatherSensorDataEntity> findAllByCount(int count);
	public void delete(String wSensorID);
	public void resetWeatherSensorWindDatabase();
}
