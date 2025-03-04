package com.bridgelabz.AddressBookApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookAppApplication {
	private static final Logger logger = LoggerFactory.getLogger(AddressBookAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
		logger.info("Application is started...");

	}

}
