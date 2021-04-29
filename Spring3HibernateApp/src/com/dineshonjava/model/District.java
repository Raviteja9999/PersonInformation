package com.dineshonjava.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="district")
public class District implements Serializable{
	
	@Id
	@Column(name="district_ID")
	private Integer district_ID;
	
	@Column(name = "district_Name")
	private String district_Name;
	
	@Column(name = "state")
	private String state;

	//setters and getters
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getDistrict_ID() {
		return district_ID;
	}
	public void setDistrict_ID(Integer district_ID) {
		this.district_ID = district_ID;
	}
	public String getDistrict_Name() {
		return district_Name;
	}
	public void setDistrict_Name(String district_Name) {
		this.district_Name = district_Name;
	}
}
