package com.design.web;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Admin;
import com.design.service.impl.AdminManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelAdminAction extends ActionSupport {

	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

		AdminManagerImpl ami = (AdminManagerImpl) appContext
				.getBean("AdminManagerImpl");
		Admin admin = ami.getAdmin(this.getUsername());
		
		if(getUsername() == null || "".equals(getUsername())) {
			this.addFieldError("blankName", "用户名不能为空");
		} else if(admin == null) {
			this.addFieldError("noName", "用户名不存在");
		} else  {
			ami.delete(getUsername());
		}
	}

}
