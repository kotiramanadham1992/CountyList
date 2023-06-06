package com.example.sample.koti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CountyTable {
	public CountyTable() {}
	
	public CountyTable(int fips, String state, String name) {
		super();
		this.fips = fips;
		this.state = state;
		this.name = name;
	}

	@Id	
	@GeneratedValue
	private int fips;
	
	private String state;
	
	private String name;

	public int getFips() {
		return fips;
	}

	public void setFips(int fips) {
		this.fips = fips;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CountyTable [fips=" + fips + ", state=" + state + ", name=" + name + "]";
	}
	
	
	

}
