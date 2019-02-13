package com.example.demo.roomallocation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.patient.PatientRepository;

@Service
public class AllocationService {
	
	@Autowired
	AllocationRepository allocationRepository;

	
	
	public List<RoomAllocation> getAllocationDetails() {
		List<RoomAllocation> roomAllocations = new ArrayList<>();
		allocationRepository.findAll()
		.forEach(roomAllocations::add);
		return roomAllocations;
		
				}
	
	public Optional<RoomAllocation> getRoomallocation(int id) {
		return allocationRepository.findById(id);		
		//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public String addRoomAllocation(RoomAllocation roomAllocation) {		
		allocationRepository.save(roomAllocation);
		return "data saved successsfully";
		
	}
	
	public RoomAllocation updateRoomAllocation( RoomAllocation roomAllocation, int id, int pdid) {
		
		return allocationRepository.save(roomAllocation);

			
	}


	public void deleteAllocatedRoom(int id) {
		allocationRepository.deleteById(id);
		
		//Appointments.removeIf(e -> e.getId() == id);
		
	}

	
	

}
