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

@RestController
public class temperatureRessource {

	public DataBase db = new DataBase();

	@PostMapping(path = "init/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TemperatureSensor> initDataBase(@PathVariable int n) {
		db.initDataBase(n);
		return db.getListSensors();
	}

	@GetMapping("/list")
	public List<TemperatureSensor> getListSensors() {
		for (int i = 0; i < db.getListSensors().size(); i++) {
			System.out.println(db.getListSensors().get(i));
		}
		return db.getListSensors();
	}

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
	
	@GetMapping("/sensorInID/{id}")
	public boolean sensorInDBbyID(@PathVariable ("id") int ID) {
		return db.sensorIsCreatedID(ID);
	}
	
	@PostMapping(path="/addSensor", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void addTemperatureSensor(@RequestBody TemperatureSensor sensor) {
		db.getListSensors().add(sensor);
	}
	
	

	@PostMapping(path = "addValueID/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addValueSensorID(@PathVariable("id") int id, @RequestBody SensorValue value) {
		int index = -1;
		for (int i = 0; i < db.getListSensors().size(); i++) {
			if (db.getListSensors().get(i).getId() == id) {
				index = i;
			}
		}

		db.getListSensors().get(index).addValue(value);
	}
	
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
