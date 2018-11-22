package com.example.demo.diagnosis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bill.Bill;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patientDoctor.PatientDoctorRepository;
import com.example.demo.prescription.Prescription;

@RestController
//@RequestMapping("/hospital")

public class DiagnosisController {
	@Autowired
	DiagnosisService diagnosisservice;
	
	@Autowired
	DiagnosisRepository diagnosisrepository;
	
	@Autowired
	PatientDoctorRepository patientdoctorrepository;

	@RequestMapping(value="/diagnosis", method=RequestMethod.GET)
	public List<Diagnosis> getAllDiagnosis() {
		return diagnosisservice.getAllDiagnosis();
	}
	
	@RequestMapping("/diagnosis/{diagnosisId}")
	 public Optional<Diagnosis> getDiagnosis(@PathVariable int diagnosisId) throws Exception {    	
        if(!diagnosisrepository.existsById(diagnosisId)) {
            throw new Exception("Diagnosis not found!");
        }
        return diagnosisservice.getDiagnosis(diagnosisId);
    }
			
	@RequestMapping(method=RequestMethod.POST, value="/diagnosis/doctor/{patientdoctorId}")
	public String addDiagnosis(@RequestBody Diagnosis diagnosis, @PathVariable int patientdoctorId) {
		return patientdoctorrepository.findById(patientdoctorId).map(patientdoctor -> {
			diagnosis.setPatient_doctor(patientdoctor);
			diagnosis.setDate();
			return diagnosisservice.addDiagnosis(diagnosis);
		}).orElseThrow(() -> new ResourceNotFoundException("Patient_Doctor Id " + patientdoctorId + " not found"));
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/diagnosis/{diagnosisId}/doctor/{patientdoctorId}")
	public Diagnosis updateDiagnosis(@RequestBody Diagnosis diagnosis1, @PathVariable int diagnosisId, @PathVariable int patientdoctorId) {
		if(!patientdoctorrepository.existsById(patientdoctorId)) {
            throw new ResourceNotFoundException("PostId " + patientdoctorId + " not found");
        }

		return diagnosisrepository.findById(diagnosisId).map(diagnosis -> {			
			diagnosis.setComplaint(diagnosis1.getComplaint());
			diagnosis.setDiagnosisDetail(diagnosis1.getDiagnosisDetail());			
            return diagnosisservice.updateDiagnosis(diagnosis, diagnosisId);
        }).orElseThrow(() -> new ResourceNotFoundException("Diagnosis Id " + diagnosisId + "not found"));
    
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/diagnosis/{diagnosisId}")
	public void deleteDiagnosis( @PathVariable int diagnosisId) {
		diagnosisservice.deleteDiagnosis(diagnosisId);

	}

}
