package com.design.dao;

import java.util.List;

import com.design.pojo.Score;

public interface ScoreDAO {
	public void save(Score s);

	public void upDate(Score s);
	
	public void delete(String name);

	public List getScores();

	public Score getScore(String name);
}
