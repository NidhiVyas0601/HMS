package com.example.demo.prescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.appointments.Appointment;
import com.example.demo.patient.Patient;
import com.example.demo.patientDoctor.PatientDoctorRepository;

@Service
public class PrescriptionService {
	
	@Autowired
	PrescriptionRepository prescriptionrepository;
	
	@Autowired
	PatientDoctorRepository patientdoctorrepository;
	
	public List<Prescription> getAllPrescriptions() {
		return (List<Prescription>) prescriptionrepository.findAll();
	}
	
	public Optional<Prescription> getPrescription(int prescriptionId) {
		return prescriptionrepository.findById(prescriptionId);	
		
	}

	public String addPrescription(Prescription prescription) {		
		prescriptionrepository.save(prescription);
		return "data saved successsfully";
		
	}
	
	public Prescription updatePrescription( Prescription prescription, int prescriptionId) {		
		return prescriptionrepository.save(prescription);
			
	}


	public void deletePrescription(int prescriptionId) {
		prescriptionrepository.deleteById(prescriptionId);		
	}
	
	
}
