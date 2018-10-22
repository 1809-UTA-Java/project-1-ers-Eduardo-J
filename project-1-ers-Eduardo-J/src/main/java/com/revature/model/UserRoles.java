package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_USER_ROLES")
public class UserRoles {
	
	@Id
	@Column(name = "UR_ID")
	int id;
	
	@Column(name = "UR_ROLE")
	String role;

	public UserRoles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "UserRoles [id=" + id + ", role=" + role + "]";
	}
}