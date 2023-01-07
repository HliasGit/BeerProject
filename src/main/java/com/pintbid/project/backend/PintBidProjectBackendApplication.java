package com.pintbid.project.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PintBidProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PintBidProjectBackendApplication.class, args);
		System.out.println(LocalDate.now());

	}


}
