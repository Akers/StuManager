package com.design.service.impl;

import java.util.List;

import com.design.dao.ScoreDAO;
import com.design.pojo.Score;
import com.design.service.ScoreManager;

public class ScoreManagerImpl implements ScoreManager {

	
	private ScoreDAO scoreDAO;
	
	public ScoreDAO getScoreDAO() {
		return scoreDAO;
	}

	public void setScoreDAO(ScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}

	public void delete(String name) {
		scoreDAO.delete(name);
	}

	public Score getScore(String name) {
		return scoreDAO.getScore(name);
	}

	public List<Score> getScores() {
		return scoreDAO.getScores();
	}

	public void save(Score s) {
		scoreDAO.save(s);
	}

	public void upDate(Score s) {
		scoreDAO.upDate(s);
	}

}
