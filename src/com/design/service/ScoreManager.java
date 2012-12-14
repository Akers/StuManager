package com.design.service;

import java.util.List;

import com.design.pojo.Score;

public interface ScoreManager {
	public void save(Score s);

	public void upDate(Score s);
	
	public void delete(String name);

	public List getScores();

	public Score getScore(String name);
}
