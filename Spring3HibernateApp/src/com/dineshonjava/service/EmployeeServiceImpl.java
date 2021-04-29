package com.dineshonjava.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.bean.EmployeeBean;
import com.dineshonjava.dao.EmployeeDaoImpl;
import com.dineshonjava.model.Employee;


@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Transactional
	public void addEmployee(EmployeeBean employee) {
		
		employeeDao.addEmployee(employee);
	}

	@Transactional
	public List<EmployeeBean> listEmployeess() {
		return employeeDao.listEmployeess();
	}

	@Transactional
	public List<Employee> listAllEmployeess() {
		return employeeDao.listAllEmployeess();
	}

	@Transactional
	public Employee getEmployee(int empid) {
		return employeeDao.getEmployee(empid);
	}

	@Transactional
	public Employee updateEmployee(EmployeeBean bean) {
		return employeeDao.updateEmployee(bean);
	}

	@Transactional
	public void deleteEmployee(Integer employee) {
		employeeDao.deleteEmployee(employee);
	}
	
	
	@Transactional
	public ArrayList<EmployeeBean> getDistrictList(String state){
		ArrayList<EmployeeBean> bean = employeeDao.getDistrictList(state); 
		
		return bean;
	}
}
