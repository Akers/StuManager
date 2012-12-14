package com.design.service.impl;

import java.util.List;

import com.design.dao.AdminDAO;
import com.design.dao.hibernate.AdminDaoHibernate;
import com.design.pojo.Admin;
import com.design.service.AdminManger;

public class AdminManagerImpl implements AdminManger {

	private AdminDAO adminDao;
	
	public void delete(String name) {
		adminDao.delete(name);
	}

	public Admin getAdmin(String name) {
		return adminDao.getAdmin(name);
	}

	public List getAdmins() {
		return adminDao.getAdmins();
	}

	public void save(Admin a) {
		adminDao.save(a);
	}

	public void upDate(Admin a) {
		adminDao.upDate(a);
	}

	public AdminDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

}
