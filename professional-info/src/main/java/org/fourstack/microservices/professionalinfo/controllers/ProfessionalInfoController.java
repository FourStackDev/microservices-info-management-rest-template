package org.fourstack.microservices.professionalinfo.controllers;

import java.util.List;

import org.fourstack.microservices.professionalinfo.models.ProfessionalInfo;
import org.fourstack.microservices.professionalinfo.services.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professional")
public class ProfessionalInfoController {

	@Autowired
	private ProfessionalService service;
	
	@GetMapping("/info")
	public String getInfo() {
		return "Professional Info Controller";
	}
	
	@GetMapping("/professions")
	public List<ProfessionalInfo> getAllProfessionalInfoList() {
		return service.getAllProfessionalInfoList();
	}
	
	@GetMapping("/professions/{personId}")
	public ProfessionalInfo getProfessionalInfoByPersonalId(@PathVariable long personId) {
		return service.getProfessionalInfoByPersonId(personId);
	}
	
	@PostMapping("/professions")
	public ProfessionalInfo saveProfessionalInfo(@RequestBody ProfessionalInfo professionalInfo) {
		return service.saveProfessionalInfo(professionalInfo);
	}
}
