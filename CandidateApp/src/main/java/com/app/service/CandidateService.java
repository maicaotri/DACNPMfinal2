package com.app.service;

import java.util.List;

import com.app.model.Candidate;

public interface CandidateService {
	
	public void add(Candidate candidate);
	
	public List<Candidate> getAllCanditate();
	
	public Candidate getById(int id);
}
