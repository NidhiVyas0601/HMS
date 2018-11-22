package com.example.demo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);		
		//return employees.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	
	public Employee updateEmployee(Employee employee, int id) {

			return employeeRepository.save(employee);
	}


	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
		//employees.removeIf(e -> e.getId() == id);
		
	}
	
	

}
