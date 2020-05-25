package org.fourstack.microservices.infomanagement.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.fourstack.microservices.infomanagement.models.InfoContainer;
import org.fourstack.microservices.infomanagement.models.Person;
import org.fourstack.microservices.infomanagement.models.ProfessionalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoManagementServiceImpl implements InfoManagementService {

	private String personInfoUrl;
	private String professionalInfoUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<InfoContainer> getAllPersonalAndProfessionalInfo() {
		List<InfoContainer> infoContainers = new ArrayList<>();

		// get personal Info List
		Person[] persons = restTemplate.getForObject(personInfoUrl + "persons", Person[].class);

		// fetch professional info for each person
		for (Person person : persons) {
			ProfessionalInfo professionalInfo = restTemplate
					.getForObject(professionalInfoUrl + "/professions/" + person.getId(), ProfessionalInfo.class);
			InfoContainer container = new InfoContainer();
			container.setPerson(person);
			container.setProfession(professionalInfo);
			infoContainers.add(container);
		}
		return infoContainers;
	}

	@Override
	public InfoContainer getPersonalAndProfessionalInfoById(Long personId) {

		// get person info by using personId
		Person person = restTemplate.getForObject(personInfoUrl + "/persons/" + personId, Person.class);

		// fetch the professionalInfo By using personId
		ProfessionalInfo professionalInfo = restTemplate.getForObject(professionalInfoUrl + "/professions/" + personId,
				ProfessionalInfo.class);

		InfoContainer conatiner = new InfoContainer();
		conatiner.setPerson(person);
		conatiner.setProfession(professionalInfo);

		return conatiner;
	}

	@Override
	public InfoContainer savePersonalAndProfessionalInfo(InfoContainer container) {

		Person person = container.getPerson();
		ProfessionalInfo professionalInfo = container.getProfession();

		person = restTemplate.postForObject(personInfoUrl + "/persons", person, Person.class);
		professionalInfo.setPersonalInfoId(person.getId());

		professionalInfo = restTemplate.postForObject(professionalInfoUrl + "/professions", professionalInfo,
				ProfessionalInfo.class);

		container.setPerson(person);
		container.setProfession(professionalInfo);
		return container;
	}

	@PostConstruct
	private void initialize() {
		/*
		 * URI's are constructed using the service discovery (personal-info -> name of
		 * application given in the application.properties)
		 */
		personInfoUrl = "http://personal-info/api/personal/";
		professionalInfoUrl = "http://professional-info/api/professional/";
	}

}
