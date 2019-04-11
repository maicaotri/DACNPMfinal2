package com.app.model;

import java.util.Date;

public class ExperienceCandidate extends Candidate {
	private int expInYear;
	private String proSkill;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String getMajors() {
		return null;
	}

	@Override
	public int getSemester() {
		return 0;
	}

	@Override
	public String getUniversityName() {
		return null;
	}

	@Override
	public Date getGraduationDate() {
		return null;
	}

	@Override
	public String getGraduationRank() {
		return null;
	}

	@Override
	public String getEducation() {
		return null;
	}

	@Override
	public void setMajors(String majors) {
	}

	@Override
	public void setSemester(int semester) {
	}

	@Override
	public void setUniversityName(String universityName) {
	}

	@Override
	public void setGraduationDate(Date graduationDate) {
	}

	@Override
	public void setGraduationRank(String graduationRank) {
	}

	@Override
	public void setEducation(String education) {
	}

}
