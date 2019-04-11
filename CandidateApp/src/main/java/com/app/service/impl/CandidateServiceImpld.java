package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CandidateDao;
import com.app.model.Candidate;
import com.app.service.CandidateService;

@Service
public class CandidateServiceImpld implements CandidateService {
	@Autowired
	CandidateDao candidateDao;

	public void add(Candidate candidate) {
		candidateDao.add(candidate);
	}

	public List<Candidate> geAllCanditate() {
		return candidateDao.geAllCanditate();
	}

}
