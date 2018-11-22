package com.example.demo.appointments;

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
import com.example.demo.patient.PatientRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@RequestMapping("/hospital")
public class AppointmentController {
	@Autowired
	AppointmentService appointService;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointRepository;
	
	@RequestMapping(value="/appointments", method=RequestMethod.GET)
	public List<Appointment> getAllappointments() {
		return appointService.getAllAppointments();
	}

	
	@RequestMapping(value="/patients/{id}/appointments", method=RequestMethod.GET)
	public List<Appointment> getAllappointments(@PathVariable Long id) {
		return appointService.getAllAppointmentsbyPatient(id);
	}
	
@RequestMapping("/appointments/{id}")
	public Optional<Appointment> getAppointment(@PathVariable int id ) {
		return appointService.getAppointment(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/patients/{patientId}/appointments")
	public String addAppointment(@RequestBody Appointment appointment, @PathVariable Long patientId) {
		return patientRepository.findById(patientId).map(patient -> {
			appointment.setPatient(patient);
			return appointService.addAppointment(appointment);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + patientId + " not found"));

	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/patients/{patientId}/appointments/{id}")
	public Appointment updateAppointment(@RequestBody Appointment appointment1, @PathVariable int id, @PathVariable Long patientId) {
		if(!patientRepository.existsById(patientId)) {
            throw new ResourceNotFoundException("PostId " + patientId + " not found");
        }

		return appointRepository.findById(id).map(appointment -> {
			appointment.setDate(appointment1.getDate());
			appointment.setTime(appointment1.getTime());
            return appointService.updateAppointment(appointment, id);
        }).orElseThrow(() -> new ResourceNotFoundException("Attendance Id " + id + "not found"));
    
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/appointments/{id}")
	public void deleteAppointment( @PathVariable int id) {
		appointService.deleteAppointment(id);
		
	}
}
