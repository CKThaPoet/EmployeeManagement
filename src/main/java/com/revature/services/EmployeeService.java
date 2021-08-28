package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.exceptions.UserNotFoundException;
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
	
	//make a method that returns the list of employees using a list<generic> and JPA methods
	public List<Employee> findallEmployees(){
		return employeeRepo.findAll();
	}
	
	//a method to update employee information
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//method to find an employee by their id
	public Employee findEmployeeById(Long id) {
		//use orElseThrow if they dont find an employee by that id it will go to the exception
		//add custom message with do the rest later .orElseThrow(() -> new UserNotFoundException ("User by id " + id + " was not found."));
		//using a lamda here it is singleton executes once
		return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException ("User by is " + id + " was not found"));
	}
	
	//method to delete a employee
	//set retun type to void because we are not returning anything
	public void deleteEmployeeById(Long id) {
		//pass id as a parameter
	employeeRepo.deleteEmployeeById(id);	
	}
}
