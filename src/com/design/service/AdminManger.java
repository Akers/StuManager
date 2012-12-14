package com.design.service;

import java.util.List;

import com.design.pojo.Admin;

public interface AdminManger {
	
	public void save(Admin a);

	public void upDate(Admin a);

	public void delete(String name);

	public List getAdmins();

	public Admin getAdmin(String name);
}
