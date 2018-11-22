
package com.example.demo.bill;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.demo.employee.Employee;
import com.example.demo.patientDoctor.PatientDoctor;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billId;
	
	@OneToOne
	@JoinColumn()
	private PatientDoctor patient_doctor;
	
	private double doctor_charge;
	private double medicine_charge;
	private double bed_charge;
	private double total;
	private Date date;
	
	public Bill() {
		
	}

	public Bill(PatientDoctor patient_doctor, double doctor_charge, double medicine_charge, double bed_charge,
			double total) {
		super();
		this.patient_doctor = patient_doctor;
		this.doctor_charge = doctor_charge;
		this.medicine_charge = medicine_charge;
		this.bed_charge = bed_charge;
		this.total = total;
		this.date = java.util.Calendar.getInstance().getTime();
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public PatientDoctor getPatient_doctor() {
		return patient_doctor;
	}

	public void setPatient_doctor(PatientDoctor patient_doctor) {
		this.patient_doctor = patient_doctor;
	}

	public double getDoctor_charge() {
		return doctor_charge;
	}

	public void setDoctor_charge(double doctor_charge) {
		this.doctor_charge = doctor_charge;
	}

	public double getMedicine_charge() {
		return medicine_charge;
	}

	public void setMedicine_charge(double medicine_charge) {
		this.medicine_charge = medicine_charge;
	}

	public double getBed_charge() {
		return bed_charge;
	}

	public void setBed_charge(double bed_charge) {
		this.bed_charge = bed_charge;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = java.util.Calendar.getInstance().getTime();
	}
	
}
