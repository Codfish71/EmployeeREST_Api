package com.crashcourse.tutorial.services;

import java.util.List;

import com.crashcourse.tutorial.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> fetchEmployees();

	public Employee fetchEmployeeById(Long employeeId);

	public void deleteEmployeeById(Long employeeId);

	public Employee updateEmployee(Long employeeId, Employee employee);

	public Employee findEmployeeById(String employeeName);

	
}
