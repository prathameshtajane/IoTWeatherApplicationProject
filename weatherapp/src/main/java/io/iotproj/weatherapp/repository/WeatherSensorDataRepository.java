package io.iotproj.weatherapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;

public interface WeatherSensorDataRepository extends Repository<WeatherSensorDataEntity,String> {
	
	@Modifying
	@Query("delete from WeatherSensorDataEntity")
	public void resetWeatherSensorDatabase();
	public List<WeatherSensorDataEntity> findAll();
	public Long count();
	public WeatherSensorDataEntity findOne(String wSensorID);
	public WeatherSensorDataEntity save(WeatherSensorDataEntity weatherSensorDataEntity);  
	public void delete(String wSensorID);

}
