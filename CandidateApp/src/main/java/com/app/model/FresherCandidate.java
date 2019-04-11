package com.app.model;

import java.util.Date;

public class FresherCandidate extends Candidate {
	private Date graduationDate;
	private String graduationRank;
	private String education;

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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
	public int getExpInYear() {
		return 0;
	}

	@Override
	public String getProSkill() {
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
	public void setExpInYear(int expInYear) {
	}

	@Override
	public void setProSkill(String proSkill) {
	}

}
