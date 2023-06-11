package com.javacapability.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JavaCompetency {

	@Column(name = "employee_Id")
	private long employee_Id;
	@Column(name = "email_id")
	private String email_id;
	@Column(name = "java_Building_Block")
    private String java_Building_Block;
	@Column(name = "type")
    private String type;
	@Column(name = "Catagory")
    private String Catagory;
	@Column(name = "competency")
    private String competency;
	@Column(name = "proficiency")
    private String proficiency;
	@Column(name = "competency_Name")
    private String competency_Name;
    @Id
    @Column(name = "competency_id")
    private int competency_id;
    private int countProficiency;
	private String workingExperience;
	private String basicUnderstanding;
	private String extensiveExperience;
	private String subjectMaterExperience;
	
	public long getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(long employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getEmail_Id() {
		return email_id;
	}

	public void setEmail_Id(String email_id) {
		this.email_id = email_id;
	}

	public String getJava_Building_Block() {
		return java_Building_Block;
	}

	public void setJava_Building_Block(String java_Building_Block) {
		this.java_Building_Block = java_Building_Block;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCatagory() {
		return Catagory;
	}

	public void setCatagory(String catagory) {
		Catagory = catagory;
	}

	public String getCompetency() {
		return competency;
	}

	public void setCompetency(String competency) {
		this.competency = competency;
	}

	public String getProficiency() {
		return proficiency;
	}

	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}

	public String getCompetency_Name() {
		return competency_Name;
	}

	public void setCompetency_Name(String competency_Name) {
		this.competency_Name = competency_Name;
	}

	public int getCompetency_id() {
		return competency_id;
	}

	public void setCompetency_id(int competency_id) {
		this.competency_id = competency_id;
	}

	public int getCountProficiency() {
		return countProficiency;
	}

	public void setCountProficiency(int countProficiency) {
		this.countProficiency = countProficiency;
	}

	public String getWorkingExperience() {
		return workingExperience;
	}

	public void setWorkingExperience(String workingExperience) {
		this.workingExperience = workingExperience;
	}

	public String getBasicUnderstanding() {
		return basicUnderstanding;
	}

	public void setBasicUnderstanding(String basicUnderstanding) {
		this.basicUnderstanding = basicUnderstanding;
	}

	public String getExtensiveExperience() {
		return extensiveExperience;
	}

	public void setExtensiveExperience(String extensiveExperience) {
		this.extensiveExperience = extensiveExperience;
	}

	public String getSubjectMaterExperience() {
		return subjectMaterExperience;
	}

	public void setSubjectMaterExperience(String subjectMaterExperience) {
		this.subjectMaterExperience = subjectMaterExperience;
	}

	public JavaCompetency(long employee_Id, String email_id, String java_Building_Block, String type, String catagory,
			String competency, String proficiency, String competency_Name, int competency_id, int countProficiency,
			String workingExperience, String basicUnderstanding, String extensiveExperience,
			String subjectMaterExperience) {
		this.employee_Id = employee_Id;
		this.email_id = email_id;
		this.java_Building_Block = java_Building_Block;
		this.type = type;
		this.Catagory = catagory;
		this.competency = competency;
		this.proficiency = proficiency;
		this.competency_Name = competency_Name;
		this.competency_id = competency_id;
		this.countProficiency = countProficiency;
		this.workingExperience = workingExperience;
		this.basicUnderstanding = basicUnderstanding;
		this.extensiveExperience = extensiveExperience;
		this.subjectMaterExperience = subjectMaterExperience;
	}
	

	@Override
	public String toString() {
		return "JavaCompetency [employee_Id=" + employee_Id + ", email_id=" + email_id + ", java_Building_Block="
				+ java_Building_Block + ", type=" + type + ", Catagory=" + Catagory + ", competency=" + competency
				+ ", proficiency=" + proficiency + ", competency_Name=" + competency_Name + ", competency_id="
				+ competency_id + ", countProficiency=" + countProficiency + ", workingExperience=" + workingExperience
				+ ", basicUnderstanding=" + basicUnderstanding + ", extensiveExperience=" + extensiveExperience
				+ ", subjectMaterExperience=" + subjectMaterExperience + "]";
	}

	public JavaCompetency() {
		
	}
}
