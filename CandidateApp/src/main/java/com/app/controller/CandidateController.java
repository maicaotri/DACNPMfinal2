package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Candidate;
import com.app.service.CandidateService;

@Controller
public class CandidateController {
	@Autowired
	CandidateService candidateService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getAllUser(HttpServletRequest request) {
		List<Candidate> list = candidateService.geAllCanditate();
		request.setAttribute("list", list);
		return new ModelAndView("lisCandidate");
	}


}
