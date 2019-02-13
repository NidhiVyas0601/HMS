package com.example.demo.attendance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	private String availabiltiy;	
	private Date createdAt;
	
	 @ManyToOne
	 @JoinColumn(name="employee_id")
	 private Employee employee;
	 
	public Attendance() {
		 
	 }
	
	

	public Attendance(int id, String availabiltiy, Employee employee) {
		super();
		this.id = id;
		this.availabiltiy = availabiltiy;
		this.createdAt = java.util.Calendar.getInstance().getTime();
		this.employee = employee;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvailabiltiy() {
		return availabiltiy;
	}

	public void setAvailabiltiy(String availabiltiy) {
		this.availabiltiy = availabiltiy;
	}

	public Date getcreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = java.util.Calendar.getInstance().getTime();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	

}
