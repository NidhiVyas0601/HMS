package com.example.demo.roomallocation;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Doctor.Doctor;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patient.Patient;
import com.example.demo.patient.PatientRepository;
import com.example.demo.patientDoctor.PatientDoctor;
import com.example.demo.patientDoctor.PatientDoctorRepository;
import com.example.demo.roomDetails.RoomDetailRepository;
import com.example.demo.roomDetails.RoomDetails;

@RestController
//@RequestMapping("/hospital")
public class AllocationController {
	
	@Autowired
	AllocationService allocationService;
	
	@Autowired
	PatientDoctorRepository pdRepository;
	
	@Autowired
	AllocationRepository allocateRepository;
	
	@Autowired
	RoomDetailRepository rdRepository;

	RoomAllocation roomAllocation;

	
	@RequestMapping(value="/roomAllocation", method=RequestMethod.GET)
	public List<RoomAllocation> getAllocationDetails() {
		return allocationService.getAllocationDetails();
	}
	
@RequestMapping("/roomAllocation/{id}")
	public Optional<RoomAllocation> getroomAllocatement(@PathVariable int id ) {
		return allocationService.getRoomallocation(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/patientdoctor/{pdid}/{roomId}/roomAllocation")
	public String addroomAllocatement(@RequestBody RoomAllocation roomAllocation, @PathVariable int pdid, @PathVariable int roomId) {
	
		   PatientDoctor pd = findPatient(pdid);
		    RoomDetails rd = findRoom(roomId);
		    roomAllocation.setPatientDoctor(pd);
		    roomAllocation.setRoomDetails(rd);
		   return allocationService.addRoomAllocation(roomAllocation);
	 
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/patientdoctor/{patientId}/{roomId}/roomAllocatements/{id}")
	public RoomAllocation updateroomAllocatement(@RequestBody RoomAllocation roomAllocatement1, @PathVariable int id, @PathVariable int patientId, @PathVariable int roomId) {
		if(!pdRepository.existsById(patientId)) {
	        throw new ResourceNotFoundException("Patient ID " + patientId + " not found");
	    }

		if(!rdRepository.existsById(roomId)) {
	        throw new ResourceNotFoundException("Doctor ID " + roomId + " not found");
	    }
			PatientDoctor patientDoctor = findPatient(patientId);
		    RoomDetails roomDetails = findRoom(roomId);
			
		    return allocateRepository.findById(id).map(roomAllocation -> {
		    	roomAllocation.setPatientDoctor(patientDoctor);
		    	roomAllocation.setRoomDetails(roomDetails);
		    	roomAllocation.setDate(roomAllocatement1.getDate());
		        return allocationService.updateRoomAllocation(roomAllocation, roomId, patientId);
		    }).orElseThrow(() -> new ResourceNotFoundException("PatientDoctor Record ID " + id + "not found"));
    
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/roomAllocation/{id}")
	public void deleteroomAllocatement( @PathVariable int id) {
		allocationService.deleteAllocatedRoom(id);
		
	}
	
	private PatientDoctor findPatient(int pdid) {
		
		return pdRepository.findById(pdid).map(article -> article).orElseThrow(ResourceNotFoundException::new);
	}

	private RoomDetails  findRoom(int rdid) {
		 return rdRepository.findById(rdid).map(article -> article).orElseThrow(ResourceNotFoundException::new);
	}
		
}
