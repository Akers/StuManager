package com.design.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.design.dao.AdminDAO;
import com.design.pojo.Admin;

public class AdminDaoHibernate extends HibernateDaoSupport implements AdminDAO {

	public void delete(String name) {
		this.getHibernateTemplate().delete(getAdmin(name));
	}

	public Admin getAdmin(String name) {
		List<Admin> ads = this.getAdmins();
		int id=0;
		for(Admin b : ads) {
			if(name.equals(b.getName())) {
				id = b.getId();
			}
		}
		
		return (Admin)this.getHibernateTemplate().get(com.design.pojo.Admin.class, id);
	}

	public List getAdmins() {
		
		return this.getHibernateTemplate().find("from Admin order by id desc");
	}

	public void save(Admin a) {
		this.getHibernateTemplate().save(a);
	}
	
	public void upDate(Admin a) {
		this.getHibernateTemplate().update(a);
	}

}
