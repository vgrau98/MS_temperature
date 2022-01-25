package com.insa.projet.microservices.temperature.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author grau
 * This class allows to implement a database of temperature sensors
 */
public class DataBase {
	
	private List<TemperatureSensor> listSensors;

	public DataBase() {
		listSensors=new ArrayList<TemperatureSensor>();
			}

	public List<TemperatureSensor> getListSensors() {
		return listSensors;
	}

	public void setListSensors(List<TemperatureSensor> listSensors) {
		this.listSensors = listSensors;
	}
	
	/**
	 * 
	 * @param ID
	 * @return true if sensor created or false otherwise
	 */
	public boolean sensorIsCreatedID(int ID) {
		boolean test=false;
		for(int i=0;i<this.listSensors.size();i++) {
			if(this.listSensors.get(i).getId()==ID) {
				test=true;
			}
		}
		return test;
	}
	
}
