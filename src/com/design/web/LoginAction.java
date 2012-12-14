package com.design.web;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Admin;
import com.design.service.impl.AdminManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	private Admin adm;

	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("username", this.getUsername());
		session.put("security", getAdm().getSecurity());
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
		this.setAdm(admin);
		if (this.getUsername() == null || "".equals(this.getUsername().trim())) {
			this.addFieldError("NoUsername", "用户名不能为空！");
		} else if (this.getPassword() == null
				|| "".equals(this.getPassword().trim())) {
			this.addFieldError("NoPassword", "密码不能为空！");
		} else if (admin == null) {
			this.addFieldError("LoginNull", "用户名不存在，请重新登陆！");
			// } else if (!admin.getPassword().equals( getPassword())) {

		} else if (!admin.getPassword().equals(
				(new MD5Digest()).md5crypt(getPassword()))) {
			this.addFieldError("PasswordFailure", "密码错误，请重新登陆！");
		}
	}

}
