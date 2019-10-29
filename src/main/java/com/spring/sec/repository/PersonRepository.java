package com.spring.sec.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.sec.entity.Person;

import java.util.List;

public interface PersonRepository<P> extends CrudRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);
}