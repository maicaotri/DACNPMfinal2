package com.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.dao.RecruitmentDao;
import com.app.model.Recruitment;

@Repository
public class RecruitmentDaoImpl implements RecruitmentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void update(Recruitment recruitment) {
		String sql = "UPDATE recruitment SET number_of_candidates = ? WHERE recruitment_code =?";
		jdbcTemplate.update(sql, recruitment.getNumberOfCandidates(), recruitment.getRecruitmentCode());

	}

	public List<Recruitment> getAllRecruitment() {
		String sql = "SELECT * FROM recruitment ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Recruitment>() {

			public Recruitment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Recruitment r = new Recruitment();
				r.setNumberOfCandidates(rs.getInt("number_of_candidates"));
				r.setPosition(rs.getString("position"));
				r.setRecruitmentCode(rs.getInt("recruitment_code"));
				r.setRecruitmentPackage(rs.getString("recruitment_package"));
				return r;
			}
		});
	}

	public Recruitment getById(int id) {
		String sql = "SELECT * FROM recruitment WHERE id =?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Recruitment>() {

			public Recruitment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Recruitment r = new Recruitment();
				r.setNumberOfCandidates(rs.getInt("number_of_candidates"));
				r.setPosition(rs.getString("position"));
				r.setRecruitmentCode(rs.getInt("recruitment_code"));
				r.setRecruitmentPackage(rs.getString("recruitment_package"));
				return r;
			}
		});
	}

}
