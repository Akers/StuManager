package com.design.dao;

import java.util.List;

import com.design.pojo.Admin;

public interface AdminDAO {
	public void save(Admin a);

	public void upDate(Admin a);
	
	public void delete(String name);

	public List getAdmins();

	public Admin getAdmin(String name);
}
