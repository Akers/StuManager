package com.design.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Course;
import com.design.pojo.Student;
import com.design.service.impl.CourseManagerImpl;
import com.design.service.impl.StudentManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddScoreAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		ActionContext ctx = ActionContext.getContext();

		ServletContext sc = (ServletContext) ctx
				.get(ServletActionContext.SERVLET_CONTEXT);

		ApplicationContext appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);

		CourseManagerImpl cmi = (CourseManagerImpl) appContext
				.getBean("CourseManagerImpl");
		StudentManagerImpl smi = (StudentManagerImpl)appContext
		.getBean("StuManagerImpl");

		
		List cmiList = cmi.getCourses();
		List smiList = smi.getStudents();
		
		Map cmiMap = new HashMap();
		Map smiMap= new HashMap();
		
		for(int i=0; i<cmiList.size();i++) {
			Course course = (Course)cmiList.get(i);
			cmiMap.put(course.getCoursId(), course.getCoursName());
		}
		
		for(int i=0; i<smiList.size();i++) {
			Student student = (Student)smiList.get(i);
			smiMap.put(student.getStuId(), student.getStuName());
		}

		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("cmiMap", cmiMap);
		session.put("smiMap", smiMap);
		return SUCCESS;
		
	}
	
}
