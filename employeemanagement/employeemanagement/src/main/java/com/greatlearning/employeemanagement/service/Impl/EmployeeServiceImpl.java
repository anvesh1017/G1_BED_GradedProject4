package com.greatlearning.employeemanagement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	  @Autowired
	  EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	    List<Employee> employees = employeeRepository.findAll();
	    return employees;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(int id, String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		
		 System.out.println("Student ID ->" + id);

		    Employee employeeObj = null;
		    if (id == 0) {

		    	employeeObj = new Employee(firstName, lastName, email);
		      System.out.println("Add employee Scenario");
		    } else {

		      System.out.println("Update employee Scenario");

		      employeeObj = this.findById(id);
		      employeeObj.setFirstName(firstName);
		      employeeObj.setLastName(lastName);
		      employeeObj.setEmail(email);
		    }

		    // Save/Update the student
		    this.save(employeeObj);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
