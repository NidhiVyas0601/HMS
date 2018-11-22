package com.example.demo.employee;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
