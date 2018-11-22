package com.example.demo.diagnosis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.patient.Patient;
import com.example.demo.patientDoctor.PatientDoctorRepository;

@Service
public class DiagnosisService {

	@Autowired
	DiagnosisRepository diagnosisrepository;
	
	@Autowired
	PatientDoctorRepository patientdoctorrepository;
	
	public List<Diagnosis> getAllDiagnosis() {
		return (List<Diagnosis>) diagnosisrepository.findAll();
	}
	
	public Optional<Diagnosis> getDiagnosis(int diagnosisId) {
		return diagnosisrepository.findById(diagnosisId);			
	}
	
	public String addDiagnosis(Diagnosis diagnosis) {		
		diagnosisrepository.save(diagnosis);
		return "data saved successsfully";
		
	}
	
	public Diagnosis updateDiagnosis( Diagnosis diagnosis, int diagnosisId) {		
		return diagnosisrepository.save(diagnosis);
			
	}

	public void deleteDiagnosis(int diagnosisId) {
		diagnosisrepository.deleteById(diagnosisId);		
	}
}
