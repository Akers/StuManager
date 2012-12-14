package com.design.service.impl;

import java.util.List;

import com.design.dao.StudentADO;
import com.design.pojo.Student;
import com.design.service.StudentManager;

public class StudentManagerImpl implements StudentManager {

	private StudentADO stuADO;
	
	public StudentADO getStuADO() {
		return stuADO;
	}

	public void setStuADO(StudentADO stuADO) {
		this.stuADO = stuADO;
	}

	public void delete(String id) {
			stuADO.delete(id);
	}

	public Student getStudent(String id) {
		return stuADO.getStudent(id);
	}

	public List getStudents() {
		return stuADO.getStudents();
	}

	public void save(Student s) {
		stuADO.save(s);
	}

	public void upDate(Student s) {
		stuADO.upDate(s);
	}

}
