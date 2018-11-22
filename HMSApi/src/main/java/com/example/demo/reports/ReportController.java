package com.example.demo.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Doctor.Doctor;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.patientDoctor.PatientDoctor;
import com.example.demo.patientDoctor.PatientDoctorRepository;

@RestController
//@RequestMapping("/hospital")
public class ReportController {
	@Autowired
	ReportService reportService;
	
	@Autowired
	PatientDoctorRepository patientDocRepository;
	
/*	@PostMapping("/Report/{patientDoctorId}")
    public Report uploadFile( @RequestParam MultipartFile file,  @PathVariable int patientDoctorId, Report report) {

		
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/Report" + patientDoctorId + "/downloadFile/")
	                .path(report.getId())
	                .toUriString();

	        return patientDocRepository.findById(patientDoctorId).map(patientDoctor -> {
				report.setPatientDoctor(patientDoctor);
				try {
					return reportService.storeFile(file, report, fileDownloadUri);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return report;
			}).orElseThrow(() -> new ResourceNotFoundException("PostId " + patientDoctorId + " not found"));

    }
    */
	
  /*  @GetMapping("/downloadFile/{patientId}/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) throws Exception {
        // Load file from database
        Report report = reportService.getReport(fileId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + report.getReportName() + "\"")
                .body(new ByteArrayResource(report.getData()));
    }

	*/
	
	
	
	 @RequestMapping(value = "/uploadFile/{patientDoctorId}", method = RequestMethod.POST)
	    public Report uploadFile(@RequestParam("file") MultipartFile file,  @PathVariable int patientDoctorId, Report report) throws Exception {
	 
		 PatientDoctor patientDoctor = findPatientDoctor(patientDoctorId);
		 report.setPatientDoctor(patientDoctor);
	        File uploadedFile = new File("E:\\tulika\\DAIICT\\springboot", file.getOriginalFilename());
	 
	        try {
	            uploadedFile.createNewFile();
	            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
	            fileOutputStream.write(file.getBytes());
	            fileOutputStream.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return reportService.storeFile(file, report);
	    }
	 
	 private PatientDoctor findPatientDoctor(int patientDoctorId) {
			
			return patientDocRepository.findById(patientDoctorId).map(article -> article).orElseThrow(ResourceNotFoundException::new);
		}
	 
	 
	 
	 
	  @RequestMapping(value = "/downloadFile/{patientDoctorId}/{fileName:.+}")
	    public ResponseEntity<Object> downloadFile(@PathVariable String fileName, HttpServletResponse response, @PathVariable int patientDoctorId) {
	 
	        String filePath = "E:\\tulika\\DAIICT\\springboot\\" + fileName;
	        Path path = Paths.get(filePath);
	        Resource resource = null;
	 
	        try {
	            resource = new UrlResource(path.toUri());
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	 
	        if (resource.exists()) {
	            return ResponseEntity.ok()
	                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                    .body(resource);
	 
	            // return new ResponseEntity<Object>(resource, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<Object>("File Not Found ", HttpStatus.OK);
	        }
	    }
	  
		@RequestMapping(value="/reports/{patientDoctorId}/view", method=RequestMethod.GET)
		
		public Iterable<Report> getReportss(@PathVariable int patientDocId) {
			return reportService.getReportss(patientDocId);
		}

}
