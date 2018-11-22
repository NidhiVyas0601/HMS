package com.example.demo.bill;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Doctor.Doctor;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patientDoctor.PatientDoctorRepository;

@RestController
//@RequestMapping("/hospital")
public class BillController {
	@Autowired
	BillService billservice;
	
	@Autowired
	BillRepository billrepository;
	
	@Autowired
	PatientDoctorRepository patientdoctorrepository;
	

	@RequestMapping(value="/bills", method=RequestMethod.GET)
	public List<Bill> getAllBills() {
		return billservice.getAllBills();
	}
	
	@RequestMapping("/bill/{billId}")
	 public Optional<Bill> getBill(@PathVariable int billId) throws Exception {    	
        if(!billrepository.existsById(billId)) {
            throw new Exception("Bill not found!");
        }
        return billservice.getBill(billId);
    }
			
	@RequestMapping(method=RequestMethod.POST, value="/bill/patient/{patientdoctorId}")
	public String addBill(@RequestBody Bill bill, @PathVariable int patientdoctorId) {
		return patientdoctorrepository.findById(patientdoctorId).map(patientdoctor -> {
			bill.setPatient_doctor(patientdoctor);
			bill.setDate();
			return billservice.addBill(bill);
		}).orElseThrow(() -> new ResourceNotFoundException("Patient_Doctor Id " + patientdoctorId + " not found"));
	}
		
	@RequestMapping(method=RequestMethod.DELETE, value="/bill/{billId}")
	public void deleteBill( @PathVariable int billId) {
		billservice.deleteBill(billId);

	}

}
