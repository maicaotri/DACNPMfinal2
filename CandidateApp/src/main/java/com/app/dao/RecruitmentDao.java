package com.app.dao;

import java.util.List;

import com.app.model.Recruitment;

public interface RecruitmentDao {
	
	public void update(Recruitment recruitment);
	
	public List<Recruitment> getAllRecruitment();
	
	public Recruitment getById(int id);
}
