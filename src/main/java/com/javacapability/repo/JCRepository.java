package com.javacapability.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javacapability.model.JavaCompetency;

@Repository
public interface JCRepository {
	
	public List<JavaCompetency> countJcList();
	
	public List<JavaCompetency> proficiencyList();
	public List<JavaCompetency> proficiencyListbyEmailId(String emailId);
	public List<JavaCompetency> proficiencyListbyEmployeeId(Long employeeId);
	
	public List<JavaCompetency> findByEmailid(String email_id);
	public List<JavaCompetency> findByEmployeeId(Long employee_Id);

	public JavaCompetency formByEmailId(String email_id, String competency_name);
	public JavaCompetency formByEmployeeId(Long employee_id, String competency_name);
	
	public void updateByEmailId(JavaCompetency jc, String email_id, String competency_name, String proficiency);
	public void updateByEmployeeId(JavaCompetency jc, Long employee_id, String competency_name);

	public int updateByEmailIdNew(JavaCompetency jc, String email_id, String competency_name, String proficiency);
	public int updateByEmployeeIdNew(JavaCompetency jc, Long employee_id, String competency_name, String proficiency);

	



}
