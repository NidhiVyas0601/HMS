package com.example.demo.diagnosis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.demo.patientDoctor.PatientDoctor;

@Entity
public class Diagnosis {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int diagnosisId;
	
	@OneToOne
	@JoinColumn()
	private PatientDoctor patient_doctor;
	
	private String complaint;
	private String diagnosisDetail;
	private Date date;
	
	public Diagnosis() {
		
	}

	public Diagnosis(int diagnosisId, PatientDoctor patient_doctor, String complaint, String diagnosisDetail) {
		super();
		this.diagnosisId = diagnosisId;
		this.patient_doctor = patient_doctor;
		this.complaint = complaint;
		this.diagnosisDetail = diagnosisDetail;
		this.date=java.util.Calendar.getInstance().getTime();
	}

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public PatientDoctor getPatient_doctor() {
		return patient_doctor;
	}

	public void setPatient_doctor(PatientDoctor patient_doctor) {
		this.patient_doctor = patient_doctor;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getDiagnosisDetail() {
		return diagnosisDetail;
	}

	public void setDiagnosisDetail(String diagnosisDetail) {
		this.diagnosisDetail = diagnosisDetail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = java.util.Calendar.getInstance().getTime();
	}
	
	

}
