package com.design.dao;

import java.util.List;

import com.design.pojo.Course;

public interface CourseDAO {
	   
	public void save(Course c);
	
	public void delete(String id);
	
	public void upDate(Course c);
	
	public Course getCourse(String id);
	
	public List getCourses();
	
}
