package com.sample.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sample.application.model.Person;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
