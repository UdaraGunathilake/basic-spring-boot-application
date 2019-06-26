package com.sample.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SampleAPI {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleAPI.class);

	public static void main(String[] args) {

		LOGGER.info("Sample Spring Boot API Starting up..!!");
		
		SpringApplication.run(SampleAPI.class, args);

		}
}
