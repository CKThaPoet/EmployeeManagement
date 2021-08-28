package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Employee;
import com.revature.repo.EmployeeRepo;

//thi is the service class we will use in the controller
public class EmployeeService {

	//create an object of the Employee Repo class so I can have access to the JPA methods
	private final EmployeeRepo employeeRepo;
	
	//to be used for crud oprations
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	//add method for employee by passing an object of the class
	//remeber repo class that is extending the JPA methods
	//use save method to presist to the database
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
}
