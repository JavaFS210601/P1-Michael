package com.revature.models;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "ers_users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ers_users_id")
	private int id;
	
	@Column(name = "ers_username", nullable = false)
	private String username;
	
	@Column(name = "ers_password", nullable = false)
	private String password;
	
	@Column(name = "user_first_name", nullable = false)
	private String firstName;
	
	@Column(name = "user_last_name", nullable = false)
	private String lastName;
	
	@Column(name = "user_email",  nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ers_user_role_id")
	private UserRoles roleId;

	
	

	
	
	
	
	
	//Constructors, toString() etc below-------------------------------------------------------
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}









	public Users(int id, String username, String password, String firstName, String lastName, String email,
			UserRoles roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}









	public Users(String username, String password, String firstName, String lastName, String email, UserRoles roleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}









	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + "]";
	}









	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, roleId, username);
	}









	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(roleId, other.roleId) && Objects.equals(username, other.username);
	}









	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
	}









	public String getUsername() {
		return username;
	}









	public void setUsername(String username) {
		this.username = username;
	}









	public String getPassword() {
		return password;
	}









	public void setPassword(String password) {
		this.password = password;
	}









	public String getFirstName() {
		return firstName;
	}









	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}









	public String getLastName() {
		return lastName;
	}









	public void setLastName(String lastName) {
		this.lastName = lastName;
	}









	public String getEmail() {
		return email;
	}









	public void setEmail(String email) {
		this.email = email;
	}









	public UserRoles getRoleId() {
		return roleId;
	}









	public void setRoleId(UserRoles roleId) {
		this.roleId = roleId;
	}
	
	
}