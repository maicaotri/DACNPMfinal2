package com.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.dao.CandidateDao;
import com.app.model.Candidate;
import com.app.model.ExperienceCandidate;
import com.app.model.FresherCandidate;
import com.app.model.InternCandidate;

@Repository
public class CandidateDaoImpl implements CandidateDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(Candidate c) {
		String sql = "INSERT INTO candidate(firstName,lastName,birthDate,phone,email,address,expInYear,type_of_candidate,proSkill,graduation_date,graduation_rank,education,majors,semester,university_name) "
				+ "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		jdbcTemplate.update(sql, c.getFirstName(), c.getLastName(), c.getBirthDate(), c.getPhone(), c.getEmail(),
				c.getAddress(), c.getExpInYear(), c.getTypeOfCandidate(), c.getProSkill(), c.getGraduationDate(),
				c.getGraduationRank(), c.getEducation(), c.getMajors(), c.getSemester(), c.getUniversityName());
	}

	public List<Candidate> geAllCanditate() {
		String sql = "SELECT * FROM candidate";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Candidate>() {

			public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
				Candidate c = null;
				if (rs.getString("type_of_candidate").equals("Experience_candidate")) {
					c = new ExperienceCandidate();
					c.setId(rs.getInt("id"));
					c.setFirstName(rs.getString("firstName"));
					c.setLastName(rs.getString("lastName"));
					c.setBirthDate(rs.getInt("birthDate"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));
					c.setAddress(rs.getString("address"));
					c.setExpInYear(rs.getInt("expInYear"));
					c.setTypeOfCandidate(rs.getString("type_of_candidate"));
					c.setProSkill(rs.getString("proSkill"));
				}
				if (rs.getString("type_of_candidate").equals("Fresher_candidate")) {
					c = new FresherCandidate();
					c.setId(rs.getInt("id"));
					c.setFirstName(rs.getString("firstName"));
					c.setLastName(rs.getString("lastName"));
					c.setBirthDate(rs.getInt("birthDate"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));
					c.setAddress(rs.getString("address"));
					c.setTypeOfCandidate(rs.getString("type_of_candidate"));
					c.setGraduationDate(rs.getDate("graduation_date"));
					c.setGraduationRank(rs.getString("graduation_rank"));
					c.setEducation(rs.getString("education"));
				}
				if (rs.getString("type_of_candidate").equals("Intern_candidate")) {
					c = new InternCandidate();
					c.setId(rs.getInt("id"));
					c.setFirstName(rs.getString("firstName"));
					c.setLastName(rs.getString("lastName"));
					c.setBirthDate(rs.getInt("birthDate"));
					c.setPhone(rs.getString("phone"));
					c.setEmail(rs.getString("email"));
					c.setAddress(rs.getString("address"));
					c.setTypeOfCandidate(rs.getString("type_of_candidate"));
					c.setMajors(rs.getString("majors"));
					c.setSemester(rs.getInt("semester"));
					c.setUniversityName(rs.getString("university_name"));
				}

				return c;
			}
		});
	}

}
