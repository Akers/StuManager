package com.design.web;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Course;
import com.design.pojo.Student;
import com.design.service.impl.CourseManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddCourseAction extends ActionSupport {
	private String courseName;
	private String courseID;
	private String courseTeacher;
	
	
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public void validate() {

		ActionContext ctx = ActionContext.getContext();

		ServletContext sc = (ServletContext) ctx
				.get(ServletActionContext.SERVLET_CONTEXT);

		ApplicationContext appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);

		CourseManagerImpl cmi = (CourseManagerImpl) appContext
				.getBean("CourseManagerImpl");
		
		Course c = new Course();
		Course tempC = cmi.getCourse(this.getCourseID());
		
		
		if(tempC != null) {
			this.addFieldError("havedCourse", "课程代号已存在");
		} else if(this.getCourseID() ==null || this.getCourseName() == null || this.getCourseTeacher() == null ) {
			this.addFieldError("NoContext", "不能有空值");
		} else {
			c.setCoursId(this.getCourseID());
			c.setCoursName(this.getCourseName());
			c.setCoursTeacher(this.getCourseTeacher());
			cmi.save(c);
		}
	}

}
