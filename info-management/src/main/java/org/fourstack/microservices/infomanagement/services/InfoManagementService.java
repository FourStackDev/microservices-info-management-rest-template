package org.fourstack.microservices.infomanagement.services;

import java.util.List;

import org.fourstack.microservices.infomanagement.models.InfoContainer;

public interface InfoManagementService {
	
	public List<InfoContainer> getAllPersonalAndProfessionalInfo();
	
	public InfoContainer getPersonalAndProfessionalInfoById(Long personId);
	
	public InfoContainer savePersonalAndProfessionalInfo(InfoContainer container);
}
