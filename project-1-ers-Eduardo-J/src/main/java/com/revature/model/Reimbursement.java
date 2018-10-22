package com.revature.model;

import java.io.File;
import java.sql.Timestamp;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity
@Table(name = "ERS_REIMBURSEMENTS")
public class Reimbursement {
	
	public Reimbursement(int id, double amount, String description, File receipt, Timestamp submitted, Timestamp resolved, int authorId, int resolverId, int rtId, int rsId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.rtId = rtId;
		this.rsId = rsId;
	}
	
	@Id
	@Column(name = "R_ID")
	int id;
	
	@Column(name  = "R_AMOUNT")
	double amount;
	
	@Column(name = "R_DESCRIPTION")
	String description;
	
	@Column(name = "R_RECEIPT")
	File receipt;
	
	@Column(name = "R_SUBMITTED")
	Timestamp submitted = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "R_RESOLVED")
	Timestamp resolved;
	
	@Column(name = "U_ID_AUTHOR")
	int authorId;
	
	@Column(name = "U_ID_RESOLVER")
	int resolverId;
	
	@Column(name = "RT_TYPE")
	int rtId;
	
	@Column(name = "RS_STATUS")
	int rsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getReceipt() {
		return receipt;
	}

	public void setReceipt(File receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getRtId() {
		return rtId;
	}

	public void setRtId(int rtId) {
		this.rtId = rtId;
	}

	public int getRsId() {
		return rsId;
	}

	public void setRsId(int rsId) {
		this.rsId = rsId;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", rtId=" + rtId + ", rsId=" + rsId + "]";
	}
}
