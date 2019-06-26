package com.sample.application.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.application.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.spring.web.json.Json;

@Api("Sample Spring Boot API")
@RestController("PersonController")
@RequestMapping("/person")
@Validated
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	/**
	 * Add Person/ Create New Person 
	 * @param person
	 * @return person
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Add Person", notes = "Add Person to the system")
	public @ResponseBody Person addPerson(@Valid @RequestBody Person person) {

		LOGGER.info("PersonController method Called : Add Person process initiated");

			return person;

	}	
}
