package com.revature.repository;

import org.hibernate.Session;

import com.revature.model.UserRoles;
import com.revature.util.HibernateUtil;

public class UserRolesDao {
	
	public String getRoleById(int id) {
		UserRoles uFound = null;
		Session session = HibernateUtil.getSession();
		
		uFound = (UserRoles) session.createQuery("from UserRoles where id = :idVar").setInteger("idVar", id);
		if(uFound != null)
			return uFound.getRole();
		return null;
	}
}
