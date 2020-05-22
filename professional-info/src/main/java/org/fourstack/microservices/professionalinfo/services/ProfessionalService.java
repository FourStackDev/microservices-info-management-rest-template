package org.fourstack.microservices.professionalinfo.services;

import java.util.List;

import org.fourstack.microservices.professionalinfo.models.ProfessionalInfo;

public interface ProfessionalService {
	
	public List<ProfessionalInfo> getAllProfessionalInfoList();
	
	public ProfessionalInfo getProfessionalInfoById(Long id);
	
	public ProfessionalInfo saveProfessionalInfo(ProfessionalInfo professionalInfo);

	ProfessionalInfo getProfessionalInfoByPersonId(Long personId);
}
