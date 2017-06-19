package io.iotproj.weatherapp.service;

import java.util.List;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;

public interface WeatherSensorDataService {
	
	public List<WeatherSensorDataEntity> findAll();
	public WeatherSensorDataEntity findOne(String wSensorID);
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject);
	public WeatherSensorDataEntity update( WeatherSensorDataEntity WeatherSensorDataObject);
	public void delete(String wSensorID);
}
