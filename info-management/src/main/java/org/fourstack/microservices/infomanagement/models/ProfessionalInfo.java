package org.fourstack.microservices.infomanagement.models;

import java.io.Serializable;

public class ProfessionalInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8139100353476375128L;
	
	private Long id;
	private int totalExperience;
	private int relavantExperience;
	private String currentOrganization;
	private String designation;
	
	private Long personalInfoId;
	
	public ProfessionalInfo() {}

	public ProfessionalInfo(int totalExperience, int relavantExperience, String currentOrganization,
			String designation) {
		super();
		this.totalExperience = totalExperience;
		this.relavantExperience = relavantExperience;
		this.currentOrganization = currentOrganization;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getRelavantExperience() {
		return relavantExperience;
	}

	public void setRelavantExperience(int relavantExperience) {
		this.relavantExperience = relavantExperience;
	}

	public String getCurrentOrganization() {
		return currentOrganization;
	}

	public void setCurrentOrganization(String currentOrganization) {
		this.currentOrganization = currentOrganization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getPersonalInfoId() {
		return personalInfoId;
	}

	public void setPersonalInfoId(Long personalInfoId) {
		this.personalInfoId = personalInfoId;
	}
}
