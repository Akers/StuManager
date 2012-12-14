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

public class ModifyAdminAction extends ActionSupport {
	private String username;
	private String question;
	private String answer;
	private String password1;
	private String password2;

	private Admin adm;

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
		} else if (this.getQuestion() == null
				|| "".equals(this.getQuestion().trim())) {
			this.addFieldError("NoQuestion", "密码问题不能为空！");
		} else if(this.getAnswer() == null
				|| "".equals(this.getAnswer().trim())){
			this.addFieldError("NoAnswer", "密码问题答案不能为空！");
		} else if (admin == null) {
			this.addFieldError("LoginNull", "用户名不存在，请重新登陆！");
		} else if(!admin.getQuestion().equals(this.getQuestion())) {
			this.addFieldError("WrongQuestion", "密码问题错误！");
		} else if (!admin.getAnswer().equals(this.getAnswer())) {
			this.addFieldError("WrongAnswer", "密码问题答案错误！");
		} else if(!getPassword1().equals(getPassword2())) {
			this.addFieldError("WrongPassword", "两次密码不相同！");
		}else {
//			admin.setPassword(getPassword1());
			admin.setPassword((new MD5Digest()).md5crypt(getPassword1()));
			ami.upDate(admin);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
