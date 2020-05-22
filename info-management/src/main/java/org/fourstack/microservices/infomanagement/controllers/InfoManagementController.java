package org.fourstack.microservices.infomanagement.controllers;

import java.util.List;

import org.fourstack.microservices.infomanagement.models.InfoContainer;
import org.fourstack.microservices.infomanagement.services.InfoManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info-management")
public class InfoManagementController {
	
	@Autowired
	private InfoManagementService service;

	@GetMapping
	public String getInfo() {
		return "InfoManagement Controller";
	}

	@GetMapping("/info-details")
	public ResponseEntity<List<InfoContainer>> getAllInformation() {
		List<InfoContainer> infoContainers = service.getAllPersonalAndProfessionalInfo();
		return new ResponseEntity<List<InfoContainer>>(infoContainers, HttpStatus.OK);
	}
	
	@GetMapping("/info-details/{personId}")
	public ResponseEntity<InfoContainer> getInfoByPersonId(@PathVariable Long personId) {
		InfoContainer container = service.getPersonalAndProfessionalInfoById(personId);
		
		return new ResponseEntity<InfoContainer>(container, HttpStatus.OK);
	}
	
	@PostMapping("/info-details")
	public ResponseEntity<InfoContainer> saveInfoContainerDetails(@RequestBody InfoContainer container) {
		container = service.savePersonalAndProfessionalInfo(container);
		
		return new ResponseEntity<InfoContainer>(container, HttpStatus.CREATED);
	}
}
