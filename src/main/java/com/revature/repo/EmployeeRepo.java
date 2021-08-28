package com.revature.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Employee;

//we will extend JpaRepositiory to gain access to the methods and inject EmployeeRepo when we want to use it
//after JpaRepository in the< > we must stat the name of the class(modal) the the datatype of the primary key (id)
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	//made to make this custom one instead of using JPA
	void deleteEmployeeById(Long id);

	//made to make this custom one instead of using JPA
	//using optional just incase we dont have that id  might add later
	Optional<Employee> findEmployeeById(Long id);

}
