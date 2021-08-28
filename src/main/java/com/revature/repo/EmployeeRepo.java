package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Employee;

//we will extend JpaRepositiory to gain access to the methods and inject EmployeeRepo when we want to use it
//after JpaRepository in the< > we must stat the name of the class(modal) the the datatype of the primary key (id)
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
