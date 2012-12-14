package com.design.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.design.dao.StudentADO;
import com.design.pojo.Student;

public class StudentADOHibernate extends HibernateDaoSupport implements
		StudentADO {

	public void delete(String id) {
		this.getHibernateTemplate().delete(getStudent(id));
	}

	public Student getStudent(String id) {
	  return (Student)getHibernateTemplate().get(com.design.pojo.Student.class, id);
	}

	public List getStudents() {
		List list = this.getHibernateTemplate().find("from Student");
		return list;
	}

	public void save(Student s) {
		this.getHibernateTemplate().save(s);
	}

	public void upDate(Student s) {
		this.getHibernateTemplate().update(s);
	}

}
