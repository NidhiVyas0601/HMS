package com.example.demo.patientDoctor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDoctorService {
	
@Autowired
PatientDoctorRepository pdRepository;
	
public Iterable<PatientDoctor> getPatientsDoctors() {
	return pdRepository.findAll();		
	//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
}

	public Iterable<PatientDoctor> getPatientsDoctors(Long patientID,int doctorId) {
		return pdRepository.findAll();		
		//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public Optional<PatientDoctor> getPatientDoctorById(int id) {
		return pdRepository.findById(id);		
		//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public String addPatientDoctorRecord( PatientDoctor patientDoctor) {		
		pdRepository.save(patientDoctor);
		return "data saved successsfully";
		
	}
	
	public PatientDoctor updatePatientDoctor( PatientDoctor patientDoctor, int id) {
		
		return pdRepository.save(patientDoctor);

			
	}


	public String deletePatientDoctor(int id) {
		pdRepository.deleteById(id);
		return "Data deleted successfully";
		
		//Appointments.removeIf(e -> e.getId() == id);
		
	}

	
}
