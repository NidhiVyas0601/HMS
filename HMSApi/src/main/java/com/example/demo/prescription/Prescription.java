package com.example.demo.prescription;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.patientDoctor.PatientDoctor;

@Entity
public class Prescription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prescriptionId;
	private String medicine_name;
	private double qty;
	private String dosage_instruction;
	private Date date;
	 @ManyToOne
	 @JoinColumn()
	private PatientDoctor patient_doctor;
	 
	public Prescription() {
		
	}

	public Prescription(int prescriptionId, String medicine_name, double qty, String dosage_instruction,
			PatientDoctor patient_doctor) {
		super();
		this.prescriptionId = prescriptionId;
		this.medicine_name = medicine_name;
		this.qty = qty;
		this.dosage_instruction = dosage_instruction;
		this.patient_doctor = patient_doctor;
		this.date=java.util.Calendar.getInstance().getTime();
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public String getDosage_instruction() {
		return dosage_instruction;
	}

	public void setDosage_instruction(String dosage_instruction) {
		this.dosage_instruction = dosage_instruction;
	}

	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = java.util.Calendar.getInstance().getTime();
	}

	public PatientDoctor getPatient_doctor() {
		return patient_doctor;
	}

	public void setPatient_doctor(PatientDoctor patient_doctor) {
		this.patient_doctor = patient_doctor;
	}

	
}
