package com.greatlearning.employeemanagement;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class Graded4EmployeeManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Graded4EmployeeManagementApplication.class, args);

		System.out.println("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {


	}

}
