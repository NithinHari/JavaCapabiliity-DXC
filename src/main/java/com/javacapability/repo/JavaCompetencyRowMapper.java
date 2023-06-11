package com.javacapability.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javacapability.model.JavaCompetency;

			 		
public class JavaCompetencyRowMapper implements RowMapper<JavaCompetency>{
	@Override
	public JavaCompetency mapRow(ResultSet rs, int rowNum) throws SQLException{
		JavaCompetency jc = new JavaCompetency();
		jc.setEmail_Id(rs.getString("email_id"));
		jc.setEmployee_Id(rs.getLong("employee_id"));
		jc.setJava_Building_Block(rs.getString("java_building_block"));
		jc.setType(rs.getString("type"));
		jc.setCatagory(rs.getString("catagory"));
		jc.setCompetency(rs.getString("competency"));
		jc.setProficiency(rs.getString("proficiency"));
		return jc;
	}
	
}
