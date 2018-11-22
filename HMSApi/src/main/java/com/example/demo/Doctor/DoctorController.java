package com.example.demo.Doctor;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.appointments.Appointment;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.exceptions.ResourceNotFoundException;


@RestController
//@RequestMapping("/hospital")
public class DoctorController {
	@Autowired
	DoctorService docService;

	@Autowired
	DoctorRepository docRepository;
	
	@Autowired
	EmployeeRepository empRepository;

	@RequestMapping(value="/doctors", method=RequestMethod.GET)
	public List<Doctor> getAllDoctors() {
		return docService.getAllDoctors();
	}
	
/*	 @GetMapping("/employees/{employeeId}/doctors")
	 public Doctor getDoctorByEmployeeId(@PathVariable Integer employeeId) throws Exception {
    	
        if(!empRepository.existsById(employeeId)) {
            throw new Exception("employeeId not found!");
        }
    	
    	List<Doctor> doctors = docRepository.findByEmployeeId(employeeId);
    	if(doctors.size() > 0) {
    		return doctors.get(0);
    	}else {
    		throw new Exception("Doctor not found!");
    	}
    }
	*/
		@RequestMapping("/doctors/{id}")
	public Optional<Doctor> getDoctor(@PathVariable int id ) {
		return docService.getDoctor(id);
	}

	@RequestMapping(method=RequestMethod.PATCH, value="/employees/{employeeId}/doctors/{id}")
	public Doctor updateDoctor(@RequestBody Doctor doctor1, @PathVariable int id) {
			return docRepository.findById(id).map(doctor -> {
				doctor.setDegree(doctor1.getDegree());
				doctor.setDocCertificate(doctor1.getDocCertificate());
				doctor.setSpecialization(doctor1.getSpecialization());
	            return docService.updateDoctor(doctor, id);
	        }).orElseThrow(() -> new ResourceNotFoundException("Attendance Id " + id + "not found"));
    
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{employeeId}/doctors/{doctorId}")
	public void deleteDoctor( @PathVariable int doctorId) {
		docService.deleteDoctor(doctorId);

	}
}