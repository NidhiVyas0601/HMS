package com.example.demo.patientDoctor;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Doctor.DoctorRepository;
import com.example.demo.exceptions.InvalidRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patient.Patient;
import com.example.demo.patient.PatientRepository;
@RestController
public class PatientDoctorController {
	
	
	@Autowired
	PatientDoctorRepository pdRepository;
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	DoctorRepository docRepository;
	
	@Autowired 
	PatientDoctorService pdService;
	
/*	@RequestMapping(value="/patientDoctor/{patentId}/{doctorId}", method=RequestMethod.GET)
	public List<PatientDoctor> getAllPatientDoctors(Long patientId, int doctorId) {
		List<PatientDoctor> patientDoctors = new ArrayList<>();
		 Patient patient = findPatient(patientId);
		 Doctor doctor = findDoctor(doctorId);
	        List<PatientDoctor> patientDoctor = pdRepository.findByPatientPatientId(patientId);
	        patientDoctor = pdRepository.findByDoctorDoctorId(doctorId);
	        return (List<PatientDoctor>) pdService.getPatientsDoctors();
}
	
*/
	
	@RequestMapping(value="/getrecords", method=RequestMethod.GET)
	public Iterable<PatientDoctor> getPatientDoctorRecords() {
		return pdService.getPatientsDoctors();
	
	}
	
	@RequestMapping(value="/patientDoctor/{patientId}/{doctorId}/getrecords", method=RequestMethod.GET)
	public Iterable<PatientDoctor> getPatientDoctorRecords(@PathVariable Long patientId, @PathVariable int doctorId) {
		return pdService.getPatientsDoctors(patientId, doctorId);
	
	}
	private Doctor findDoctor(int doctorId) {
	
		return docRepository.findById(doctorId).map(article -> article).orElseThrow(ResourceNotFoundException::new);
	}

	private Patient findPatient(Long patientId) {
		 return patientRepository.findById(patientId).map(article -> article).orElseThrow(ResourceNotFoundException::new);
	}
		
	
@RequestMapping("/getRecordsById/{id}") 
	public Optional<PatientDoctor> getPatientDoctorRecords(@PathVariable int id ) {
		return pdService.getPatientDoctorById(id);
	}

//post patientDoctor details

@PostMapping("/patientDoctor/{patientId}/{doctorId}/addRecord") 
public String addPatientDoctorRecord(@PathVariable int doctorId, @RequestBody PatientDoctor patientDoctorParam, @PathVariable Long patientId) throws InvalidRequestException {
    Patient patient = findPatient(patientId);
    Doctor doctor = findDoctor(doctorId);
   patientDoctorParam.setDoctor(doctor);
   patientDoctorParam.setPatient(patient);
   return pdService.addPatientDoctorRecord(patientDoctorParam);
}

//Patch method

@RequestMapping(method=RequestMethod.PATCH, value="/patientDoctor/{patientId}/{doctorId}/updateRecord/{id}")
public PatientDoctor updatePatientDoctorRecord(@PathVariable int doctorId, @PathVariable int id, @RequestBody PatientDoctor patientDoctorParam, @PathVariable Long patientId) {
	if(!patientRepository.existsById(patientId)) {
        throw new ResourceNotFoundException("Patient ID " + patientId + " not found");
    }

	if(!docRepository.existsById(doctorId)) {
        throw new ResourceNotFoundException("Doctor ID " + patientId + " not found");
    }
		Patient patient = findPatient(patientId);
	    Doctor doctor = findDoctor(doctorId);
	return pdRepository.findById(id).map(patientDoctor -> {
		patientDoctor.setDoctor(doctor);
		patientDoctor.setPatient(patient);
		patientDoctor.setAdmitted(patientDoctorParam.getAdmitted());
		patientDoctor.setDate(patientDoctorParam.getDate());
		patientDoctor.setTime(patientDoctorParam.getTime());
        return pdService.updatePatientDoctor(patientDoctor, id);
    }).orElseThrow(() -> new ResourceNotFoundException("PatientDoctor Record ID " + id + "not found"));

}

// delete record

@RequestMapping(method=RequestMethod.DELETE, value="/deleteRecord/{id}")
public void deletePatientDoctorRecord( @PathVariable int id) {
	pdService.deletePatientDoctor(id);
	
}



}
