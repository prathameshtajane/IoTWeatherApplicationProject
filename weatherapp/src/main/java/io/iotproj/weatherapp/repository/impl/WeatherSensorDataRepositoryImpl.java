package io.iotproj.weatherapp.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.repository.WeatherSensorDataRepository;

@Repository
public class WeatherSensorDataRepositoryImpl implements WeatherSensorDataRepository{

	@Override
	public List<WeatherSensorDataEntity> findAll() {
		WeatherSensorDataEntity testObj1= new WeatherSensorDataEntity();
		testObj1.setSensorId("1");
		testObj1.setCity("Chicago");
		testObj1.setDescription("testDescription");
		testObj1.setHumidity(123);
		testObj1.setPressure(1234);
		testObj1.setTemperature(123);
		testObj1.setTimestamp("Some test timestamp");
		testObj1.setWind("north");
	
		List<WeatherSensorDataEntity> testWeatherlist = new ArrayList<WeatherSensorDataEntity>();
		testWeatherlist.add(testObj1);
		return testWeatherlist;
	}

	@Override
	public WeatherSensorDataEntity findOne(String wSensorID) {
		WeatherSensorDataEntity testObj1= new WeatherSensorDataEntity();
		testObj1.setSensorId("2");
		testObj1.setCity("Chicago");
		testObj1.setDescription("testDescription");
		testObj1.setHumidity(123);
		testObj1.setPressure(1234);
		testObj1.setTemperature(123);
		testObj1.setTimestamp("Some test timestamp");
		testObj1.setWind("north");
		if(Integer.parseInt(wSensorID) == Integer.parseInt(testObj1.getSensorId())){
		return testObj1;
		}
		else{
			return null;
		}
	}

	@Override
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject) {
		WeatherSensorDataEntity testObj1= new WeatherSensorDataEntity();
		testObj1.setSensorId("createObjectTest");
		testObj1.setCity("Chicago");
		testObj1.setDescription("testDescription");
		testObj1.setHumidity(123);
		testObj1.setPressure(1234);
		testObj1.setTemperature(123);
		testObj1.setTimestamp("Some test timestamp");
		testObj1.setWind("north");
		return testObj1;
	}

	@Override
	public WeatherSensorDataEntity update(WeatherSensorDataEntity WeatherSensorDataObject) {
		WeatherSensorDataEntity testObj1= new WeatherSensorDataEntity();
		testObj1.setSensorId("updateObjectTest");
		testObj1.setCity("Chicago");
		testObj1.setDescription("testDescription");
		testObj1.setHumidity(123);
		testObj1.setPressure(1234);
		testObj1.setTemperature(123);
		testObj1.setTimestamp("Some test timestamp");
		testObj1.setWind("north");
		return testObj1;
	}

	@Override
	public void delete(String wSensorID) {
		WeatherSensorDataEntity testObj1= new WeatherSensorDataEntity();
		testObj1.setSensorId("deleteObjectTest");
		testObj1.setCity("Chicago");
		testObj1.setDescription("testDescription");
		testObj1.setHumidity(123);
		testObj1.setPressure(1234);
		testObj1.setTemperature(123);
		testObj1.setTimestamp("Some test timestamp");
		testObj1.setWind("north");
	}

}
