package com.dineshonjava.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.bean.EmployeeBean;
import com.dineshonjava.model.District;
import com.dineshonjava.model.Employee;


@Repository
public class EmployeeDaoImpl{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addEmployee(EmployeeBean eb) {

		sessionFactory.getCurrentSession();
		
		Session ses = sessionFactory.openSession();
		Employee data = new Employee();

		System.out.println("userName"+eb.getStudentid());
		System.out.println("Password"+eb.getUsername());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getSchoolcode());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getStandard());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getSection());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getMedium());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getType());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getAddress());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getMandal());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getDistrict());
		System.out.println("EmployeeDaoImpl.addEmployee()"+eb.getState());

        data.setStudentid(eb.getStudentid());
        data.setUserName(eb.getUsername());
        data.setSchoolCode(eb.getSchoolcode());
        data.setStandard(eb.getStandard());
        data.setSection(eb.getSection());
        data.setMedium(eb.getMedium());
        data.setType(eb.getType());
        data.setAddress(eb.getAddress());
        data.setMandal(eb.getMandal());
        data.setDistrict(eb.getDistrict());
        data.setState(eb.getState());
        
		org.hibernate.Transaction tx =  ses.beginTransaction();
		ses.save(data);

		tx.commit();
		ses.close();
	}

	public List<EmployeeBean> listEmployeess() {

		List<EmployeeBean> empBean = new ArrayList<EmployeeBean>();

		sessionFactory.getCurrentSession();
		Session ses = sessionFactory.openSession();
		Query qry = ses.createQuery("from Employee");
		List list = qry.list();
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			EmployeeBean bean = new EmployeeBean();
			Object obj = itr.next();
			Employee emp =(Employee)obj;
			
			
			bean.setStudentid(emp.getStudentid());
			bean.setUsername(emp.getUserName());
			bean.setSchoolcode(emp.getSchoolCode());
			bean.setStandard(emp.getStandard());
			bean.setSection(emp.getSection());
			bean.setMedium(emp.getMedium());
			bean.setType(emp.getType());
			bean.setAddress(emp.getAddress());
			bean.setMandal(emp.getMandal());
			bean.setDistrict(emp.getDistrict());
			bean.setState(emp.getState());
			
			empBean.add(bean);
		}

		// return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		return empBean;
	}

	public List<Employee> listAllEmployeess() {

		List<Employee> listEmployee  = new ArrayList<Employee>();
		sessionFactory.getCurrentSession();
		Session ses = sessionFactory.openSession();
		Query qry = ses.createQuery("from Employee");
		List list = qry.list();
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			Object obj = itr.next();
			Employee emp =(Employee)obj;
			listEmployee.add(emp);
		}
		return listEmployee;
	}

	public Employee getEmployee(int empid) {
		// return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);

		sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Object obj = session.get(Employee.class,empid);
		Employee details = (Employee)obj;
		return details;
	}

	//single employye update operation using SESSION obj
	public Employee updateEmployee(EmployeeBean bean) {

		sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		System.out.println("Its Executing");
		Object obj = session.get(Employee.class,bean.getUserName());
		Employee details = (Employee)obj;

		org.hibernate.Transaction tx = session.beginTransaction();
		details.setPassword(bean.getEmpPassword());
		details.setRoleId(bean.getRoleid());
		details.setDistrictId(bean.getDistrictid());
		details.setmSchoolCode(bean.getMschoolCode());

		session.update(details);

		tx.commit();
		session.close();
		return details;
	}
	
	
	//single employye delete operation using SESSION obj
	public void deleteEmployee(Integer bean) {
		// sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getUserName()).executeUpdate();
		sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		System.out.println("Its Executing");
		Object obj = session.get(Employee.class,bean);
		Employee details = (Employee)obj;

		org.hibernate.Transaction tx  = session.beginTransaction();
		session.delete(details);

		tx.commit();
		session.close();

	}
	
	public ArrayList<EmployeeBean> getDistrictList(String state_name){
		
		ArrayList<EmployeeBean> employeeBean_DistrcitList = new ArrayList<EmployeeBean>();
		
		sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Query qry = session.createQuery("from District d where d.state= :state");
         
		qry.setParameter("state",state_name);
		List list =qry.list();
		Iterator it = list.iterator();

		while(it.hasNext())
		{
			EmployeeBean bean        = new EmployeeBean();
			Object obj               = (Object)it.next();
			District district_Model  = (District) obj;
			
			bean.setDistrict_ID(district_Model.getDistrict_ID());
			bean.setDistrict_Name(district_Model.getDistrict_Name());
			employeeBean_DistrcitList.add(bean);
		}			
		return employeeBean_DistrcitList;
	}
}