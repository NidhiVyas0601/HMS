package com.example.demo.patient;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.patientDoctor.PatientDoctor;

@Entity
@Table(name="Patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=7)
	private Long patientId;
	
	@Column(length = 60)
	private String patientName;
	private int age;
	@Column(length = 30)
	private String houseNumber;
	
	@Column(length = 30)
	private String streetNumber;
	
	@Column(length = 25)
	private String city;
	
	@Column(length = 30)
	private String state;
	private int pincode;
	private String healthIssue;
	
	@Column(length = 13)
	private String contactNumber;
	
	@Column(length = 30)
	private String emailId;
	private String gender;
	
	@Column(length = 50)
	private String guardianName;
	
	@Column(length = 13)
	private String guardianNumber;
	
	@OneToMany(mappedBy="patient")
	private Set<PatientDoctor> patientDoc = new HashSet<PatientDoctor>();

	
	public Patient() {
		
	}

	public Patient(Long patientId, String patientName, int age, String houseNumber, String streetNumber, String city,
			String state, int pincode, String healthIssue, String contactNumber, String emailId, String gender,
			String guardianName, String guardianNumber) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.houseNumber = houseNumber;
		this.streetNumber = streetNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.healthIssue = healthIssue;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.gender = gender;
		this.guardianName = guardianName;
		this.guardianNumber = guardianNumber;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getHealthIssue() {
		return healthIssue;
	}

	public void setHealthIssue(String healthIssue) {
		this.healthIssue = healthIssue;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getGuardianNumber() {
		return guardianNumber;
	}

	public void setGuardianNumber(String guardianNumber) {
		this.guardianNumber = guardianNumber;
	}

	

}
