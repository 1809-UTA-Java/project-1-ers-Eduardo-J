package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao {
	
	public List<User> getAllUsers() {
		Session session = HibernateUtil.getSession();
		
		return session.createQuery("from user where roleid = 0").list();
	}
	
	public User getByUsername(String username){
		Session session = HibernateUtil.getSession();
		User u = null;
		List<User> us = new ArrayList<>();
		Session ses = HibernateUtil.getSession();
		us = session.createQuery("from user where username = :namevar").setString("usernameVar", username).list();
		
		return u;
		
	}
	
	public User getByUserId(int id) {
		Session session = HibernateUtil.getSession();
		User u = null;
		List<User> users = new ArrayList<>();
		users = session.createQuery("from User where username = :nameVar").setInteger("nameVar", id).list();
		
		return u;
	}
	
	public void saveUser(User info) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(info);
		session.getTransaction().commit();
	}
}