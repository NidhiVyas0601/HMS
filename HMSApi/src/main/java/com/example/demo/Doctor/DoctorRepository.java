package com.example.demo.Doctor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.employee.Employee;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
