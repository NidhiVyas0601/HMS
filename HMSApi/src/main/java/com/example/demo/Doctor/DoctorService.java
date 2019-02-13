package com.example.demo.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	
	
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		doctorRepository.findAll()
		.forEach(doctors::add);
		return doctors;
		
				}
	
	public Optional<Doctor> getDoctor(int id) {
		return doctorRepository.findById(id);		
		//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public String addDoctor(Doctor doctor) {		
		doctorRepository.save(doctor);
		return "data saved successsfully";
		
	}
	
	public Doctor updateDoctor( Doctor doctor, int id) {
		
		return doctorRepository.save(doctor);

			
	}


	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
		
		//Appointments.removeIf(e -> e.getId() == id);
		
	}
	
	

}
