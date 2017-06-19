package io.iotproj.weatherapp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.exceptions.BadRequestException;
import io.iotproj.weatherapp.exceptions.DataNotFoundException;
import io.iotproj.weatherapp.repository.WeatherSensorDataRepository;
import io.iotproj.weatherapp.service.WeatherSensorDataService;

@Service
public class WeatherSensorDataServiceImpl implements WeatherSensorDataService{
	
	WeatherSensorDataRepository weatherSensorDataRepository;
	
	public WeatherSensorDataServiceImpl(WeatherSensorDataRepository weatherSensorDataRepository){
		this.weatherSensorDataRepository=weatherSensorDataRepository;
	}

	@Override
	public List<WeatherSensorDataEntity> findAll() {
		return this.weatherSensorDataRepository.findAll();
	}

	@Override
	public WeatherSensorDataEntity findOne(String wSensorID) {
		WeatherSensorDataEntity existingEntity=this.weatherSensorDataRepository.findOne(wSensorID);
		if(existingEntity == null){
			throw new DataNotFoundException("Sensor data unavailable for sensor identification : "+wSensorID);
		}
		return existingEntity;
	}	

	@Override
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject){
		return this.weatherSensorDataRepository.create(WeatherSensorDataObject);
	}

	@Override
	public WeatherSensorDataEntity update(WeatherSensorDataEntity WeatherSensorDataObject){
		String sensorId=WeatherSensorDataObject.getSensorId();
		WeatherSensorDataEntity tempWeatherSensorDataObject;
		tempWeatherSensorDataObject=this.weatherSensorDataRepository.findOne(sensorId);
		if(tempWeatherSensorDataObject == null){
			throw new BadRequestException("Unable to find sensor data from sensor "+WeatherSensorDataObject); 
		}
		return this.weatherSensorDataRepository.update(tempWeatherSensorDataObject);
	}

	@Override
	public void delete(String wSensorID) {
		
		WeatherSensorDataEntity tempWeatherSensorDataObject;
		tempWeatherSensorDataObject=this.weatherSensorDataRepository.findOne(wSensorID);
		if(tempWeatherSensorDataObject == null){
			throw new BadRequestException("Unable to find sensor data from sensor ID : "+wSensorID); 
		}
		this.weatherSensorDataRepository.delete(wSensorID);		
	}

}
