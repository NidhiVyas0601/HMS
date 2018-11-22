package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@ComponentScan(basePackageClasses = DoctorController.class)
@EnableJpaAuditing
public class HmsApiApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HmsApiApplication.class, args);
	}
}
