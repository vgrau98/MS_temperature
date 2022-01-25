package com.insa.projet.microservices.temperature.controller;

import com.insa.projet.microservices.temperature.model.*;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 
 * @author grau
 * Expose resources for managing a database of temperature sensors each with an ID, a room and a list of values representing the history. 
 */
@RestController
public class temperatureRessource {

	public DataBase db = new DataBase();


	/**
	 * 
	 * @return the list of temperature sensors
	 */
	@GetMapping("/list")
	public List<TemperatureSensor> getListSensors() {
		for (int i = 0; i < db.getListSensors().size(); i++) {
			System.out.println(db.getListSensors().get(i));
		}
		return db.getListSensors();
	}

	
	/**
	 * 
	 * @param id
	 * @return a temperature sensor according to its id
	 */
	@GetMapping("/id/{id}")
	public TemperatureSensor getTemperatureSensorID(@PathVariable("id") int id) {

		int index = -1;
		for (int i = 0; i < db.getListSensors().size(); i++) {
			if (db.getListSensors().get(i).getId() == id) {
				index = i;
			}
		}
		return db.getListSensors().get(index);
	}

	/**
	 * 
	 * @param room
	 * @return a temperature sensor according to its room
	 */
	@GetMapping("/room/{room}")
	public TemperatureSensor getTemperatureSensorRoom(@PathVariable("room") int room) {

		int index = -1;
		for (int i = 0; i < db.getListSensors().size(); i++) {
			if (db.getListSensors().get(i).getRoom() == room) {
				index = i;
			}
		}
		return db.getListSensors().get(index);
	}
	
	/**
	 * 
	 * @param ID
	 * @return true if a sensor with the id exists. False otherwise
	 */
	@GetMapping("/sensorInID/{id}")
	public boolean sensorInDBbyID(@PathVariable ("id") int ID) {
		return db.sensorIsCreatedID(ID);
	}
	
	/**
	 * 
	 * @param id
	 * @param timestamp
	 * @return true if a value for a specific sensor has already been measured
	 */
	@GetMapping("/isMeasured/{id}/{timestamp}")
	public boolean alreadyMeasured(@PathVariable ("id") int id,@PathVariable ("timestamp") long timestamp) {
		
		boolean measured=false;
		TemperatureSensor sensor = getTemperatureSensorID(id);
		for(SensorValue v : sensor.getValues()) {
			if(v.getTimestamp()==timestamp) {
				measured=true;
			}
		}
		return measured;
	}
	
	/**
	 * 
	 * @param sensor, see class TemperatureSensor
	 */
	@PostMapping(path="/addSensor", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void addTemperatureSensor(@RequestBody TemperatureSensor sensor) {
		db.getListSensors().add(sensor);
	}
	
	
	
	/**
	 * 
	 * @param id, sensor id
	 * @param value, see SensorValue class
	 */
	@PostMapping(path = "addValueID/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addValueSensorID(@PathVariable("id") int id, @RequestBody SensorValue value) {
		int index = -1;
		for (int i = 0; i < db.getListSensors().size(); i++) {
			if (db.getListSensors().get(i).getId() == id) {
				index = i;
			}
		}

		db.getListSensors().get(index).addValue(value);
	}
	
	/**
	 * 
	 * @param room, sensor room. In our system we have one sensor by room
	 * @param value, 
	 */
	@PostMapping(path = "addValueRoom/{room}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addValueSensorRoom(@PathVariable("room") int room, @RequestBody SensorValue value) {
		int index = -1;
		for (int i = 0; i < db.getListSensors().size(); i++) {
			if (db.getListSensors().get(i).getRoom() == room) {
				index = i;
			}
		}

		db.getListSensors().get(index).addValue(value);
	}
}
