package com.design.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.design.dao.ScoreDAO;
import com.design.pojo.Score;

public class ScoreDaoHibernate extends HibernateDaoSupport implements ScoreDAO {

	public void delete(String name) {
		this.getHibernateTemplate().delete(getScore(name));
	}

	public Score  getScore(String name){
		return (Score)this.getHibernateTemplate().get(com.design.pojo.Score.class, name);
	}

	public List getScores() {
		return this.getHibernateTemplate().find("from Score");
	}

	public void save(Score s) {
		this.getHibernateTemplate().save(s);
	}

	public void upDate(Score s) {
		this.getHibernateTemplate().update(s);
	}

}
