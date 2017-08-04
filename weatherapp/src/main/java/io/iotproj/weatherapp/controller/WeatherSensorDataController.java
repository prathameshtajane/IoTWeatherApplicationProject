package io.iotproj.weatherapp.controller;
import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.service.WeatherSensorDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@EnableAutoConfiguration

@RequestMapping(value="/sensordata")
@Api(tags="WeatherSensordata")
public class WeatherSensorDataController {
	
	WeatherSensorDataService weatherSensorDataService;  
	
	public WeatherSensorDataController(WeatherSensorDataService weatherSensorDataService){
		this.weatherSensorDataService=weatherSensorDataService;
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Find All Weather Sensordata", notes = "Returns a list of sensordata in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<WeatherSensorDataEntity> findAll(){
		return weatherSensorDataService.findAll();
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/{id}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Find Weather Sensordata By sensorId", notes = "Returns a requested sensordata by sensorId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherSensorDataEntity findOne(@PathVariable("id") String wSensorID){
		return weatherSensorDataService.findOne(wSensorID);
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/totalcount",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Find total count Sensordata entries present in the database", notes = "Returns a count of total sensor entries in present in the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Long findTotalCount(){
		return weatherSensorDataService.count();
	}
	
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/bulk/{count}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Find particular number of Sensor data entries", notes = "Returns a requested number of sensordata entries")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<WeatherSensorDataEntity> findAllByCount(@PathVariable("count") int count){
		return weatherSensorDataService.findAllByCount(count);
	}
	
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/reset",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Reset the database", notes = "Reset the sensor entries database to null state")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public void resetWeatherSensorDatabase(){
		weatherSensorDataService.resetWeatherSensorWindDatabase();
	}
	
	

	@RequestMapping(
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Create Sensor data entry", notes = "Creates a new sensor data entry")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherSensorDataEntity create( @RequestBody WeatherSensorDataEntity WeatherSensorDataObject){
		return weatherSensorDataService.create(WeatherSensorDataObject);
	}
	
	
	@RequestMapping(
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Updates Sensor data entry", notes = "Updates sensor data entry")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherSensorDataEntity update( @RequestBody WeatherSensorDataEntity WeatherSensorDataObject){
		return weatherSensorDataService.update(WeatherSensorDataObject);
	}
	
	@RequestMapping(
			method=RequestMethod.DELETE,
			value="/{id}")
	@ApiOperation(value = "Delete Sensor data by sensorId", notes = "Delete Sensor data by sensorId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public void delete(@PathVariable("id") String wSensorID){
		weatherSensorDataService.delete(wSensorID);
	}
}
