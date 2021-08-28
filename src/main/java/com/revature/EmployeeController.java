package com.revature;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

//combines the two annotations of @Controller Stereotype Annotation For MVC, it indicates that the class will handle HTTP requests from DispatcherServlet. and 
//@ResponseBody -converts the body of our response to JSON. Can be placed at the method level or the class level.
@RestController

//Specifies the path URI that will be delegated to this controller class. We can also use it to specify particular HTTP verbs using Get or Post mapping
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//get request from database get all employees
	@GetMapping("/all")
	//ResponseEntity to return an http response because its a generic we must specify what type of data in the<> 
	//since we are using another generic as the type we must specify the type for that one as well in <>
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		//list of employess from the service using the finall all method
		List<Employee> employees= employeeService.findAllEmployees();
		
		//return the responseeneity with the variable employees *we have all the employees and the the status code
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	//get request from database to find employee by id
	//this time use path variable with id to get the id
		@GetMapping("/find{id}")
		//ResponseEntity to return an http response because its a generic we must specify what type of data in the<> 
		//just employee this time that is all we are returing
		//use path variable annotation
		//what is in the get mapping {} must match what is in the path variable
		public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
			
			//find an employee from the service using the find by id method
			Employee employee= employeeService.findEmployeeById(id);
			
			//return the responseeneity with the variable employees *we have all the employees and the the status code
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		
		//send data to the database to add a new employee
		@PostMapping("/add")
		
		//request body parses the JSON of a request to an object specified in the parameters of a controller’s method
		//we are expecting the whole employee object 
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
			Employee newEmployee = employeeService.addEmployee(employee);
			return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		}
		
		
		//request to update a part of the database
				@PutMapping("/update")
				public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
					//using update methhod from service 
					Employee updateEmployee = employeeService.updateEmployee(employee);
					return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
				}
				
				//delete data from a part of the database
				//using path variable with the id
				@DeleteMapping("/delete/{id}")
				
				//use path variable annotation
				//use wildcard ? as the type in genereic<>
				//what is in the get mapping {} must match what is in the path variable
				public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
					 
					employeeService.deleteEmployee(id);
					return new ResponseEntity<>(HttpStatus.OK);
				}
}
