package com.spring.sec.service;

import java.util.List;

import com.spring.sec.entity.AuthGroup;
import com.spring.sec.entity.Person;
import com.spring.sec.repository.AuthGroupRepository;
import com.spring.sec.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonService {

	@Autowired
	PersonRepository<Person> personRepository;

	@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@Transactional
	public List<Person> findByName(String name) {

		System.out.println("inside findByName method");
		return personRepository.findByFirstName(name);
	}

	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	@Transactional
	public boolean updatePerson(Person person) {
		return personRepository.save(person) != null;
	}
}
