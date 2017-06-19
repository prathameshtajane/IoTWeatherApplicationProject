package io.iotproj.weatherapp.entity;

public class WeatherSensorDataEntity {
	
	private String sensorId;
	private String city;
	private String description;
	private int humidity;
	private int pressure;
	private int temperature;
	private String wind;
	private String timestamp;
	
	/*{
  "city": "Chicago",
  "description": "scattered clouds",
  "humidity": 33,
  "pressure": 1020,
  "temperature": 25,
  "wind": {"speed": 3.1,"degree": 240},
  "timestamp": "2017-02-14T05:48:41.861Z"*/

	
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
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
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
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

}
