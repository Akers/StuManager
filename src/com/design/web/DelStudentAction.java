package com.design.web;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Admin;
import com.design.pojo.Student;
import com.design.service.impl.StudentManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class DelStudentAction extends ActionSupport {


	private String stuID;

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
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

		StudentManagerImpl stu = (StudentManagerImpl) appContext
				.getBean("StuManagerImpl");
		Student student = stu.getStudent(this.getStuID());
		
		if(this.getStuID() == null || "".equals(this.getStuID())) {
			this.addFieldError("blankName", "学号不能为空");
		} else if(student == null) {
			this.addFieldError("noName", "学号不存在");
		} else  {
			stu.delete(this.getStuID());
		}

	}
	
}
