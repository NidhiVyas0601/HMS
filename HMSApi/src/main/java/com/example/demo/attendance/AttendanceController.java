package com.example.demo.attendance;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patient.PatientRepository;

@RestController
//@RequestMapping("/hospital")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	

	@RequestMapping(value="/attendance", method=RequestMethod.GET)
	public List<Attendance> getAllAttendance() {

		return attendanceService.getAllAttendance();
	}
	
@RequestMapping("/attendance/{id}")
	public Optional<Attendance> getAttendance(@PathVariable int id ) {
		return attendanceService.getAttendance(id);
	}
	
// post attendance
	@RequestMapping(method=RequestMethod.POST, value="/attendance/{employeeId}")
	public String addAttendance(@RequestBody Attendance attendance, @PathVariable int employeeId) {
		return employeeRepository.findById(employeeId).map(employee -> {
			attendance.setEmployee(employee);
			return attendanceService.addAttendance(attendance);
		}).orElseThrow(() -> new ResourceNotFoundException("employee id " + employeeId + " not found"));

	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/attendance/{employeeId}/{id}")
	public Attendance updateAttendance(@RequestBody Attendance attendance1, @PathVariable int id, @PathVariable int employeeId) {
		if(!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee id " + employeeId + " not found");
        }
		return attendanceRepository.findById(id).map(attendance -> {
			attendance.setAvailabiltiy(attendance1.getAvailabiltiy());
            return attendanceService.updateAttendance(attendance, id);
        }).orElseThrow(() -> new ResourceNotFoundException("Attendance Id " + id + "not found"));
    
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/attendance/{employeeId}/{id}")
	public void deleteAttendance( @PathVariable int id) {
		attendanceService.deleteAttendance(id);
		
	}
}
