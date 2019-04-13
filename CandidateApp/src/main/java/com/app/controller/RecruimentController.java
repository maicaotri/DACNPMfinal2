package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Candidate;
import com.app.model.Recruitment;
import com.app.service.CandidateService;
import com.app.service.RecruimentService;

@Controller
public class RecruimentController {
	@Autowired
	CandidateService candidateService;
	@Autowired
	RecruimentService recruimentService;

	@RequestMapping(value = "/recruiment", method = RequestMethod.GET)
	public String getRecruimentPage(HttpServletRequest request) {
		List<Recruitment> listrecruiment = recruimentService.geAllRecruitment();
		List<Candidate> listCandidate = candidateService.getAllCanditate();
		request.setAttribute("listrecruiment", listrecruiment);
		request.setAttribute("listCandidate", listCandidate);
		return "recruiment";
	}

	@RequestMapping(value = "/addCanditateToRecruiment", method = RequestMethod.GET)
	public String addCanditateToRecruiment(HttpServletRequest request,
			@RequestParam(name = "idCanditate", required = true) int idCanditate,
			@RequestParam(name = "idRecruiment", required = true) int idRecruiment) {
		String mess = "This candidate not matching";
		Candidate candidate = candidateService.getById(idCanditate);
		Recruitment recruitment = recruimentService.getById(idRecruiment);
		if (candidate.getTypeOfCandidate().equals("Experience_candidate")
				&& recruitment.getRecruitmentPackage().equals("A")) {
			recruitment.setNumberOfCandidates(recruitment.getNumberOfCandidates() + 1);
			recruimentService.update(recruitment);
			mess = "Submitted this candidate successfully";
		}
		if (candidate.getTypeOfCandidate().equals("Fresher_candidate")
				&& recruitment.getRecruitmentPackage().equals("B")) {
			recruitment.setNumberOfCandidates(recruitment.getNumberOfCandidates() + 1);
			recruimentService.update(recruitment);
			mess = "Submitted this candidate successfully";
		}
		if (candidate.getTypeOfCandidate().equals("Intern_candidate")
				&& recruitment.getRecruitmentPackage().equals("C")) {
			recruitment.setNumberOfCandidates(recruitment.getNumberOfCandidates() + 1);
			recruimentService.update(recruitment);
			mess = "Submitted this candidate successfully";
		}
		List<Recruitment> listrecruiment = recruimentService.geAllRecruitment();
		List<Candidate> listCandidate = candidateService.getAllCanditate();
		request.setAttribute("listrecruiment", listrecruiment);
		request.setAttribute("listCandidate", listCandidate);
		request.setAttribute("mess", mess);
		return "recruiment";
	}
}
