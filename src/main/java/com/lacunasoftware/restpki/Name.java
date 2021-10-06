package com.lacunasoftware.restpki;

import com.lacunasoftware.restpki.NameModel;

/**
 * A X.509 Name
 */
public class Name {

	private String country;
	private String organization;
	private String organizationUnit;
	private String dnQualifier;
	private String stateName;
	private String commonName;
	private String serialNumber;
	private String locality;
	private String title;
	private String surname;
	private String givenName;
	private String initials;
	private String pseudonym;
	private String generationQualifier;
	private String emailAddress;

	Name(NameModel model) {
		this.country = model.getCountry();
		this.organization = model.getOrganization();
		this.organizationUnit = model.getOrganizationUnit();
		this.dnQualifier = model.getDnQualifier();
		this.stateName = model.getStateName();
		this.commonName = model.getCommonName();
		this.serialNumber = model.getSerialNumber();
		this.locality = model.getLocality();
		this.title = model.getTitle();
		this.surname = model.getSurname();
		this.givenName = model.getGivenName();
		this.initials = model.getInitials();
		this.pseudonym = model.getPseudonym();
		this.generationQualifier = model.getGenerationQualifier();
		this.emailAddress = model.getEmailAddress();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganizationUnit() {
		return organizationUnit;
	}

	public void setOrganizationUnit(String organizationUnit) {
		this.organizationUnit = organizationUnit;
	}

	public String getDnQualifier() {
		return dnQualifier;
	}

	public void setDnQualifier(String dnQualifier) {
		this.dnQualifier = dnQualifier;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public String getGenerationQualifier() {
		return generationQualifier;
	}

	public void setGenerationQualifier(String generationQualifier) {
		this.generationQualifier = generationQualifier;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
