package com.design.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.design.dao.CourseDAO;
import com.design.pojo.Course;

public class CourseDaoHibernate extends HibernateDaoSupport implements
		CourseDAO {

	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getCourse(id));
	}

	public Course getCourse(String id) {
		return (Course)this.getHibernateTemplate().get(com.design.pojo.Course.class, id);
	}

	public List getCourses() {
		return this.getHibernateTemplate().find("from Course");
	}

	public void save(Course c) {
		this.getHibernateTemplate().save(c);
	}

	public void upDate(Course c) {
		this.getHibernateTemplate().update(c);
	}

}
