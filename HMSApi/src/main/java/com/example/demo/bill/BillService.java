package com.example.demo.bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Doctor.Doctor;
import com.example.demo.diagnosis.Diagnosis;
import com.example.demo.patientDoctor.PatientDoctorRepository;




@Service
public class BillService {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	PatientDoctorRepository patientdoctorrepository;
	
	public List<Bill> getAllBills() {
		return (List<Bill>) billRepository.findAll();
	}
	
	public Optional<Bill> getBill(int billId) {
		return billRepository.findById(billId);			
	}
	
	public String addBill(Bill bill) {		
		billRepository.save(bill);
		return "data saved successsfully";
		
	}
	
	public Bill updateBill( Bill bill, int billId) {		
		return billRepository.save(bill);
			
	}

	public void deleteBill(int billId) {
		billRepository.deleteById(billId);		
	}

}
