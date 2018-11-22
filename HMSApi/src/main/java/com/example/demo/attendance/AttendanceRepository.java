package com.example.demo.attendance;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
	
	public List<Attendance> findByEmployeeId(int employeeId);
}
