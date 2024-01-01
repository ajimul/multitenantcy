package com.multitenantcy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multitenantcy.entity.Person;

interface Persons extends JpaRepository<Person, Long> {
	static Person named(String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}
}