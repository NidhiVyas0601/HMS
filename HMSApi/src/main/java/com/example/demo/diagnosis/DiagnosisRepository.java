package com.example.demo.diagnosis;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
	//List<Diagnosis> findByPatientDoctorId(int patientdoctorId);	
}
