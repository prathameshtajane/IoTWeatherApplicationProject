package io.iotproj.weatherapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.entity.WeatherSensorDataWindEntity;

public interface WeatherSensorDataWindRepository extends Repository<WeatherSensorDataWindEntity,String>{
	public WeatherSensorDataWindEntity save(WeatherSensorDataWindEntity weatherSensorDataWindEntity);
	
	
	//@Query("SET FOREIGN_KEY_CHECKS = 0;TRUNCATE weather_sensor_data_wind_entity;SET FOREIGN_KEY_CHECKS = 1")
	@Modifying
	@Query("delete from WeatherSensorDataWindEntity")
	public void resetWeatherSensorDatabase();
}
