package org.fourstack.microservices.personalinfo.controllers;

import java.util.List;

import org.fourstack.microservices.personalinfo.models.Person;
import org.fourstack.microservices.personalinfo.services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personal")
public class PersonalInfoController {
	
	@Autowired
	private PersonalInfoService service;
	
	@GetMapping("/info")
	public String getInfo() {
		return "Personal info Controller";
	}
	
	@GetMapping("/persons")
	public List<Person> getPersonalInfoList() {
		return service.getAllPersonsList();
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPersonById(@PathVariable Long personId) {
		return service.getPersonById(personId);
	}
	
	@PostMapping("/persons")
	public Person savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}
}
