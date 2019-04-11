package com.app.model;

import java.util.Date;

public abstract class Candidate {
	private int id;
	private String firstName;
	private String lastName;
	private int birthDate;
	private String address;
	private String phone;
	private String email;
	private String typeOfCandidate;
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeOfCandidate() {
		return typeOfCandidate;
	}

	public void setTypeOfCandidate(String typeOfCandidate) {
		this.typeOfCandidate = typeOfCandidate;
	}

	public abstract String getMajors();

	public abstract int getSemester();

	public abstract String getUniversityName();

	public abstract Date getGraduationDate();

	public abstract String getGraduationRank();

	public abstract String getEducation();

	public abstract int getExpInYear();

	public abstract String getProSkill();

	public abstract void setMajors(String majors);

	public abstract void setSemester(int semester);

	public abstract void setUniversityName(String universityName);

	public abstract void setGraduationDate(Date graduationDate);

	public abstract void setGraduationRank(String graduationRank);

	public abstract void setEducation(String education);

	public abstract void setExpInYear(int expInYear);

	public abstract void setProSkill(String proSkill);

}
