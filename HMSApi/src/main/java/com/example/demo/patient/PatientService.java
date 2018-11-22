package com.example.demo.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.patient.Patient;
import com.example.demo.patient.PatientRepository;;

@Service
public class PatientService {
	@Autowired
	PatientRepository patientRepository;
	
	
	public List<Patient> getAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}
	
	public Optional<Patient> getPatient(Long id) {
		return patientRepository.findById(id);		
	}

	public void addPatient(Patient patient) {
		patientRepository.save(patient);
		
	}
	
	public Patient updatePatient(Patient patient, Long id) {

				return patientRepository.save(patient);
	}


	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
				
	}
	
	

}
