package com.example.demo.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.appointments.Appointment;
import com.example.demo.patient.Patient;
import com.example.demo.patient.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;

	
	@RequestMapping(value="/patients", method=RequestMethod.GET)
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	@RequestMapping("/patients/{id}")
	public Optional<Patient> getPatient(@PathVariable Long id) {
		return patientService.getPatient(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/patients")
	public void addPatient(@RequestBody Patient patient) {
		patientService.addPatient(patient);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
		Optional<Patient> patient1 = patientService.getPatient(id);
		patient.setPatientId(id);
		patientService.updatePatient(patient, id);
		if(patient1 == null){
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
		
		Patient patient2 = patientService.updatePatient(patient, id);
		 return new ResponseEntity<Patient>(patient2, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/patients/{id}")
	public void deletePatient( @PathVariable Long id) {
		patientService.deletePatient(id);
	}

}
