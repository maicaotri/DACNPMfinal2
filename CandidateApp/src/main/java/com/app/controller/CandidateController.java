package com.app.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Candidate;
import com.app.model.ExperienceCandidate;
import com.app.model.FresherCandidate;
import com.app.model.InternCandidate;
import com.app.service.CandidateService;

@Controller
public class CandidateController {
	@Autowired
	CandidateService candidateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getAllUser(HttpServletRequest request) {
		List<Candidate> list = candidateService.geAllCanditate();
		request.setAttribute("list", list);
		return new ModelAndView("lisCandidate");
	}

	@RequestMapping(value = "/addCandidate", method = RequestMethod.POST)
	public ModelAndView addCandidate(HttpServletRequest request, @RequestParam(name = "firstName", required = true) String firstName,
			@RequestParam(name = "lastName", required = true) String lastName,
			@RequestParam(name = "birthDate", required = true) int birthDate,
			@RequestParam(name = "address", required = true) String address,
			@RequestParam(name = "phone", required = true) String phone,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "typeOfCandidate", required = true) String typeOfCandidate,
			@RequestParam(name = "expInYear", required = false) Integer expInYear,
			@RequestParam(name = "proSkill", required = false) String proSkill,
			@RequestParam(name = "graduationDate", required = false) Date graduationDate,
			@RequestParam(name = "graduationRank", required = false) Integer graduationRank,
			@RequestParam(name = "education", required = false) String education,
			@RequestParam(name = "majors", required = false) String majors,
			@RequestParam(name = "semester", required = false) Integer semester,
			@RequestParam(name = "universityName", required = false) String universityName) {
		Candidate c = null;
		Calendar calendar = Calendar.getInstance();
		StringBuilder errBirthday;
		StringBuilder errPhone = new StringBuilder();
		StringBuilder errEmail = new StringBuilder();
		StringBuilder errExpInYear = new StringBuilder();
		String graduationRankName =null;

		if (typeOfCandidate.equals("Experience_candidate")) {
			c = new ExperienceCandidate();
			c.setExpInYear(expInYear);
			c.setProSkill(proSkill);
		}
		if (typeOfCandidate.equals("Fresher_candidate")) {
			c = new FresherCandidate();
			c.setGraduationDate(graduationDate);
			c.setEducation(education);
			switch (graduationRank) {
			case 1:
				graduationRankName = "Excellence";
				break;
			case 2:
				graduationRankName = "Good";
				break;
			case 3:
				graduationRankName = "Fair";
				break;
			case 4:
				graduationRankName = "Poor";
				break;
			}
			c.setGraduationRank(graduationRankName);
		}
		if (typeOfCandidate.equals("Intern_candidate")) {
			c = new InternCandidate();
			c.setMajors(majors);
			c.setSemester(semester);
			c.setUniversityName(universityName);
		}

		if (c != null) {
			if (birthDate <= 1900 || birthDate > calendar.get(Calendar.YEAR)) {
				errBirthday = new StringBuilder("Vui long nhap lai nam sinh (>=1990 va < nam hien tai): ");
			}
			Pattern pattern = Pattern.compile("^[0-9]*$");
			Matcher matcher = pattern.matcher(phone);
			if (!matcher.matches()) {
				errPhone.append("Chuoi nhap vao phai la so, vui long nhap lai!");
				if (phone.length() < 7)
					errPhone.append("So dien thoai phai it nhat 7 chu so, vui long nhap lai!");
			}

			String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			Pattern regex = Pattern.compile(emailPattern);
			Matcher matcher2 = regex.matcher(email);
			if (!matcher2.find()) {
				errEmail.append("Email khong hop le, vui long nhap lai!");
			}

			while (expInYear < 0 || expInYear > 100) {
				errExpInYear.append("Nam kinh nghiem khong hop le, vui long nhap lai!");
			}

			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setBirthDate(birthDate);
			c.setAddress(address);
			c.setPhone(phone);
			c.setEmail(email);
			c.setTypeOfCandidate(typeOfCandidate);
			candidateService.add(c);
		}
		List<Candidate> list = candidateService.geAllCanditate();
		request.setAttribute("list", list);
		return new ModelAndView("lisCandidate");
	}

}
