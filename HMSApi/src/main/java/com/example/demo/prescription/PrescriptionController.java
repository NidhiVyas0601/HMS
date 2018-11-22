package com.example.demo.prescription;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.appointments.Appointment;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patientDoctor.PatientDoctorRepository;

@RestController
//@RequestMapping("/hospital")
public class PrescriptionController {
	
	@Autowired
	PrescriptionService prescriptionservice;
	
	@Autowired
	PrescriptionRepository prescriptionrepository;
	
	@Autowired
	PatientDoctorRepository patientdoctorrepository;
	
	
	
	@RequestMapping(value="/doctors/prescription", method=RequestMethod.GET)	
	public List<Prescription> getAllprescriptions() {
		return prescriptionservice.getAllPrescriptions();
	}
	
@RequestMapping("/doctors/{patientdoctorId}/prescription/{prescriptionId}")
	public Optional<Prescription> getPrescription(@PathVariable int prescriptionId ) {
		return prescriptionservice.getPrescription(prescriptionId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/doctors/{patientdoctorId}/prescription")
	public String addPrescription(@RequestBody Prescription prescription, @PathVariable int patientdoctorId) {
		return patientdoctorrepository.findById(patientdoctorId).map(patientdoctor -> {
			prescription.setPatient_doctor(patientdoctor);
			prescription.setDate();
			return prescriptionservice.addPrescription(prescription);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + patientdoctorId + " not found"));

	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/doctors/{patientdoctorId}/prescription/{prescriptionId}")
	public Prescription updatePrescription(@RequestBody Prescription prescription1, @PathVariable int prescriptionId, @PathVariable int patientdoctorId) {
		if(!patientdoctorrepository.existsById(patientdoctorId)) {
            throw new ResourceNotFoundException("PostId " + patientdoctorId + " not found");
        }

		return prescriptionrepository.findById(prescriptionId).map(prescription -> {			
			prescription.setDosage_instruction(prescription1.getDosage_instruction());
			prescription.setMedicine_name(prescription1.getMedicine_name());
			prescription.setQty(prescription1.getQty());
            return prescriptionservice.updatePrescription(prescription, prescriptionId);
        }).orElseThrow(() -> new ResourceNotFoundException("Prescription Id " + prescriptionId + "not found"));
    
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/doctors/prescription/{prescriptionId}")
	public void deletePrescription( @PathVariable int prescriptionId) {
		prescriptionservice.deletePrescription(prescriptionId);
		
	}
	
	

}
