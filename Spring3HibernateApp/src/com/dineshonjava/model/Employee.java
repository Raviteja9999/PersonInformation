package com.dineshonjava.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee implements Serializable{


	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="student_id")//student distid
	private Integer studentid;

	@Column(name = "name")//studentname
	private String userName;

	@Column(name="student_school_code")//student sch code
	private String SchoolCode;

	@Column(name="standard")
	private String standard;//student class

	@Column(name="section")
	private String section;//student section

	@Column(name="medium")
	private String medium;//student medium

	@Column(name="type")
	private String type;//student type

	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="district")
	private String district;

	@Column(name="mandal")
	private String mandal;

	
	

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSchoolCode() {
		return SchoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		SchoolCode = schoolCode;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
