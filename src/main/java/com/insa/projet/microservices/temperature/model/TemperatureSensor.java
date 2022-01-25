package com.insa.projet.microservices.temperature.model;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author grau
 * This class allows to implement a temperature sensor
 */
public class TemperatureSensor {
	
	private int id;
	private int room;
	private List<SensorValue> values;
	
	/**
	 * 
	 * @param id
	 * @param room
	 */
	public TemperatureSensor(int id, int room) {
		this.id = id;
		this.room = room;
		values= new ArrayList<SensorValue>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public List<SensorValue> getValues() {
		return values;
	}
	
	public void addValue(SensorValue value) {
		this.values.add(value);
	}
	
}
