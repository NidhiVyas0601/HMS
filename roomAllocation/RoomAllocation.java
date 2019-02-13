package com.example.demo.roomallocation;

import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.patientDoctor.PatientDoctor;
import com.example.demo.roomDetails.RoomDetails;

@Entity
@Table(name="RoomAllocation")
public class RoomAllocation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String date;
	
	 @ManyToOne
	 @JoinColumn(name="patientRecord")
	private PatientDoctor patientDoctor;
	 
		@ManyToOne
		 @JoinColumn(name="roomRecord")
		private RoomDetails roomDetails;
	 
		public RoomAllocation(int id, String date, PatientDoctor patientDoctor, RoomDetails roomDetails,
			String deallocateDate) {
		super();
		this.id = id;
		this.date = date;
		this.patientDoctor = patientDoctor;
		this.roomDetails = roomDetails;
		this.deallocateDate = deallocateDate;
	}


		 
		public String getDeallocateDate() {
			return deallocateDate;
		}


		public void setDeallocateDate(String deallocateDate) {
			this.deallocateDate = deallocateDate;
		}

		private String deallocateDate;

	 public RoomAllocation() {
		 
	 }

	 

	public RoomDetails getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(RoomDetails roomDetails) {
		this.roomDetails = roomDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		//  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		this.date = date;
	}

	public PatientDoctor getPatientDoctor() {
		return patientDoctor;
	}

	public void setPatientDoctor(PatientDoctor patientDoctor) {
		this.patientDoctor = patientDoctor;
	}
		

}
