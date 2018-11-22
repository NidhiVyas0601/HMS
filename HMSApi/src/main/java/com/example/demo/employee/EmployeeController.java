package com.example.demo.employee;

import java.util.List;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;


@RestController
//@RequestMapping("/hospital")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@RequestMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return empService.getEmployee(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/addEmployees")
	public void addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
	}
	
	@PatchMapping(value="/employees/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		Optional<Employee> emp = empService.getEmployee(id);
		employee.setId(id);
		empService.updateEmployee(employee, id);
		if(emp == null){
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
		
		Employee emp1 = empService.updateEmployee(employee, id);
		 return new ResponseEntity<Employee>(emp1, HttpStatus.OK);
	}

	@DeleteMapping(value="/employees/{id}")
	public void deleteEmployee( @PathVariable int id) {
		empService.deleteEmployee(id);
	}
	
	@RequestMapping(value = "/login/{id}/{password}", method = RequestMethod.GET)
    public Employee login(@PathVariable int id,@PathVariable String password) {		
		Employee emp2;		
        if (!employeeRepository.existsById(id)) {
        	throw new ResourceNotFoundException("Invalid login credentials");
        } 
        else {        	        	
        	emp2 = employeeRepository.findById(id).get();
        	if(emp2.getPassword().equals(password)) {
        		return emp2;
        	}
        	else {
        		throw new ResourceNotFoundException("Invalid login credentials");
        	}
        	
        }
        	

       
    }
}
