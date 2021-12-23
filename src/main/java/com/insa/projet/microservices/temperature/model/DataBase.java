package com.insa.projet.microservices.temperature.model;

import java.util.ArrayList;
import java.util.List;

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
	
	public void initDataBase(int n){
		
		this.listSensors.clear();
		for(int i=0;i<n;i++) {
			this.listSensors.add(new TemperatureSensor(i, i+100));
		}
		
	}
	
}
