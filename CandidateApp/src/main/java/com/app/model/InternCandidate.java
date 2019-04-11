package com.app.model;

import java.util.Date;

public class InternCandidate extends Candidate {
	private String majors;
	private int semester;
	private String universityName;

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
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
	public int getExpInYear() {
		return 0;
	}

	@Override
	public String getProSkill() {
		return null;
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

	@Override
	public void setExpInYear(int expInYear) {
	}

	@Override
	public void setProSkill(String proSkill) {
	}

}
