package com.revature.repository;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbursementDao {
	
	public List<Reimbursement> getReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement").list();
	}
	
	public List<Reimbursement> getReimbursementsByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement where authorId = :nameVar").setInteger("nameVar", id).list();
	}
	
	public List<Reimbursement> getPendingReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement where rtId = :statusVar").setInteger("statusVar", 0).list();
	}
	
	public List<Reimbursement> getPendingByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement where authorId = :authorVar and rtId = :statusVar").setInteger("authorVar", id).setInteger("statusVar", 0).list();
	}
	
	public List<Reimbursement> getResolvedReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement where rtId != :statusVar").setInteger("statusVar", 0).list();
	}
	
	public List<Reimbursement> getResolvedByAuthor(int id) {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement where authorId = :authorVar and rtId != :statusVar").setInteger("authorVar", id).setInteger("statusVar", 0).list();
	}

	public Reimbursement getReimbursementById(int id) {
		Session session = HibernateUtil.getSession();
		Reimbursement r = null;
		r = (Reimbursement) session.createQuery("from Reimbursement where id = :idVar").setInteger("idVar", id);
		return r;
	}
	
	public void saveReimbursement(Reimbursement r) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}
}
