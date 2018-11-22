package com.example.demo.bill;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface BillRepository extends CrudRepository<Bill, Integer> {
	//List<Bill> findByPatientDoctorId(int patientdoctorId);	
}
