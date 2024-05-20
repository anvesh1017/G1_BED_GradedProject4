package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Employee;

public interface EmployeeService {
	
	  public List<Employee> findAll();
	  
	  public void save(Employee employee);
	  
	  public Employee findById(int id);
	  
	  public void saveOrUpdate(int id, String firstName, String lastName, String email);
	  
	  public void deleteById(int id);

}
 