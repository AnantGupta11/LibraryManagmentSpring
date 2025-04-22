package com.infy.LibraryManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LibraryManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagmentApplication.class, args);
	}

}
