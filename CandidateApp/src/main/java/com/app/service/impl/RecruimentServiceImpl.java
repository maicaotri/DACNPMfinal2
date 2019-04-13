package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RecruitmentDao;
import com.app.model.Recruitment;
import com.app.service.RecruimentService;

@Service
public class RecruimentServiceImpl implements RecruimentService {
	@Autowired
	RecruitmentDao recruitmentDao;

	public void update(Recruitment recruitment) {
		recruitmentDao.update(recruitment);
	}

	public List<Recruitment> geAllRecruitment() {
		return recruitmentDao.getAllRecruitment();
	}

	public Recruitment getById(int id) {
		return recruitmentDao.getById(id);
	}

}
