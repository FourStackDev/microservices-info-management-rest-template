package org.fourstack.microservices.personalinfo.services;

import java.util.List;

import org.fourstack.microservices.personalinfo.models.Person;

public interface PersonalInfoService {
	
	public List<Person> getAllPersonsList();
	
	public Person getPersonById(Long id);
	
	public Person savePerson(Person person);
}
