package com.dineshonjava.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dineshonjava.bean.EmployeeBean;
import com.dineshonjava.model.Employee;
import com.dineshonjava.service.EmployeeServiceImpl;


@Controller
public class EmployeeController {


	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean,
			BindingResult result) {
		// Employee employee = prepareModel(employeeBean);
		// employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	/*model.addAttribute("emp", new EmployeeBean());
	@ModelAttribute("emp") EmployeeBean eb
	
	Model and @ModelAttribute those both are working 
	as same */
	
	
	@RequestMapping(value="/add.htm",method=RequestMethod.GET)
	public String getRegisterPage(Model model)
	{
		model.addAttribute("emp", new EmployeeBean()); 
		return "MyAddEmployee";
	}

	@RequestMapping(value="/add.htm",method=RequestMethod.POST)
	public ModelAndView getSubmitPage(@ModelAttribute("emp") EmployeeBean eb)
	{
		System.out.println("EmployeeController.getSubmitPage()");
		ModelAndView mav = new ModelAndView();
		employeeService.addEmployee(eb);
		mav.setViewName("MyAddEmployee");
		return mav;
		//		return new ModelAndView("redirect:/employees.htm","","");
	}

	/*@RequestMapping(value="districtList.htm",method=RequestMethod.POST)
	public ModelAndView getDistrictList(@ModelAttribute("emp") EmployeeBean eb,HttpServletRequest request,Model model){

		ModelAndView mav                      = new ModelAndView();
		String state_Name 	                  = request.getParameter("state");
		List<EmployeeBean> districtList       = employeeService.getDistrictList(state_Name);
		HashMap<String,String> districtIDName = new HashMap<String,String>();

		for(int i=0;i<districtList.size();i++)
		{
			String district_ID   =  String.valueOf(districtList.get(i).getDistrict_ID());
			String  district_Name =  districtList.get(i).getDistrict_Name();
			System.out.println("EmployeeController.getDistrictList():::::"+String.valueOf(districtList.get(i).getDistrict_ID()));
			System.out.println("EmployeeController.getDistrictList():::::"+ districtList.get(i).getDistrict_Name());
			districtIDName.put(district_ID,district_Name);
		}

		model.addAttribute("districtIDName", districtIDName);
		request.setAttribute("districtIDName", districtIDName);
		mav.setViewName("MyAddEmployee");
		return 	new ModelAndView("MyAddEmployee","districtIDName",districtIDName);
	}*/


	@RequestMapping(value="/employees.htm", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		// Map<String, Object> model = new HashMap<String, Object>();
		// model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		// return new ModelAndView("employeesList", model);

		List<EmployeeBean> eb= employeeService.listEmployeess();
		return new ModelAndView("employeesList","employees",eb);
	}


	@RequestMapping(value = "/editEmployee.htm", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result,HttpServletRequest request)
	{
		Integer userName          = Integer.parseInt(request.getParameter("id"));
		Map<String, Object> model = new HashMap<String, Object>();
		Employee emp              = employeeService.getEmployee(userName);
		List<Employee> listEmp    = employeeService.listAllEmployeess();
		model.put("employee", prepareEmployeeBean(emp));
		model.put("employees", prepareListofBean(listEmp));
		return new ModelAndView("addEmployee",model);
	}

	@RequestMapping(value = "/updateEmployee.htm", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result,HttpServletRequest request)
	{
		employeeService.updateEmployee(employeeBean);
		return new ModelAndView("redirect:/employees.htm","","");
	}

	@RequestMapping(value = "/deleteEmployee.htm",method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result,HttpServletRequest request)
	{
		Integer userName          = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(userName);
		return new ModelAndView("redirect:/employees.htm","","");
	}


	/*@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}*/

	/*private Employee prepareModel(EmployeeBean employeeBean){
		Employee employee = new Employee();
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}*/

	private List<EmployeeBean> prepareListofBean(List<Employee> employees)
	{
		List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
		if(employees != null && !employees.isEmpty())
		{
			for(Employee employee : employees)
			{
				EmployeeBean bean = new EmployeeBean();
				bean.setUserName(employee.getUserName());
				bean.setEmpPassword(employee.getPassword());
				bean.setRoleid(employee.getRoleId());
				bean.setDistrictid(employee.getDistrictId());
				bean.setMschoolCode(employee.getmSchoolCode());
				beans.add(bean);
			}
		}
		return beans;
	}

	private EmployeeBean prepareEmployeeBean(Employee employee)
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setUserName(employee.getUserName());
		bean.setEmpPassword(employee.getPassword());
		bean.setRoleid(employee.getRoleId());
		bean.setDistrictid(employee.getDistrictId());
		bean.setMschoolCode(employee.getmSchoolCode());
		return bean;
	}
}