package com.example.demo.prescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.appointments.Appointment;



public interface PrescriptionRepository extends CrudRepository<Prescription, Integer> {
	
	//public List<Prescription> findByPatientDoctorId(int id);
}