package com.kinsolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TeleRadiologyApp {
	
	public static void main(String[] args) {
		System.out.println("TeleRadiologyApp Init.............");
		SpringApplication.run(TeleRadiologyApp.class, args);
	}
}
