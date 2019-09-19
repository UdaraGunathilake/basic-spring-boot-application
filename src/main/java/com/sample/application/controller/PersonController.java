package com.sample.application.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.application.model.Person;
import com.sample.application.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * Person Controller containing all controller methods relate to Person
 *
 */
@Api("Sample Spring Boot API")
@RestController("PersonController")
@RequestMapping("/person")
@Validated
public class PersonController {

	@Autowired
	PersonService personService;

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	/**
	 * Add Person/ Create New Person
	 * 
	 * @param person
	 * @return person
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Add Person", notes = "Add Person to the system")
	public @ResponseBody Person addPerson(@Valid @RequestBody Person person) {
		
		LOGGER.info("PersonController method Called : Add Person process initiated");

		personService.addPerson(person);

		return person;

	}
	
	/**
	 * Get Person/ Return Person
	 * 
	 * @param person
	 * @return person
	 */
	@GetMapping(value="/{personId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Get Person", notes = "Get Person from the system")
	public @ResponseBody Optional<Person> getPerson(@PathVariable("personId") int personId) {	

		LOGGER.info("PersonController method Called : Get Person process initiated");

		return personService.getPerson(personId);

	}
}
