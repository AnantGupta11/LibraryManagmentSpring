package com.infy.LibraryManagment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LibraryManagmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("My App is started!!");
	}
}
