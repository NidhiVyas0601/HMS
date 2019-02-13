package com.example.demo.roomallocation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AllocationRepository extends CrudRepository<RoomAllocation, Integer> {
	
	public List<RoomAllocation> findByPatientDoctorId(int patientDocId);
}
