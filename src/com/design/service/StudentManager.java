package com.design.service;

import java.util.List;

import com.design.pojo.Student;

public interface StudentManager {
	   
	public void save(Student s);
	
	public void delete(String id);
	
	public void upDate(Student s);
	
	public Student getStudent(String id);
	
	public List getStudents();
   
}
