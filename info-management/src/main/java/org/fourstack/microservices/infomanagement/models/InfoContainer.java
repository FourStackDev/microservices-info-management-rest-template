package org.fourstack.microservices.infomanagement.models;

import java.io.Serializable;

public class InfoContainer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1695569298158368840L;

	private Person person;
	private ProfessionalInfo profession;

	public InfoContainer() {
	}

	public InfoContainer(Person person, ProfessionalInfo profession) {
		super();
		this.person = person;
		this.profession = profession;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ProfessionalInfo getProfession() {
		return profession;
	}

	public void setProfession(ProfessionalInfo profession) {
		this.profession = profession;
	}
}
