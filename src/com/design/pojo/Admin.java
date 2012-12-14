package com.design.pojo;

import org.springframework.stereotype.Component;

/**
 * Admin entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Component("Admin")
public class Admin implements java.io.Serializable {

	// Fields

	private int id;
	private String name;
	private String password;
	private String question;
	private String answer;
	private int security;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public Admin(String name, String password, String question, String answer,
			Integer security) {
		this.name = name;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.security = security;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getSecurity() {
		return this.security;
	}

	public void setSecurity(int security) {
		this.security = security;
	}

}