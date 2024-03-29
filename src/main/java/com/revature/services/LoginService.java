package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.daos.LoginDAO;
import com.revature.daos.UserDAO;
import com.revature.models.UserRoles;
import com.revature.models.Users;

public class LoginService {
	

	
	private LoginDAO lDAO = new LoginDAO();
	
	UserDAO userDao = new UserDAO();
	
	public int login(String username, String password) {
		
		
		 
		
		UserDAO allUsers = new UserDAO();
		List<Users> checkLogin = allUsers.getAllUsers();
		
		for(Users test : checkLogin) {
			
			if(username.equals(test.getUsername()) && password.equals(test.getPassword())) {
				
				return test.getId();
			}
			
			
		}
		
		return -1;
	}
	
	public boolean login2(String username, String password) {
		
		//get credentials from DAO
		List<Users> userList = new ArrayList<>();
		
		
		
		userList = userDao.getAllUsers();
		
		for(int i = 0; i < userList.size(); i++) {
			if(username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
				return true;
			}
			
			
		}
		return false;
	}



	public UserRoles getRole(Users user, Session roles) {
		UserRoles role = lDAO.getRole(user, roles);
		if(role!= null) {
			return role;
		}
		return null;
	}

	
	}




