package io.iotproj.weatherapp.repository;

import java.util.List;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;

public interface WeatherSensorDataRepository {
	
	public List<WeatherSensorDataEntity> findAll();
	public WeatherSensorDataEntity findOne(String wSensorID);
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject);
	public WeatherSensorDataEntity update(WeatherSensorDataEntity WeatherSensorDataObject);
	public void delete(String wSensorID);

}
