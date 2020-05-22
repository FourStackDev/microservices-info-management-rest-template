package org.fourstack.microservices.personalinfo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.fourstack.microservices.personalinfo.models.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
	private static Map<Long, Person> personMap = new HashMap<>();
	private static int nextNum;
	
	@Override
	public List<Person> getAllPersonsList() {
		return personMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Person getPersonById(Long id) {
		return personMap.containsKey(id) ? personMap.get(id) : null;
	}
	
	@Override
	public Person savePerson(Person person) {
		if (person.getId() == null || person.getId() == 0) {
			person.setId(new Long(nextNum));
			nextNum++;
		} 
		personMap.put(person.getId(), person);
		return person;
	}
	
	@PostConstruct
	private void initializeData() {
		Person p1 = new Person("Manjunath", "HM", null, null, "Munikrishnappa");
		p1.setId(1L);
		
		Person p2 = new Person("Manoj", "HM", null, null, "Munikrishnappa");
		p2.setId(2L);
		
		personMap.put(1L, p1);
		personMap.put(2L, p2);
		
		nextNum = personMap.size();
	}

}
