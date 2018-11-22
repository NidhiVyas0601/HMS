package com.example.demo.patientDoctor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.Doctor.Doctor;
import com.example.demo.patient.Patient;

@Entity
@Table(name="PatientDoctorRecord")
public class PatientDoctor {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String date;
	private String time;

	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	private String admitted;
	
	public PatientDoctor(int id, String date, String time, Patient patient, Doctor doctor, String admitted) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.doctor = doctor;
		this.admitted = admitted;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getAdmitted() {
		return admitted;
	}

	public void setAdmitted(String admitted) {
		this.admitted = admitted;
	}

	
	public PatientDoctor() {
		
	}

}
