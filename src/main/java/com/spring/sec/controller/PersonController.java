package com.spring.sec.controller;

import java.util.List;

import com.spring.sec.entity.Person;
import com.spring.sec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<Person> getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public List<Person> getAll() {
		return personService.getAllPersons();
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public HttpStatus insertPersone(@RequestBody Person person) {
		return personService.addPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public HttpStatus updatePersone(@RequestBody Person person) {
		return personService.updatePerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
}

