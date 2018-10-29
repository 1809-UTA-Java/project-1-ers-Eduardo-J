package com.revature.repository;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbursementDao {
	
	public List<Reimbursement> getAllReimbursements() {
		Session session = HibernateUtil.getSession();
		
		return session.createQuery("from reimbursement").list();
	}
	
	public List<Reimbursement> getReimbursementsByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		
		return session.createQuery("from Reimbursement where authorid = :nameVar").setInteger("nameVar", id).list();
	}
	
	public void saveReimbursement(Reimbursement r) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}
}
