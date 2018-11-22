package com.example.demo.Doctor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.employee.Employee;
import com.example.demo.patientDoctor.PatientDoctor;

@Entity
@Table(name="Doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int doctorId;
	@NotBlank
	private String specialization;
	@NotBlank
	private String degree;
	@NotBlank
	private String docCertificate;
	
	 @OneToOne
	 @JoinColumn(name="employee_id", referencedColumnName="id")
	Employee employee;
	 
	 @OneToMany(mappedBy = "doctor")
	 private Set<PatientDoctor> userServices = new HashSet<PatientDoctor>();
	
	public Doctor() {
		
	}
	
	public Doctor(int doctorId, @NotBlank String specialization, @NotBlank String degree, @NotBlank String docCertificate,  Employee employee) {
		super();
		this.doctorId = doctorId;
		this.specialization = specialization;
		this.degree = degree;
		this.docCertificate = docCertificate;
		this.employee = employee;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDocCertificate() {
		return docCertificate;
	}

	public void setDocCertificate(String docCertificate) {
		this.docCertificate = docCertificate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


}
