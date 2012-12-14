package com.design.web;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.dao.hibernate.CourseDaoHibernate;
import com.design.dao.hibernate.StudentADOHibernate;
import com.design.pojo.Admin;
import com.design.pojo.Course;
import com.design.pojo.Score;
import com.design.pojo.Student;
import com.design.service.impl.CourseManagerImpl;
import com.design.service.impl.ScoreManagerImpl;
import com.design.service.impl.StudentManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddScoreDataAction extends ActionSupport {

	private String courseID;
	private String stuName;
	private String score;
	
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String execute() throws Exception {

		if(Integer.parseInt( this.getScore()) < 0 || Integer.parseInt( this.getScore())>150) {
			this.addFieldError("WrongScore", "成绩违法！");
		} else {
			ActionContext ctx = ActionContext.getContext();
			ServletContext sc = (ServletContext) ctx
					.get(ServletActionContext.SERVLET_CONTEXT);

			ApplicationContext appContext = WebApplicationContextUtils
					.getRequiredWebApplicationContext(sc);

			ScoreManagerImpl smi = (ScoreManagerImpl) appContext
					.getBean("ScoreManagerImpl");
			
			StudentManagerImpl stumi = (StudentManagerImpl)appContext
			.getBean("StuManagerImpl");
			
			CourseManagerImpl cmi = (CourseManagerImpl)appContext.getBean("CourseManagerImpl");
			
			Course course = cmi.getCourse(this.getCourseID());
			Student student = stumi.getStudent(this.getStuName());

			Score s = new Score();
			s.setStuScore(getScore());
			s.setStudent(student);
			s.setCourse(course);
			
			smi.save(s);
		}
		return SUCCESS;
	}
	
}
