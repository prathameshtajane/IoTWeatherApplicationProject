package io.iotproj.weatherapp.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WeatherSensorDataWindEntity {
	
	@Id
	private String windEntityId;
	private float speed;
	private int degree;
	
	public WeatherSensorDataWindEntity(){
		this.windEntityId=UUID.randomUUID().toString();
	}
	
	public String getWindEntityId() {
		return windEntityId;
	}
	
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
		
}
