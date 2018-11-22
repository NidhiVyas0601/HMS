package com.example.demo.employee;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.Doctor.Doctor;



@Entity
@Table(name="Employees")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotBlank
	private String firstName;	
	@NotBlank
	private String lastName;
	@NotBlank
	private String emailId;
	private String gender;
	@NotBlank
	private String primayNumber;
	@NotBlank
	private String password;
	@NotBlank
	private String designation;
	private  Date dateOfBirth;
	
	  @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	  private Doctor doctor;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String emailId, String gender, String primayNumber,
			String password, String designation, Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.primayNumber = primayNumber;
		this.password = password;
		this.designation = designation;
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPrimayNumber() {
		return primayNumber;
	}

	public void setPrimayNumber(String primayNumber) {
		this.primayNumber = primayNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	

}
