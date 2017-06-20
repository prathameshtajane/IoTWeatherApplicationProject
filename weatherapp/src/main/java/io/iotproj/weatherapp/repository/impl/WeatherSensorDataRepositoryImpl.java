package io.iotproj.weatherapp.repository.impl;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.iotproj.weatherapp.entity.WeatherSensorDataEntity;
import io.iotproj.weatherapp.repository.WeatherSensorDataRepository;

@Repository
public class WeatherSensorDataRepositoryImpl implements WeatherSensorDataRepository{

	@PersistenceContext
    EntityManager em;
	
	@Override
	public List<WeatherSensorDataEntity> findAll() {	
		List<WeatherSensorDataEntity> WeatherSensorDataEntityList = new ArrayList<WeatherSensorDataEntity>();
		TypedQuery<WeatherSensorDataEntity> query = em.createNamedQuery("WeatherSensorDataEntity.findAllData", WeatherSensorDataEntity.class);
		WeatherSensorDataEntityList=query.getResultList();
		if(WeatherSensorDataEntityList.isEmpty()){
			return WeatherSensorDataEntityList;
		}else{
			return null;
		}
		
	}

	@Override
	public WeatherSensorDataEntity findOne(String wSensorID) {
		return em.find(WeatherSensorDataEntity.class,wSensorID);
	}

	@Override
	@Transactional
	public WeatherSensorDataEntity create(WeatherSensorDataEntity WeatherSensorDataObject) {
		em.persist(WeatherSensorDataObject.getWind());
		em.persist(WeatherSensorDataObject);
		return WeatherSensorDataObject;
	}

	@Override
	public WeatherSensorDataEntity update(WeatherSensorDataEntity WeatherSensorDataObject) {
		return em.merge(WeatherSensorDataObject);
	}

	@Override
	public void delete(String wSensorID){
		WeatherSensorDataEntity entityToBeDeleted;
		entityToBeDeleted=findOne(wSensorID);
		em.remove(entityToBeDeleted);
	}

}
