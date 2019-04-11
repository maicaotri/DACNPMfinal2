package com.app.dao;

import java.util.List;

import com.app.model.Candidate;

public interface CandidateDao {

	public void add(Candidate candidate);
	
	public List<Candidate> geAllCanditate();
}
