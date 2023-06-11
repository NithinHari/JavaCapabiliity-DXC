package com.javacapability.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.javacapability.model.JavaCompetency;


@Transactional

public class JCRepoImp implements JCRepository{
	
	
	private JdbcTemplate jdbcTemplate;
	
	public JCRepoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		 
	}
	
	
	@Override
	public List<JavaCompetency> countJcList() {
		List<JavaCompetency> list = jdbcTemplate.query("select cm.java_building_block, cm.type, cm.catagory, tc.competency_name,tc.proficiency, count(tc.proficiency)\r\n"
				+ ", case when proficiency = \"Working Experience\" then count(tc.proficiency) else 0 end as Working_Experience\r\n"
				+ ", case when proficiency = \"Basic Understanding\" then count(tc.proficiency) else 0 end as Basic_Understanding\r\n"
				+ ", case when proficiency = \"Extensive Experience\" then count(tc.proficiency) else 0 end as Extensive_Experience\r\n"
				+ ", case when proficiency = \"Subject MaterExperience\" then count(tc.proficiency) else 0 end as Subject_MaterExperience\r\n"
				+ "from team_competency tc, \r\n"
				+ "competency_master cm where \r\n"
				+ "cm.id = tc.Competency_id \r\n"
				+ "group by tc.competency_name, tc.proficiency;", new RowMapper<JavaCompetency>() {
			@Override
			public JavaCompetency mapRow(ResultSet rs, int rowNum) throws SQLException {
				JavaCompetency jc = new JavaCompetency();			
				jc.setJava_Building_Block(rs.getString("java_building_block"));
				jc.setType(rs.getString("type"));
				jc.setCatagory(rs.getString("catagory"));
				jc.setCompetency_Name(rs.getString("competency_name"));
				jc.setProficiency(rs.getString("proficiency"));	
				jc.setCountProficiency(rs.getInt("count(tc.proficiency)"));
				jc.setWorkingExperience(rs.getString("Working_Experience"));
				jc.setBasicUnderstanding(rs.getString("Basic_Understanding"));
				jc.setExtensiveExperience(rs.getString("Extensive_Experience"));
				jc.setSubjectMaterExperience(rs.getString("Subject_MaterExperience"));
				return jc;
			}
		});
		return list;	
	}


	@Override
	public List<JavaCompetency> proficiencyList() {
		
		return jdbcTemplate.query("select Employee_Id, Email_Id, Competency_Name, Proficiency from team_competency;",
				new BeanPropertyRowMapper<JavaCompetency>(JavaCompetency.class));
	}


	@Override
	public List<JavaCompetency> proficiencyListbyEmailId(String email_Id) {
		return jdbcTemplate.query("select Employee_Id, Email_Id, Competency_Name, Proficiency from team_competency where email_id = ?;",
				new BeanPropertyRowMapper<JavaCompetency>(JavaCompetency.class), email_Id);	
		}


	@Override
	public List<JavaCompetency> proficiencyListbyEmployeeId(Long employee_Id) {
		return jdbcTemplate.query("select Employee_Id, Email_Id, Competency_Name, Proficiency from team_competency where employee_id = ?;",
				new BeanPropertyRowMapper<JavaCompetency>(JavaCompetency.class), employee_Id);
	}
	
	@Override
	public List<JavaCompetency> findByEmailid(String email_id) {
		String sql = "select distinct Employee_id,Email_Id,java_building_block, type, catagory, Competency, proficiency from competency_master join team_competency on competency_master.id = team_competency.Competency_id and competency_master.Competency = team_competency.Competency_Name where email_id = ? ;";
		return jdbcTemplate.query(sql, new JavaCompetencyRowMapper(), email_id);
	}

 
	@Override
	public List<JavaCompetency> findByEmployeeId(Long employee_Id) {
		String sql = "select distinct Employee_id,Email_Id,java_building_block, type, catagory, Competency, proficiency from competency_master join team_competency on competency_master.id = team_competency.Competency_id and competency_master.Competency = team_competency.Competency_Name where Employee_id = ? ;";
		return jdbcTemplate.query(sql, new JavaCompetencyRowMapper(), employee_Id);
	}
	


	
	@Override
	public JavaCompetency formByEmailId(String email_id, String competency_name) {
		String sql = "select distinct Employee_id,Email_Id,java_building_block, type, catagory, Competency, proficiency "
				+ "from competency_master join team_competency on competency_master.id = team_competency.Competency_id "
				+ "and competency_master.Competency = team_competency.Competency_Name "
				+ "where email_id = ? and competency_name = ? ;";
		return jdbcTemplate.queryForObject(sql, new JavaCompetencyRowMapper(), email_id, competency_name);
	}


	@Override
	public JavaCompetency formByEmployeeId(Long employee_id, String competency_name) {
		String sql = "select distinct Employee_id,Email_Id,java_building_block, type, catagory, Competency, proficiency "
				+ "from competency_master join team_competency on competency_master.id = team_competency.Competency_id "
				+ "and competency_master.Competency = team_competency.Competency_Name "
				+ "where Employee_id = ? and competency_name = ? ;";
		return jdbcTemplate.queryForObject(sql, new JavaCompetencyRowMapper(), employee_id, competency_name);
	}

	@Override
	public void updateByEmailId(JavaCompetency jc, String email_id, String competency_name, String proficiency) {
		String sql = "update team_competency set proficiency = ? where email_id = ? and Competency_Name = ?";
		jdbcTemplate.update(sql, jc.getProficiency(), jc.getEmail_Id(),jc.getCompetency_Name());
	}


	@Override
	public void updateByEmployeeId(JavaCompetency jc, Long employee_id, String competency_name) {
		String sql = "update team_competency set proficiency = ? where employee_id = ? and Competency_Name = ?";
		jdbcTemplate.update(sql, jc.getProficiency(),jc.getEmployee_Id(),jc.getCompetency_Name());	
	}
	//, jc.getEmail_Id(),jc.getCompetency_Name(),email_id,competency_name,
	//, jc.getEmployee_Id(),jc.getCompetency_Name(), employee_id,competency_name

	
	@Override
	public int updateByEmailIdNew(JavaCompetency jc, String email_id, String competency_name, String proficiency) {
		return jdbcTemplate.update("update team_competency set proficiency = ? where email_id = ? and Competency_Name = ?;", 
				new Object[] {jc.getProficiency(),email_id,competency_name  }
				);
	}
	@Override
	public int updateByEmployeeIdNew(JavaCompetency jc, Long employee_id, String competency_name, String proficiency) {
		return jdbcTemplate.update("update team_competency set proficiency = ? where employee_id = ? and Competency_Name = ?;", 
				new Object[] {jc.getProficiency(),employee_id,competency_name  }
				);
	
	}
}
