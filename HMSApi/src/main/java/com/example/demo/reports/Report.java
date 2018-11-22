package com.example.demo.reports;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.example.demo.patient.Patient;
import com.example.demo.patientDoctor.PatientDoctor;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=3)
	 private int id;

	@Column(length=20)
	    private String reportName;
	
	 @ManyToOne
	 @JoinColumn(name="patient_record_id")
	private PatientDoctor patientDoctor;
	 
	 @Lob 
	    private byte[] data;
	 
	 public Report() {
		 
	 }

	public Report(String reportName, PatientDoctor patientDoctor, byte[] data) {
		super();
		this.reportName = reportName;
		this.patientDoctor = patientDoctor;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}



	public PatientDoctor getPatientDoctor() {
		return patientDoctor;
	}

	public void setPatientDoctor(PatientDoctor patientDoctor) {
		this.patientDoctor = patientDoctor;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
	

}
