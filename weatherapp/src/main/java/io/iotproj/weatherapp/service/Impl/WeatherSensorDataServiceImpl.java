package io.iotproj.weatherapp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.entity.WeatherSensorDataWindEntity;
import io.iotproj.weatherapp.exceptions.BadRequestException;
import io.iotproj.weatherapp.exceptions.DataNotFoundException;
import io.iotproj.weatherapp.repository.WeatherSensorDataRepository;
import io.iotproj.weatherapp.repository.WeatherSensorDataWindRepository;
import io.iotproj.weatherapp.service.WeatherSensorDataService;

@Service
public class WeatherSensorDataServiceImpl implements WeatherSensorDataService{
	
	WeatherSensorDataRepository weatherSensorDataRepository;
	WeatherSensorDataWindRepository weatherSensorDataWindRepository;
	
	public WeatherSensorDataServiceImpl(WeatherSensorDataRepository weatherSensorDataRepository,WeatherSensorDataWindRepository weatherSensorDataWindRepository){
		this.weatherSensorDataRepository=weatherSensorDataRepository;
		this.weatherSensorDataWindRepository=weatherSensorDataWindRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<WeatherSensorDataEntity> findAll() {
		return this.weatherSensorDataRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public WeatherSensorDataEntity findOne(String wSensorID) {
		WeatherSensorDataEntity existingEntity=this.weatherSensorDataRepository.findOne(wSensorID);
		if(existingEntity == null){
			throw new DataNotFoundException("Sensor data unavailable for sensor identification : "+wSensorID);
		}
		return existingEntity;
	}	

	@Override
	@Transactional
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject){
		WeatherSensorDataWindEntity tempWeatherSensorDataWindEntity=weatherSensorDataWindRepository.save(WeatherSensorDataObject.getWind());
		return this.weatherSensorDataRepository.save(WeatherSensorDataObject);
	}

	@Override
	@Transactional(readOnly=true)
	public WeatherSensorDataEntity update(WeatherSensorDataEntity WeatherSensorDataObject){
		
		String sensorId=WeatherSensorDataObject.getSensorId();
		WeatherSensorDataEntity tempWeatherSensorDataObject;
		tempWeatherSensorDataObject=this.weatherSensorDataRepository.findOne(sensorId);
		if(tempWeatherSensorDataObject == null){
			throw new BadRequestException("Unable to find sensor data from sensor "+WeatherSensorDataObject); 
		}else{
			return create(WeatherSensorDataObject);
			}
	}

	@Override
	@Transactional(readOnly=true)
	public void delete(String wSensorID) {
		
		WeatherSensorDataEntity tempWeatherSensorDataObject;
		tempWeatherSensorDataObject=this.weatherSensorDataRepository.findOne(wSensorID);
		if(tempWeatherSensorDataObject == null){
			throw new BadRequestException("Unable to find sensor data from sensor ID : "+wSensorID); 
		}
		this.weatherSensorDataRepository.delete(wSensorID);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return this.weatherSensorDataRepository.count();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<WeatherSensorDataEntity> findAllByCount(int count) {
		if(this.weatherSensorDataRepository.count() < count){
			return this.weatherSensorDataRepository.findAll();	
		}else{
		return this.weatherSensorDataRepository.findAll().subList(0, count);}
	}

	
	@Override
	@Transactional
	public void resetWeatherSensorWindDatabase() {
		this.weatherSensorDataRepository.resetWeatherSensorDatabase();
		this.weatherSensorDataWindRepository.resetWeatherSensorDatabase();
	}
	

}
