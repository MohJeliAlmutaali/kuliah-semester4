package com.jeli.library_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jeli.library_manager.model")
public class LibraryManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagerApplication.class, args);
	}
}
