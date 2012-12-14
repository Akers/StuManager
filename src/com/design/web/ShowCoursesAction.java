package com.design.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.service.impl.AdminManagerImpl;
import com.design.service.impl.CourseManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowCoursesAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		
		ActionContext ctx = ActionContext.getContext();
		ServletContext sc = (ServletContext) ctx
				.get(ServletActionContext.SERVLET_CONTEXT);

		ApplicationContext appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);

		CourseManagerImpl cmi = (CourseManagerImpl) appContext
				.getBean("CourseManagerImpl");
		
		List cmiList = cmi.getCourses();
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("courses", cmiList);
		
		return SUCCESS;
	}
}
