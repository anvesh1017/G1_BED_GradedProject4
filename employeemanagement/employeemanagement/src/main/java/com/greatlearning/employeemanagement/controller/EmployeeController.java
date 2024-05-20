package com.greatlearning.employeemanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employees details from DB
		List<Employee> employees = employeeService.findAll();
		
		//add to the model
		theModel.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	//step1
	//show form - employee-form.html for saving employee details
	@RequestMapping("/showEmployeeForm")
	public String saveEmployee_Step1(Model theModel) {
		
		//create model attribute
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	//step2
	//save the employee details in DB
	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute("employee") Employee employee) {
		
		//save the employee
		employeeService.save(employee);
		
		//redirect to listing page
		return "redirect:/employees/list";
	}
	
	@RequestMapping("/showEmployeeForm_Update")
	public String updateEmployee_Step1(
			@RequestParam("employeeId") Integer employeeId,
			Model theModel) {
		
		Employee employee  = employeeService.findById(employeeId);
		theModel.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam("employeeId") Integer employeeId) {
		
		employeeService.deleteById(employeeId);
		
		return "redirect:/employees/list";
	}
	
	
	@RequestMapping(value = "/403")
	public ModelAndView handleAccessDeniedError(Principal user) {

	  ModelAndView model = new ModelAndView();

	  if (user != null) {
	    model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
	  } else {
	    model.addObject("msg", "You do not have permission to access this page!");
	  }

	  model.setViewName("authorization-error-403");
	  return model;
	}  
}