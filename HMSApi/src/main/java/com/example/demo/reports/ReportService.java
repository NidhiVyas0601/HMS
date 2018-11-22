package com.example.demo.reports;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Doctor.Doctor;
import com.example.demo.attendance.Attendance;
import com.example.demo.exceptions.FileStorageException;
import com.example.demo.patient.PatientRepository;
import com.example.demo.patientDoctor.PatientDoctor;

@Service
public class ReportService {
	
//	@Autowired
	//PatientDoctor patientDoctor;
	
	@Autowired
	private ReportRepository reportRepository;
	
	public Report storeFile(MultipartFile file, Report report) throws Exception {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Report report1 = new Report(fileName, report.getPatientDoctor(),file.getBytes() );

            return reportRepository.save(report1);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
		
	}
	
	  public Report getReports(int fileId) throws Exception {
	        return reportRepository.findById(fileId)
	                .orElseThrow(() -> new Exception("File not found with id " + fileId));
	    }


		public Iterable<Report> getReportss(int id) {
			return reportRepository.findAll();	
	

}

}