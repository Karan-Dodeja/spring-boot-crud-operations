package com.springboot.crud.services;

import java.util.List;

import com.springboot.crud.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmplyees();
	void saveEmployee(Employee employee); 
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
