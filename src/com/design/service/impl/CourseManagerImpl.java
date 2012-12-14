package com.design.service.impl;

import java.util.List;

import com.design.dao.CourseDAO;
import com.design.pojo.Course;
import com.design.service.CourseManager;

public class CourseManagerImpl implements CourseManager {

	private CourseDAO courseDAO;
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void delete(String id) {
		courseDAO.delete(id);
	}

	public Course getCourse(String name) {
		return courseDAO.getCourse(name);
	}

	public List getCourses() {
		return courseDAO.getCourses();
	}

	public void save(Course c) {
		courseDAO.save(c);
	}

	public void upDate(Course c) {
		courseDAO.upDate(c);
	}

}
