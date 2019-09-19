package com.sample.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.application.model.Person;
import com.sample.application.repository.PersonRepository;

@Service("PersonService")
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public void addPerson(Person person) {

		personRepository.save(person);
	}

	public Optional<Person> getPerson(int personId) {

		Optional<Person> person = personRepository.findById(personId);

		return person;
	}

}
