package com.revature.services;

import org.hibernate.Session;

import com.revature.daos.LoginDAO;
import com.revature.models.UserRoles;
import com.revature.models.Users;

public class LoginService {
	
	private LoginDAO lDAO = new LoginDAO();

	public Users login(String username, String password) {
		Users user = lDAO.getUserPass(username, password);
		return user;
	}

	public UserRoles getRole(Users user, Session roles) {
		UserRoles role = lDAO.getRole(user, roles);
		if(role!= null) {
			return role;
		}
		return null;
	}

	
	}


