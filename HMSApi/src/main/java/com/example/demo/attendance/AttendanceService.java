package com.example.demo.attendance;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.EmployeeRepository;
import com.example.demo.patient.PatientRepository;

@Service
public class AttendanceService {
	
	@Autowired
	AttendanceRepository attendanceRepository;
	@Autowired
	EmployeeRepository empRepository;
	
	
	public List<Attendance> getAllAttendance() {
		List<Attendance> attendances = new ArrayList<>();
		attendanceRepository.findAll()
		.forEach(attendances::add);
		return attendances;
		
				}
	
	public Optional<Attendance> getAttendance(int id) {
		return attendanceRepository.findById(id);		
		//return Appointments.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public String addAttendance(Attendance attendance) {		
		attendanceRepository.save(attendance);
		return "data saved successsfully";
		
	}
	
	public Attendance updateAttendance( Attendance attendance, int id) {
		
		return attendanceRepository.save(attendance);

			
	}


	public void deleteAttendance(int id) {
		attendanceRepository.deleteById(id);
		
		//Appointments.removeIf(e -> e.getId() == id);
		
	}
	
	

}
