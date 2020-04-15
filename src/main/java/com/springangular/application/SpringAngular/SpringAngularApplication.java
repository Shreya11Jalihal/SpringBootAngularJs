package com.springangular.application.SpringAngular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAngularApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringAngularApplication.class);
	
	public static void main(String[] args) {
		
		logger.debug("Starting SpringAngularApplication");
		SpringApplication.run(SpringAngularApplication.class, args);
		logger.debug("Started SpringAngularApplication");

		
	}

}
	