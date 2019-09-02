package com.kinsolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class TeleRadiologyApp {
	
	public static void main(String[] args) {
		System.out.println("TeleRadiologyApp Init.............");
		SpringApplication.run(TeleRadiologyApp.class, args);
	}
}

/*@SpringBootApplication
public class TeleRadiologyApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	System.out.println("TeleRadiologyApp Init.............");
        SpringApplication.run(TeleRadiologyApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	System.out.println("TeleRadiologyApp Configure.............");
        return builder.sources(TeleRadiologyApp.class);
    }
}*/