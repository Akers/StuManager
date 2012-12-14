package com.design.pojo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * Student entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Component("Student")
public class Student implements java.io.Serializable {

	// Fields

	private String stuId;
	private String stuName;
	private String stuSex;
	private String stuGrdSchool;
	private String stuAddr;
	private String stuHomePhone;
	private String stuMobilePhone;
	private String stuNowAddr;
	private String stuClass;
	private String stuAssistant;
	private String stuPhoto;
	private Set scores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String stuID,String stuName, String stuSex, String stuGrdSchool,
			String stuAddr, String stuHomePhone, String stuMobilePhone,
			String stuNowAddr, String stuClass, String stuAssistant) {
		this.stuId = stuID;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuGrdSchool = stuGrdSchool;
		this.stuAddr = stuAddr;
		this.stuHomePhone = stuHomePhone;
		this.stuMobilePhone = stuMobilePhone;
		this.stuNowAddr = stuNowAddr;
		this.stuClass = stuClass;
		this.stuAssistant = stuAssistant;
	}

	/** full constructor */
	public Student(String stuID,String stuName, String stuSex, String stuGrdSchool,
			String stuAddr, String stuHomePhone, String stuMobilePhone,
			String stuNowAddr, String stuClass, String stuAssistant,
			String stuPhoto, Set scores) {
		this.stuId = stuID;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuGrdSchool = stuGrdSchool;
		this.stuAddr = stuAddr;
		this.stuHomePhone = stuHomePhone;
		this.stuMobilePhone = stuMobilePhone;
		this.stuNowAddr = stuNowAddr;
		this.stuClass = stuClass;
		this.stuAssistant = stuAssistant;
		this.stuPhoto = stuPhoto;
		this.scores = scores;
	}

	// Property accessors

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuGrdSchool() {
		return this.stuGrdSchool;
	}

	public void setStuGrdSchool(String stuGrdSchool) {
		this.stuGrdSchool = stuGrdSchool;
	}

	public String getStuAddr() {
		return this.stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	public String getStuHomePhone() {
		return this.stuHomePhone;
	}

	public void setStuHomePhone(String stuHomePhone) {
		this.stuHomePhone = stuHomePhone;
	}

	public String getStuMobilePhone() {
		return this.stuMobilePhone;
	}

	public void setStuMobilePhone(String stuMobilePhone) {
		this.stuMobilePhone = stuMobilePhone;
	}

	public String getStuNowAddr() {
		return this.stuNowAddr;
	}

	public void setStuNowAddr(String stuNowAddr) {
		this.stuNowAddr = stuNowAddr;
	}

	public String getStuClass() {
		return this.stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getStuAssistant() {
		return this.stuAssistant;
	}

	public void setStuAssistant(String stuAssistant) {
		this.stuAssistant = stuAssistant;
	}

	public String getStuPhoto() {
		return this.stuPhoto;
	}

	public void setStuPhoto(String stuPhoto) {
		this.stuPhoto = stuPhoto;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

}