package com.example.demo.appointments;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Doctor.Doctor;
import com.example.demo.patient.PatientRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	PatientRepository patientRepository;
	
	
	
	public List<Appointment> getAllAppointments() {
		List<Appointment> Appointments= new ArrayList<>();
		appointmentRepository.findAll()
		.forEach(Appointments::add);
		return Appointments;
		
				}
	
	
	public List<Appointment> getAllAppointmentsbyPatient(Long patientId) {
		List<Appointment> appointments = new ArrayList<>();
		appointmentRepository.findByPatientPatientId(patientId)
		.forEach(appointments::add);
		return appointments;
		
				}
	
	public Optional<Appointment> getAppointment(int id) {
		return appointmentRepository.findById(id);		
		//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public String addAppointment(Appointment appointment) {		
		appointmentRepository.save(appointment);
		return "data saved successsfully";
		
	}
	
	public Appointment updateAppointment( Appointment appointment, int id) {
		
		return appointmentRepository.save(appointment);

			
	}


	public void deleteAppointment(int id) {
		appointmentRepository.deleteById(id);
		
		//Appointments.removeIf(e -> e.getId() == id);
		
	}
	
	

}
