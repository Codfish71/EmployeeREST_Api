package com.crashcourse.tutorial.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crashcourse.tutorial.entity.Employee;
import com.crashcourse.tutorial.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	public List<Employee> fetchEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employee) {
		Employee empDb = employeeRepository.findById(employeeId).get();
		if (Objects.nonNull(empDb.getEmployeeName()) && !"".equalsIgnoreCase(empDb.getEmployeeName())) {
			empDb.setEmployeeName(empDb.getEmployeeName());
		}
		if (Objects.nonNull(empDb.getNumber()) && !"".equalsIgnoreCase(empDb.getNumber())) {
			empDb.setNumber(empDb.getNumber());
		}
		

		return employeeRepository.save(empDb);

	}

	@Override
	public Employee findEmployeeById(String employeeName) {
		
		return employeeRepository.findByEmployeeName(employeeName) ;
	}

}
