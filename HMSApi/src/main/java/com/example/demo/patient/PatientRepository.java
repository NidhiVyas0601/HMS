package com.example.demo.patient;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.patient.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{

}
