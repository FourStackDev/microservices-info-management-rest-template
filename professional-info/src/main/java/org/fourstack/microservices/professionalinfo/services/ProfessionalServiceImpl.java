package org.fourstack.microservices.professionalinfo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.fourstack.microservices.professionalinfo.models.ProfessionalInfo;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {
	private static Map<Long, ProfessionalInfo> professionalInfoMap = new HashMap<>();
	private static int nextNum;
	
	@Override
	public List<ProfessionalInfo> getAllProfessionalInfoList() {
		return professionalInfoMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public ProfessionalInfo getProfessionalInfoById(Long id) {
		return professionalInfoMap.get(id);
	}
	
	@Override
	public ProfessionalInfo getProfessionalInfoByPersonId(Long personId) {
		return professionalInfoMap.values()
				                  .stream()
				                  .filter(professionInfo -> personId == professionInfo.getPersonalInfoId())
				                  .findFirst()
				                  .get();
	}
	
	@Override
	public ProfessionalInfo saveProfessionalInfo(ProfessionalInfo professionalInfo) {
		if (professionalInfo.getId() == null || professionalInfo.getId() == 0) {
			professionalInfo.setId(new Long(nextNum));
			nextNum++;
		}
		
		professionalInfoMap.put(professionalInfo.getId(), professionalInfo);
		return professionalInfo;
	}
	
	@PostConstruct
	private void initializeData() {
		ProfessionalInfo p1 = new ProfessionalInfo(48, 11, "UST", "Senior Software Developer");
		p1.setId(1l);
		p1.setPersonalInfoId(1l);
		
		ProfessionalInfo p2 = new ProfessionalInfo(23, 23, "Dairy", "Supervisor");
		p2.setId(2l);
		p2.setPersonalInfoId(2l);
		
		professionalInfoMap.put(1l, p1);
		professionalInfoMap.put(2l, p2);
		
		nextNum = professionalInfoMap.size();
	}

	

}
