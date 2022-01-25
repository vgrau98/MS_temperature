package com.insa.projet.microservices.temperature.model;

/**
 * 
 * @author grau
 * This class allows to implement a sensor value
 */
public class SensorValue {
	private double value;
	private String unit;
	private long timestamp;
	
	
	/**
	 * 
	 * @param value
	 * @param timestamp
	 * @param unit
	 */
	public SensorValue(double value, long timestamp, String unit) {

		this.value = value;
		this.timestamp = timestamp;
		this.unit=unit;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String unit) {
		this.unit=unit;
	}
	

}
