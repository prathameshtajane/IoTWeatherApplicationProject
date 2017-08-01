package io.iotproj.weatherapp.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(
		{
			@NamedQuery(name="WeatherSensorDataEntity.findAllData",query="SELECT u from WeatherSensorDataEntity u ORDER BY u.sensorId")
		}
		)

public class WeatherSensorDataEntity {
	
	@Id
	private String sensorId;
	private String city;
	private String description;
	private int humidity;
	private int pressure;
	private int temperature;
	
	@OneToOne
	private WeatherSensorDataWindEntity wind;
	
	private String timestamp;
	
   public WeatherSensorDataEntity(){
	   this.sensorId=UUID.randomUUID().toString();
   }
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSensorId() {
		return sensorId;
	}

	public WeatherSensorDataWindEntity getWind() {
		return wind;
	}

	public void setWind(WeatherSensorDataWindEntity wind) {
		this.wind = wind;
	}


}
