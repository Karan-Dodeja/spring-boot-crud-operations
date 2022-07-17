package com.springboot.crud.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crud.model.Employee;
import com.springboot.crud.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	// Show Data
	@Override
	public List<Employee> getAllEmplyees() {
		return employeeRepository.findAll(); // FindAll() Return list of employees
	}
	// Add Data
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);		
	}
	// Update Data
	@Override
	public Employee getEmployeeById(long id) {	
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()){
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee Not Found For Id" + id);
		}
		return employee;
	}
	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}
}
