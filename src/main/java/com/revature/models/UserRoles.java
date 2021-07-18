package com.revature.models;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ers_user_roles")
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ers_user_role_id")
	private int id;
	
	@Column(name = "user_role", nullable = false)
	private String role;
	
	@OneToMany(mappedBy = "roleId", fetch = FetchType.EAGER)
	private List<Users> userList;
	

	
	
	//Constructors, toString() etc below-------------------------------------------------------
	
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	
	
}





	public UserRoles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}





	public UserRoles(String role) {
		super();
		this.role = role;
	}





	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", role=" + role + "]";
	}





	@Override
	public int hashCode() {
		return Objects.hash(id, role);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		return id == other.id && Objects.equals(role, other.role);
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
	
	
	
}
