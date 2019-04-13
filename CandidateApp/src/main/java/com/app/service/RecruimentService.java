package com.app.service;

import java.util.List;

import com.app.model.Recruitment;

public interface RecruimentService {
	
	public void update(Recruitment recruitment);

	public List<Recruitment> geAllRecruitment();
	
	public Recruitment getById(int id);
}
