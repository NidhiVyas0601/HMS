package com.example.demo.patientDoctor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientDoctorRepository extends CrudRepository<PatientDoctor, Integer>{
	public List<PatientDoctor> findByPatientPatientId(Long patientId);
	public List<PatientDoctor> findByDoctorDoctorId(int doctorId);
}
