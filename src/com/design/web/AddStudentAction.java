package com.design.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.design.pojo.Student;
import com.design.service.impl.StudentManagerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class AddStudentAction extends ActionSupport {

	private static final int BUFFER_SIZE = 16 * 1024 ;
	private String stuID;
    private String userName;
    private String sex;
    private String StuGrdSchool;
    private String StuAddr;
    private String StuHomePhone;
    private String StuMobilePhone;
    private String StuNowAddr;
    private String StuClass;
    private String StuAssistant;
    private File StuPhoto;
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStuGrdSchool() {
		return StuGrdSchool;
	}
	public void setStuGrdSchool(String stuGrdSchool) {
		StuGrdSchool = stuGrdSchool;
	}
	public String getStuAddr() {
		return StuAddr;
	}
	public void setStuAddr(String stuAddr) {
		StuAddr = stuAddr;
	}
	public String getStuHomePhone() {
		return StuHomePhone;
	}
	public void setStuHomePhone(String stuHomePhone) {
		StuHomePhone = stuHomePhone;
	}
	public String getStuMobilePhone() {
		return StuMobilePhone;
	}
	public void setStuMobilePhone(String stuMobilePhone) {
		StuMobilePhone = stuMobilePhone;
	}
	public String getStuNowAddr() {
		return StuNowAddr;
	}
	public void setStuNowAddr(String stuNowAddr) {
		StuNowAddr = stuNowAddr;
	}
	public String getStuClass() {
		return StuClass;
	}
	public void setStuClass(String stuClass) {
		StuClass = stuClass;
	}
	public String getStuAssistant() {
		return StuAssistant;
	}
	public void setStuAssistant(String stuAssistant) {
		StuAssistant = stuAssistant;
	}
	public File getStuPhoto() {
		return StuPhoto;
	}
	public void setStuPhoto(File stuPhoto) {
		StuPhoto = stuPhoto;
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
		Student tempStu = stu.getStudent(this.getStuID());
		
		Student student = new Student();
		
		if(tempStu != null) {
			this.addFieldError("existStuID", "学号已存在，请查证后重新输入！");
		}else if (this.getStuID() == null || "".equals(this.getStuID().trim())) {
			this.addFieldError("NoStuID", "学号不能为空！");
		} else if (this.getStuGrdSchool() == null || "".equals(this.getStuGrdSchool().trim())) {
			this.addFieldError("NoStuGrdSchool", "毕业学校不能为空！");
		}else if(this.getStuAssistant() == null
				|| "".equals(this.getStuAssistant().trim())){
			this.addFieldError("NoAssistant", "辅导员不能为空！");
		} else if(this.getStuClass()== null || "".equals(this.getStuClass().trim())) {
			this.addFieldError("NoClass", "班级不能为空！");
		}else if(this.getUserName()== null || "".equals(this.getUserName().trim())) {
			this.addFieldError("NoName", "姓名不能为空！");
		}else if(this.getStuMobilePhone()== null || "".equals(this.getStuMobilePhone().trim())) {
			this.addFieldError("NoPhone", "手机号不能为空！");
		}
		else {
			//Save upload image
			HttpServletRequest  request  = ServletActionContext.getRequest();   
			String imageFileName = new Date().getTime() + getExtention(StuPhoto.getPath());  
			File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "uploadimg" ) + "/" + imageFileName);   
			String imageFilePath = "uploadimg" + "/" + imageFileName;  
			copy(StuPhoto, imageFile);
			
			student.setStuPhoto(imageFilePath);
			student.setStuAddr(this.getStuAddr());
			student.setStuNowAddr(this.getStuNowAddr());
			student.setStuAssistant(this.getStuAssistant());
			student.setStuClass(this.getStuClass());
			student.setStuGrdSchool(this.getStuGrdSchool());
			student.setStuId(this.getStuID());
			student.setStuMobilePhone(this.getStuMobilePhone());
			student.setStuHomePhone(this.getStuHomePhone());
			student.setStuName(this.getUserName());
			student.setStuSex(this.getSex());
	
			stu.save(student);
		}
	}
	
	private static void copy(File src, File dst)  {  
        try  {  
           InputStream in = null ;  
           OutputStream out = null ;  
            try  {                  
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);  
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);  
                byte [] buffer = new byte [BUFFER_SIZE];  
                while (in.read(buffer) > 0 )  {  
                   out.write(buffer);  
               }   
            } finally  {  
                if ( null != in)  {  
                   in.close();  
               }   
                 if ( null != out)  {  
                   out.close();  
               }   
           }   
        } catch (Exception e)  {  
           e.printStackTrace();  
       }   
   }    
    private static String getExtention(String fileName)  {  
        int pos = fileName.lastIndexOf( "." );  
        return fileName.substring(pos);  
   } 
}
