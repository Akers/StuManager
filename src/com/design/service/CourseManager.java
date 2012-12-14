package com.design.service;

import java.util.List;

import com.design.pojo.Course;

public interface CourseManager {
	
	public void save(Course c);

	public void upDate(Course c);

	public void delete(String id);

	public List getCourses();

	public Course getCourse(String name);
}
