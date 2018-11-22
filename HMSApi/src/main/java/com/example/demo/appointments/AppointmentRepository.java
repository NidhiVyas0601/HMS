package com.example.demo.appointments;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	
	public List<Appointment> findByPatientPatientId(Long patientId);
}
