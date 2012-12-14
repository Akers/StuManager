package com.design.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.service.impl.AdminManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAdminsAction extends ActionSupport {

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		ServletContext sc = (ServletContext) ctx
				.get(ServletActionContext.SERVLET_CONTEXT);

		ApplicationContext appContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);

		AdminManagerImpl ami = (AdminManagerImpl) appContext
				.getBean("AdminManagerImpl");
		
		List adm = ami.getAdmins();
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("admins", adm);
		
		return SUCCESS;
	}

}
