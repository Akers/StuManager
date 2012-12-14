package com.design.pojo;

import org.springframework.stereotype.Component;

/**
 * Score entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Component("Score")
public class Score implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private Student student;
	private String stuScore;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** minimal constructor */
	public Score(Course course, Student student) {
		this.course = course;
		this.student = student;
	}

	/** full constructor */
	public Score(Course course, Student student, String stuScore) {
		this.course = course;
		this.student = student;
		this.stuScore = stuScore;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStuScore() {
		return this.stuScore;
	}

	public void setStuScore(String stuScore) {
		this.stuScore = stuScore;
	}

}