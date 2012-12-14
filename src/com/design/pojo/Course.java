package com.design.pojo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * Course entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Component("Course")
public class Course implements java.io.Serializable {

	// Fields

	private String coursId;
	private String coursName;
	private String coursTeacher;
	private Set scores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String courseid,String coursName, String coursTeacher) {
		this.coursId = courseid;
		this.coursName = coursName;
		this.coursTeacher = coursTeacher;
	}

	/** full constructor */
	public Course(String coursName, String coursTeacher, Set scores) {
		this.coursName = coursName;
		this.coursTeacher = coursTeacher;
		this.scores = scores;
	}

	// Property accessors

	public String getCoursId() {
		return this.coursId;
	}

	public void setCoursId(String coursId) {
		this.coursId = coursId;
	}

	public String getCoursName() {
		return this.coursName;
	}

	public void setCoursName(String coursName) {
		this.coursName = coursName;
	}

	public String getCoursTeacher() {
		return this.coursTeacher;
	}

	public void setCoursTeacher(String coursTeacher) {
		this.coursTeacher = coursTeacher;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

}