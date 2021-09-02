package com.crashcourse.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crashcourse.tutorial.entity.Employee;
import com.crashcourse.tutorial.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employees") 
	public List<Employee> fetchEmployee() {
		return employeeService.fetchEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@DeleteMapping("/employees/{id}") 
	public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return "deleted successfully";
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@GetMapping("/employees/name/{name}") 
	public Employee findEmployeeById(@PathVariable("name") String employeeName) {
		return employeeService.findEmployeeById(employeeName);
	}
}
