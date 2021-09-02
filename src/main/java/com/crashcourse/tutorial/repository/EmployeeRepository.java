package com.crashcourse.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crashcourse.tutorial.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	//word after find must match with parameter of the employee entity which you want to find
	public Employee findByEmployeeName(String employeeName); 
}
