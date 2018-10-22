package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao {
	
	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User").list();
	}
	
	public List<User> getEmployees() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User where roleId = 0").list();
	}
	
	public User getUserByUserName(String uName) {
		User uFound = null;
		List<User> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		users = session.createQuery("from User where username = :nameVar").setString("nameVar", uName).list();
		
		if (!users.isEmpty()) {
			uFound = users.get(0);
		}
		
		return uFound;
	}
	
	public User getUserByUserId(int id) {
		User uFound = null;
		List<User> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		users = session.createQuery("from User where username = :nameVar").setInteger("nameVar", id).list();
		
		if (!users.isEmpty()) {
			uFound = users.get(0);
		}
		
		return uFound;
	}
	
	public void saveUser(User u) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
	}
}