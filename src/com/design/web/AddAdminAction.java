package com.design.web;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Admin;
import com.design.service.impl.AdminManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAdminAction extends ActionSupport {
  private String username;
  private String password1;
  private String password2;
  private String question;
  private String answer;
  
@SuppressWarnings("unchecked")
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

	Admin ad = ami.getAdmin(getUsername());
	Admin admin = new Admin();
	
	if (this.getUsername() == null || "".equals(this.getUsername().trim())) {
		this.addFieldError("NoUsername", "用户名不能为空！");
	} else if (this.getQuestion() == null
			|| "".equals(this.getQuestion().trim())) {
		this.addFieldError("NoQuestion", "密码问题不能为空！");
	}else if(ad != null) {
		this.addFieldError("existName", "用户已存在，请重新选择！");
	}else if(this.getAnswer() == null
			|| "".equals(this.getAnswer().trim())){
		this.addFieldError("NoAnswer", "密码问题答案不能为空！");
	} else if(!getPassword1().equals(getPassword2())) {
		this.addFieldError("WrongPassword", "两次密码不相同！");
	}else {
		admin.setName(getUsername());
		admin.setPassword((new MD5Digest()).md5crypt(getPassword1()));
//		admin.setPassword(getPassword1());
		admin.setQuestion(getQuestion());
		admin.setAnswer(getAnswer());
		admin.setSecurity(1);
		ami.save(admin);
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
